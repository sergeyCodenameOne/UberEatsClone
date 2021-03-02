/**
 *  This package contains foundation components that are used by views in CodeRAD.  
 *  
 *  The components in this package are not, themselves, CodeRAD views - i.e. they don't bind to a view model.  They are used *by* CodeRAD components, and can also be used on their own.
 */
package ca.weblite.shared.components;


/**
 *  A component for editing tags.
 *  @author shannah
 */
public class TagEditor extends com.codename1.ui.Container {

	public TagEditor(com.codename1.ui.list.MultipleSelectionListModel options, TagEditor.OptionFactory optionFactory) {
	}

	public static interface class OptionFactory {


		public Object createOptionWithLabel(String label) {
		}
	}
}
