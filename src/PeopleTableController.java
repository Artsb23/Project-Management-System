
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.event.*;


public class PeopleTableController implements ListSelectionListener, TableModelListener{
	private PeopleTableModel tableModel;
	private SearchesGUI gui;
	private NewAdminGUI admingui;
	private int selectedRow;

	private int maxPeopleID;
	
	public PeopleTableController(SearchesGUI gui) {
		this.gui = gui;
         // create the tableModel using the data in the cachedRowSet
		tableModel = new PeopleTableModel(); 
		tableModel.addTableModelListener(this);
	}
	
	public PeopleTableController(NewAdminGUI admingui) {
		this.admingui = admingui;   
         // create the tableModel using the data in the cachedRowSet
		tableModel = new PeopleTableModel(); 
		tableModel.addTableModelListener(this);
		maxPeopleID = tableModel.getTempPeopleID();
	}
	
	// new code
	public TableModel getTableModel() {
		return tableModel;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		int firstIndex = selectModel.getMinSelectionIndex();
		
		// read the data in each column using getValueAt and display it on corresponding textfield
		admingui.setPeople_projNameComboBox( (String) tableModel.getValueAt(firstIndex, 1));
		admingui.setPeople_peopleRoleTextField( (String) tableModel.getValueAt(firstIndex, 3));
		admingui.setPeople_peopleNameTextField( (String) tableModel.getValueAt(firstIndex, 1));
		selectedRow = firstIndex;
	}
	
	public void tableChanged(TableModelEvent e)
	{
	   try {
	    	// get the index of the inserted row
	        //tableModel.getRowSet().moveToCurrentRow();
	    	int firstIndex =  e.getFirstRow();
	    	
	    	// create a new table model with the new data
	        tableModel = new PeopleTableModel(tableModel.getList(), tableModel.getEntityManager());
	        tableModel.addTableModelListener(this);
	        
	        // update the JTable with the data
	        admingui.updatePeopleTable();
	    
	        // read the data in each column using getValueAt and display it on corresponding textfield
	        admingui.setPeople_projNameComboBox( (String) tableModel.getValueAt(firstIndex, 1));
			admingui.setPeople_peopleRoleTextField( (String) tableModel.getValueAt(firstIndex, 3));
			admingui.setPeople_peopleNameTextField( (String) tableModel.getValueAt(firstIndex, 1));
			
	} catch(Exception exp) {
		exp.getMessage();
		exp.printStackTrace();
	}
	}
	
	
	
	public TableModel search_people(String[] array){
		TableModel results = tableModel.search_people(array);
		return results;	

	}

	
	public void addRow(String[] array) {
		maxPeopleID++;
		array[0] = String.format("%03d", maxPeopleID);
		System.out.println(array[0]);
		tableModel.addRow(array);			
	}
	
	public void updateRow(String[] array) {
		array[0] = (String) tableModel.getValueAt(selectedRow, 0);
		tableModel.updateRow(selectedRow, array);
	}
	
	public void deleteRow(String peopleName) {
		if (peopleName.equals((String) tableModel.getValueAt(selectedRow, 3))) {
			tableModel.deleteRow(selectedRow);
		}
	}
	
	public void filterPeopleList(String projID){
		
		tableModel.filterPeopleList(projID);
		
	}
}

