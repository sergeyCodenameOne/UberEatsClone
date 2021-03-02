/**
 *  This package contains property views, which are used to bind UI components with model properties.
 */
package com.codename1.rad.propertyviews;


/**
 *  View for binding to {@link com.codename1.ui.Label} components.
 *  @author shannah
 */
public class LabelPropertyView extends com.codename1.rad.ui.PropertyView {

	public LabelPropertyView(com.codename1.ui.Label component, com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.FieldNode textField) {
	}

	public LabelPropertyView(com.codename1.ui.Label component, com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.FieldNode textField, com.codename1.rad.nodes.FieldNode iconField) {
	}

	public LabelPropertyView(com.codename1.ui.Label component, com.codename1.rad.models.Entity entity, com.codename1.rad.models.Tag[] tags) {
	}

	public LabelPropertyView(com.codename1.ui.Label component, com.codename1.rad.models.Entity entity, com.codename1.rad.models.Property prop) {
	}

	@java.lang.Override
	protected void bindImpl() {
	}

	@java.lang.Override
	protected void unbindImpl() {
	}

	protected String getText() {
	}

	@java.lang.Override
	public void update() {
	}

	@java.lang.Override
	public void commit() {
	}

	public com.codename1.rad.models.PropertySelector getIconPropertySelector() {
	}

	public void setIconOnly(boolean iconOnly) {
	}

	public static LabelPropertyView createIconLabel(com.codename1.ui.Label cmp, com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.FieldNode iconField) {
	}

	public static LabelPropertyView createIconLabel(com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.FieldNode iconField) {
	}

	public static LabelPropertyView createIconLabel(com.codename1.rad.models.Entity entity, com.codename1.rad.models.PropertySelector iconProperty) {
	}

	public static LabelPropertyView createRoundIconLabel(com.codename1.ui.Label label, com.codename1.rad.models.Entity entity, com.codename1.rad.models.PropertySelector iconProperty, int size) {
	}

	public static LabelPropertyView createRoundRectIconLabel(com.codename1.ui.Label label, com.codename1.rad.models.Entity entity, com.codename1.rad.models.PropertySelector iconProperty, int width, int height, float cornerRadiusMM) {
	}
}
