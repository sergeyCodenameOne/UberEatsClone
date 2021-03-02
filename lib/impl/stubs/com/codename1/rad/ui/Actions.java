/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  A light-weight list of actions.  Includes some utility methods that are handy for performing on 
 *  groups of actions together.
 *  @author shannah
 */
public class Actions implements Iterable {

	public Actions() {
	}

	public void add(com.codename1.rad.nodes.ActionNode[] nodes) {
	}

	public void add(Iterable actions) {
	}

	/**
	 *  Get only the enabled actions from this actions list.
	 *  @param entity
	 *  @return 
	 */
	public Actions getEnabled(com.codename1.rad.models.Entity entity) {
	}

	public int size() {
	}

	public boolean isEmpty() {
	}

	@java.lang.Override
	public java.util.Iterator iterator() {
	}

	public com.codename1.rad.nodes.ActionNode[] toArray() {
	}

	public void addToContainer(com.codename1.ui.Container cnt, com.codename1.rad.models.Entity entity) {
	}

	public Actions proxy(com.codename1.rad.nodes.Node parent) {
	}

	public Actions proxy() {
	}

	public Actions setAttributes(com.codename1.rad.models.Attribute[] atts) {
	}

	public Actions setAttributesIfNotSet(com.codename1.rad.models.Attribute[] atts) {
	}
}
