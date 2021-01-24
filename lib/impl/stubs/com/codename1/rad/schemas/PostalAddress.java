/**
 *  This package contains schemas (adapted from https://schema.org) which can be used to promote loose-coupling between CodeRAD components.
 */
package com.codename1.rad.schemas;


/**
 * 
 *  @author shannah
 */
public interface PostalAddress extends ContactPoint {

	public static final com.codename1.rad.models.Tag addressCountry;

	public static final com.codename1.rad.models.Tag addressLocality;

	public static final com.codename1.rad.models.Tag addressRegion;

	public static final com.codename1.rad.models.Tag postOfficeBoxNumber;

	public static final com.codename1.rad.models.Tag postalCode;

	public static final com.codename1.rad.models.Tag streetAddress;
}
