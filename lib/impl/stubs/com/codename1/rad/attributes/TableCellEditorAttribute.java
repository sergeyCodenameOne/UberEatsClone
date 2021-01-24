/**
 *  This package contains {@link Attribute} classes for use in UI descriptors.
 *  
 */
package com.codename1.rad.attributes;


/**
 *  Attribute used by {@link Table} to specify the cell editor for a table. 
 *  This can be added to any Node, as interested views can obtain it using {@link com.codename1.rad.nodes.Node#findInheritedAttribute(java.lang.Class) }.
 *  
 *  The primary target of this attribute is the {@link FieldNode} with the {@link WidgetType#TABLE} type (ie. {@link com.codename1.rad.ui.UI#table(com.codename1.rad.models.Attribute...) }.
 *  @author shannah
 *  @see com.codename1.rad.ui.UI#cellEditor(ca.weblite.shared.components.table.TableCellEditor) 
 */
public class TableCellEditorAttribute extends com.codename1.rad.models.Attribute {

	public TableCellEditorAttribute(ca.weblite.shared.components.table.TableCellEditor value) {
	}
}
