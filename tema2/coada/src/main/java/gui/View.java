package main.java.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;


public class View extends JFrame {
	    private JPanel panel = new JPanel();
	    private JTextField txtClients;
	    private JTextField txtQueue;
	    private JTextField txtMinArrivalTime;
	    private JTextField txtMaxArrivalTime;
	    private JTextField txtMinServiceTime;
	    private JTextField txtMaxServiceTime;
	    private JTextField txtSimulation;
	    
	    private JTextField txtAverage;
	    private JTextField txtCount;
	    private JButton btnStart;
	    
        public JTextField getMinArrival() {
	        return txtMinArrivalTime;
	    }

	    public JTextField getMaxArrival() {
	        return txtMaxArrivalTime;
	    }

	    public JTextField getMinService() {
	        return txtMinServiceTime;
	    }

	    public JTextField getMaxService() {
	        return txtMaxServiceTime;
	    }

	    public JTextField getSimulation() {
	        return txtSimulation;
	    }

	    public JTextField getQueues() {
	        return txtQueue;
	    }

	    public JTextField getClients() {
	        return txtClients;
	    }

	    public JTextField getCount() {
	        return txtCount;
	    }

	    public JTextField getAverage() {
	        return txtAverage;
	    }

	    public View() {
	        this.setBounds(10, 10, 498, 371);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        panel.setBounds(10, 10, 1000, 784);
	        getContentPane().add(panel);
	        panel.setLayout(null);

	        JLabel lblCount = new JLabel("Count");
	        lblCount.setBounds(299, 207, 58, 19);
	        panel.add(lblCount);

	        txtCount = new JTextField();
	        txtCount.setBounds(371, 205, 76, 22);
	        panel.add(txtCount);

	        JLabel lblAverage = new JLabel("Average waitingPeriod");
	        lblAverage.setBounds(243, 237, 122, 19);
	        panel.add(lblAverage);

	        txtAverage = new JTextField();
	        txtAverage.setBounds(371, 238, 76, 22);
	        panel.add(txtAverage);

	        JLabel lblMinArrivalTime = new JLabel("Min Arrival Time ");
	        lblMinArrivalTime.setBounds(243, 31, 94, 19);
	        panel.add(lblMinArrivalTime);

	        txtMinArrivalTime = new JTextField();
	        txtMinArrivalTime.setBounds(347, 29, 76, 22);
	        panel.add(txtMinArrivalTime);

	        JLabel lblMAxArrivalTime = new JLabel("Max Arrival Time");
	        lblMAxArrivalTime.setBounds(231, 70, 94, 16);
	        panel.add(lblMAxArrivalTime);

	        txtMaxArrivalTime = new JTextField();
	        txtMaxArrivalTime.setBounds(347, 67, 76, 22);
	        panel.add(txtMaxArrivalTime);

	        JLabel lblMinServiceTime = new JLabel("Min Service Time");
	        lblMinServiceTime.setBounds(10, 120, 101, 16);
	        panel.add(lblMinServiceTime);

	        txtMinServiceTime = new JTextField();
	        txtMinServiceTime.setBounds(121, 117, 75, 22);
	        panel.add(txtMinServiceTime);

	        JLabel lblMaxServiceTime = new JLabel("Max Service Time");
	        lblMaxServiceTime.setBounds(10, 166, 111, 16);
	        panel.add(lblMaxServiceTime);

	        txtMaxServiceTime = new JTextField();
	        txtMaxServiceTime.setBounds(121, 163, 75, 22);
	        panel.add(txtMaxServiceTime);

	        JLabel lblSimulation = new JLabel("Simulation");
	        lblSimulation.setBounds(231, 120, 101, 16);
	        panel.add(lblSimulation);

	        txtSimulation = new JTextField();
	        txtSimulation.setBounds(347, 117, 76, 22);
	        panel.add(txtSimulation);

	        JLabel lblQueue = new JLabel("Queues");
	        lblQueue.setBounds(27, 70, 66, 16);
	        panel.add(lblQueue);

	        txtQueue = new JTextField();
	        txtQueue.setBounds(116, 67, 80, 22);
	        panel.add(txtQueue);

	        JLabel lblClients = new JLabel("Clients");
	        lblClients.setBounds(23, 32, 80, 16);
	        panel.add(lblClients);

	        txtClients = new JTextField();
	        txtClients.setBounds(113, 29, 83, 22);
	        panel.add(txtClients);

	        btnStart = new JButton("Start");
	        btnStart.setBounds(27, 234, 111, 25);
	        panel.add(btnStart);
	        
	      

	        this.setVisible(true);
	    }

	    public void addBtnStartListener(ActionListener avl) {
	        btnStart.addActionListener(avl);
	    }
}
