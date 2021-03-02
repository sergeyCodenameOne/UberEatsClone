/**
 *  This package contains schemas (adapted from https://schema.org) which can be used to promote loose-coupling between CodeRAD components.
 */
package com.codename1.rad.schemas;


/**
 *  From https://schema.org/Person
 *  @author shannah
 */
public interface Thing {

	public static final com.codename1.rad.models.Tag additionalType;

	public static final com.codename1.rad.models.Tag alternateName;

	public static final com.codename1.rad.models.Tag description;

	public static final com.codename1.rad.models.Tag disambiguatingDescription;

	public static final com.codename1.rad.models.Tag identifier;

	public static final com.codename1.rad.models.Tag image;

	public static final com.codename1.rad.models.Tag mainEntityOfPage;

	public static final com.codename1.rad.models.Tag name;

	public static final com.codename1.rad.models.Tag potentialAction;

	public static final com.codename1.rad.models.Tag sameAs;

	public static final com.codename1.rad.models.Tag subjectOf;

	public static final com.codename1.rad.models.Tag url;

	public static final com.codename1.rad.models.Tag thumbnailUrl;
}
