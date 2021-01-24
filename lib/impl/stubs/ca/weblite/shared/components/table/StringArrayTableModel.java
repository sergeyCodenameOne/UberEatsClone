/**
 *  This package contains a Table component similar to swing's JTable and associated renderer and editor classes.
 *  
 *  
 */
package ca.weblite.shared.components.table;


/**
 *  A table model that gets its data from a {@link String} array.
 *  @author shannah
 */
public class StringArrayTableModel implements TableModel {

	/**
	 *  Create a new table cell model with the given data.
	 *  @param columns The number of columns
	 *  @param colnames The cell data.  The first {@literal columns} values are interpreted as the column names, and the rest is row data.
	 */
	public StringArrayTableModel(int columns, String[] colnames) {
	}

	@java.lang.Override
	public com.codename1.rad.models.ContentType getCellContentType(int row, int column) {
	}

	@java.lang.Override
	public int getColumnCount() {
	}

	@java.lang.Override
	public String getColumnName(int column) {
	}

	@java.lang.Override
	public int getRowCount() {
	}

	@java.lang.Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	}

	@java.lang.Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	}

	@java.lang.Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
	}

	@java.lang.Override
	public void addTableModelListener(com.codename1.ui.events.ActionListener l) {
	}

	@java.lang.Override
	public void removeTableModelListener(com.codename1.ui.events.ActionListener l) {
	}

	public void insertRow(int rowNum, String[] values) {
	}

	public void addRow(String[] values) {
	}

	public void deleteRow(int row) {
	}
}
