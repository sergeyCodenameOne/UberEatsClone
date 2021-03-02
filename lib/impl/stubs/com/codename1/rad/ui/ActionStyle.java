/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  Enum specifying an action style.
 *  
 *  @author shannah
 *  @see ActionStyleAttribute
 *  @see ActionNode
 */
public final class ActionStyle extends Enum {

	/**
	 *  Action should be rendered as an icon only.
	 */
	public static final ActionStyle IconOnly;

	/**
	 *  Action should be rendered as text only.
	 */
	public static final ActionStyle TextOnly;

	/**
	 *  Action should be rendered with the icon on top.
	 */
	public static final ActionStyle IconTop;

	/**
	 *  Action should be rendered with the icon on the bottom.
	 */
	public static final ActionStyle IconBottom;

	/**
	 *  Action should be rendered with the icon on the left.
	 */
	public static final ActionStyle IconLeft;

	/**
	 *  Action should be rendered with the icon on the right.
	 */
	public static final ActionStyle IconRight;

	public static ActionStyle[] values() {
	}

	public static ActionStyle valueOf(String name) {
	}
}
