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
 *  A {@link Node} for binding a {@link FieldNode} to a {@link Property}.
 *  
 *  WARNING: Avoid binding {@link FieldNode}s directly to {@link Property}s.  This results in a tight coupling between the view and the model.  Prefer to bind to a {@link Tag} so that binding can occur dynamically, 
 *  by binding to a {@link Property} that has that {@link Tag} at render time.
 *  
 *  @author shannah
 *  @see FieldNode
 *  @see com.codename1.rad.ui.UI#property(com.codename1.rad.models.Property, com.codename1.rad.models.Attribute...) 
 */
public class PropertyNode extends Node {

	public PropertyNode(com.codename1.rad.models.Property value, com.codename1.rad.models.Attribute[] atts) {
	}
}
