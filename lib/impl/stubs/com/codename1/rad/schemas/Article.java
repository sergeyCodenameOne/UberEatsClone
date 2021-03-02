/**
 *  This package contains schemas (adapted from https://schema.org) which can be used to promote loose-coupling between CodeRAD components.
 */
package com.codename1.rad.schemas;


/**
 * 
 *  @author shannah
 */
public interface Article extends CreativeWork {

	public static final com.codename1.rad.models.Tag articleBody;

	public static final com.codename1.rad.models.Tag articleSection;

	public static final com.codename1.rad.models.Tag backstory;

	public static final com.codename1.rad.models.Tag pageEnd;

	public static final com.codename1.rad.models.Tag pageStart;

	public static final com.codename1.rad.models.Tag pagination;

	public static final com.codename1.rad.models.Tag speakable;

	public static final com.codename1.rad.models.Tag wordCount;
}
