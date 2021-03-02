/**
 *  This package contains {@link Attribute} classes for use in UI descriptors.
 *  
 */
package com.codename1.rad.attributes;


/**
 *  An attribute for specifying the list cell renderer for a {@link com.codename1.rad.ui.entityviews.EntityListView}.  
 *  
 *  This attribute can be added to any node, as nodes that are interested in rendering a list cell, may 
 *  use {@link com.codename1.rad.nodes.Node#findInheritedAttribute(java.lang.Class) to find a renderer from its parents.
 *  @author shannah
 *  @see com.codename1.rad.ui.UI#cellRenderer(com.codename1.rad.ui.EntityListCellRenderer) 
 */
public class ListCellRendererAttribute extends com.codename1.rad.models.Attribute {

	public ListCellRendererAttribute(com.codename1.rad.ui.EntityListCellRenderer value) {
	}
}
