/**
 *  This package contains controllers for CodeRAD applications.
 *  
 */
package com.codename1.rad.controllers;


/**
 *  A controller for a section of an app.  The primary purpose of this is to group a set of 
 *  forms together into a section which can include common functionality.  
 *  @author shannah
 */
public class AppSectionController extends Controller {

	public AppSectionController(Controller parent) {
	}

	@java.lang.Override
	public void actionPerformed(ControllerEvent evt) {
	}

	/**
	 *  An event that can be dispatched from anywhere inside an AppSection to exit the section.  
	 *  This will be converted into a FormBackEvent and propagated up the stack from the section.
	 */
	public static class ExitSectionEvent {


		public ExitSectionEvent(com.codename1.ui.Component source) {
		}
	}
}
