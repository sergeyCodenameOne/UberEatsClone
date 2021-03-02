/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  An interface used by views that can bind to entities.
 *  @author shannah
 */
public interface EntityView {

	public void bind();

	public void unbind();

	public void update();

	public void commit();

	public void setEntity(com.codename1.rad.models.Entity entity);

	public com.codename1.rad.models.Entity getEntity();

	public com.codename1.rad.nodes.Node getViewNode();
}
