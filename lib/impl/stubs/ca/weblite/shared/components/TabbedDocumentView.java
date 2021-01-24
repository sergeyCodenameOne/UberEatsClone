/**
 *  This package contains foundation components that are used by views in CodeRAD.  
 *  
 *  The components in this package are not, themselves, CodeRAD views - i.e. they don't bind to a view model.  They are used *by* CodeRAD components, and can also be used on their own.
 */
package ca.weblite.shared.components;


/**
 *  A frame for keeping multiple documents opened in separate tabs.  Each document is contained inside its own {@link InternalFrame}.
 *  @author shannah
 */
public class TabbedDocumentView extends com.codename1.ui.Container {

	public TabbedDocumentView() {
	}

	public void showDocument(int index) {
	}

	public int getDocumentCount() {
	}

	public String getDocumentTitle(int index) {
	}

	public com.codename1.ui.Component getDocumentView(int index) {
	}

	public com.codename1.ui.Container getTopLeftButtonsContainer(int index) {
	}

	public com.codename1.ui.Container getTopRightButtonsContainer(int index) {
	}

	public int findIndexWithContent(com.codename1.ui.Component mainContent) {
	}

	public int findIndexWithFrameName(String name) {
	}

	public int getSelectedIndex() {
	}

	public void addDocumentView(String title, com.codename1.ui.Component mainContent) {
	}

	public void removeDocument(int index) {
	}

	public void setDelegate(TabbedDocumentView.TabbedDocumentViewDelegate del) {
	}

	public TabbedDocumentView.TabbedDocumentViewDelegate getDelegate() {
	}

	public static interface class TabbedDocumentViewDelegate {


		public void close(int index) {
		}
	}
}
