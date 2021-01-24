/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  Factory for creating a property view.  I.e. Renders a {@link FieldNode} as a {@link PropertyView}.
 *  @author shannah
 */
public interface PropertyViewFactory {

	public PropertyView createPropertyView(com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.FieldNode field);
}
