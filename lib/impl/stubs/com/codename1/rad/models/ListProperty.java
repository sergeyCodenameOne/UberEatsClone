/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  A {@link Property} containing an {@link EntityList}
 *  @author shannah
 *  @see EntityType#list(java.lang.Class, com.codename1.rad.models.Attribute...) 
 */
public class ListProperty extends EntityProperty {

	public ListProperty(Class cls) {
	}

	@java.lang.Override
	public void setValue(Entity entity, EntityList value) {
	}
}
