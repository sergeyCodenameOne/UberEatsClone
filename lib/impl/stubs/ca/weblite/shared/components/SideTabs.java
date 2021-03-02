/**
 *  This package contains foundation components that are used by views in CodeRAD.  
 *  
 *  The components in this package are not, themselves, CodeRAD views - i.e. they don't bind to a view model.  They are used *by* CodeRAD components, and can also be used on their own.
 */
package ca.weblite.shared.components;


/**
 *  A {@link Tabs} component that displays the tab buttons on the left side.
 *  @author shannah
 */
public class SideTabs extends com.codename1.ui.Container {

	public SideTabs() {
	}

	public SideTabs setTabUIID(String uiid) {
	}

	public String getTabUIID() {
	}

	public int getTabCount() {
	}

	public String getTabTitle(int index) {
	}

	public com.codename1.ui.Image getTabIcon(int index) {
	}

	public com.codename1.ui.Component getTabComponentAt(int index) {
	}

	public SideTabs addTab(String title, com.codename1.ui.Component content) {
	}

	public SideTabs addTabFA(String title, char icon, float iconSize, com.codename1.ui.Component content) {
	}

	public SideTabs addTab(String title, char materialIcon, float iconSize, com.codename1.ui.Component content) {
	}

	public void update() {
	}
}
