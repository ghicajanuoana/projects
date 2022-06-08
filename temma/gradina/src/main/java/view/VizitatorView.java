package main.java.view;
import main.java.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
public class VizitatorView extends JFrame {
	ResourceBundle resourceBundle=ResourceBundle.getBundle("main.resources.Bundle", Locale.getDefault());
    
    private JTextField zonaField=new JTextField("");
    private JTextField tipField=new JTextField("");
    private JTextField specieField=new JTextField("");
    private JTextField cautaField=new JTextField("");
    private JLabel filterZonaLabel=new JLabel(resourceBundle.getString("filterZona"));
    private JLabel filterSpecieLabel=new JLabel(resourceBundle.getString("filterSpecie"));
    private JLabel filterTipLabel=new JLabel(resourceBundle.getString("filterTip"));
    private JLabel cautaLabel=new JLabel(resourceBundle.getString("searchName"));
    private JButton showButton;
    private JButton filtreazaZonaButton;
    private JButton cautaButton;
    private JButton filtreazaSpecieButton;
    private JButton filtreazaTipButton;
    
    private JButton btnLogin;
    

    private String[][] rec={};
    private String[] header={resourceBundle.getString("nume"), resourceBundle.getString("tip"), resourceBundle.getString("specie"), resourceBundle.getString("zona")};

    private JPanel panel=new JPanel();
    DefaultTableModel model=new DefaultTableModel(rec,header);

    JTable table=new JTable(model);

    private JButton romana;
    private JButton engleza;
    private JButton franceza;

    public VizitatorView(){


        romana = new JButton("RO");
        romana.setBounds(75,500,105,37);

        engleza=new JButton("EN");
        engleza.setBounds(236,500,92,37);

        franceza=new JButton("FR");
        franceza.setBounds(382,500,106,37);


        panel.setLayout(null);
        this.setBounds(0,0,1150,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        this.setTitle(resourceBundle.getString("vizitator"));
        this.setResizable(true);
        this.setVisible(true);
        panel.setBounds(0,-22,1150,750);

        showButton=new JButton(resourceBundle.getString("Show"));
        showButton.setBounds(900,350,100,20);

        filterZonaLabel.setBounds(430,238,100,20);
        zonaField.setBounds(580,247,100,20);
        filtreazaZonaButton=new JButton(resourceBundle.getString("Zfilter"));
        filtreazaZonaButton.setBounds(733,247,143,20);

        filterTipLabel.setBounds(430,269,150,20);
        tipField.setBounds(580,281,100,20);
        filtreazaTipButton=new JButton(resourceBundle.getString("Tfilter"));
        filtreazaTipButton.setBounds(733,281,143,20);

        filterSpecieLabel.setBounds(430,312,100,20);
        specieField.setBounds(580,311,100,20);
        filtreazaSpecieButton=new JButton(resourceBundle.getString("Sfilter"));
        filtreazaSpecieButton.setBounds(733,312,143,20);

        cautaLabel.setBounds(430,350,150,20);
        cautaField.setBounds(580,350,100,20);
        cautaButton=new JButton(resourceBundle.getString("Search"));
        cautaButton.setBounds(733,350,143,20);

        btnLogin = new JButton(resourceBundle.getString("Login")); 
        btnLogin.setBounds(75, 349, 121, 37);
        
        table.setRowSelectionAllowed(true);
        table.setFillsViewportHeight(true);

        JScrollPane js = new JScrollPane(table);
        js.setBounds(10,36,600,200);
        js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        js.setVisible(true);


        panel.add(js);
        panel.add(showButton);
        panel.add(filtreazaZonaButton);
        panel.add(filterZonaLabel);
        panel.add(zonaField);
        panel.add(filtreazaTipButton);
        panel.add(filtreazaSpecieButton);
        panel.add(cautaButton);
        panel.add(tipField);
        panel.add(specieField);
        panel.add(cautaField);
        panel.add(filterTipLabel);
        panel.add(filterSpecieLabel);
        panel.add(cautaLabel);
        panel.add(btnLogin);
        
        panel.add(romana);
        panel.add(engleza);
        panel.add(franceza);

        getContentPane().add(panel);
        
        
       
        this.setResizable(false);

    }

    public JButton getCautaButton(){
        return cautaButton;
    }

    public JButton getFiltreazaHabitatButton(){
        return filtreazaZonaButton;
    }

    public JButton getFiltreazaSpecieButton() {
        return filtreazaSpecieButton;
    }

    public JButton getFiltreazaAlimentatieButton() {
        return filtreazaTipButton;
    }

    public JButton getShowButton(){
        return showButton;
    }

    public JButton getLogin(){
        return btnLogin;
    }
    
    
    public void loginListener(ActionListener avl) {
        btnLogin.addActionListener(avl);
    }

    public JTable getTabel() {
        return table;
    }


    public JTextField getZonaField() {
        return zonaField;
    }

    public JTextField getTipField() {
        return tipField;
    }

    public JTextField getSpecieField() {
        return specieField;
    }

    public JTextField getCautaField() {
        return cautaField;
    }

    public void setTabelPlante(List<Planta> list){
        String[][] data = new String[list.size() + 100][5];

        int i = 0;
        for (Planta planta : list) {

            String[] rows = new String[this.getTabel().getModel().getColumnCount() + 1];

            rows[0] = planta.getNume();
            rows[1] = planta.getTip();
            rows[2] = planta.getSpecie();
            rows[3] = planta.getZona();
            data[i++] = rows;
        }
        String[] newHeader = {resourceBundle.getString("nume"), resourceBundle.getString("tip"), resourceBundle.getString("specie"), resourceBundle.getString("zona")};

        DefaultTableModel model = new DefaultTableModel(data, newHeader);
        this.getTabel().setModel(model);
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public JButton getRomana() {
        return romana;
    }

    public void setRomana(JButton romana) {
        this.romana = romana;
    }

    public JButton getEngleza() {
        return engleza;
    }

    public void setEngleza(JButton engleza) {
        this.engleza = engleza;
    }

    public JButton getFranceza() {
        return franceza;
    }

    public void setFranceza(JButton franceza) {
        this.franceza = franceza;
    }

    public void onLocaleChange(Locale locale){
        resourceBundle=ResourceBundle.getBundle("main.resources.Bundle",locale);
        filterZonaLabel.setText(resourceBundle.getString("filterZona"));
        filterSpecieLabel.setText(resourceBundle.getString("filterSpecie"));
        filterTipLabel.setText(resourceBundle.getString("filterTip"));
        cautaLabel.setText(resourceBundle.getString("searchName"));
        btnLogin.setText(resourceBundle.getString("Login"));
        String[] header={resourceBundle.getString("nume"), resourceBundle.getString("tip"), resourceBundle.getString("specie"), resourceBundle.getString("zona")};
        this.setTitle(resourceBundle.getString("vizitator"));
        showButton.setText(resourceBundle.getString("Show"));
        filtreazaZonaButton.setText(resourceBundle.getString("Zfilter"));
        filtreazaTipButton.setText(resourceBundle.getString("Tfilter"));
        filtreazaSpecieButton.setText(resourceBundle.getString("Sfilter"));
        cautaButton.setText(resourceBundle.getString("Search"));
        String[] newHeader = {resourceBundle.getString("nume"), resourceBundle.getString("tip"), resourceBundle.getString("specie"), resourceBundle.getString("zona")};

        DefaultTableModel model = new DefaultTableModel(rec, newHeader);
        this.getTabel().setModel(model);
    }
}
