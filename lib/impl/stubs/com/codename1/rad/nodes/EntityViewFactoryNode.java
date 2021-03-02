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
 *  A node containing an {@link EntityViewFactory}.  This node can be added to any part of the node hierarchy.  Views that
 *  are interested in retrieving the factory will call {@link ViewNode#getViewFactory() }, which will find the first 
 *  view factory registered when walking up the node hierarchy. 
 *  @author shannah
 *  @see com.codename1.rad.ui.UI#viewFactory(com.codename1.rad.ui.EntityViewFactory, com.codename1.rad.models.Attribute...) 
 *  @see EntityViewFactory
 *  @see DefaultEntityViewFactory
 *  @see ViewNode#getViewFactory()
 *  @see com.codename1.rad.ui.UI#getDefaultEntityViewFactory() 
 *  @see com.codename1.rad.ui.UI#setDefaultEntityViewFactory(com.codename1.rad.ui.EntityViewFactory) 
 */
public class EntityViewFactoryNode extends Node {

	public EntityViewFactoryNode(com.codename1.rad.ui.EntityViewFactory value, com.codename1.rad.models.Attribute[] atts) {
	}
}
