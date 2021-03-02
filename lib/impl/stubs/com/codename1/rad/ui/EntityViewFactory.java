/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  A factory for converting {@link ViewNode} objects into views.
 *  @author shannah
 */
public interface EntityViewFactory {

	public EntityView createView(com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.ViewNode node);
}
