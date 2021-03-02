/**
 *  This package contains a Table component similar to swing's JTable and associated renderer and editor classes.
 *  
 *  
 */
package ca.weblite.shared.components.table;


/**
 *  Selection mode for a table.
 *  @author shannah
 */
public final class SelectionMode extends Enum {

	/**
	 *  Allow only row selection.
	 */
	public static final SelectionMode RowOnly;

	/**
	 *  Allow only column selection.
	 */
	public static final SelectionMode ColumnOnly;

	/**
	 *  Allow single cell selection.
	 */
	public static final SelectionMode SingleCell;

	/**
	 *  Allow cell range selection.
	 */
	public static final SelectionMode CellRange;

	public static SelectionMode[] values() {
	}

	public static SelectionMode valueOf(String name) {
	}
}
