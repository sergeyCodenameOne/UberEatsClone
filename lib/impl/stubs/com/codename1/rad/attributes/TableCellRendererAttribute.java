/**
 *  This package contains {@link Attribute} classes for use in UI descriptors.
 *  
 */
package com.codename1.rad.attributes;


/**
 *  An attribute for specifying the {@link TableCellRenderer} of a a {@link Table}.  
 *  This can be added to any Node, as interested views can obtain it using {@link com.codename1.rad.nodes.Node#findInheritedAttribute(java.lang.Class) }.
 *  
 *  The primary target of this attribute is the {@link FieldNode} with the {@link WidgetType#TABLE} type (ie. {@link com.codename1.rad.ui.UI#table(com.codename1.rad.models.Attribute...) }.
 *  
 *  @author shannah
 *  @see com.codename1.rad.ui.UI#table(com.codename1.rad.models.Attribute...) 
 *  @see com.codename1.rad.ui.UI#cellRenderer(ca.weblite.shared.components.table.TableCellRenderer) 
 */
public class TableCellRendererAttribute extends com.codename1.rad.models.Attribute {

	public TableCellRendererAttribute(ca.weblite.shared.components.table.TableCellRenderer value) {
	}
}
