/**
 *  This package contains foundation components that are used by views in CodeRAD.  
 *  
 *  The components in this package are not, themselves, CodeRAD views - i.e. they don't bind to a view model.  They are used *by* CodeRAD components, and can also be used on their own.
 */
package ca.weblite.shared.components;


/**
 *  A button that, when clicked on, displays some help text in a popup bubble.
 *  
 *  === Example
 *  
 *  [source,java]
 *  ----
 * Form hi = new Form("Hi World", BoxLayout.y());
 * HelpButton btn = new HelpButton("This is some help text to give you some hints");
 * hi.add(FlowLayout.encloseIn(new Label("Hi World"), btn));
 * hi.show();
 *  ----
 *  
 *  image::doc-files/help-button-animated.gif[]
 *  
 *  @author shannah
 */
public class HelpButton extends com.codename1.ui.Button {

	public HelpButton(String helpText) {
	}

	public HelpButton(String helpText, String UUID) {
	}

	/**
	 *  @return the helpText
	 */
	public String getHelpText() {
	}

	/**
	 *  @param helpText the helpText to set
	 */
	public void setHelpText(String helpText) {
	}

	public void setType(HelpButton.HelpButtonType type) {
	}

	public void setPopupPreferredW(int w) {
	}

	/**
	 *  Help button types.
	 */
	public static final class HelpButtonType {


		public static final HelpButton.HelpButtonType Info;

		public static final HelpButton.HelpButtonType Error;

		public static HelpButton.HelpButtonType[] values() {
		}

		public static HelpButton.HelpButtonType valueOf(String name) {
		}
	}
}
