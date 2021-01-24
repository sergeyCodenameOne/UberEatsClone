/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  An interface for decorating PropertyViews. If you add this (via {@link com.codename1.rad.attributes.PropertyViewDecoratorAttribute} or
 *  {@link com.codename1.rad.nodes.PropertyViewDecoratorNode}) to a {@link FieldNode}, its {@link #decorate(com.codename1.rad.ui.PropertyView) }
 *  method will be executed on the {@link PropertyView} just after it is created by the {@link DefaultPropertyViewFactory}.
 *  @author shannah
 *  
 *  @see com.codename1.rad.attributes.PropertyViewDecoratorAttribute
 *  @see com.codename1.rad.nodes.PropertyViewDecoratorNode
 *  
 */
public interface PropertyViewDecorator {

	/**
	 *  Decorates a property view.
	 *  @param propertyView The property view to decorate.
	 *  @return The decorated property view.  Generally the same object that was received as an argument.
	 */
	public PropertyView decorate(PropertyView propertyView);
}
