/**
 *  This package contains foundation components that are used by views in CodeRAD.  
 *  
 *  The components in this package are not, themselves, CodeRAD views - i.e. they don't bind to a view model.  They are used *by* CodeRAD components, and can also be used on their own.
 */
package ca.weblite.shared.components;


/**
 *  A pane that includes a title bar that will hide when scrolling down the page, and reveal when scrolling back up 
 *  the page.
 *  
 *  == Component Alignment
 *  
 *  This container includes a post-layout pass which can align child components' left edges.  This is handy if you 
 *  need to line up a component in the title bar with components in the body.  This can't be easily achieved inside
 *  a layout manager because The title bar is in a separate branch of the component hierarchy than the body.  Simply
 *  setting the same left margin or padding on elements may be insufficient due to safe areas adjusting the padding
 *  on some devices.
 *  
 *  If you want to align the left edge of components, you need to use the {@link ComponentSelector#addTags(java.lang.String...) } method
 *  to add the "left-inset" tag to components that should be left aligned, and the "left-edge" tag to the container that will 
 *  bleed to the left edge of the screen.  The "left-edge" container is used as the relative "zero" point for calculating
 *  the necessary padding to line them up.  
 *  
 *  @author shannah
 */
public class CollapsibleHeaderContainer extends com.codename1.ui.Container {

	public CollapsibleHeaderContainer(com.codename1.ui.Container titleBar, com.codename1.ui.Container body, com.codename1.ui.Container verticalScroller) {
	}

	public void setPartialCollapseUIID(String uiid) {
	}

	public void setFullCollapseUIID(String uiid) {
	}

	public void setCollapseMode(CollapsibleHeaderContainer.CollapseMode mode) {
	}

	@java.lang.Override
	protected void initComponent() {
	}

	@java.lang.Override
	protected void deinitialize() {
	}

	/**
	 *  Layout does a post-layout pass to line up all components with the "left-inset" tag.
	 */
	@java.lang.Override
	public void layoutContainer() {
	}

	@java.lang.Override
	public void paint(com.codename1.ui.Graphics g) {
	}

	public static final class CollapseMode {


		public static final CollapsibleHeaderContainer.CollapseMode FullCollapse;

		public static final CollapsibleHeaderContainer.CollapseMode PartialCollapse;

		public static CollapsibleHeaderContainer.CollapseMode[] values() {
		}

		public static CollapsibleHeaderContainer.CollapseMode valueOf(String name) {
		}
	}

	public static interface class ScrollableContainer {


		public com.codename1.ui.Container getVerticalScroller() {
		}
	}
}
