/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  A special type of Entity that helps to propagate changes from any entity in the aggregate to the 
 *  aggregate root.  This can be handy if there is a primary entity that contains some aggregated "sub-entities".  The sub-entities
 *  cannot exist outside the context of their aggregate root, and changes to any of the sub-entities will imply that the 
 *  root is dirty.
 *  @author shannah
 */
public class Aggregate extends Entity implements Iterable {

	public Aggregate(Entity root) {
	}

	public Entity getRoot() {
	}

	@java.lang.Override
	public java.util.Iterator iterator() {
	}

	public void add(Entity entity) {
	}

	public void remove(Entity entity) {
	}

	@java.lang.Override
	public synchronized boolean hasChanged() {
	}

	@java.lang.Override
	protected synchronized void clearChanged() {
	}

	@java.lang.Override
	public void notifyObservers(Object arg) {
	}
}
