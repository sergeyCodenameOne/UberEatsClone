/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  Interface used by {@link EntityListView} for rendering its rows.
 *  @author shannah
 */
public interface EntityListCellRenderer {

	public EntityView getListCellRendererComponent(entityviews.EntityListView list, com.codename1.rad.models.Entity value, int index, boolean isSelected, boolean isFocused);
}
