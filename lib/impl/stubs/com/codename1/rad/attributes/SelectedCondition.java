/**
 *  This package contains {@link Attribute} classes for use in UI descriptors.
 *  
 */
package com.codename1.rad.attributes;


/**
 *  Selected condition, for {@link ActionNode}.  This test will be run when updating an action's View to determine whether it is in selected state. 
 *  
 *  If this attribute is added to an action, the {@link DefaultActionViewFactory} will render the action as a toggle button instead of a 
 *  regular button.
 *  @author shannah
 *  @see com.codename1.rad.ui.UI#selectedCondition(com.codename1.rad.models.EntityTest) 
 */
public class SelectedCondition extends com.codename1.rad.models.Property.Test {

	public SelectedCondition(com.codename1.rad.models.EntityTest value) {
	}
}
