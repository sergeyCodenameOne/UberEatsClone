/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  A parameter that can be added to the node hierarchy to set the value or binding of a ViewProperty.
 *  @author shannah
 */
public class ViewPropertyParameter {

	public static ViewPropertyParameter createValueParam(ViewProperty property, Object value) {
	}

	public static ViewPropertyParameter createBindingParam(ViewProperty property, com.codename1.rad.models.Tag[] tags) {
	}

	public ViewProperty getProperty() {
	}

	public Object getValue() {
	}

	public com.codename1.rad.models.Tags getBindings() {
	}

	public Object getValue(com.codename1.rad.models.Entity context) {
	}

	public com.codename1.rad.models.Property findProperty(com.codename1.rad.models.Entity context) {
	}
}
