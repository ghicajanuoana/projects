package polinom.view;


import javax.swing.JFrame;
import javax.swing.JPanel;

import polinom.controller.Controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame {

    public JLabel lblP1, lblRezP1,lblP2, lblRezP2,lblSuma, lblRezSuma,lblScadere, lblRezScadere,lblInmultire, lblRezInmultire;
    public JLabel lblImpartire, lblRezImpartire;
    public JPanel panelPol1, panelPol2, messages;
    public JTextField txtPol1, txtPol2;
    public JButton btnAdd, btnMinus, btnMul, btnImpartire;
  
    
    public View(){
        prepareGUI();   
    }

    private void prepareGUI(){
        this.setSize(860,452);
        this.getContentPane().setLayout(new GridLayout(1,2));
        JPanel panel1 = new JPanel();
        
        this.getContentPane().add(panel1);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
       
       
        panelPol1 = new JPanel();
        panelPol2 = new JPanel();
        panelPol1.setLayout(new FlowLayout());
        panelPol2.setLayout(new FlowLayout());
        panelPol1.add(new JLabel("Polinom1", JLabel.LEFT));
        panelPol2.add(new JLabel("Polinom2", JLabel.LEFT));
        
        
        txtPol1 = new JTextField(25);
        txtPol2 = new JTextField(25);
        

        panelPol1.add(txtPol1);
        panelPol2.add(txtPol2);
        
      
        lblP1 = new JLabel("", JLabel.LEFT);
        lblP1.setPreferredSize(new Dimension(350,20));
        lblP1.setText("Polinomul 1");
        lblRezP1 = new JLabel("",JLabel.LEFT);
        lblRezP1.setVerticalTextPosition(JLabel.TOP);
        lblRezP1.setPreferredSize(new Dimension(350,20));
        JPanel panelP1 = new JPanel();
        panelP1.setLayout(new GridLayout(2,1));
        panelP1.add(lblP1);
        panelP1.add(lblRezP1);
        
        
        lblP2 = new JLabel("", JLabel.LEFT);
        lblP2.setPreferredSize(new Dimension(350,20));
        lblP2.setText("Polinomul 2");
        lblRezP2 = new JLabel("",JLabel.LEFT);
        lblRezP2.setVerticalTextPosition(JLabel.TOP);
        lblRezP2.setPreferredSize(new Dimension(350,20));
        JPanel panelP2 = new JPanel();
        panelP2.setLayout(new GridLayout(2,1));
        panelP2.add(lblP2);
        panelP2.add(lblRezP2);
        
        
        lblSuma = new JLabel("", JLabel.LEFT);
        lblSuma.setPreferredSize(new Dimension(350,20));
        lblSuma.setText("Suma ");
        lblRezSuma = new JLabel("",JLabel.LEFT);
        lblRezSuma.setVerticalTextPosition(JLabel.TOP);
        lblRezSuma.setPreferredSize(new Dimension(350,20));
        JPanel panelSuma = new JPanel();
        panelSuma.setLayout(new GridLayout(2,1));
        panelSuma.add(lblSuma);
        panelSuma.add(lblRezSuma);
        

        lblScadere = new JLabel("", JLabel.LEFT);
        lblScadere.setPreferredSize(new Dimension(350,20));
        lblScadere.setText("Scadere");
        lblRezScadere = new JLabel("",JLabel.LEFT);
        lblRezScadere.setVerticalTextPosition(JLabel.TOP);
        lblRezScadere.setPreferredSize(new Dimension(350,20));
        JPanel panelScadere = new JPanel();
        panelScadere.setLayout(new GridLayout(2,1));
        panelScadere.add(lblScadere);
        panelScadere.add(lblRezScadere);
        
        
        lblInmultire = new JLabel("", JLabel.LEFT);
        lblInmultire.setPreferredSize(new Dimension(350,20));
        lblInmultire.setText("Inmultire ");
        lblRezInmultire = new JLabel("",JLabel.LEFT);
        lblRezInmultire.setVerticalTextPosition(JLabel.TOP);
        lblRezInmultire.setPreferredSize(new Dimension(350,20));
        JPanel oanelInmultire = new JPanel();
        oanelInmultire.setLayout(new GridLayout(2,1));
        oanelInmultire.add(lblInmultire);
        oanelInmultire.add(lblRezInmultire);
        
        
        
        btnAdd = new JButton("+");
        btnMinus= new JButton("-");
        btnMul = new JButton("*");
        btnImpartire = new JButton("/");
        
        
        panel1.add(panelPol1);
        panel1.add(panelPol2);
        panel1.add(btnAdd);
        panel1.add(btnMinus);
        panel1.add(btnMul);
        panel1.add(btnImpartire);
    
        panel1.add(panelP1);
        panel1.add(panelP2);
        panel1.add(panelSuma);
        panel1.add(panelScadere);
        panel1.add(oanelInmultire);
        panel1.setVisible(true);
       
    }
    
 

    public void showEvent(){ 
        JButton enter1 = new JButton("enter");
        JButton enter2 =  new JButton("enter");
        
        enter1.setActionCommand("enter1");
        enter2.setActionCommand("enter2");
        btnAdd.setActionCommand("aduna");
        btnMinus.setActionCommand("scade");
        btnMul.setActionCommand("inmulteste");
        btnImpartire.setActionCommand("imparte");
        
        enter1.addActionListener(new Controller(this));
        enter2.addActionListener(new Controller(this));
        btnAdd.addActionListener(new Controller(this));
        btnMinus.addActionListener(new Controller(this));
        btnMul.addActionListener(new Controller(this));
        btnImpartire.addActionListener(new Controller(this));
         
        panelPol1.add(enter1);
        panelPol2.add(enter2);
        
        this.setVisible(true);
    }

}
