/**
 *  This package contains entity views - view components that are bound to an Entity value model.
 */
package com.codename1.rad.ui.entityviews;


/**
 *  A view that renders an {@link EntityList} visually.  This will bind to the list's events so that rows will animate in and 
 *  out appropriately when they are added to the model.  The list can be customized with a {@link EntityListCellRenderer}.
 *  
 *  @see ListCellRendererAttribute
 *  @see RowTemplateNode
 *  
 *  @author shannah
 */
public class EntityListView extends com.codename1.rad.ui.AbstractEntityView implements ca.weblite.shared.components.CollapsibleHeaderContainer.ScrollableContainer {

	/**
	 *  View property to configure whether the list is scrollable vertically.
	 */
	public static final com.codename1.rad.ui.ViewProperty SCROLLABLE_Y;

	/**
	 *  View property to configure whether the list is scrollable horizontally.
	 */
	public static final com.codename1.rad.ui.ViewProperty SCROLLABLE_X;

	/**
	 *  View property to configure whether inserting new rows should be animated.
	 */
	public static final com.codename1.rad.ui.ViewProperty ANIMATE_INSERTIONS;

	/**
	 *  View property to configure whether removing rows should be animated.
	 */
	public static final com.codename1.rad.ui.ViewProperty ANIMATE_REMOVALS;

	/**
	 *  View property to specify the layout of the list.  See {@link RowLayout}.
	 */
	public static final com.codename1.rad.ui.ViewProperty LAYOUT;

	/**
	 *  View property to specify the number of columns to use for the {@link RowLayout#Grid} layout.
	 */
	public static final com.codename1.rad.ui.ViewProperty COLUMNS;

	/**
	 *  View property to specify the number of columns to use in landscape mode for {@link RowLayout#Grid}
	 */
	public static final com.codename1.rad.ui.ViewProperty LANDSCAPE_COLUMNS;

	public EntityListView(com.codename1.rad.models.EntityList list) {
	}

	/**
	 *  Creates a list view for the given Entity list
	 *  @param list The view model to render.
	 *  @param node Node providing configuration and actions for the view.
	 */
	public EntityListView(com.codename1.rad.models.EntityList list, com.codename1.rad.nodes.ListNode node) {
	}

	/**
	 *  Sets whether to animate insertions into the list.  This can also be configured using the {@link #ANIMATE_INSERTIONS}
	 *  view property.
	 *  @param anim 
	 */
	public void setAnimateInsertions(boolean anim) {
	}

	/**
	 *  Checks if animation of row insertions is enabled.
	 *  @return 
	 */
	public boolean isAnimateInsertions() {
	}

	/**
	 *  Sets whether to animate removes from the list.  This can also be configured using the {@link #ANIMATE_REMOVALS} view property.
	 */
	public void setAnimateRemovals(boolean anim) {
	}

	/**
	 *  Checks if animate removals is enabled.
	 *  @return 
	 */
	public boolean isAnimateRemovals() {
	}

	public com.codename1.rad.ui.EntityView getRowViewForEntity(com.codename1.rad.models.Entity e) {
	}

	@java.lang.Override
	public void bindImpl() {
	}

	@java.lang.Override
	public void unbindImpl() {
	}

	public void setListCellRenderer(com.codename1.rad.ui.EntityListCellRenderer renderer) {
	}

	public com.codename1.rad.ui.EntityListCellRenderer getListCellRenderer() {
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

	/**
	 *  Gets the container that is scrollable, for scrolling through rows.
	 *  @return 
	 */
	public com.codename1.ui.Container getScrollWrapper() {
	}

	/**
	 *  A wrapper for {@link #getScrollWrapper() } to conform to the {@link ScrollableContainer} interface.
	 *  @return 
	 */
	@java.lang.Override
	public com.codename1.ui.Container getVerticalScroller() {
	}

	/**
	 *  Sets the layout used to render rows of the list.
	 *  @param l The layout used to render the list.
	 */
	public void setListLayout(com.codename1.ui.layouts.Layout l) {
	}

	/**
	 *  Gets the layout used to render the rows of the list.
	 *  @return 
	 */
	public com.codename1.ui.layouts.Layout getListLayout() {
	}

	@java.lang.Override
	public void setScrollableY(boolean scrollableY) {
	}

	/**
	 *  An enum to specify the layout used for the rows.
	 */
	public static final class RowLayout {


		/**
		 *  Layout the list in a BoxLayout.Y layout (i.e. vertical rows)
		 */
		public static final EntityListView.RowLayout Y;

		/**
		 *  Layout the list in a grid.  Use the {@link #COLUMNS} and {@link #LANDSCAPE_COLUMNS} view properties
		 *  to configure the number of columns in the grid.
		 */
		public static final EntityListView.RowLayout Grid;

		public static EntityListView.RowLayout[] values() {
		}

		public static EntityListView.RowLayout valueOf(String name) {
		}
	}
}
