/**
 *  This package contains controllers for CodeRAD applications.
 *  
 */
package com.codename1.rad.controllers;


/**
 *  An interface that can be implemented by a View so that ViewControllers can seamlessly
 *  register to receive events from them.  It is not absolutely necessary to implement this interface, since {@link com.codename1.rad.nodes.ActionNode#fireEvent(com.codename1.rad.events.EventContext) } 
 *  will automatically traverse up the view hierarchy to find the nearest ViewController to dispatch the event.  The event will then propagate up the view hierarchy.
 *  @author shannah
 */
public interface EventProducer {

	public ActionSupport getActionSupport();
}
