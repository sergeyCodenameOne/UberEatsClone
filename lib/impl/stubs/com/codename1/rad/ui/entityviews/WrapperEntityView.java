/**
 *  This package contains entity views - view components that are bound to an Entity value model.
 */
package com.codename1.rad.ui.entityviews;


/**
 *  An entity view that is made explicitly to wrap another component.  
 *  May be handy if you have a renderer that must return an EntityView, and all you have
 *  is a regular component, then you can wrap the component in this view, and return it.
 *  @author shannah
 */
public class WrapperEntityView extends com.codename1.rad.ui.AbstractEntityView {

	public WrapperEntityView(com.codename1.ui.Component wrapped, com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.Node viewNode) {
	}

	@java.lang.Override
	public void update() {
	}

	@java.lang.Override
	public void commit() {
	}

	@java.lang.Override
	public com.codename1.rad.nodes.Node getViewNode() {
	}
}
