/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  An abstract base class for {@link Property} that includes most of the essential plumbing 
 *  to handle attributes and getting and setting values.
 *  @author shannah
 *  @param <T> The type of value held in thi sproperty.
 */
public class AbstractProperty implements Property {

	public AbstractProperty(ContentType contentType) {
	}

	public AbstractProperty getter(Property.Getter getter) {
	}

	public AbstractProperty setter(Property.Setter setter) {
	}

	public void setAttributes(Attribute[] atts) {
	}

	@java.lang.Override
	public Object getValue(Entity entity) {
	}

	@java.lang.Override
	public void setValue(Entity entity, Object value) {
	}

	public Property.Label getLabel() {
	}

	public Property.Description getDescription() {
	}

	public Property.Widget getWidget() {
	}

	@java.lang.Override
	public Attribute getAttribute(Class type) {
	}

	@java.lang.Override
	public AttributeSet getAttributes() {
	}

	@java.lang.Override
	public void freeze() {
	}

	@java.lang.Override
	public ContentType getContentType() {
	}

	public Tags getTags() {
	}
}
