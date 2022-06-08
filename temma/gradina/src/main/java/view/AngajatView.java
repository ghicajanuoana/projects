package main.java.view;
import main.java.model.*;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class AngajatView extends JFrame{
	 ResourceBundle resourceBundle=ResourceBundle.getBundle("main.resources.Bundle", Locale.getDefault());

	   // private JButton backButton = new JButton(resourceBundle.getString("Back"));
	    private JButton deleteButton = new JButton(resourceBundle.getString("Delete"));
	    private JButton updateButton = new JButton(resourceBundle.getString("Update"));
	    private JButton addButton = new JButton(resourceBundle.getString("Add"));
	    private JButton raportButton = new JButton(resourceBundle.getString("Reports"));

	    private JTextField addNameTextField = new JTextField("");
	    private JTextField addSpecieTextField = new JTextField("");
	    private JTextField addTipTextField = new JTextField("");
	    private JTextField addZonaTextField = new JTextField("");

	    private JLabel nameLabel = new JLabel(resourceBundle.getString("nume"));
	    private JLabel specieLabel = new JLabel(resourceBundle.getString("specie"));
	    private JLabel tipLabel = new JLabel(resourceBundle.getString("tip"));
	    private JLabel zonaLabel = new JLabel(resourceBundle.getString("zona"));


	    private JTextField zonaField = new JTextField();
	    private JTextField tipField = new JTextField();
	    private JTextField specieField = new JTextField();
	    private JTextField cautaField = new JTextField();

	    private JLabel filterZonaLabel = new JLabel(resourceBundle.getString("filterZona"));
	    private JLabel filterSpecieLabel = new JLabel(resourceBundle.getString("filterSpecie"));
	    private JLabel filterTipLabel = new JLabel(resourceBundle.getString("filterTip"));
	    private JLabel cautaLabel = new JLabel(resourceBundle.getString("searchName"));

	    private JButton showButton;
	    private JButton FiltreazaZonaButton;
	    private JButton CautaButton;
	    private JButton FiltreazaSpecieButton;
	    private JButton FiltreazaTipButton;

	    private JButton statisticiButton = new JButton(resourceBundle.getString("Statistics"));

	    private String[][] rec = {};
	    private String[] header = {resourceBundle.getString("nume"), resourceBundle.getString("tip"), resourceBundle.getString("specie"), resourceBundle.getString("zona")};

	    DefaultTableModel model = new DefaultTableModel(rec, header);

	    private JTable planteTabel = new JTable(model);
	    private final JPanel panel = new JPanel();
	    //String id;
	    JLabel title = new JLabel(resourceBundle.getString("angajat"));

	    private JButton romana;
	    private JButton engleza;
	    private JButton franceza;

	    public AngajatView() {



	        romana=new JButton("RO");
	        romana.setBounds(444,11,63,30);

	        engleza=new JButton("EN");
	        engleza.setBounds(545,16,85,20);

	        franceza=new JButton("FR");
	        franceza.setBounds(675,16,100,25);


	        panel.setSize(new Dimension(2000, 2000));
	        this.setBounds(0, 0, 1192, 721);
	        getContentPane().setLayout(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setResizable(false);
	        this.setVisible(true);

	        panel.setLayout(null);

	        title.setHorizontalAlignment((JLabel.CENTER));
	        title.setVerticalTextPosition(JLabel.TOP);


	        addNameTextField.setBounds(762, 119, 100, 20);
	        addSpecieTextField.setBounds(762, 150, 100, 20);
	        addTipTextField.setBounds(762, 196, 100, 20);
	        addZonaTextField.setBounds(762, 241, 100, 20);

	        nameLabel.setBounds(652, 119, 100, 20);
	        specieLabel.setBounds(652, 150, 100, 20);
	        tipLabel.setBounds(652, 196, 100, 20);
	        zonaLabel.setBounds(652, 241, 100, 20);

	        addButton.setBounds(935, 119, 150, 20);
	        deleteButton.setBounds(935, 267, 150, 20);
	        updateButton.setBounds(935, 218, 150, 20);

	        raportButton.setBounds(935, 166, 150, 20);
	        statisticiButton.setBounds(935, 326, 150, 20);


	        //operatii vizitator

	        showButton = new JButton(resourceBundle.getString("Show"));
	        showButton.setBounds(952, 376, 100, 20);

	        filterZonaLabel.setBounds(107, 409, 143, 20);
	        zonaField.setBounds(275, 409, 100, 20);
	        FiltreazaZonaButton = new JButton(resourceBundle.getString("Zfilter"));
	        FiltreazaZonaButton.setBounds(415, 409, 198, 20);

	        filterTipLabel.setBounds(107, 440, 129, 20);
	        tipField.setBounds(275, 440, 100, 20);
	        FiltreazaTipButton = new JButton(resourceBundle.getString("Tfilter"));
	        FiltreazaTipButton.setBounds(415, 440, 198, 20);

	        filterSpecieLabel.setBounds(107, 482, 100, 20);
	        specieField.setBounds(275, 482, 100, 20);
	        FiltreazaSpecieButton = new JButton(resourceBundle.getString("Sfilter"));
	        FiltreazaSpecieButton.setBounds(415, 482, 198, 20);

	        cautaLabel.setBounds(125, 537, 75, 20);
	        cautaField.setBounds(275, 537, 100, 20);
	        CautaButton = new JButton(resourceBundle.getString("Search"));
	        CautaButton.setBounds(415, 537, 198, 20);

	        
	        planteTabel.setRowSelectionAllowed(true);
	        planteTabel.setFillsViewportHeight(true);

	        JScrollPane js = new JScrollPane(planteTabel);
	        js.setBounds(30, 77, 600, 269);
	        js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	        js.setVisible(true);


	        panel.add(statisticiButton);
	        panel.add(js);
	        panel.add(title);

	        panel.add(addNameTextField);
	        panel.add(addSpecieTextField);
	        panel.add(addTipTextField);
	        panel.add(addZonaTextField);

	        panel.add(addButton);
	        panel.add(deleteButton);
	        panel.add(updateButton);
	       // panel.add(backButton);
	        panel.add(raportButton);

	        //adaugare elemente pt operatii vizitator

	        panel.add(nameLabel);
	        panel.add(specieLabel);
	        panel.add(tipLabel);
	        panel.add(zonaLabel);


	        panel.add(showButton);
	        panel.add(FiltreazaZonaButton);
	        panel.add(filterZonaLabel);
	        panel.add(zonaField);
	        panel.add(FiltreazaTipButton);
	        panel.add(FiltreazaSpecieButton);
	        panel.add(CautaButton);

	        panel.add(tipField);
	        panel.add(specieField);
	        panel.add(cautaField);
	        panel.add(filterTipLabel);
	        panel.add(filterSpecieLabel);
	        panel.add(cautaLabel);

	        panel.add(romana);
	        panel.add(engleza);
	        panel.add(franceza);

	        getContentPane().add(panel);
	    }
	    public JTable getTable() {
	        return planteTabel;
	    }

	    public JTextField getAddNameTextField() {
	        return addNameTextField;
	    }

	    public void setAddNameTextField(JTextField addNameTextField) {
	        this.addNameTextField = addNameTextField;
	    }

	    public JTextField getAddSpecieTextField() {
	        return addSpecieTextField;
	    }

	    public void setAddSpecieTextField(JTextField addSpecieTextField) {
	        this.addSpecieTextField = addSpecieTextField;
	    }

	    public JTextField getAddTipTextField() {
	        return addTipTextField;
	    }

	    public void setAddTipTextField(JTextField addTipTextField) {
	        this.addTipTextField = addTipTextField;
	    }

	    public JTextField getAddZonaTextField() {
	        return addZonaTextField;
	    }

	    public void setAddZonaTextField(JTextField addZonaTextField) {
	        this.addZonaTextField = addZonaTextField;
	    }

	    public JTextField getZonaField() {
	        return zonaField;
	    }

	    public void setZonaField(JTextField zonaField) {
	        this.zonaField = zonaField;
	    }

	    public JTextField getTipField() {
	        return tipField;
	    }

	    public void setTipField(JTextField tipField) {
	        this.tipField = tipField;
	    }

	    public JTextField getSpecieField() {
	        return specieField;
	    }

	    public void setSpecieField(JTextField specieField) {
	        this.specieField = specieField;
	    }

	    public JTextField getCautaField() {
	        return cautaField;
	    }

	    public void setCautaField(JTextField cautaField) {
	        this.cautaField = cautaField;
	    }
/*
	    public JButton getBackButton() {
	        return backButton;
	    }
*/
	    public JButton getDeleteButton() {
	        return deleteButton;
	    }

	    public JButton getUpdateButton() {
	        return updateButton;
	    }

	    public JButton getAddButton() {
	        return addButton;
	    }

	    public JButton getRaportButton() {
	        return raportButton;
	    }

	    public JButton getShowButton() {
	        return showButton;
	    }

	    public JButton getFiltreazaHabitatButton() {
	        return FiltreazaZonaButton;
	    }

	    public JButton getCautaButton() {
	        return CautaButton;
	    }

	    public JButton getFiltreazaSpecieButton() {
	        return FiltreazaSpecieButton;
	    }

	    public JButton getFiltreazaTipButton() {
	        return FiltreazaTipButton;
	    }

	    public JButton getStatisticiButton() {
	        return statisticiButton;
	    }

	    public String[] getHeader() {
	        return header;
	    }

	    public void setTabelPlante(List<Planta> lista){
	        String[][] data = new String[lista.size() + 100][5];

	        int i = 0;
	        for (Planta planta : lista) {

	            String[] rows = new String[this.getTable().getModel().getColumnCount() + 1];

	            rows[0] = planta.getNume();
	            rows[1] = planta.getTip();
	            rows[2] = planta.getSpecie();
	            rows[3] = planta.getZona();
	            data[i++] = rows;
	        }
	        String[] newHeader = {resourceBundle.getString("nume"), resourceBundle.getString("tip"), resourceBundle.getString("specie"), resourceBundle.getString("zona")};
	        DefaultTableModel model = new DefaultTableModel(data, newHeader);
	        this.getTable().setModel(model);
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
	    public Planta getPlanta(){
	        Planta planta=null;
	        if(getSelectedRowContentDelete()!=null){
	            String nume=String.valueOf(getSelectedRowContentDelete().get(0));
	            String tip=String.valueOf(getSelectedRowContentDelete().get(1));
	            String specie=String.valueOf(getSelectedRowContentDelete().get(2));
	            String zona=String.valueOf(getSelectedRowContentDelete().get(3));
	            planta=new Planta(nume,tip,specie,zona);
	        }
	        return planta;
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
	          deleteButton.setText(resourceBundle.getString("Delete"));
	          updateButton.setText(resourceBundle.getString("Update"));
	          addButton.setText(resourceBundle.getString("Add"));
	          nameLabel.setText(resourceBundle.getString("nume"));
	          specieLabel.setText(resourceBundle.getString("specie"));
	          tipLabel.setText(resourceBundle.getString("tip"));
	          zonaLabel.setText(resourceBundle.getString("zona"));
	          filterZonaLabel.setText(resourceBundle.getString("filterZona"));
	          filterSpecieLabel.setText(resourceBundle.getString("filterSpecie"));
	          filterTipLabel.setText(resourceBundle.getString("filterTip"));
	          cautaLabel.setText(resourceBundle.getString("searchName"));
	          
	         String[] header = {resourceBundle.getString("nume"), resourceBundle.getString("tip"), resourceBundle.getString("specie"), resourceBundle.getString("zona")};
	         title.setText(resourceBundle.getString("angajat"));
	         showButton.setText(resourceBundle.getString("Show"));
	         FiltreazaZonaButton.setText(resourceBundle.getString("Zfilter"));
	         FiltreazaTipButton.setText(resourceBundle.getString("Tfilter"));
	         FiltreazaSpecieButton.setText(resourceBundle.getString("Sfilter"));
	         CautaButton.setText(resourceBundle.getString("Search"));
	         
	         
	         String[] newHeader = {resourceBundle.getString("nume"), resourceBundle.getString("tip"), resourceBundle.getString("specie"), resourceBundle.getString("zona")};
	         model = new DefaultTableModel(rec, newHeader);
	         this.getTable().setModel(model);
	    }
}
