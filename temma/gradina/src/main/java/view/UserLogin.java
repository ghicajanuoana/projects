package main.java.view;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.java.connection.ConnectionFactory;
import main.java.controller.AdministratorController;
import main.java.controller.AngajatController;
import main.java.model.Utilizator;
import main.java.model.PersistentaUtilizator;

public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JTextField txtRole;
    private JButton btnLogin;
    private JLabel label;
    private JPanel contentPane;
    
   

    public UserLogin() {
    	
    	 
    	this.setSize(900, 700);  
        this.setLocationRelativeTo(null);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true); 

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setForeground(Color.BLACK);
        lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblLogin.setBounds(423, 13, 273, 93);
        contentPane.add(lblLogin);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(400, 170, 281, 30);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(400, 230, 281, 30);
        contentPane.add(passwordField);
        
        txtRole = new JTextField();
        txtRole.setFont(new Font("Tahoma", Font.PLAIN, 32));
        txtRole.setBounds(400, 300, 281, 30);
        contentPane.add(txtRole);
        txtRole.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(250, 130, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 200, 193, 52);
        contentPane.add(lblPassword);
        
        JLabel lblRole= new JLabel("Role");
        lblRole.setForeground(Color.BLACK);
        lblRole.setBackground(Color.CYAN);
        lblRole.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblRole.setBounds(250, 270, 193, 52);
        contentPane.add(lblRole);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnLogin.setBounds(340, 392, 162, 73);
        btnLogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	String username = textField.getText();
                String password = passwordField.getText();
                String role = txtRole.getText();
                try {
                	Utilizator user=null;
                    for (Utilizator utilizator : PersistentaUtilizator.getInstance().getLista()) {
                        if (getUsername().equals(utilizator.getUsername()) && getPassword().equals(utilizator.getPassword()) && getRole().getText().equals(utilizator.getRole()) && utilizator.getRole().equals("admin")) {
                            user=new Utilizator(utilizator.getId(),utilizator.getUsername(),utilizator.getPassword(),utilizator.getRole());
                            AdministratorView administratorView = new AdministratorView();
                            AdministratorController administratorController=new AdministratorController(administratorView);
                            break;
                        } else if(getUsername().equals(utilizator.getUsername()) && getPassword().equals(utilizator.getPassword()) && getRole().getText().equals(utilizator.getRole()) && utilizator.getRole().equals("angajat"))
                        {
                            user=new Utilizator(utilizator.getId(),utilizator.getUsername(),utilizator.getPassword(),utilizator.getRole());
                            AngajatView angajatView = new AngajatView();
                            AngajatController angajatController = new AngajatController(angajatView);

                            break;
                        }
                    }
                    if(user==null){
                        throw new Exception("Utilizator inexistent");
                    }
                    //vizitatorView.dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

			
        });

        contentPane.add(btnLogin);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
    }
    
    

    public String getUsername(){
        if(!this.textField.getText().isEmpty()){
            return textField.getText();
        }
        return null;
    }

    public String getPassword(){
        if(!Arrays.toString(this.passwordField.getPassword()).isEmpty()){
            return String.valueOf(passwordField.getPassword());
        }
        return null;
    }
    
    public JTextField getRole() {
        return txtRole;
    }
}