import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.event.*;

public class ProjectTableController implements ListSelectionListener,
		TableModelListener {
	private ProjectTableModel tableModel;
	private SearchGUI gui;
	private SearchesGUI gui1;
	private NewAdminGUI admingui;
	private int selectedRow;

	public ProjectTableController(SearchGUI gui) {
		this.gui = gui;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new ProjectTableModel();
		tableModel.addTableModelListener(this);
	}
	
	public ProjectTableController(NewAdminGUI admingui) {
		this.admingui = admingui;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new ProjectTableModel();
		tableModel.addTableModelListener(this);
	}

	public ProjectTableController(SearchesGUI gui) {
		this.gui1 = gui;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new ProjectTableModel();
		tableModel.addTableModelListener(this);
	}

	// new code
	public TableModel getTableModel() {
		return tableModel;
	}

	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		int firstIndex = selectModel.getMinSelectionIndex();

		// read the data in each column using getValueAt and display it on
		// corresponding textfield
		admingui.setProjNameTextField((String) tableModel.getValueAt(firstIndex, 1));
		admingui.setCategoryTextField((String) tableModel.getValueAt(firstIndex, 6));
		admingui.setStatusComboBox((String) tableModel.getValueAt(firstIndex, 5));
		admingui.setOutcomeTextField((String) tableModel.getValueAt(firstIndex, 7));
		admingui.setScopeTextField((String) tableModel.getValueAt(firstIndex, 4));
		admingui.setFromDateTextField((String) tableModel.getValueAt(firstIndex, 2));
		admingui.setToDateTextField((String) tableModel.getValueAt(firstIndex, 3));
		admingui.updateFileComboBox();
		admingui.updatePeopleComboBox();

		selectedRow = firstIndex;
	}

	public void tableChanged(TableModelEvent e) {
		try {
			// get the index of the inserted row
			// tableModel.getRowSet().moveToCurrentRow();
			int firstIndex = e.getFirstRow();

			// create a new table model with the new data
			tableModel = new ProjectTableModel(tableModel.getList(),
					tableModel.getEntityManager());
			tableModel.addTableModelListener(this);

			// update the JTable with the data
			admingui.updateTable();

			// read the data in each column using getValueAt and display it on
			// corresponding textfield
			admingui.setProjNameTextField((String) tableModel.getValueAt(firstIndex,
					1));
			admingui.setCategoryTextField((String) tableModel.getValueAt(firstIndex,
					6));
			admingui.setStatusComboBox((String) tableModel.getValueAt(firstIndex, 5));
			admingui.setOutcomeTextField((String) tableModel.getValueAt(firstIndex,
					7));
			admingui.setScopeTextField((String) tableModel.getValueAt(firstIndex, 4));
			admingui.setFromDateTextField((String) tableModel.getValueAt(firstIndex,
					2));
			admingui.setToDateTextField((String) tableModel
					.getValueAt(firstIndex, 3));
			admingui.updateFileComboBox();
			admingui.updatePeopleComboBox();

		} catch (Exception exp) {
			exp.getMessage();
			exp.printStackTrace();
		}
	}

	public TableModel search(String[] array) {
		TableModel results = tableModel.search(array);
		return results;

	}

	public TableModel search_file(String[] array) {
		TableModel results = tableModel.search_file(array);
		return results;

	}

	public String[] getCategoryComboBoxesData() {
		List<String> data = tableModel.getCategoryComboBoxesData();
		String[] strarray = data.toArray(new String[0]);
		return strarray;
	}

	public String[] getStatusComboBoxesData() {
		List<String> data = tableModel.getStatusComboBoxesData();
		String[] strarray = data.toArray(new String[0]);
		return strarray;
	}

	public String[] getScopeComboBoxesData() {
		List<String> data = tableModel.getScopeComboBoxesData();
		String[] strarray = data.toArray(new String[0]);
		return strarray;
	}

	public void addRow(String[] array) {
		array[0] = tableModel.generateNewID();
		tableModel.addRow(array);
		// gui.updateFileComboBox();
	}
	
	public void updateRow(String[] array) {
		array[0] = (String) tableModel.getValueAt(selectedRow, 0);
		tableModel.updateRow(selectedRow, array);
		// gui.updateFileComboBox();
	}

	public void deleteRow(String projName) {
		if (projName.equals((String) tableModel.getValueAt(selectedRow, 1))) {
			tableModel.deleteRow(selectedRow);
		}
		// gui.updateFileComboBox();
	}

	public String[] getProjNameComboBoxesData() {
		return tableModel.getProjNameComboBoxesData();
	}
}
