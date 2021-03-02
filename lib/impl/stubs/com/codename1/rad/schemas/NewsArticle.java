/**
 *  This package contains schemas (adapted from https://schema.org) which can be used to promote loose-coupling between CodeRAD components.
 */
package com.codename1.rad.schemas;


/**
 * 
 *  @author shannah
 */
public interface NewsArticle extends Article {

	public static final com.codename1.rad.models.Tag dateline;

	public static final com.codename1.rad.models.Tag printColumn;

	public static final com.codename1.rad.models.Tag printEdition;

	public static final com.codename1.rad.models.Tag printPage;

	public static final com.codename1.rad.models.Tag printSection;
}
