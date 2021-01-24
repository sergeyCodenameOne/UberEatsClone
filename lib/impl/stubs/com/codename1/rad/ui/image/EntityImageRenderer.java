/**
 *  This class contains subclasses of AsyncImage
 */
package com.codename1.rad.ui.image;


/**
 *  Creates an image for a given entity.
 *  @author shannah
 */
public interface EntityImageRenderer {

	public AsyncImage createImage(com.codename1.rad.ui.EntityView view, com.codename1.rad.models.Property property, int rowIndex, boolean selected, boolean focused);
}
