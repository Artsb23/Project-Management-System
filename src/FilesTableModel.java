
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.*;
import javax.persistence.*;
import java.util.*;

public class FilesTableModel extends AbstractTableModel {

	  List<Files> fileResultList;   // stores the model data in a List collection of type Project
	  private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;				// JPA 
	  private Files file;			    // represents the entity project
	  private FileService fileService;
	  private int tempFileID;
	  
	   // This field contains additional information about the results   
	    int numcols, numrows;           // number of rows and columns

	    FilesTableModel() {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    file = new Files();
	    fileService = new FileService(manager);
	    
	    // read all the records from project
	    fileResultList = fileService.readAll();
	    
	    // update the number of rows and columns in the model
	    numrows = fileResultList.size();
		numcols = file.getNumberOfColumns();
		
		tempFileID = 0;
		int tempID;
		for (Files p : fileResultList) {
			tempID = Integer.parseInt(p.getFileID());
			if (tempID > tempFileID) {
				tempFileID = tempID;
			}
		}
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
		  return fileResultList.get(row).getColumnData(col);
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
				return file.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	 // update the data in the given row and column to aValue
	 public void setValueAt(Object aValue, int row, int col) {
		//data[rowIndex][columnIndex] = (String) aValue;
		try {
		   Files element = fileResultList.get(row);
                   element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
		} catch(Exception err) {
			err.toString();
		}	
	 }
	
	 public List<Files> getList() {
		 return fileResultList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public FilesTableModel(List<Files> list, EntityManager em)  {
	    fileResultList = list;
	    numrows = fileResultList.size();
	    file = new Files();
	   	numcols = file.getNumberOfColumns();     
		manager = em;  
		fileService = new FileService(manager);
	 }
	 
	 // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
	 // The argument to this method is an array containing the data in the textfields of the new row.
	 public void addRow(Object[] array) {
		//data[rowIndex][columnIndex] = (String) aValue;
			
	    // add row to database
		EntityTransaction userTransaction = manager.getTransaction();  
		userTransaction.begin();
		Files newRecord = fileService.createFile((String) array[0], (String) array[1], (String) array[2], (String) array[3], (String) array[4]);
		userTransaction.commit();
		 
		// set the current row to rowIndex
        fileResultList.add(newRecord);
        int row = fileResultList.size();  
        int col = 0;

        // update the data in the model to the entries in array
         for (Object data : array) {
          	 setValueAt((String) data, row-1, col++);
         }
         
         numrows++;
	}
	 
	 public void addRows(List<Files> array) {
		 FilesTableModel tableModel = new FilesTableModel(array, manager);
		 int row = array.size();  
	        int col = 0;
		 for (Files data : array) {
          	 setValueAt(data, row-1, col++);
         }
		 
	 }
	 public void updateRow(int index, Object[] array) {
		// data[rowIndex][columnIndex] = (String) aValue;
		EntityTransaction userTransaction = manager.getTransaction();
		userTransaction.begin();
		Files updateRecord = fileService.updateFiles((String) array[0],
				(String) array[1], (String) array[2], (String) array[3],
				(String) array[4]);
		userTransaction.commit();

		// set the current row to rowIndex
		int col = 0;

		// update the data in the model to the entries in array
		for (Object data : array) {
			setValueAt((String) data, index, col++);
		}
	}

	public void deleteRow(int index) {
		// delete row from database
		EntityTransaction userTransaction = manager.getTransaction();
		userTransaction.begin();
		fileService.deleteFile((String) getValueAt(index, 0));
		userTransaction.commit();

		fileResultList.remove(index);

		int row;
		int col;
		for (row = index; row < numrows; row++) {
			for (col = 0; col < numcols; col++) {
				fireTableCellUpdated(row, col);
			}
		}
		numrows--;
	}
	
	public void filterFileList(String projID){
	
		fileResultList = fileService.readAll();
		//System.out.println(fileResultList.size());
		String currentID="";
		int i = 0;
		while(i < fileResultList.size()) {	
			try{
			 currentID = fileResultList.get(i).getColumnData(1);
			 if(!projID.equals(currentID))
			 {
				 fileResultList.remove(i);
			 }
			 else {
				 i++;
			 }
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
		//System.out.println(fileResultList.size());
		int row;
		int col;
		for (row = 0; row < numrows; row++) {
			for (col = 0; col < numcols; col++) {
				fireTableCellUpdated(row, col);
			}
		}
		numrows = fileResultList.size();
	}
	
	public int getTempFileID() {
		return tempFileID;
	}
	 
	 public FilesTableModel search_file(Object[] array)
	 {
		 EntityTransaction userTransaction = manager.getTransaction();  
			userTransaction.begin();
			List<Files> fileSearchResultList = fileService.Search_file((String) array[0], (String) array[1], (String) array[2]);
			//projectResultList.addAll(projectSearchResultList);
			FilesTableModel tbmodel = new FilesTableModel(fileSearchResultList,manager);
			userTransaction.commit();
			return tbmodel;
	 }
}


