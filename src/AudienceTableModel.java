
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import javax.persistence.*;
import java.util.*;

/**
*
* @author Lasya
*/
public class AudienceTableModel extends AbstractTableModel {

	  List<Audience> audienceResultList;   
	  private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  
	  private static EntityManagerFactory factory;  
	  private EntityManager manager;				
	  private Audience viewer;			    
	  private AudienceService audienceService;
	
	   // This field contains additional information about the results   
	    int numcols, numrows;           // number of rows and columns

	    AudienceTableModel() {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    viewer = new Audience();
	    audienceService = new AudienceService(manager);
	    
	    // read all the records from audience
	    audienceResultList = audienceService.readAll();
	    
	    // update the number of rows and columns in the model
	    numrows = audienceResultList.size();
	    numcols = viewer.getNumberOfColumns();
      }

	 // returns a count of the number of rows
	 public int getRowCount() {
		return numrows;
	 }
	
	 // returns a count of the number of columns
	 public int getColumnCount() {
		return numcols;
	 }
	
	 // returns the data at the given row and column number
	 public Object getValueAt(int row, int col) {
		try {
		  return audienceResultList.get(row).getColumnData(col);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	 }
	
	 // table cells are not editable
	 public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	 }
	
	 public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	 }
	
	 // returns the name of the column
	 public String getColumnName(int col) {
		   try {
				return viewer.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	 // update the data in the given row and column to aValue
	 public void setValueAt(Object aValue, int row, int col) {
		//data[rowIndex][columnIndex] = (String) aValue;
		try {
		   Audience element = audienceResultList.get(row);
                   element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
		} catch(Exception err) {
			err.toString();
		}	
	 }
	
	 public List<Audience> getList() {
		 return audienceResultList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public AudienceTableModel(List<Audience> list, EntityManager em)  {
		 audienceResultList = list;
	    numrows = audienceResultList.size();
	    viewer = new Audience();
	   	numcols = viewer.getNumberOfColumns();     
		manager = em;  
		audienceService = new AudienceService(manager);
	 }
	 
	 // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
	 // The argument to this method is an array containing the data in the textfields of the new row.
	 public void addRow(Object[] array) {
		//data[rowIndex][columnIndex] = (String) aValue;
		try{	
	    // add row to database
		EntityTransaction userTransaction = manager.getTransaction();  
		userTransaction.begin();
		Audience newViewer = audienceService.createviewer((String) array[0], (String) array[1],  (String) array[2], (String) array[3], (String) array[4]);
		userTransaction.commit();
		
		// set the current row to rowIndex
        audienceResultList.add(newViewer);
        JOptionPane.showMessageDialog(window,"SignUp Successful","Confirm SignUP",JOptionPane.PLAIN_MESSAGE );
        int row = audienceResultList.size();  
        int col = 0;

        // update the data in the model to the entries in array
         for (Object data : array) {
          	 setValueAt((String) data, row-1, col++);
         }
         
         numrows++;
         LoginGUI LGui = new LoginGUI();
    	 LGui.showGUI();
    	 
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(window,"Username already exits.Try a different Username","UserName Invalid",JOptionPane.PLAIN_MESSAGE );
			
			//SignUpGUI gui1 = new SignUpGUI();
			//gui1.showGUI();
		}
		
	}	
	 private javax.swing.JFrame window;
}



