/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  An event that is fired when the value of a {@link Property} changes in an entity.
 *  @author shannah
 *  @see Entity#addPropertyChangeListener(com.codename1.ui.events.ActionListener) 
 *  @see Entity#removePropertyChangeListener(com.codename1.ui.events.ActionListener) 
 */
public class PropertyChangeEvent extends com.codename1.ui.events.ActionEvent {

	public PropertyChangeEvent(Entity source, Property prop, Object oldVal, Object newVal) {
	}

	/**
	 *  @return the property
	 */
	public Property getProperty() {
	}

	/**
	 *  @return the oldValue
	 */
	public Object getOldValue() {
	}

	/**
	 *  @return the newValue
	 */
	public Object getNewValue() {
	}
}
