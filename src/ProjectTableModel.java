import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.*;
import javax.persistence.*;
import java.util.*;

public class ProjectTableModel extends AbstractTableModel {

	List<Project> projectResultList; // stores the model data in a List
										// collection of type Project
	private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit"; // Used
																			// in
																			// persistence.xml
	private static EntityManagerFactory factory; // JPA
	private EntityManager manager; // JPA
	private Project project; // represents the entity project
	private ProjectService projectService;

	// This field contains additional information about the results
	int numcols, numrows; // number of rows and columns

	ProjectTableModel() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		manager = factory.createEntityManager();
		project = new Project();
		projectService = new ProjectService(manager);

		// read all the records from project
		 projectResultList = projectService.readAll();

		// update the number of rows and columns in the model
		numrows = projectResultList.size();
		numcols = project.getNumberOfColumns();
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
			return projectResultList.get(row).getColumnData(col);
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
			return project.getColumnName(col);
		} catch (Exception err) {
			return err.toString();
		}
	}

	// update the data in the given row and column to aValue
	public void setValueAt(Object aValue, int row, int col) {
		// data[rowIndex][columnIndex] = (String) aValue;
		try {
			Project element = projectResultList.get(row);
			element.setColumnData(col, aValue);
			fireTableCellUpdated(row, col);
		} catch (Exception err) {
			err.toString();
		}
	}

	public List<Project> getList() {
		return projectResultList;
	}

	public EntityManager getEntityManager() {
		return manager;
	}

	// create a new table model using the existing data in list
	public ProjectTableModel(List<Project> list, EntityManager em) {
		projectResultList = list;
		numrows = projectResultList.size();
		project = new Project();
		numcols = project.getNumberOfColumns();
		System.out.println(numcols);
		manager = em;
		projectService = new ProjectService(manager);
	}
	
	public String generateNewID() {
		int maxID = 0;
		int tempID;
		for (Project p : projectResultList) {
			tempID = Integer.parseInt(p.getProjectID());
			if (tempID > maxID) {
				maxID = tempID;
			}
		}
		return String.format("%03d", maxID + 1);
	}

	// In this method, a newly inserted row in the GUI is added to the table
	// model as well as the database table
	// The argument to this method is an array containing the data in the
	// textfields of the new row.
	public void addRow(Object[] array) {
		// data[rowIndex][columnIndex] = (String) aValue;

		// add row to database
		EntityTransaction userTransaction = manager.getTransaction();
		userTransaction.begin();
		Project newRecord = projectService.createProject((String) array[0],
				(String) array[1], (String) array[2], (String) array[3],
				(String) array[4], (String) array[5], (String) array[6],
				(String) array[7], (String) array[8], (String) array[9]);
		userTransaction.commit();

		// set the current row to rowIndex
		projectResultList.add(newRecord);
		int row = projectResultList.size();
		int col = 0;

		// update the data in the model to the entries in array
		for (Object data : array) {
			setValueAt((String) data, row - 1, col++);
		}

		numrows++;
	}

	public void addRows(List<Project> array) {
		ProjectTableModel tableModel = new ProjectTableModel(array, manager);
		int row = array.size();
		int col = 0;
		for (Project data : array) {
			setValueAt(data, row - 1, col++);
		}

	}
	
	public void updateRow(int index, Object[] array) {
		// data[rowIndex][columnIndex] = (String) aValue;
		EntityTransaction userTransaction = manager.getTransaction();
		userTransaction.begin();
		Project updateRecord = projectService.updateProject((String) array[0],
				(String) array[1], (String) array[2], (String) array[3],
				(String) array[4], (String) array[5], (String) array[6],
				(String) array[7], (String) array[8], (String) array[9]);
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
		projectService.deleteProject((String) getValueAt(index, 0));
		userTransaction.commit();

		projectResultList.remove(index);

		int row;
		int col;
		for (row = index; row < numrows; row++) {
			for (col = 0; col < numcols; col++) {
				fireTableCellUpdated(row, col);
			}
		}
		numrows--;
	}

	public String[] getProjNameComboBoxesData() {
		String[] projNameList = new String[numrows];
		for (int row = 0; row < numrows; row++) {
			projNameList[row] = getValueAt(row, 1).toString();
		}
		return projNameList;
	}

	public List<String> getCategoryComboBoxesData() {
		return projectService.getCategoryComboBoxesData();
	}

	public List<String> getStatusComboBoxesData() {
		return projectService.getStatusComboBoxesData();
	}

	public List<String> getScopeComboBoxesData() {
		return projectService.getScopeComboBoxesData();
	}

	public ProjectTableModel search(Object[] array) {
		EntityTransaction userTransaction = manager.getTransaction();
		userTransaction.begin();
		List<Project> projectSearchResultList = projectService.Search(
				(String) array[0], (String) array[1], (String) array[2],
				(String) array[3], (String) array[4], (String) array[5],
				(String) array[6], (String) array[7], (String) array[8]);
		// projectResultList.addAll(projectSearchResultList);
		ProjectTableModel tbmodel = new ProjectTableModel(
				projectSearchResultList, manager);
		userTransaction.commit();
		return tbmodel;
	}

	public ProjectTableModel search_file(Object[] array) {
		EntityTransaction userTransaction = manager.getTransaction();
		userTransaction.begin();
		List<Project> projectSearchResultList = projectService.Search_file(
				(String) array[0], (String) array[1], (String) array[2]);
		// projectResultList.addAll(projectSearchResultList);
		ProjectTableModel tbmodel = new ProjectTableModel(
				projectSearchResultList, manager);
		userTransaction.commit();
		return tbmodel;
	}
}
