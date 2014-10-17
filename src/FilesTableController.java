
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.event.*;


public class FilesTableController implements ListSelectionListener, TableModelListener{
	private FilesTableModel tableModel;
	private SearchesGUI gui;
	private NewAdminGUI admingui;
	private int selectedRow;

	private int maxFileID;
	
	public FilesTableController(SearchesGUI gui) {
		this.gui = gui;
         // create the tableModel using the data in the cachedRowSet
		tableModel = new FilesTableModel(); 
		tableModel.addTableModelListener(this);
	}
	
	public FilesTableController(NewAdminGUI admingui) {
		this.admingui = admingui;   
         // create the tableModel using the data in the cachedRowSet
		tableModel = new FilesTableModel(); 
		tableModel.addTableModelListener(this);
		maxFileID = tableModel.getTempFileID();
	}
	
	// new code
	public TableModel getTableModel() {
		return tableModel;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		int firstIndex = selectModel.getMinSelectionIndex();
		
		// read the data in each column using getValueAt and display it on corresponding textfield
		admingui.setFile_projNameComboBox( (String) tableModel.getValueAt(firstIndex, 1));
		admingui.setFile_fileNameTextField( (String) tableModel.getValueAt(firstIndex, 3));
		admingui.setFile_fileFormatTextField( (String) tableModel.getValueAt(firstIndex, 2));
		admingui.setFile_fileLocationTextField( (String) tableModel.getValueAt(firstIndex, 4));
		
		selectedRow = firstIndex;
	}
	
	public void tableChanged(TableModelEvent e)
	{
	   try {
	    	// get the index of the inserted row
	        //tableModel.getRowSet().moveToCurrentRow();
	    	int firstIndex =  e.getFirstRow();
	    	
	    	// create a new table model with the new data
	        tableModel = new FilesTableModel(tableModel.getList(), tableModel.getEntityManager());
	        tableModel.addTableModelListener(this);
	        
	        // update the JTable with the data
	        admingui.updateFileTable();
	    
	        // read the data in each column using getValueAt and display it on corresponding textfield
	        admingui.setFile_projNameComboBox( (String) tableModel.getValueAt(firstIndex, 1));
			admingui.setFile_fileNameTextField( (String) tableModel.getValueAt(firstIndex, 3));
			admingui.setFile_fileFormatTextField( (String) tableModel.getValueAt(firstIndex, 2));
			admingui.setFile_fileLocationTextField( (String) tableModel.getValueAt(firstIndex, 4));
			
	} catch(Exception exp) {
		exp.getMessage();
		exp.printStackTrace();
	}
	}
	
	
	
	public TableModel search_file(String[] array){
		TableModel results = tableModel.search_file(array);
		return results;	

	}

	
	public void addRow(String[] array) {
		maxFileID++;
		array[0] = String.format("%03d", maxFileID);
		System.out.println(array[0]);
		tableModel.addRow(array);			
	}
	
	public void updateRow(String[] array) {
		array[0] = (String) tableModel.getValueAt(selectedRow, 0);
		tableModel.updateRow(selectedRow, array);
	}
	
	public void deleteRow(String fileName) {
		if (fileName.equals((String) tableModel.getValueAt(selectedRow, 3))) {
			tableModel.deleteRow(selectedRow);
		}
	}
	
	public void filterFileList(String projID){
		
		tableModel.filterFileList(projID);
		
	}
}

