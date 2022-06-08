package main.java.model;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import main.java.bll.SimulationManager;

public class Queue extends Thread {

        private BlockingQueue<Client> queue = new LinkedBlockingQueue<Client>();
        private AtomicInteger waitingPeriod = new AtomicInteger(0);
        private SimulationManager simulationManager;

        public Queue(SimulationManager managerCoada) {
                this.simulationManager = managerCoada;
                this.start();
        }

        public int getNrClients() {
                return queue.size();
        }

        public int getWaitingPeriodQueue() {
                return waitingPeriod.get();
        }

        public void addClient(Client client) {
                client.setWaitingPeriodClient(waitingPeriod.get());
                waitingPeriod.addAndGet(client.getService());
                queue.add(client);
        }

        public String toString() {
                String out = "";
                for(Client c: queue)
                        out = out + c.toString();
                return out;
        }

        public void run() {
                Client client;
                while (simulationManager.getFinal() == false) {
                        if (queue.isEmpty() != true) {
                                try {
                                        client = queue.peek();
                                        while (client.getService() > 1) {
                                                client.setService(client.getService() - 1);
                                                waitingPeriod.decrementAndGet();
                                                Thread.sleep(1000);
                                        }
                                        waitingPeriod.decrementAndGet();
                                        queue.remove();//remove () method =>removes first element from the queue
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                }
        }


}