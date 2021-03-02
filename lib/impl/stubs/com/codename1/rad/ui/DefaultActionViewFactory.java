/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  The default factory to use for creating views for actions.
 *  @author shannah
 *  @see com.codename1.rad.ui.UI#setDefaultActionViewFactory(com.codename1.rad.ui.ActionViewFactory) 
 *  @see com.codename1.rad.ui.UI#getDefaultActionViewFactory() 
 *  @see ActionNode
 *  @see Entity
 */
public class DefaultActionViewFactory implements ActionViewFactory {

	public DefaultActionViewFactory() {
	}

	@java.lang.Override
	public com.codename1.ui.Component createActionView(com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.ActionNode action) {
	}
}
