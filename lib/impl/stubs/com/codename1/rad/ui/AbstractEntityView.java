/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  A base class for a view that can bind to an entity.  Sublasses just need toi implement {@link #update() }.
 *  @author shannah
 */
public abstract class AbstractEntityView extends com.codename1.ui.Container implements EntityView {

	public AbstractEntityView(com.codename1.rad.models.Entity entity) {
	}

	/**
	 *  Set whether to bind to the model on PropertyChangeEvents.  Default value is {@literal true},
	 *  which results in very eager updates.  Setting this value to {@literal false} will cause
	 *  the binding to use the Observer pattern so that {@link #update() } will only be triggered
	 *  in response to a {@link Entity#notifyObservers() } call.
	 *  
	 *  
	 *  
	 *  @param bindOnPcl {@literal true} to trigger {@link #update() } in response
	 *  to PropertyChangeEvents on the mode.  {@literal false} to trigger {@link #update() }
	 *  in response to {@link Entity#notifyObservers() }
	 *  
	 *  @throws IllegalStateException If this method is called while the view is already bound.
	 */
	public void setBindOnPropertyChangeEvents(boolean bindOnPcl) {
	}

	/**
	 *  Checks whether this view is set to bind on PropertyChangeEvents.  
	 *  @return True if the view is bound on PropertyChangeEvents.
	 *  @see #setBindOnPropertyChangeEvents(boolean) 
	 */
	public boolean isBindOnPropertyChangeEvents() {
	}

	/**
	 *  Binds listeners to model.  Subclasses should override {@link #bindImpl() }
	 */
	public final void bind() {
	}

	/**
	 *  To be implemented by subclasses to register listeners on the model.
	 */
	protected void bindImpl() {
	}

	/**
	 *  Unbinds listeners from the model.  Subclasses should override {@link #unbindImpl()}
	 */
	public final void unbind() {
	}

	/**
	 *  Should be overridden by subclasses to unregister listeners from the model.
	 */
	protected void unbindImpl() {
	}

	@java.lang.Override
	protected void initComponent() {
	}

	@java.lang.Override
	protected void deinitialize() {
	}

	public com.codename1.rad.models.Entity getEntity() {
	}

	public void setEntity(com.codename1.rad.models.Entity entity) {
	}

	protected com.codename1.rad.models.Property findProperty(com.codename1.rad.models.Tag[] tags) {
	}
}
