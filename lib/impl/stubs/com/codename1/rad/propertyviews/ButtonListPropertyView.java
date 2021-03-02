/**
 *  This package contains property views, which are used to bind UI components with model properties.
 */
package com.codename1.rad.propertyviews;


/**
 * 
 *  @author shannah
 */
public class ButtonListPropertyView extends com.codename1.rad.ui.PropertyView {

	public ButtonListPropertyView(com.codename1.components.ButtonList buttonList, com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.FieldNode field) {
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

	public static final class ButtonListLayout {


		public static final ButtonListPropertyView.ButtonListLayout Y;

		public static final ButtonListPropertyView.ButtonListLayout X;

		public static final ButtonListPropertyView.ButtonListLayout Flow;

		public static final ButtonListPropertyView.ButtonListLayout Grid;

		public static ButtonListPropertyView.ButtonListLayout[] values() {
		}

		public static ButtonListPropertyView.ButtonListLayout valueOf(String name) {
		}
	}

	public static class ButtonListLayoutAttribute {


		public ButtonListLayoutAttribute(ButtonListPropertyView.ButtonListLayout l) {
		}
	}
}
