/**
 *  This package contains a Table component similar to swing's JTable and associated renderer and editor classes.
 *  
 *  
 */
package ca.weblite.shared.components.table;


/**
 *  A Table UI component similar to swing's JTable.  Supports row selection, column selection, cell selection, and editing.
 *  @author shannah
 */
public class Table extends com.codename1.ui.Container {

	protected com.codename1.ui.Component editorComp;

	protected int editingRow;

	protected int editingColumn;

	public Table(TableModel model) {
	}

	public Table(TableModel model, TableCellRenderer renderer, TableCellEditor editor) {
	}

	/**
	 *  @return the selectionMode
	 */
	public SelectionMode getSelectionMode() {
	}

	/**
	 *  @param selectionMode the selectionMode to set
	 */
	public void setSelectionMode(SelectionMode selectionMode) {
	}

	/**
	 *  @return the selectionEnabled
	 */
	public boolean isSelectionEnabled() {
	}

	/**
	 *  @param selectionEnabled the selectionEnabled to set
	 */
	public void setSelectionEnabled(boolean selectionEnabled) {
	}

	public void setEditable(boolean editable) {
	}

	public void editCellAt(int row, int column) {
	}

	@java.lang.Override
	public void startEditingAsync() {
	}

	public TableModel getModel() {
	}

	@java.lang.Override
	public void stopEditing(Runnable onFinish) {
	}

	public boolean isEditing() {
	}

	@java.lang.Override
	public boolean isEditable() {
	}

	@java.lang.Override
	protected void initComponent() {
	}

	@java.lang.Override
	protected void deinitialize() {
	}

	public void setModel(TableModel model) {
	}

	public boolean isFocused(int row, int col) {
	}

	public void setTableCellRenderer(TableCellRenderer renderer) {
	}

	public void setTableCellEditor(TableCellEditor editor) {
	}

	protected com.codename1.ui.table.TableLayout createLayout() {
	}

	public class TableEvent {


		public TableEvent() {
		}
	}

	public class SelectionModeChangedEvent {


		public SelectionModeChangedEvent(SelectionMode selectionMode, boolean selectionEnabled) {
		}

		/**
		 *  @return the selectionEnabled
		 */
		public boolean isSelectionEnabled() {
		}

		/**
		 *  @return the selectionMode
		 */
		public SelectionMode getSelectionMode() {
		}
	}
}
