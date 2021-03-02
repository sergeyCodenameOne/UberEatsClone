/**
 *  This package contains schemas (adapted from https://schema.org) which can be used to promote loose-coupling between CodeRAD components.
 */
package com.codename1.rad.schemas;


/**
 *  A schema with tags to identify properties you woud expect in a ChatRoom.
 *  @author shannah
 */
public interface ChatRoom extends Thing {

	public static final com.codename1.rad.models.Tag messages;

	public static final com.codename1.rad.models.Tag participants;

	/**
	 *  A property that stores the content of the current input buffer (i.e. the text
	 *  field where the user enters text messages).
	 */
	public static final com.codename1.rad.models.Tag inputBuffer;
}
