/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 * 
 *  @author shannah
 */
public class VetoablePropertyChangeEvent extends PropertyChangeEvent {

	public VetoablePropertyChangeEvent(Entity source, Property prop, Object oldVal, Object newVal) {
	}

	public void veto(String reason) {
	}

	public boolean isVetoed() {
	}

	public String getReason() {
	}
}
