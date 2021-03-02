/**
 *  This package contains foundation components that are used by views in CodeRAD.  
 *  
 *  The components in this package are not, themselves, CodeRAD views - i.e. they don't bind to a view model.  They are used *by* CodeRAD components, and can also be used on their own.
 */
package ca.weblite.shared.components;


/**
 *  A utility wrapper that allows a Component to be used as an Image so that it can 
 *  be set as the icon for a Label or button.
 *  
 *  @author shannah
 */
public class ComponentImage extends com.codename1.ui.Image {

	public ComponentImage(com.codename1.ui.Component cmp, int w, int h) {
	}

	public com.codename1.ui.Component getComponent() {
	}

	public void enablePulsingAnimation(double currStep, double stepSize, double minAlpha, double maxAlpha) {
	}

	public void disablePulsingAnimation() {
	}

	public boolean isPulsingAnimationEnabled() {
	}

	@java.lang.Override
	public int getWidth() {
	}

	@java.lang.Override
	public int getHeight() {
	}

	@java.lang.Override
	public void scale(int width, int height) {
	}

	@java.lang.Override
	public com.codename1.ui.Image fill(int width, int height) {
	}

	@java.lang.Override
	public com.codename1.ui.Image applyMask(Object mask) {
	}

	public void setAnimation(boolean anim) {
	}

	@java.lang.Override
	public boolean isAnimation() {
	}

	@java.lang.Override
	public boolean requiresDrawImage() {
	}

	@java.lang.Override
	protected void drawImage(com.codename1.ui.Graphics g, Object nativeGraphics, int x, int y) {
	}

	@java.lang.Override
	protected void drawImage(com.codename1.ui.Graphics g, Object nativeGraphics, int x, int y, int w, int h) {
	}

	@java.lang.Override
	public com.codename1.ui.Image scaled(int width, int height) {
	}

	@java.lang.Override
	public boolean animate() {
	}

	public com.codename1.ui.EncodedImage toEncodedImage() {
	}

	public class EncodedWrapper {


		@java.lang.Override
		public com.codename1.ui.EncodedImage scaledEncoded(int width, int height) {
		}

		@java.lang.Override
		public com.codename1.ui.Image scaled(int width, int height) {
		}

		@java.lang.Override
		protected com.codename1.ui.Image getInternal() {
		}
	}
}
