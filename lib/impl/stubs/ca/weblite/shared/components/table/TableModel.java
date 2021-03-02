/**
 *  This package contains a Table component similar to swing's JTable and associated renderer and editor classes.
 *  
 *  
 */
package ca.weblite.shared.components.table;


/**
 *  A model for the content of a {@link Table}.
 *  @author shannah
 */
public interface TableModel {

	/**
	 *  Get the content type of a cell.
	 *  @param row The row.
	 *  @param column The column
	 *  @return The content type of the cell.
	 */
	public com.codename1.rad.models.ContentType getCellContentType(int row, int column);

	/**
	 *  Get the number of columns in the model.
	 *  @return The number of columns.
	 */
	public int getColumnCount();

	/**
	 *  Get the name of the given column
	 *  @param column The column number
	 *  @return The column name.
	 */
	public String getColumnName(int column);

	/**
	 *  Get the number of rows in the model.
	 *  @return The number of rows.
	 */
	public int getRowCount();

	/**
	 *  Get the value of a particular cell.
	 *  @param rowIndex The row of the cell
	 *  @param columnIndex The column of the cell
	 *  @return The cell content.
	 */
	public Object getValueAt(int rowIndex, int columnIndex);

	/**
	 *  Check if the cell is editable.
	 *  @param rowIndex The row
	 *  @param columnIndex The column
	 *  @return 
	 */
	public boolean isCellEditable(int rowIndex, int columnIndex);

	/**
	 *  Set the value in a cell.
	 *  @param value The value to set.
	 *  @param rowIndex The row
	 *  @param columnIndex The column
	 */
	public void setValueAt(Object value, int rowIndex, int columnIndex);

	/**
	 *  Add a listener to be notified of changes to the model.
	 *  @param l 
	 */
	public void addTableModelListener(com.codename1.ui.events.ActionListener l);

	/**
	 *  Remove a listener.
	 *  @param l 
	 */
	public void removeTableModelListener(com.codename1.ui.events.ActionListener l);
}
