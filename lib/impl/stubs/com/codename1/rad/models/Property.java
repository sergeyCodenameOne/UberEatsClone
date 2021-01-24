/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  An interface to be implemented by all properties of entities.  Generally new Property types should extend {@link AbstractProperty} since it includes default implementations of the boiler plate stuff.
 *  @author shannah
 */
public interface Property {

	public AttributeSet getAttributes();

	public ContentType getContentType();

	public Object getValue(Entity entity);

	public void setValue(Entity entity, Object value);

	public void freeze();

	public Attribute getAttribute(Class type);

	public Tags getTags();
}
