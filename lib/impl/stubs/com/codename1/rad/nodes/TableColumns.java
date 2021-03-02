/**
 *  This package contains {@link Node} classes for use inside UI descriptors.
 *  
 *  = Models
 *  :toc:
 *  
 *  == Introduction
 *  
 *  === Entities
 *  
 *  === EntityTypes
 *  
 *  
 *  === Properties
 *  
 *  
 *  === Attributes
 *  
 *  
 *  === Tags
 *  
 *  
 *  
 */
package com.codename1.rad.nodes;


/**
 *  A node that specifies the columns that should be included in a {@link Table}.  This node should be added to the {@link FieldNode} with type {@link com.codename1.rad.attributes.WidgetType#TABLE}.
 *  
 *  == Example
 *  
 *  [source,java]
 *  ----
 *  ...
 *  table(actions(OVERFLOW_MENU, deleteAction, printAction),
 *         label("Quick Links"),
 *         description("Useful links related to this person"),
 *         editable(true),
 *         //property(quicklinks),
 *         tags(com.codename1.rad.schemas.Person.url),
 *         columns(new QuickLinkEditor().getAllFields()) <1>
 *  )
 *   ...
 *  ---
 *  <1> This example imports all of the fields from another UI descriptor, and adds them as columns to this table. 
 *  
 *  
 *  @author shannah
 *  
 *  @see com.codename1.rad.ui.UI#columns(com.codename1.rad.nodes.FieldNode...) 
 *  @see com.codename1.rad.ui.UI#table(com.codename1.rad.models.Attribute...) 
 */
public class TableColumns extends Node implements Iterable {

	public TableColumns(FieldNode[] atts) {
	}

	@java.lang.Override
	public void setAttributes(com.codename1.rad.models.Attribute[] atts) {
	}

	@java.lang.Override
	public java.util.Iterator iterator() {
	}

	public FieldNode getColumn(int column) {
	}

	public FieldNode[] toFieldArray() {
	}

	public int getColumnCount() {
	}
}
