/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  A special entity type that is automatically assigned to an entity that doesn't have its own type.  This entity type will
 *  support *any* {@link Property}, which is different behaviour than entities of other {@link EntityType} objects, which 
 *  will throw an {@link IllegalArgumentException} if you try to set or get a value for a {@link Property} that is not part
 *  of its {@link EntityType}.
 *  @author shannah
 */
public class DynamicEntityType extends EntityType {

	public DynamicEntityType() {
	}

	@java.lang.Override
	public boolean isDynamic() {
	}
}
