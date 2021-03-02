/**
 *  This package contains {@link Attribute} classes for use in UI descriptors.
 *  
 */
package com.codename1.rad.attributes;


/**
 *  Attribute to specify a renderer for rendering an icon.  This attribute can be added to any {@link Node}, as views that are interested
 *  in rendering icons can use {@link com.codename1.rad.nodes.Node#findInheritedAttribute(java.lang.Class) } to get the renderer from a parent.
 *  @author shannah
 *  @see com.codename1.rad.ui.UI#iconRenderer(com.codename1.rad.ui.image.EntityImageRenderer) 
 */
public class IconRendererAttribute extends com.codename1.rad.models.Attribute {

	public IconRendererAttribute(com.codename1.rad.ui.image.EntityImageRenderer value) {
	}
}
