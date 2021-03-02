/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  Encapsulates a boolean test performed against an {@link Entity}.  This is primarily used by {@link SelectedCondition}, {@link EnabledCondition}, and {@link Condition} as attributes of
 *  {@link ActionNode} to allow actions to test their state when an entity is updated.
 *  @author shannah
 *  
 *  @see com.codename1.rad.ui.UI#condition(com.codename1.rad.models.EntityTest) 
 *  @see com.codename1.rad.ui.UI#selectedCondition(com.codename1.rad.models.EntityTest) 
 *  @see com.codename1.rad.ui.UI#enabledCondition(com.codename1.rad.models.EntityTest) 
 */
public interface EntityTest {

	public boolean test(Entity entity);
}
