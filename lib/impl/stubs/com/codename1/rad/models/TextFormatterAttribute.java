/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  An attribute for setting a {@1ink TextFormatter} on a node.  This is usually added to the {@link FieldNode} so that PropertyViews can use
 *  it to format the string for rendering.
 *  @author shannah
 *  
 *  @see com.codename1.rad.ui.UI#dateFormat(com.codename1.rad.text.DateFormatter) 
 */
public class TextFormatterAttribute extends Attribute {

	public TextFormatterAttribute(com.codename1.rad.text.TextFormatter value) {
	}
}
