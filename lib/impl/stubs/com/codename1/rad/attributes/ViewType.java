/**
 *  This package contains {@link Attribute} classes for use in UI descriptors.
 *  
 */
package com.codename1.rad.attributes;


/**
 *  An attribute for specifying the view type for a view node so that the {@link EntityViewFactory} can generate the proper type of view.
 *  @author shannah
 *  @see com.codename1.rad.ui.UI#viewFactory(com.codename1.rad.ui.EntityViewFactory) 
 */
public class ViewType extends com.codename1.rad.models.Attribute {

	/**
	 *  A multibutton view type.  Will result in a {@link MultiButtonEntityView} when {@link ViewNode} is converted to an {@link EntityView} by
	 *  {@link DefaultEntityViewFactory}.
	 */
	public static final ViewType MULTIBUTTON;

	public ViewType(com.codename1.rad.models.Property.Name name) {
	}
}
