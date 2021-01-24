/**
 *  This package contains schemas (adapted from https://schema.org) which can be used to promote loose-coupling between CodeRAD components.
 */
package com.codename1.rad.schemas;


/**
 * 
 *  @author shannah
 */
public interface Action extends Thing {

	public static final com.codename1.rad.models.Tag actionStatus;

	public static final com.codename1.rad.models.Tag agent;

	public static final com.codename1.rad.models.Tag endTime;

	public static final com.codename1.rad.models.Tag error;

	public static final com.codename1.rad.models.Tag instrument;

	public static final com.codename1.rad.models.Tag location;

	public static final com.codename1.rad.models.Tag object;

	public static final com.codename1.rad.models.Tag participant;

	public static final com.codename1.rad.models.Tag result;

	public static final com.codename1.rad.models.Tag startTime;

	public static final com.codename1.rad.models.Tag target;
}
