
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.event.*;


/**
*
* @author Lasya
*/

public class AudienceTableController implements ListSelectionListener, TableModelListener{
	private AudienceTableModel tableModel;
	private SignUpGUI signUpgui;
	
	public AudienceTableController(SignUpGUI signUpgui) {
		this.signUpgui = signUpgui;   
         // create the tableModel using the data in the cachedRowSet
		tableModel = new AudienceTableModel(); 
		tableModel.addTableModelListener(this);
	}
	
	
	// new code
	public TableModel getTableModel() {
		return tableModel;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		int firstIndex = selectModel.getMinSelectionIndex();
		
		// read the data in each column using getValueAt and display it on corresponding textfield
		//signUpgui.setUserName( (String) tableModel.getValueAt(firstIndex, 0));
		//signUpgui.setpasswordTextField( (String) tableModel.getValueAt(firstIndex, 1));
		//signUpgui.setEnrollmentTextField( (String) tableModel.getValueAt(firstIndex, 2));
		//signUpgui.setStartDateTextField( (String) tableModel.getValueAt(firstIndex, 3));
		//signUpgui.setEndDateTextField( (String) tableModel.getValueAt(firstIndex, 4));
		//signUpgui.setEndDateTextField( (String) tableModel.getValueAt(firstIndex, 4));
	}
	
	public void tableChanged(TableModelEvent e)
	{
	   try {
	    	// get the index of the inserted row
	        //tableModel.getRowSet().moveToCurrentRow();
	    	int firstIndex =  e.getFirstRow();
	    	
	    	// create a new table model with the new data
	        tableModel = new AudienceTableModel(tableModel.getList(), tableModel.getEntityManager());
	        tableModel.addTableModelListener(this);
	        // update the JTable with the data
	    	//signUpgui.updateTable();
	    
	        // read the data in each column using getValueAt and display it on corresponding textfield
			/*signUpgui.setCourseNameTextField( (String) tableModel.getValueAt(firstIndex, 0));
			signUpgui.setCourseNumberTextField( (String) tableModel.getValueAt(firstIndex, 1));
			signUpgui.setEnrollmentTextField( (String) tableModel.getValueAt(firstIndex, 2));
			signUpgui.setStartDateTextField( (String) tableModel.getValueAt(firstIndex, 3));
			signUpgui.setEndDateTextField( (String) tableModel.getValueAt(firstIndex, 4));
			*/
	} catch(Exception exp) {
		exp.getMessage();
		exp.printStackTrace();
	}
	}

	public void addRow(String[] array) {
		tableModel.addRow(array);			
	}
}
