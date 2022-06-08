package main.java.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

import main.java.bll.SimulationManager;
import main.java.model.Client;

public class Controller extends Thread {
    private View v;
    private SimulationManager simulationManager;
    private Client[] clients;
    
    private int nrClients = 0;
    private int nrQueues = 0;
    private int minArrival = 0;
    private int maxArrival = 0;
    private int minService = 0;
    private int maxService = 0;
    
    private int simulationTime = 0;

    public Controller(View v) {
        this.v = v;
        
        v.addBtnStartListener(new StartListener());
    }
    
    class StartListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
            	nrClients = Integer.parseInt(v.getClients().getText());
            	nrQueues = Integer.parseInt(v.getQueues().getText());
                minArrival = Integer.parseInt(v.getMinArrival().getText());
                maxArrival = Integer.parseInt(v.getMaxArrival().getText());
                minService = Integer.parseInt(v.getMinService().getText());
                maxService = Integer.parseInt(v.getMaxService().getText());
                simulationTime = Integer.parseInt(v.getSimulation().getText());
                startThread();
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }

    public void startThread() {
        simulationManager = new SimulationManager(nrQueues);
        clients = new Client[nrClients];
        for(int i = 0; i < nrClients; i++)
            clients[i] = new Client(i + 1, minArrival, maxArrival, minService, maxService);
        Arrays.sort(clients);
        this.start();
    }

    public void run() {

        try {
            BufferedWriter file = new BufferedWriter(new FileWriter("test.txt"));

            int count = 0;
            while (count <= simulationTime) {
                for (Client client : clients)
                    if (client.getArrival() == count)
                        simulationManager.getQueue(simulationManager.minQueue()).addClient(client);

                file.write("\nTime " + count + "\nClients: ");
                System.out.print("\nTime " + count + "\nClients: ");

                for(int i = 0; i < clients.length; i++) {
                    if(clients[i].getArrival() > count) {
                        file.write(clients[i].toString() );
                        System.out.print(clients[i].toString() );
                    }
                }

                file.write("\n");
                System.out.println();

                for(int i = 0; i < simulationManager.getQueues().length; i++) {
                    file.write("Queue " + (i + 1) + ":" + simulationManager.getQueue(i).toString() + "\n");
                    System.out.println("Queue " + (i + 1) + ":" + simulationManager.getQueue(i).toString());
                }

                for(int i = 0; i < nrQueues; i++)
                v.getCount().setText(String.valueOf(count));

                Thread.sleep(1000);
                count++;
            }

            float averageWaiting = 0;
            for(int i = 0; i < clients.length; i++)
                averageWaiting += clients[i].getWaitingPeriodClient();
            averageWaiting = averageWaiting / clients.length;

            file.write("\nAverage waiting period: " + averageWaiting);
            System.out.println("\nAverage waiting period: " + averageWaiting);
            v.getAverage().setText(String.valueOf(averageWaiting));

            file.close();
            simulationManager.setFinal(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   
}
