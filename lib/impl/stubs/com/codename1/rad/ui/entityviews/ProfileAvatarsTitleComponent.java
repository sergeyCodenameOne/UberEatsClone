/**
 *  This package contains entity views - view components that are bound to an Entity value model.
 */
package com.codename1.rad.ui.entityviews;


/**
 *  A component with profile avatars of one or more profiles.  This component is appropriate to use as a
 *  form's Title component in forms that involve interaction between people, such as in a chat
 *  form.
 *  
 *  .A ProfileAvatarsTitleComponent rendering two entities that have {@link Thing#thumbnailUrl} properties.
 *  image::https://shannah.github.io/RADChatRoom/images/Image-210220-020916.612.png[ProvileAvatarsTitleComponent]
 *  
 *  === View Model Requirements
 *  
 *  For the view model, this view expects an EntityList where each entity in the list contains an "icon",
 *  and a "name".  The individual avatars are rendered as {@link ProfileAvatarView}, so you can refer to its
 *  documentation for details the view model requirements for each individual profile.
 *  
 *  === Supported Actions
 *  
 *  The following actions are supported on this view:
 *  
 *   . {@link #PROFILE_AVATAR_TITLE_COMPONENT_CLICKED}
 *   . {@link #PROFILE_AVATAR_TITLE_COMPONENT_LONG_PRESS}
 *   . {@link #PROFILE_AVATAR_CLICKED}
 *   . {@link #PROFILE_AVATAR_LONG_PRESS}
 *   . {@link #PROFILE_AVATAR_TITLE_COMPONENT_CLICKED_MENU}
 *   . {@link #PROFILE_AVATAR_TITLE_COMPONENT_LONG_PRESS_MENU}
 *   . {@link #PROFILE_AVATAR_CLICKED_MENU}
 *   . {@link #PROFILE_AVATAR_LONG_PRESS_MENU}
 *  
 *  
 *  
 *  @author shannah
 */
public class ProfileAvatarsTitleComponent extends com.codename1.rad.ui.AbstractEntityView {

	/**
	 *  Action fired on click event.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category PROFILE_AVATAR_TITLE_COMPONENT_CLICKED;

	/**
	 *  Action fired on long press.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category PROFILE_AVATAR_TITLE_COMPONENT_LONG_PRESS;

	/**
	 *  Action fired when individual profile avatar is clicked.
	 *  @see ProfileAvatarView#PROFILE_AVATAR_CLICKED
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category PROFILE_AVATAR_CLICKED;

	/**
	 *  Action fired when individual profile avatar is long pressed.
	 *  @see ProfileAvatarView#PROFILE_AVATAR_LONG_PRESS
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category PROFILE_AVATAR_LONG_PRESS;

	/**
	 *  Actions displayed in a popup menu when individual avatar is clicked.
	 *  @see ProfileAvatarView#PROFILE_AVATAR_CLICKED_MENU
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category PROFILE_AVATAR_CLICKED_MENU;

	/**
	 *  Actions displayed in popup menu when individual avatar is longpressed.
	 *  @see ProfileAvatarView#PROFILE_AVATAR_LONG_PRESS_MENU
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category PROFILE_AVATAR_LONG_PRESS_MENU;

	/**
	 *  Actions displayed in popup menu when this component is clicked
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category PROFILE_AVATAR_TITLE_COMPONENT_CLICKED_MENU;

	/**
	 *  Actions displayed in popup menu when this component is longpressed.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category PROFILE_AVATAR_TITLE_COMPONENT_LONG_PRESS_MENU;

	/**
	 *  Creates a title component.
	 *  @param entity An EntityList containg profiles.  See {@link ProfileAvatarView} for information on properties
	 *  and tags that should be present for avatars.
	 *  @param node The view node for this title component.  
	 *  @param avatarSizeMM The size in millimeters of the avatars.
	 */
	public ProfileAvatarsTitleComponent(com.codename1.rad.models.EntityList entity, com.codename1.rad.nodes.ViewNode node, float avatarSizeMM) {
	}

	@java.lang.Override
	protected void bindImpl() {
	}

	@java.lang.Override
	protected void unbindImpl() {
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
