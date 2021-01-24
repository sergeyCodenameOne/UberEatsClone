/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  A decorator that can be added to an {@link ActionNode} to decorate the resulting component
 *  from the {@link DefaultActionViewFactory}.
 *  @author shannah
 */
public interface ComponentDecorator {

	/**
	 *  Decorates a component.
	 *  @param cmp The component to be decorated.
	 */
	public void decorate(com.codename1.ui.Component cmp);
}
