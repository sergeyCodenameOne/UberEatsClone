/**
 *  This package contains {@link Attribute} classes for use in UI descriptors.
 *  
 */
package com.codename1.rad.attributes;


/**
 *  An attribute that can be used on an {@link ActionNode} to add a badge to the action.
 *  
 *  @author shannah
 *  @see BadgeUIID
 *  @see ActionNode
 *  @see UI#badge(String)
 *  @see UI#badge(StringProvider)
 */
public class Badge extends com.codename1.rad.models.Attribute {

	public Badge(String text) {
	}

	public Badge(String text, com.codename1.rad.models.StringProvider provider) {
	}

	public String getValue(com.codename1.rad.models.Entity context) {
	}
}
