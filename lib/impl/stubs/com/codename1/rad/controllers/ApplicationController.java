/**
 *  This package contains controllers for CodeRAD applications.
 *  
 */
package com.codename1.rad.controllers;


/**
 *  The main application controller.  This is the root controller for the entire application.
 *  Applications should extend this class and use it as their main application class.  Then can
 *  then override the actionPerformed() method to handle events of type {@link StartEvent}, {@link StopEvent},
 *  {@link DestroyEvent}, and {@link InitEvent}.
 *  
 *  The application controller is ideally suited to act as the main class for a CodenameOne application.  It implements all of the
 *  lifecycle methods ({@link #init(java.lang.Object) }, {@link #start() }, {@link #stop() }, and {@link #destroy() }, and dispatches 
 *  corresponding events that you can handle in your controller.
 *  
 *  == Example
 *  
 *  .Typical application structure, replacing the main app class with an ApplicationController
 *  [source,java]
 *  ----
 *  public class MyApplication extends ApplicationController {
 *       public void actionPerformed(ActionEvent evt) {
 *           if (evt instance of StartEvent) {
 *               evt.consume();
 *  
 *               // Show a form
 *               new MyFormController(this).getView().show();
 *           }
 *       }
 *  }
 *  ----
 *  @author shannah
 */
public class ApplicationController extends Controller {

	protected com.codename1.ui.Form current;

	public static ApplicationController instance;

	public ApplicationController() {
	}

	public static ApplicationController getInstance() {
	}

	public void init(Object context) {
	}

	protected void showCurrentForm() {
	}

	public void start() {
	}

	public void stop() {
	}

	public void destroy() {
	}

	public static class ApplicationEvent {


		public ApplicationEvent() {
		}
	}

	public static class InitEvent {


		public InitEvent(Object context) {
		}

		public Object getContext() {
		}
	}

	public static class StartEvent {


		public StartEvent() {
		}
	}

	public static class StopEvent {


		public StopEvent() {
		}
	}

	public static class DestroyEvent {


		public DestroyEvent() {
		}
	}
}
