/**
 *  This package contains schemas (adapted from https://schema.org) which can be used to promote loose-coupling between CodeRAD components.
 */
package com.codename1.rad.schemas;


/**
 *  From https://schema.org/Comment
 *  @author shannah
 */
public interface Comment extends CreativeWork {

	public static final com.codename1.rad.models.Tag downvoteCount;

	public static final com.codename1.rad.models.Tag parentItem;

	public static final com.codename1.rad.models.Tag upvoteCount;
}
