/**
 *  This package contains controllers for CodeRAD applications.
 *  
 */
package com.codename1.rad.controllers;


/**
 *  A controller for handling application logic related to a Form.
 *  
 *  == Controller Hierarchy
 *  
 *  Controllers have a hierarchy similar to UI components.  The {@link ApplicationController} is generally the "root"
 *  controller.  The top-level form controller is a "child" of the application controller.  If the user navigates to another
 *  form from which they should be able to navigate back, then the new FormController is a "child" of the previous FormController.
 *  
 *  == Back Navigation
 *  
 *  If a FormController's parent controller is also a FormController, then "back" functionality will automatically be connected
 *  to its Form.  When the user clicks "back", they will automatically navigate to the parent controller's form.
 *  
 *  Views may also request a "back" navigation by firing a {@link FormBackEvent}, which will propagate up the controller hierarchy
 *  to the first FormController, where it will be handled.
 *  
 *  == Event Propagation
 *  
 *  Events which are dispatched to a Controller will be propagated to the controller's parent, and its parent, and so on... until the event
 *  is consumed, or until it reaches the root.  In this way, it is possible to create a catch-all event handler in the ApplicationController
 *  that will catch all events in the application that haven't been consumed by another controller.
 *  
 *  
 *  == Example
 *  .A FormController for the ChatRoomView.  Excerpt from https://shannah.github.io/RADChatRoom/getting-started-tutorial.html[this tutorial,window=top].
 * [source,java]
 *  ----
 * public class ChatFormController extends FormController {
 *     
 *     // Define the "SEND" action for the chat room
 *     public static final ActionNode send = action(
 *         enabledCondition(entity-> {
 *             return !entity.isEmpty(ChatRoom.inputBuffer);
 *         }),
 *         icon(FontImage.MATERIAL_SEND)
 *     );
 *     public ChatFormController(Controller parent) {
 *         super(parent);
 *         Form f = new Form("My First Chat Room", new BorderLayout());
 *         
 *         // Create a "view node" as a UI descriptor for the chat room.
 *         // This allows us to customize and extend the chat room.
 *         ViewNode viewNode = new ViewNode(
 *             actions(ChatRoomView.SEND_ACTION, send)
 *         );
 *         
 *         // Add the viewNode as the 2nd parameter
 *         ChatRoomView view = new ChatRoomView(createViewModel(), viewNode, f);
 *         f.add(CENTER, view);
 *         setView(f);
 *         
 *         addActionListener(send, evt->{
 *             evt.consume();
 *             // ... handle send event
 *             
 *         });
 *     }
 *     //...
 *  }
 *  ----
 *  
 *    
 * 
 *  @author shannah
 */
public class FormController extends ViewController {

	public FormController(Controller parent) {
	}

	/**
	 *  Sets the form associated with this controller.  This will automatically set
	 *  the back command of the form to call back() on this controller.
	 *  @param form 
	 */
	public void setView(com.codename1.ui.Form form) {
	}

	public void setTitle(String title) {
	}

	public String getTitle() {
	}

	/**
	 *  Overrides parent setView().  Delegates to {@link #setView(com.codename1.ui.Form} if cmp is 
	 *  a form.  Throws IllegalArgumentException otherwise.
	 *  @param cmp 
	 */
	public void setView(com.codename1.ui.Component cmp) {
	}

	/**
	 *  Gets form associated with this controller.
	 *  @return 
	 */
	@java.lang.Override
	public com.codename1.ui.Form getView() {
	}

	/**
	 *  Goes back to previous form.  The previous form is always the parent controller's
	 *  form, if the parent controller is a FormController.
	 *  
	 *  If the current controller is an instance of {@link AutoCloseable},
	 *  then this will first attempt to call {@link AutoCloseable#close() } on the current form first.  If it throws an exception,
	 *  then that exception will be swallowed, but the showBack() action will be cancelled.
	 */
	public void back() {
	}

	public void show() {
	}

	/**
	 *  Shows this controller's form using the "back" animation.  If the current controller is an instance of {@link AutoCloseable},
	 *  then this will first attempt to call {@link AutoCloseable#close() } on the current form first.  If it throws an exception,
	 *  then that exception will be swallowed, but the showBack() action will be cancelled.
	 */
	public void showBack() {
	}

	public boolean hasBackCommand() {
	}

	/**
	 *  Handles Controller event.  This implementation consumes {@link FormBackEvent} events.
	 *  @param evt 
	 */
	@java.lang.Override
	public void actionPerformed(ControllerEvent evt) {
	}

	/**
	 *  Base class for FormController events.
	 */
	public static class FormControllerEvent {


		public FormControllerEvent() {
		}

		public FormControllerEvent(Object source) {
		}
	}

	/**
	 *  Event that can be fired by any view to request that the current form go back 
	 *  to the previous form.
	 */
	public static class FormBackEvent {


		public FormBackEvent(Object source) {
		}
	}
}
