/**
 *  This package contains foundation components that are used by views in CodeRAD.  
 *  
 *  The components in this package are not, themselves, CodeRAD views - i.e. they don't bind to a view model.  They are used *by* CodeRAD components, and can also be used on their own.
 */
package ca.weblite.shared.components;


/**
 *  An internal frame, which is used inside the {@link TabbedDocumentView}
 *  @author shannah
 */
public class InternalFrame extends com.codename1.ui.Container {

	public InternalFrame(String title, com.codename1.ui.Component mainContent) {
	}

	public void setTitle(String title) {
	}

	public String getTitle() {
	}

	public void setMainContent(com.codename1.ui.Component cmp) {
	}

	public com.codename1.ui.Component getMainContent() {
	}

	public com.codename1.ui.Container getTopLeftButtonsContainer() {
	}

	public com.codename1.ui.Container getTopRightButtonsContainer() {
	}

	public static interface class InternalFrameDelegate {


		public void close(InternalFrame src) {
		}
	}
}
