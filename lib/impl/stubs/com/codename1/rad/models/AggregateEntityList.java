/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  An entity list that automatically adds its items to its aggregate root.
 *  @author shannah
 */
public class AggregateEntityList extends EntityList implements Iterable {

	public AggregateEntityList(int maxLen) {
	}

	public AggregateEntityList() {
	}

	@java.lang.Override
	protected Entity beforeAdd(Entity link) {
	}

	@java.lang.Override
	protected Entity beforeRemove(Entity link) {
	}
}
