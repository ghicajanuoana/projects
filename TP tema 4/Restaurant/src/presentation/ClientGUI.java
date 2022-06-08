package presentation;

import javax.swing.table.DefaultTableModel;

import bll.model.BaseProduct;

import java.awt.GridLayout;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ClientGUI extends JFrame{

	
	JPanel panel = new JPanel();
	
	
	private String[][] rec={};
	private String[] header={"title", "rating", "calories", "protein", "fat", "sodium", "price"};
	DefaultTableModel model=new DefaultTableModel(rec,header);
	JTable table=new JTable(model);
	
	private String[][] recO={};
	private String[] headerO={"idOrder", "idClient", "date", "price"};
	DefaultTableModel modelO=new DefaultTableModel(recO,headerO);
	JTable tableO=new JTable(modelO);
	

	JButton btnTitle;
	JButton btnView;
	JButton btnRating;
	JButton btnFat;
	JButton btnCalories;
	JButton btnSodium;
	JButton btnPrice;
	JButton btnProtein;
	
	JButton btnAddOrder;
	JButton btnCreateOrder;
	
	private JButton btnSearch;
	private JTextField txtTitle;
	private JTextField txtRating;
	private JTextField txtCalories;
	private JTextField txtProtein;
	private JTextField txtFat;
	private JTextField txtSodium;
	private JTextField txtPrice;
	
	JLabel lblTitle;
	JLabel lblRating;
	JLabel lblCalories;
	JLabel lblProtein;
	JLabel lblFat;
	JLabel lblSodium;
	JLabel lblPrice;
	
	
	
	
	
	//private JTextPane textPane= new JTextPane();
	//private JScrollPane scrollPane= new JScrollPane(textPane);
	
	
    public ClientGUI() {
    	panel.setLayout(null);
        this.setBounds(0,0,1030,538);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        this.setTitle("client");
        this.setResizable(true);
        this.setVisible(true);
        panel.setBounds(0,-22,1014,521);
       
        getContentPane().add(panel);
        
        btnTitle = new JButton("Search title");
        btnTitle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnTitle.setBounds(25, 419, 135, 23);
        panel.add(btnTitle);
        
        lblTitle = new JLabel("Title");
        lblTitle.setBounds(25, 48, 46, 14);
        panel.add(lblTitle);
        
        lblRating = new JLabel("Rating");
        lblRating.setBounds(25, 87, 46, 14);
        panel.add(lblRating);
        
        lblCalories = new JLabel("Calories");
        lblCalories.setBounds(25, 132, 46, 14);
        panel.add(lblCalories);
        
        lblProtein = new JLabel("Protein");
        lblProtein.setBounds(25, 172, 46, 14);
        panel.add(lblProtein);
        
        lblFat = new JLabel("Fat");
        lblFat.setBounds(25, 221, 46, 14);
        panel.add(lblFat);
        
        lblSodium = new JLabel("Sodium");
        lblSodium.setBounds(25, 255, 46, 14);
        panel.add(lblSodium);
        
        lblPrice = new JLabel("Price");
        lblPrice.setBounds(25, 292, 46, 14);
        panel.add(lblPrice);
        
        txtTitle = new JTextField();
        txtTitle.setBounds(93, 45, 135, 23);
        panel.add(txtTitle);
        txtTitle.setColumns(10);
        
        txtRating = new JTextField();
        txtRating.setBounds(93, 84, 135, 20);
        panel.add(txtRating);
        txtRating.setColumns(10);
        
        txtCalories = new JTextField();
        txtCalories.setBounds(93, 126, 135, 23);
        panel.add(txtCalories);
        txtCalories.setColumns(10);
        
        txtProtein = new JTextField();
        txtProtein.setBounds(90, 169, 138, 23);
        panel.add(txtProtein);
        txtProtein.setColumns(10);
        
        txtFat = new JTextField();
        txtFat.setBounds(93, 215, 135, 23);
        panel.add(txtFat);
        txtFat.setColumns(10);
        
        txtSodium = new JTextField();
        txtSodium.setBounds(93, 252, 119, 20);
        panel.add(txtSodium);
        txtSodium.setColumns(10);
        
        txtPrice = new JTextField();
        txtPrice.setBounds(93, 289, 119, 20);
        panel.add(txtPrice);
        txtPrice.setColumns(10);
        
        btnView = new JButton("View list");
        btnView.setBounds(188, 335, 119, 23);
        panel.add(btnView);
        
        btnRating = new JButton("Search rating");
        btnRating.setBounds(25, 453, 135, 23);
        panel.add(btnRating);
        
        btnCalories = new JButton("Search calories");
        btnCalories.setBounds(25, 487, 135, 23);
        panel.add(btnCalories);
        
        btnProtein = new JButton("Search protein");
        btnProtein.setBounds(194, 372, 135, 23);
        panel.add(btnProtein);
        
        btnFat = new JButton("Search fat");
        btnFat.setBounds(25, 372, 119, 23);
        panel.add(btnFat);
        
        btnSodium = new JButton("Search sodium");
        btnSodium.setBounds(25, 335, 135, 23);
        panel.add(btnSodium);
        
        btnPrice = new JButton("Search price");
        btnPrice.setBounds(194, 419, 135, 23);
        panel.add(btnPrice);
        
        
        table.setRowSelectionAllowed(true);
        table.setFillsViewportHeight(true);

        JScrollPane js = new JScrollPane(table);
        js.setBounds(278,41,708,172);
        js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        js.setVisible(true);
        panel.add(js);
        
        
        tableO.setRowSelectionAllowed(true);
        tableO.setFillsViewportHeight(true);

        JScrollPane jsO = new JScrollPane(tableO);
        jsO.setBounds(361,221,625,216);
        jsO.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jsO.setVisible(true);
        panel.add(jsO);
        
        
        
        
        btnAddOrder = new JButton("Add order");
        btnAddOrder.setBounds(618, 453, 135, 23);
        panel.add(btnAddOrder);
        
        btnCreateOrder = new JButton("Create Order");
        btnCreateOrder.setBounds(426, 453, 135, 23);
        panel.add(btnCreateOrder);
        
       
        
    }
    
    public JTable getTabel() {
        return table;
    }
    
    public void setProducts(String string) {
    	table.setToolTipText(string);
    }
    
    
    public void setTabel(List<BaseProduct> list) {
    	String[][] data = new String[list.size() + 100][5];

        int i = 0;
        for (BaseProduct base : list) {

            String[] rows = new String[this.getTabel().getModel().getColumnCount() + 1];

            rows[0] = base.getTitle();
            rows[1] = base.getRating();
            rows[2] = base.getCalories();
            rows[3] = base.getProtein();
            rows[4] = base.getFat();
            rows[5] = base.getSodium();
            rows[6] = base.computePrice();
            
            data[i++] = rows;
        }
        String[] newHeader={"title", "rating", "calories", "protein", "fat", "sodium", "price"};
        DefaultTableModel model = new DefaultTableModel(data, newHeader);
        this.getTabel().setModel(model);
    }
  
   public String getTitleTxt() {
	   return txtTitle.getText();
   }
   public String getRatingTxt() {
	   return txtRating.getText();
   }
   public String getCaloriesTxt() {
	   return txtCalories.getText();
   }
   public String getSodiumTxt() {
	   return txtSodium.getText();
   }
   public String getFatTxt() {
	   return txtFat.getText();
   }
   public String getPriceTxt() {
	   return txtPrice.getText();
   }
   public String getProteinTxt() {
	   return txtProtein.getText();
   }
   
   
   public void searchTitleListener(ActionListener avl) {
	   btnTitle.addActionListener(avl);
   }
   
   public void searchProteinListener(ActionListener avl) {
	   btnProtein.addActionListener(avl);
   }
   public void searchFatListener(ActionListener avl) {
	   btnFat.addActionListener(avl);
   }
   public void searchSodiumListener(ActionListener avl) {
	   btnSodium.addActionListener(avl);
   }
   public void searchCaloriesListener(ActionListener avl) {
	   btnCalories.addActionListener(avl);
   }
   public void searchRatingListener(ActionListener avl) {
	   btnRating.addActionListener(avl);
   }
   public void searchPriceListener(ActionListener avl) {
	   btnPrice.addActionListener(avl);
   }
   public void viewListener(ActionListener avl) {
	   btnView.addActionListener(avl);
   }
   
   public void addOrderListener(ActionListener avl) {
	   btnAddOrder.addActionListener(avl);
   }
   public void createOrderListener(ActionListener avl) {
	   btnCreateOrder.addActionListener(avl);
   }
   
   
   
   public void setOrders(String lista) {
	   table.setToolTipText(lista);
   }
}
