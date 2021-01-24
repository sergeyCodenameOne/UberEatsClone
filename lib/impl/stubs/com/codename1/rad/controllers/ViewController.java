/**
 *  This package contains controllers for CodeRAD applications.
 *  
 */
package com.codename1.rad.controllers;


/**
 *  A controller class that handles application logic for a view.  In most cases a FormController will be sufficient to
 *  handle the logic for a form.  Some more complex views may require their own controllers as well, in which case you 
 *  might use a ViewController to handle Action dispatch on the view.
 *  
 *  == Controller Hierarchy
 *  
 *  Controllers form a hierarchy similar to UI components.  E.g. A controller has a parent controller, and events that are not 
 *  consumed by the child will propagate to the parent.  See {@link FormController} for a more details discussion of the Controller hierarchy.
 *  @author shannah
 */
public class ViewController extends Controller {

	public ViewController(Controller parent) {
	}

	/**
	 *  Sets the view associated with this controller.
	 *  @param view 
	 */
	public void setView(com.codename1.ui.Component view) {
	}

	public static ViewController getViewController(com.codename1.ui.Component cmp) {
	}

	/**
	 *  Gets the view associated with this controller.
	 *  @return 
	 */
	public com.codename1.ui.Component getView() {
	}

	/**
	 *  Callback called when the view is initialized (i.e. made visible)
	 */
	public void initController() {
	}

	/**
	 *  Callback called when the view is deinitialized (i.e. removed from display hierarchy).
	 */
	public void deinitialize() {
	}

	/**
	 *  Event that is fired when a "view" is set in a view controller.
	 */
	public static class DidSetViewEvent {


		public DidSetViewEvent(ViewController source, com.codename1.ui.Component view) {
		}

		public Controller getSource() {
		}

		public com.codename1.ui.Component getView() {
		}

		public com.codename1.ui.Component getView(Class asClass) {
		}
	}

	/**
	 *  Event that is fired when a "view" is unset from a view controller.
	 */
	public static class DidUnSetViewEvent {


		public DidUnSetViewEvent(ViewController source, com.codename1.ui.Component view) {
		}

		public Controller getSource() {
		}

		public com.codename1.ui.Component getView() {
		}

		public com.codename1.ui.Component getView(Class asClass) {
		}
	}
}
