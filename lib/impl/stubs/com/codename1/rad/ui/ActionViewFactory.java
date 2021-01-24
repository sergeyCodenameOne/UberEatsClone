/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  A factory to create a view for a given action, which acts on the provided entity.
 *  @author shannah
 *  
 *  @see DefaultActionViewFactory
 *  @see com.codename1.rad.ui.UI#setDefaultActionViewFactory(com.codename1.rad.ui.ActionViewFactory) 
 *  @see com.codename1.rad.ui.UI#getDefaultActionViewFactory() 
 *  @see ActionNode
 *  @see Entity
 */
public interface ActionViewFactory {

	public com.codename1.ui.Component createActionView(com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.ActionNode action);
}
