/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  A property of a {@link EntityView}.  A View Property allows an EntityView to declare parameters
 *  that it will accept to customize its rendering or behaviour.  The property can be "filled" by adding a {@link ViewPropertyParameter}
 *  to the node tree in the view's view node or any parent. This allows a view to, for example, accept direction on what UIID
 *  to use in the component, or which Tags to bind parts of its UI to.
 *  @author shannah
 *  @see UI#param(com.codename1.rad.ui.ViewProperty, java.lang.Object) 
 *  @see UI#param(com.codename1.rad.ui.ViewProperty, com.codename1.rad.models.Tag...) 
 */
public class ViewProperty {

	public ViewProperty(com.codename1.rad.models.ContentType contentType, com.codename1.rad.models.Attribute[] attributes) {
	}

	public com.codename1.rad.models.ContentType getContentType() {
	}

	public static ViewProperty stringProperty(com.codename1.rad.models.Attribute[] atts) {
	}

	public static ViewProperty intProperty(com.codename1.rad.models.Attribute[] atts) {
	}

	public static ViewProperty booleanProperty(com.codename1.rad.models.Attribute[] atts) {
	}

	public static ViewProperty doubleProperty(com.codename1.rad.models.Attribute[] atts) {
	}

	public static ViewProperty floatProperty(com.codename1.rad.models.Attribute[] atts) {
	}
}
