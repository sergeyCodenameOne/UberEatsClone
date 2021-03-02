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
 *  A wrapper node for adding multiple actions to a Node hierarchy.  Common attributes that this will accept:
 *  
 *  . {@link ActionNode}
 *  . {@link Category}
 *  . {@link ActionStyle}
 *  
 *  @author shannah
 *  @see ActionNode
 *  @see Category
 *  @see ActionStyle
 *  @see com.codename1.rad.ui.UI#actions(com.codename1.rad.models.Attribute...) 
 *  @see com.codename1.rad.ui.UI#actions(com.codename1.rad.nodes.ActionNode.Category, com.codename1.rad.ui.Actions) 
 */
public class ActionsNode extends Node implements Iterable {

	public ActionsNode(com.codename1.rad.models.Attribute[] atts) {
	}

	@java.lang.Override
	public void setAttributes(com.codename1.rad.models.Attribute[] atts) {
	}

	public ActionNode.Category getCategory() {
	}

	@java.lang.Override
	public java.util.Iterator iterator() {
	}
}
