/**
 *  This package contains entity views - view components that are bound to an Entity value model.
 */
package com.codename1.rad.ui.entityviews;


/**
 *  A view that renders an {@link Entity} as a MultiButton.  
 *  
 *  TODO Add documentation about view properties, bindings and actions.
 *  @author shannah
 */
public class MultiButtonEntityView extends com.codename1.components.MultiButton implements com.codename1.rad.ui.EntityView {

	public static final com.codename1.rad.models.Tag line1;

	public static final com.codename1.rad.models.Tag line2;

	public static final com.codename1.rad.models.Tag line3;

	public static final com.codename1.rad.models.Tag line4;

	public static final com.codename1.rad.models.Tag icon;

	/**
	 *  View property to bind {@link MultiButton#setTextLine1(java.lang.String) }
	 */
	public static final com.codename1.rad.ui.ViewProperty LINE1;

	/**
	 *  View property to bind {@link MultiButton#setTextLine2(java.lang.String) }.
	 */
	public static final com.codename1.rad.ui.ViewProperty LINE2;

	/**
	 *  View property to bind {@link MultiButton#setTextLine3(java.lang.String) }
	 */
	public static final com.codename1.rad.ui.ViewProperty LINE3;

	/**
	 *  View property to bind {@link MultiButton#setTextLine4(java.lang.String) }
	 */
	public static final com.codename1.rad.ui.ViewProperty LINE4;

	/**
	 *  View property to bind {@link MultiButton#setIcon(com.codename1.ui.Image) }.
	 */
	public static final com.codename1.rad.ui.ViewProperty ICON;

	public static final com.codename1.rad.ui.ViewProperty ACTION_CATEGORY;

	public static final com.codename1.rad.ui.ViewProperty LINE1_UIID;

	public static final com.codename1.rad.ui.ViewProperty LINE2_UIID;

	public static final com.codename1.rad.ui.ViewProperty LINE3_UIID;

	public static final com.codename1.rad.ui.ViewProperty LINE4_UIID;

	public static final com.codename1.rad.ui.ViewProperty UIID;

	public MultiButtonEntityView(com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.ViewNode viewNode) {
	}

	public void setAction(com.codename1.rad.nodes.ActionNode action) {
	}

	@java.lang.Override
	protected void initComponent() {
	}

	@java.lang.Override
	protected void deinitialize() {
	}

	@java.lang.Override
	public void bind() {
	}

	@java.lang.Override
	public void unbind() {
	}

	@java.lang.Override
	public void update() {
	}

	@java.lang.Override
	public void commit() {
	}

	@java.lang.Override
	public void setEntity(com.codename1.rad.models.Entity entity) {
	}

	@java.lang.Override
	public com.codename1.rad.models.Entity getEntity() {
	}

	@java.lang.Override
	public com.codename1.rad.nodes.ViewNode getViewNode() {
	}
}
