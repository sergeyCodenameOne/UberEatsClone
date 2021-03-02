/**
 *  This package contains a Table component similar to swing's JTable and associated renderer and editor classes.
 *  
 *  
 */
package ca.weblite.shared.components.table;


/**
 *  An abstract base class for the {@link TableCellRenderer}.
 *  @author shannah
 */
public abstract class AbstractTableCellRenderer implements TableCellRenderer {

	public AbstractTableCellRenderer() {
	}

	@java.lang.Override
	public com.codename1.ui.table.TableLayout.Constraint createCellConstraint(Table table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	}
}
