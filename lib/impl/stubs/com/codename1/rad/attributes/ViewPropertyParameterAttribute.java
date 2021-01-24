/**
 *  This package contains {@link Attribute} classes for use in UI descriptors.
 *  
 */
package com.codename1.rad.attributes;


/**
 *  Attribute to add a {@link ViewPropertyParameter} to a node.  This can be added to any node, as interested views can use {@link com.codename1.rad.nodes.Node#findInheritedAttribute(java.lang.Class) } to 
 *  obtain the parameter it wants.  
 *  @author shannah
 *  @see com.codename1.rad.ui.UI#param(com.codename1.rad.ui.ViewProperty, java.lang.Object) 
 *  @see com.codename1.rad.ui.UI#param(com.codename1.rad.ui.ViewProperty, com.codename1.rad.models.Tag...) 
 */
public class ViewPropertyParameterAttribute extends com.codename1.rad.models.Attribute {

	public ViewPropertyParameterAttribute(com.codename1.rad.ui.ViewPropertyParameter value) {
	}
}
