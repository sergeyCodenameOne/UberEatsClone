/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  A special class that provides configuration for a "widget" which is used to edit a {@link Property} in the {@link EntityEditor}.
 *  @author shannah
 *  @see EntityType#widget(com.codename1.rad.models.Attribute...) 
 *  @see com.codename1.rad.ui.UI#widget(com.codename1.rad.models.Attribute...) 
 *  
 */
public class WidgetDescriptor {

	public WidgetDescriptor() {
	}

	public WidgetDescriptor(Property prop) {
	}

	public void setAttributes(Attribute[] atts) {
	}

	public Attribute getAttribute(Class type) {
	}

	public WidgetDescriptor.Type getWidgetType() {
	}

	public Property.Label getLabel() {
	}

	public Property.Description getDescription() {
	}

	public AttributeSet getAllAttributes() {
	}

	public static class Type {


		public Type(Class value) {
		}
	}
}
