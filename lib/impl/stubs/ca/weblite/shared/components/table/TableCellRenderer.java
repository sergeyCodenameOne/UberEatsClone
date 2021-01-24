/**
 *  This package contains a Table component similar to swing's JTable and associated renderer and editor classes.
 *  
 *  
 */
package ca.weblite.shared.components.table;


/**
 *  An interface used to create components which display data in a cell of a {@link Table}.
 *  @author shannah
 */
public interface TableCellRenderer {

	/**
	 *  Create a component to display the content of a particular cell of the table.
	 *  @param table The table.
	 *  @param value The cell value to display.
	 *  @param isSelected Whether the cell is currently selected.
	 *  @param hasFocus Whether the cell currently has focus.
	 *  @param row The row number (0-based).
	 *  @param column The column number (0-based)
	 *  @return The component to display the content.
	 */
	public com.codename1.ui.Component getTableCellRendererComponent(Table table, Object value, boolean isSelected, boolean hasFocus, int row, int column);

	public com.codename1.ui.table.TableLayout.Constraint createCellConstraint(Table table, Object value, boolean isSelected, boolean hasFocus, int row, int column);
}
