/**
 *  This package contains schemas (adapted from https://schema.org) which can be used to promote loose-coupling between CodeRAD components.
 */
package com.codename1.rad.schemas;


/**
 * 
 *  @author shannah
 */
public interface MediaObject extends CreativeWork {

	public static final com.codename1.rad.models.Tag associatedArticle;

	public static final com.codename1.rad.models.Tag bitrate;

	public static final com.codename1.rad.models.Tag contentSize;

	public static final com.codename1.rad.models.Tag contentUrl;

	public static final com.codename1.rad.models.Tag duration;

	public static final com.codename1.rad.models.Tag embedUrl;

	public static final com.codename1.rad.models.Tag encodesCreativeWork;

	public static final com.codename1.rad.models.Tag encodingFormat;

	public static final com.codename1.rad.models.Tag endTime;

	public static final com.codename1.rad.models.Tag height;

	public static final com.codename1.rad.models.Tag playerType;

	public static final com.codename1.rad.models.Tag productionCompany;

	public static final com.codename1.rad.models.Tag regionsAllowed;

	public static final com.codename1.rad.models.Tag requiresSubscription;

	public static final com.codename1.rad.models.Tag startTime;

	public static final com.codename1.rad.models.Tag uploadDate;

	public static final com.codename1.rad.models.Tag width;
}
