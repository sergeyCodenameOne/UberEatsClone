/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  An interface that keeps a number of commonly used Action categories.
 *  @author shannah
 */
public interface ActionCategories {

	/**
	 *  Actions displayed at top left of either form, section, or field.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category TOP_LEFT_MENU;

	/**
	 *  Actions displayed at top right of either form, section, or field.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category TOP_RIGHT_MENU;

	/**
	 *  Actions displayed at bottom right of either form, section, or field.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category BOTTOM_RIGHT_MENU;

	/**
	 *  Actions displayed at bottom left of either form, section, or field.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category BOTTOM_LEFT_MENU;

	/**
	 *  Actions displayed in overflow menu of form, section, or field.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category OVERFLOW_MENU;

	/**
	 *  Action fired when clicking on an item from a list.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category LIST_SELECT_ACTION;

	public static final com.codename1.rad.nodes.ActionNode.Category LIST_REMOVE_ACTION;

	public static final com.codename1.rad.nodes.ActionNode.Category LIST_ADD_ACTION;

	/**
	 *  Action fired when button is pressed.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category BUTTON_ACTION;

	public static final com.codename1.rad.nodes.ActionNode.Category LEFT_SWIPE_MENU;

	public static final com.codename1.rad.nodes.ActionNode.Category RIGHT_SWIPE_MENU;
}
