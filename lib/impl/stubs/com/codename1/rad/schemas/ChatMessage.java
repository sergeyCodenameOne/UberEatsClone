/**
 *  This package contains schemas (adapted from https://schema.org) which can be used to promote loose-coupling between CodeRAD components.
 */
package com.codename1.rad.schemas;


/**
 *  A schema with tags to identify common properties you would expect for a Chat message.
 *  @author shannah
 */
public interface ChatMessage extends Comment {

	public static final com.codename1.rad.models.Tag isOwnMessage;

	public static final com.codename1.rad.models.Tag isFavorite;

	public static final com.codename1.rad.models.Tag typingInProgress;

	public static final com.codename1.rad.models.Tag attachment;

	public static final com.codename1.rad.models.Tag attachmentPlaceholderImage;
}
