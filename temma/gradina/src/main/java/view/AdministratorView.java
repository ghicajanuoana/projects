package main.java.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import main.java.model.Planta;
import main.java.model.*;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JLabel;

public class AdministratorView extends JFrame {
	ResourceBundle resourceBundle=ResourceBundle.getBundle("main.resources.Bundle", Locale.getDefault());
	private JPanel contentPane;
	
	
	private JButton addButton = new JButton(resourceBundle.getString("Add"));
	private JButton deleteButton = new JButton(resourceBundle.getString("Delete"));
    private JButton updateButton = new JButton(resourceBundle.getString("Update"));
    private JButton showButton = new JButton(resourceBundle.getString("Show"));
    
	
	
	private JTable table;
	private String[][] rec = {};
    private String[] header = {"userID", "username", "password", "role"};

    DefaultTableModel model = new DefaultTableModel(rec, header);
    
    
    
    private JTextField txtId = new JTextField(resourceBundle.getString("id"));
	private JTextField txtUsername = new JTextField(resourceBundle.getString("username"));
	private JTextField txtPass = new JTextField(resourceBundle.getString("password"));
	private JTextField txtRole= new JTextField(resourceBundle.getString("role"));
    private JButton btnRo;
    private JButton btnFr;
    private JButton btnEn;
    
	public AdministratorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 444);
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setSize(new Dimension(300, 200));
		panel.setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(422, 16, 256, 221);
		panel.add(scrollPane);
		
		txtId = new JTextField("");
		txtId.setBounds(78, 20, 86, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtUsername = new JTextField("");
		txtUsername.setBounds(78, 45, 86, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPass = new JTextField("");
		txtPass.setBounds(78, 78, 86, 20);
		panel.add(txtPass);
		txtPass.setColumns(10);
		
		txtRole = new JTextField("");
		txtRole.setBounds(78, 109, 86, 20);
		panel.add(txtRole);
		txtRole.setColumns(10);
        
		addButton.setBounds(213, 20, 150, 20);
        deleteButton.setBounds(213, 109, 150, 20);
        updateButton.setBounds(213, 65, 150, 20);
       
        showButton.setBounds(78, 163, 100, 20);
		
		table = new JTable(model);
		table.setBackground(Color.CYAN);
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		btnRo = new JButton("RO");
		btnRo.setBounds(13, 274, 89, 23);
		panel.add(btnRo);
		
		btnEn = new JButton("EN");
		btnEn.setBounds(115, 274, 89, 23);
		panel.add(btnEn);
		
		btnFr = new JButton("FR");
		btnFr.setBounds(234, 274, 89, 23);
		panel.add(btnFr);
		
		panel.add(addButton);
        panel.add(deleteButton);
        panel.add(updateButton);
        panel.add(showButton);
		
		this.setVisible(true);
		
	}
	public void romanaListener(ActionListener avl) {
		btnRo.addActionListener(avl);
	}
	public void englezaListener(ActionListener avl) {
		btnEn.addActionListener(avl);
	}
	public void francezaListener(ActionListener avl) {
		btnFr.addActionListener(avl);
	}
	
	
	public JButton getAdauga() {
		return addButton;
	}
	public JButton getShow() {
		return showButton;
	}
	public JButton getDelete() {
		return deleteButton;
	}
	public JButton getUpdate() {
		return updateButton;
	}
	
	public JTable getTable() {
        return table;
    }
	public JTextField getUserID() {
		return txtId;
	}
	public JTextField getUserName() {
		return txtUsername;
	}
	public JTextField getUserPass() {
		return txtPass;
	}
	public JTextField getRole() {
		return txtRole;
	}
	
	public void setId(JTextField id) {
		this.txtId=id;
	}
	public void setUsername(JTextField u) {
		this.txtUsername=u;
	}
	public void setPass(JTextField p) {
		this.txtPass=p;
	}
	public void setRole(JTextField r) {
		this.txtRole=r;
	}
	
	 public ResourceBundle getResourceBundle() {
	        return resourceBundle;
	    }

	    public void setResourceBundle(ResourceBundle resourceBundle) {
	        this.resourceBundle = resourceBundle;
	    }
	    public void changeText(Locale locale) {
	    	resourceBundle=ResourceBundle.getBundle("main.resources.Bundle",locale);
	    	addButton.setText(resourceBundle.getString("Add"));
	    	deleteButton.setText(resourceBundle.getString("Delete"));
	    	updateButton.setText(resourceBundle.getString("Update"));
	    	showButton.setText(resourceBundle.getString("Show"));
	    	
	    	
	    }
	    public void setTabel(List<Utilizator> lista){
	        String[][] data = new String[lista.size() + 100][5];

	        int i = 0;
	        for (Utilizator user : lista) {

	            String[] rows = new String[this.getTable().getModel().getColumnCount() + 1];

	            rows[0] = user.getId();
	            rows[1] = user.getUsername();
	            rows[2] = user.getPassword();
	            rows[3] = user.getRole();
	            data[i++] = rows;
	        }
	        String[] newHeader = {"userID", "username", "password", "role"};
	        DefaultTableModel model = new DefaultTableModel(data, newHeader);
	        this.getTable().setModel(model);
	    }
		public String[] getHeader() {
	        return header;
	    }
		public ArrayList<String> getSelectedRowContentDelete() {

	        ArrayList<String> values = new ArrayList<>();
	        int row = this.getTable().getSelectedRow();
	        if (row == -1)
	            return null;
	        for (int column = 0; column < this.getHeader().length; column++) {
	            if (this.getTable().getModel().getValueAt(row, column) == null)
	                return null;
	            values.add(this.getTable().getModel().getValueAt(row, column).toString());
	        }
	        return values;
	    }
	    public Utilizator getUser(){
	        Utilizator user=null;
	        if(getSelectedRowContentDelete()!=null){
	            String id=String.valueOf(getSelectedRowContentDelete().get(0));
	            String username=String.valueOf(getSelectedRowContentDelete().get(1));
	            String password=String.valueOf(getSelectedRowContentDelete().get(2));
	            String role=String.valueOf(getSelectedRowContentDelete().get(3));
	            user=new Utilizator(id,username,password,role);
	        }
	        return user;
	    }
}

