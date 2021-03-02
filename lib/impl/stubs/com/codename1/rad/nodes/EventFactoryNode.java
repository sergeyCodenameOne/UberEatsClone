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
 *  A node that wraps an {@link EventFactory}.  This can be added to any part of the Node hierarchy, as 
 *  actions will walk up the tree until it finds a factory when it needs to generate events.
 *  @author shannah
 *  
 *  @see EventFactory
 *  @see com.codename1.rad.ui.UI#eventFactory(com.codename1.rad.events.EventFactory, com.codename1.rad.models.Attribute...) 
 */
public class EventFactoryNode extends Node {

	public EventFactoryNode(com.codename1.rad.events.EventFactory value, com.codename1.rad.models.Attribute[] atts) {
	}
}
