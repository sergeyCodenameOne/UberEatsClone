/**
 *  This package contains some event utility classes that aren't part of CodeRAD proper, but may be useful to some apps.
 */
package ca.weblite.shared.event;


/**
 *  A utility class for observing changes on TextAreas.  API lends itself to expanding to other types of of components also. It subscribes to receive action events from the textareas,
 *  but only propagates the event to its listeners if the value of the text area has changed since the last event.
 *  
 *  NOTE:  This class isn't used by CodeRAD for its property binding functionality.  It is still a useful class for monitoring plain old
 *  text areas, though.
 *  @author shannah
 */
public class ChangeObserver {

	public ChangeObserver(com.codename1.ui.Component[] components) {
	}

	public ChangeObserver add(com.codename1.ui.Component cmp) {
	}

	public ChangeObserver addActionListener(com.codename1.ui.events.ActionListener l) {
	}

	public ChangeObserver removeActionListener(com.codename1.ui.events.ActionListener l) {
	}
}
