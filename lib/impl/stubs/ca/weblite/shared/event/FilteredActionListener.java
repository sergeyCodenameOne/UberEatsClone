/**
 *  This package contains some event utility classes that aren't part of CodeRAD proper, but may be useful to some apps.
 */
package ca.weblite.shared.event;


/**
 *  An ActionListener that defines a method {@link #valueChanged(com.codename1.ui.events.ActionEvent) }
 *  that is only fired when the value is changed.
 *  @author shannah
 */
public class FilteredActionListener implements com.codename1.ui.events.ActionListener {

	@java.lang.Override
	public void actionPerformed(com.codename1.ui.events.ActionEvent evt) {
	}

	public static FilteredActionListener addFilteredActionListener(com.codename1.ui.TextArea ta, com.codename1.ui.events.ActionListener l) {
	}

	public static interface class ValueGetter {


		public String getValue() {
		}
	}
}
