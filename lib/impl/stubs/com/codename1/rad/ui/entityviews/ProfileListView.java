/**
 *  This package contains entity views - view components that are bound to an Entity value model.
 */
package com.codename1.rad.ui.entityviews;


/**
 *  A list view that can show a list of profiles.  
 *  
 *  .A ProfileListView rendering an EntityList with 2 entities, and 2 actions.
 *  image::https://shannah.github.io/RADChatRoom/images/Image-220220-084136.625.png[]
 *  
 *  Each row shows the profile avatar/icon,
 *  name, and optionally a set of actions that will be rendered as buttons for the user to perform.  Row click 
 *  events can be handled by registering an action in the {@link #ACCOUNT_LIST_ROW_SELECTED} category.  Row actions
 *  can be assigned to the {@link #ACCOUNT_LIST_ROW_ACTIONS} category.
 *  
 *  === View Model Requirements
 *  
 *  This view will accept any {@link EntityList} where the row items are "profiles". For best results, each profile
 *  should contain a name and icon, although it will fall back to suitable output if one or both of those fields are missing.
 *  
 *  The icon is rendered using the {@link ProfileAvatarView} view, so see its docs for details on what information it needs.  A simple
 *  solution, that will always work, is to make sure that the profile entities contain properties tagged with {@link Thing#name} and {@link Thing#thumbnailUrl}.
 *  
 *  Since rows are rendered using {@link ProfileListRowView}, you can also see its docs for information about row view model requirements.
 *  
 *  === Supported Actions
 *  
 *  The following actions are supported by this view:
 *  
 *   . {@link #ACCOUNT_LIST_ROW_ACTIONS}
 *   . {@link #ACCOUNT_LIST_ROW_SELECTED}
 *  
 *  @author shannah
 */
public class ProfileListView extends EntityListView {

	/**
	 *  Actions that can be performed on a single row of the list.  These will be rendered in the right
	 *  side of the row, as buttons.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category ACCOUNT_LIST_ROW_ACTIONS;

	/**
	 *  Category used to register an action to receive "click" events for a row.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category ACCOUNT_LIST_ROW_SELECTED;

	public ProfileListView(com.codename1.rad.models.EntityList list) {
	}

	public ProfileListView(com.codename1.rad.models.EntityList list, com.codename1.rad.nodes.ListNode node, float avatarSizeMM) {
	}

	/**
	 *  Row view for rendering a single row of the {@link ProfileListView}.
	 *  <h3>View Model Requirements</h3>
	 *  <p>This view will accept an entity that is a "profile".  Only needs to contain a name and icon, 
	 *  although it will fall back to suitable output if one or both of those fields are missing.</p>
	 *  <p>The icon is rendered using the {@link ProfileAvatarView} view, so see its docs for details on what information it needs.  A simple
	 *  solution, that will always work, is to make sure that the profile entities contain properties tagged with {@link Thing#name} and {@link Thing#thumbnailUrl}.</p>
	 *  
	 *  <h3>Supported Actions</h3>
	 *  
	 *  <p>The following actions are supported by this view:</p>
	 *  
	 *  <ul>
	 *   <li>{@link #ACCOUNT_LIST_ROW_ACTIONS}</li>
	 *   <li>{@link #ACCOUNT_LIST_ROW_SELECTED}</li>
	 *  </ul>
	 */
	public static class ProfileListRowView {


		/**
		 *  @see ProfileListView#ACCOUNT_LIST_ROW_ACTIONS
		 *  
		 */
		public static final com.codename1.rad.nodes.ActionNode.Category ACCOUNT_LIST_ROW_ACTIONS;

		/**
		 *  @see ProfileListView#ACCOUNT_LIST_ROW_SELECTED
		 */
		public static final com.codename1.rad.nodes.ActionNode.Category ACCOUNT_LIST_ROW_SELECTED;

		/**
		 *  Creates a row for the given profile entity.
		 *  @param profile The view model.  A profile entity.  Should implement the {@link Thing#name} and {@link ProfileAvatarView#icon} (or {@link Thing#thumbnailUrl}
		 *  tags.  This uses a {@link ProfileAvatarView} to render the icon, so see the view model requirements for that view for details.  In general, all you need is {@link Thing#name} and {@link ProfileAvatarView#icon} or {@link Thing#thumbnailUrl}.
		 *  @param node The view node.
		 *  @param avatarSizeMM The size to render the avatar in mm.
		 */
		public ProfileListRowView(com.codename1.rad.models.Entity profile, com.codename1.rad.nodes.ViewNode node, float avatarSizeMM) {
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

	/**
	 *  A list cell renderer for rendering rows of a list with {@link ProfileListRowView}.  This is used by {@link ProfileListView}
	 *  to render its rows.
	 */
	public static class ProfileListRowCellRenderer {


		/**
		 *  Creates a renderer for a row.
		 *  @param avatarSizeMM 
		 */
		public ProfileListRowCellRenderer(float avatarSizeMM) {
		}

		@java.lang.Override
		public com.codename1.rad.ui.EntityView getListCellRendererComponent(EntityListView list, com.codename1.rad.models.Entity value, int index, boolean isSelected, boolean isFocused) {
		}
	}
}
