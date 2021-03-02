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
 *  A node representing an EntityView.
 *  @author shannah
 */
public class ViewNode extends Node {

	public ViewNode(com.codename1.rad.models.Attribute[] atts) {
	}

	public com.codename1.rad.attributes.IconRendererAttribute getIconRenderer() {
	}

	public com.codename1.rad.ui.EntityViewFactory getViewFactory(com.codename1.rad.ui.EntityViewFactory defaultVal) {
	}

	public com.codename1.rad.ui.EntityViewFactory getViewFactory() {
	}

	public com.codename1.rad.ui.EntityView createView(com.codename1.rad.models.Entity entity) {
	}

	public com.codename1.rad.ui.EntityView createView(com.codename1.rad.models.Entity entity, com.codename1.rad.ui.EntityViewFactory defaultFactory) {
	}
}
