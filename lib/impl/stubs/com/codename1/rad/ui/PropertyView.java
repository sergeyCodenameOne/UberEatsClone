/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  Wrapper around a component that supports binding to a property.
 *  @author shannah
 */
public abstract class PropertyView extends com.codename1.ui.Container implements com.codename1.ui.Editable {

	public PropertyView(com.codename1.ui.Component component, com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.FieldNode field) {
	}

	@java.lang.Override
	public void setNextFocusLeft(com.codename1.ui.Component nextFocusLeft) {
	}

	@java.lang.Override
	public void setNextFocusRight(com.codename1.ui.Component nextFocusRight) {
	}

	@java.lang.Override
	protected void initComponent() {
	}

	@java.lang.Override
	protected void deinitialize() {
	}

	/**
	 *  Binds view to the model listeners. {@link #bind() } calls must be balanced with {@link #unbind() }
	 *  calls.  {@link #bind() } is called inside {@link #initComponent() } (i.e. when the component
	 *  is added to the UI.  {@link #unbind() } is called inside {@link #deinitialize() } (i.e. when
	 *  the component is removed from the UI.
	 *  
	 *  If you want to maintain binding when view is offscreen, you can call {@link #bind() } explicitly,
	 *  but you'll need to also call {@link #unbind() } later on when you no longer need the binding, otherwise
	 *  you may introduce a memory leak.
	 *  
	 *  Subclasses should implement {@link #bindImpl() } and {@link #unbindImpl() }
	 */
	public final void bind() {
	}

	/**
	 *  Unbinds view from the model listeners. {@link #bind() } calls must be balanced with {@link #unbind() }
	 *  calls.  {@link #bind() } is called inside {@link #initComponent() } (i.e. when the component
	 *  is added to the UI.  {@link #unbind() } is called inside {@link #deinitialize() } (i.e. when
	 *  the component is removed from the UI.
	 *  
	 *  If you want to maintain binding when view is offscreen, you can call {@link #bind() } explicitly,
	 *  but you'll need to also call {@link #unbind() } later on when you no longer need the binding, otherwise
	 *  you may introduce a memory leak.
	 *  
	 *  Subclasses should implement {@link #bindImpl() } and {@link #unbindImpl() }.
	 */
	public final void unbind() {
	}

	/**
	 *  Subclasses should override this method to bind to the model.
	 */
	protected abstract void bindImpl() {
	}

	/**
	 *  Subclasses should override this method to unbind from the model.
	 */
	protected abstract void unbindImpl() {
	}

	public com.codename1.ui.Component getComponent() {
	}

	public com.codename1.rad.models.Property getProperty() {
	}

	public com.codename1.rad.models.PropertySelector getPropertySelector() {
	}

	public com.codename1.rad.nodes.FieldNode getField() {
	}

	public com.codename1.rad.models.Entity getEntity() {
	}

	public abstract void update() {
	}

	public abstract void commit() {
	}
}
