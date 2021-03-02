/**
 *  This package contains foundation components that are used by views in CodeRAD.  
 *  
 *  The components in this package are not, themselves, CodeRAD views - i.e. they don't bind to a view model.  They are used *by* CodeRAD components, and can also be used on their own.
 */
package ca.weblite.shared.components;


/**
 *  A popup-menu with commands that the user can click on.
 *  @author shannah
 */
public class PopupMenu extends com.codename1.components.InteractionDialog {

	public PopupMenu() {
	}

	/**
	 *  @return the commandLabel
	 */
	public String getCommandLabel() {
	}

	/**
	 *  @param commandLabel the commandLabel to set
	 */
	public void setCommandLabel(String commandLabel) {
	}

	/**
	 *  @return the materialIcon
	 */
	public char getMaterialIcon() {
	}

	/**
	 *  @param materialIcon the materialIcon to set
	 */
	public void setMaterialIcon(char materialIcon) {
	}

	public void setCommandsLayout(com.codename1.ui.layouts.Layout layout) {
	}

	public com.codename1.ui.Command getCommand() {
	}

	@java.lang.Override
	public void showPopupDialog(com.codename1.ui.Component c) {
	}

	public PopupMenu addCommand(com.codename1.ui.Component component) {
	}

	public PopupMenu addCommand(com.codename1.ui.Command command) {
	}

	public void removeAllCommands() {
	}
}
