/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  A set of attributes.  This will store one of each type of {@link Attribute}.
 *  @author shannah
 */
public class AttributeSet implements Iterable {

	public AttributeSet() {
	}

	public void setAttributes(Attribute[] atts) {
	}

	public Attribute getAttribute(Class attType) {
	}

	public Attribute getAttribute(Class type, Attribute defaultVal) {
	}

	public Object getValue(Class type, Object defaultValue) {
	}

	public void addAll(AttributeSet[] sources) {
	}

	public static AttributeSet merge(AttributeSet[] attrs) {
	}

	@java.lang.Override
	public java.util.Iterator iterator() {
	}
}
