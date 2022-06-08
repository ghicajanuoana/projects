package main.java.view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
public class UserHome extends JFrame{
	private static final long serialVersionUID = 1L;
    private JPanel panel;
    JButton btnAngajat;

   
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserHome frame = new UserHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserHome() {

    }

    
    public UserHome(String userSes) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 600, 600);
        setResizable(false);
        setLocationRelativeTo(null);  
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);
        
        JButton btnLogout = new JButton("Logout");
        btnLogout.setForeground(new Color(0, 0, 0));
        btnLogout.setBackground(UIManager.getColor("Button.disabledForeground"));
     /*   
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnLogout, "Logout?");
               
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    UserLogin obj = new UserLogin();
                    obj.setTitle("Login");
                    obj.setVisible(true);
                }
                dispose();
                UserLogin obj = new UserLogin();

                obj.setTitle("Login");
                obj.setVisible(true);

            }
        });
        */
        btnLogout.setBounds(200, 100, 150, 20);
        panel.add(btnLogout);
     
        
        
        JButton btnAngajat = new JButton("Angajat");
        btnAngajat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                AngajatView angajatview = new AngajatView();

            }
        });
        btnAngajat.setBounds(200,300,150,20);
        btnAngajat.setBackground(Color.green);
        panel.add(btnAngajat);
        
        JButton btnAdmin = new JButton("Admin");
        btnAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                AdministratorView adminview = new AdministratorView();

            }
        });
        btnAdmin.setBounds(200,400,150,20);
        btnAdmin.setBackground(Color.green);
        panel.add(btnAdmin);
    }

}
