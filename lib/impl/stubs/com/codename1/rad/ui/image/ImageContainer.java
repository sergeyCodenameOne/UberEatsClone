/**
 *  This class contains subclasses of AsyncImage
 */
package com.codename1.rad.ui.image;


/**
 *  A that manages the loading of URLImages, application of mask (rect or roundrect), and proper sizing
 *  according to the current layout manager.
 *  @author shannah
 */
public class ImageContainer extends com.codename1.ui.Container {

	public Object createImageMask(int width) {
	}

	public static ImageContainer createToStorage(com.codename1.rad.models.Entity entity, com.codename1.rad.models.Property property, String storageFile) {
	}

	public static ImageContainer createToStorage(com.codename1.rad.models.PropertySelector property, String storageFile) {
	}

	public static ImageContainer createToStorage(com.codename1.rad.models.Entity entity, com.codename1.rad.models.Property property) {
	}

	public static ImageContainer createToStorage(com.codename1.rad.models.PropertySelector property) {
	}

	public static ImageContainer createToStorage(com.codename1.rad.models.Entity entity) {
	}

	public static ImageContainer createToFileSystem(com.codename1.rad.models.Entity entity, com.codename1.rad.models.Property property, String filePath) {
	}

	public static ImageContainer createToFileSystem(com.codename1.rad.models.PropertySelector property, String filePath) {
	}

	public static ImageContainer createToFileSystem(com.codename1.rad.models.Entity entity, com.codename1.rad.models.Property property) {
	}

	public static ImageContainer createToFileSystem(com.codename1.rad.models.PropertySelector property) {
	}

	public static ImageContainer createToFileSystem(com.codename1.rad.models.Entity entity) {
	}

	public void setAspectRatio(double aspect) {
	}

	public void invalidateImage() {
	}
}
