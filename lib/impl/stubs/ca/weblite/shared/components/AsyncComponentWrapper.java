/**
 *  This package contains foundation components that are used by views in CodeRAD.  
 *  
 *  The components in this package are not, themselves, CodeRAD views - i.e. they don't bind to a view model.  They are used *by* CodeRAD components, and can also be used on their own.
 */
package ca.weblite.shared.components;


/**
 * 
 *  @author shannah
 */
public class AsyncComponentWrapper extends com.codename1.ui.Container {

	public AsyncComponentWrapper(com.codename1.util.AsyncResource asyncContent) {
	}

	public com.codename1.util.AsyncResource getContent(Class type) {
	}

	public com.codename1.util.AsyncResource getContent() {
	}
}
