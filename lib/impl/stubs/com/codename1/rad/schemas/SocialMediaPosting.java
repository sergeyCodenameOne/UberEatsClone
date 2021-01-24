/**
 *  This package contains schemas (adapted from https://schema.org) which can be used to promote loose-coupling between CodeRAD components.
 */
package com.codename1.rad.schemas;


/**
 * 
 *  @author shannah
 */
public interface SocialMediaPosting extends Article {

	/**
	 *  A CreativeWork such as an image, video, or audio clip shared as part of this posting.
	 */
	public static final com.codename1.rad.models.Tag sharedContent;
}
