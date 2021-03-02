/**
 *  This package contains {@link Attribute} classes for use in UI descriptors.
 *  
 */
package com.codename1.rad.attributes;


/**
 *  An attribute to specify a test condition.  A test condition is a function that takes an {@link Entity} as input, and returns a boolean
 *  value.  This is useful for providing tests to {@link ActionNodes} to determine selected and enabled states.
 *  @author shannah
 *  @see com.codename1.rad.ui.UI#condition(com.codename1.rad.models.EntityTest) 
 */
public class Condition extends com.codename1.rad.models.Property.Test {

	public Condition(com.codename1.rad.models.EntityTest value) {
	}
}
