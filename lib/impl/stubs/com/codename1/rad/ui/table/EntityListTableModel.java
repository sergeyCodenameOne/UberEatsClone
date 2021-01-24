/**
 *  This package contains bindable implementations of the classes in the {@link ca.weblite.shared.components.table} package.
 */
package com.codename1.rad.ui.table;


/**
 *  A table model that allows using a {@link Table} to render and edit an EntityList.
 *  @author shannah
 */
public class EntityListTableModel implements ca.weblite.shared.components.table.TableModel {

	public EntityListTableModel(com.codename1.rad.models.EntityType rowType, com.codename1.rad.models.EntityList entities, com.codename1.rad.nodes.TableColumns columnsNode) {
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

	public com.codename1.rad.models.Property getColumnProperty(int column) {
	}

	public com.codename1.rad.models.Entity getEntity(int row) {
	}

	public com.codename1.rad.nodes.FieldNode getColumnField(int column) {
	}

	public com.codename1.rad.models.EntityList getEntityList() {
	}
}
