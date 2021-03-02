/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  An attribute for setting a {@1ink DateFormatter} on a node.  This can be added to any {@link com.codename1.rad.nodes.Node}
 *  as any given view can call {@link com.codename1.rad.nodes.Node#findInheritedAttribute(java.lang.Class) } to find the formatter from a parent node.
 *  @author shannah
 *  
 *  @see com.codename1.rad.ui.UI#dateFormat(com.codename1.rad.text.DateFormatter) 
 */
public class DateFormatterAttribute extends Attribute {

	public DateFormatterAttribute(com.codename1.rad.text.DateFormatter value) {
	}
}
