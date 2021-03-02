/**
 *  This package contains entity views - view components that are bound to an Entity value model.
 */
package com.codename1.rad.ui.entityviews;


/**
 *  A view which displays a label representing a given entity.  This will display the entity name {@link Thing.name} 
 *  as the text, and the entity's icon (one of {@link Thing.thumbnailUrl}, {@link Thing.image}).
 *  
 *  <p>The full-arg constructor accepts the actual Label which will be wrapped, along with a placeholder
 *  icon and an image adapter, so that the icon can be loaded as a URLImage.
 *  
 *  @author shannah
 */
public class LabelEntityView extends com.codename1.rad.ui.AbstractEntityView {

	public LabelEntityView(com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.ViewNode node, com.codename1.ui.Label label, int iconWidth, int iconHeight) {
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

	public com.codename1.ui.Label getLabel() {
	}
}
