

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.*;
import javax.persistence.*;
import java.util.*;

public class PeopleTableModel extends AbstractTableModel {

	List<People> peopleResultList; // stores the model data in a List
									// collection of type File
	private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit"; // Used
																			// in
																			// persistence.xml
	private static EntityManagerFactory factory; // JPA
	private EntityManager manager; // JPA
	private People people; // represents the entity file
	private PeopleService peopleService;
	private int tempPeopleID;
	
	// This field contains additional information about the results
	int numcols, numrows; // number of rows and columns

	PeopleTableModel() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		manager = factory.createEntityManager();
		people = new People();
		peopleService = new PeopleService(manager);

		// read all the records from file
		peopleResultList = peopleService.readAll();

		// update the number of rows and columns in the model
		numrows = peopleResultList.size();
		numcols = people.getNumberOfColumns();
		
		tempPeopleID = 0;
		int tempID;
		for (People p : peopleResultList) {
			tempID = Integer.parseInt(p.getPersonID());
			if (tempID > tempPeopleID) {
				tempPeopleID = tempID;
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
			return peopleResultList.get(row).getColumnData(col);
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
			return people.getColumnName(col);
		} catch (Exception err) {
			return err.toString();
		}
	}

	// update the data in the given row and column to aValue
	public void setValueAt(Object aValue, int row, int col) {
		// data[rowIndex][columnIndex] = (String) aValue;
		try {
			People element = peopleResultList.get(row);
			element.setColumnData(col, aValue);
			fireTableCellUpdated(row, col);
		} catch (Exception err) {
			err.toString();
		}
	}

	public List<People> getList() {
		return peopleResultList;
	}

	public EntityManager getEntityManager() {
		return manager;
	}

	// create a new table model using the existing data in list
	public PeopleTableModel(List<People> list, EntityManager em) {
		peopleResultList = list;
		numrows = peopleResultList.size();
		people = new People();
		numcols = people.getNumberOfColumns();
		manager = em;
		peopleService = new PeopleService(manager);
	}

	//public String generateNewID() {
	//	return String.format("%03d", nextFileID);
	//}
	
	// In this method, a newly inserted row in the GUI is added to the table
	// model as well as the database table
	// The argument to this method is an array containing the data in the
	// textfields of the new row.
	public void addRow(Object[] array) {
		// data[rowIndex][columnIndex] = (String) aValue;

		// add row to database
		EntityTransaction userTransaction = manager.getTransaction();
		userTransaction.begin();
		People newRecord = peopleService.createPeople((String) array[0],
				(String) array[1], (String) array[2], (String) array[3]);
		userTransaction.commit();

		// set the current row to rowIndex
		peopleResultList.add(newRecord);
		int row = peopleResultList.size();
		int col = 0;

		// update the data in the model to the entries in array
		for (Object data : array) {
			setValueAt((String) data, row - 1, col++);
		}

		numrows++;
	}

	public void updateRow(int index, Object[] array) {
		// data[rowIndex][columnIndex] = (String) aValue;
		EntityTransaction userTransaction = manager.getTransaction();
		userTransaction.begin();
		People updateRecord = peopleService.updatePeople((String) array[0],
				(String) array[1], (String) array[2], (String) array[3]);
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
		peopleService.deletePeople((String) getValueAt(index, 0));
		userTransaction.commit();

		peopleResultList.remove(index);

		int row;
		int col;
		for (row = index; row < numrows; row++) {
			for (col = 0; col < numcols; col++) {
				fireTableCellUpdated(row, col);
			}
		}
		numrows--;
	}
	
	public void filterPeopleList(String projID){
	
		peopleResultList = peopleService.readAll();
		System.out.println(peopleResultList.size());
		String currentID="";
		int i = 0;
		while(i < peopleResultList.size()) {	
			try{
			 currentID = peopleResultList.get(i).getColumnData(2);
			 if(!projID.equals(currentID))
			 {
				 peopleResultList.remove(i);
			 }
			 else {
				 i++;
			 }
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
		System.out.println(peopleResultList.size());
		int row;
		int col;
		for (row = 0; row < numrows; row++) {
			for (col = 0; col < numcols; col++) {
				fireTableCellUpdated(row, col);
			}
		}
		numrows = peopleResultList.size();
	}
	
	public int getTempPeopleID() {
		return tempPeopleID;
	}
	
	public PeopleTableModel search_people(Object[] array)
	 {
		 EntityTransaction userTransaction = manager.getTransaction();  
			userTransaction.begin();
			List<People> peopleSearchResultList = peopleService.Search_people((String) array[0], (String) array[1], (String) array[2]);
			//projectResultList.addAll(projectSearchResultList);
			PeopleTableModel tbmodel = new PeopleTableModel(peopleSearchResultList,manager);
			userTransaction.commit();
			return tbmodel;
	 }
	
}

