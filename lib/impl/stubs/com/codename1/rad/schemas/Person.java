/**
 *  This package contains schemas (adapted from https://schema.org) which can be used to promote loose-coupling between CodeRAD components.
 */
package com.codename1.rad.schemas;


/**
 *  From https://schema.org/Person
 *  @author shannah
 */
public interface Person extends Thing {

	public static final com.codename1.rad.models.Tag additionalName;

	public static final com.codename1.rad.models.Tag address;

	public static final com.codename1.rad.models.Tag affiliation;

	public static final com.codename1.rad.models.Tag alumniOf;

	public static final com.codename1.rad.models.Tag award;

	public static final com.codename1.rad.models.Tag birthDate;

	public static final com.codename1.rad.models.Tag birthPlace;

	public static final com.codename1.rad.models.Tag brand;

	public static final com.codename1.rad.models.Tag callSign;

	public static final com.codename1.rad.models.Tag children;

	public static final com.codename1.rad.models.Tag colleague;

	public static final com.codename1.rad.models.Tag contactPoint;

	public static final com.codename1.rad.models.Tag deathDate;

	public static final com.codename1.rad.models.Tag duns;

	public static final com.codename1.rad.models.Tag email;

	public static final com.codename1.rad.models.Tag familyName;

	public static final com.codename1.rad.models.Tag faxNumber;

	public static final com.codename1.rad.models.Tag follows;

	public static final com.codename1.rad.models.Tag funder;

	public static final com.codename1.rad.models.Tag gender;

	public static final com.codename1.rad.models.Tag givenName;

	public static final com.codename1.rad.models.Tag globalLocationNumber;

	public static final com.codename1.rad.models.Tag hasCredential;

	public static final com.codename1.rad.models.Tag hasOccupation;

	public static final com.codename1.rad.models.Tag hasOfferCatalog;

	public static final com.codename1.rad.models.Tag hasPOS;

	public static final com.codename1.rad.models.Tag height;

	public static final com.codename1.rad.models.Tag homeLocation;

	public static final com.codename1.rad.models.Tag honorificPrefix;

	public static final com.codename1.rad.models.Tag honorificSuffix;

	public static final com.codename1.rad.models.Tag interactionStatistic;

	public static final com.codename1.rad.models.Tag isicV4;

	public static final com.codename1.rad.models.Tag jobTitle;

	public static final com.codename1.rad.models.Tag knowsAbout;

	public static final com.codename1.rad.models.Tag knowsLanguage;

	public static final com.codename1.rad.models.Tag makesOffer;

	public static final com.codename1.rad.models.Tag memberOf;

	public static final com.codename1.rad.models.Tag naics;

	public static final com.codename1.rad.models.Tag nationality;

	public static final com.codename1.rad.models.Tag netWorth;

	public static final com.codename1.rad.models.Tag owns;

	public static final com.codename1.rad.models.Tag parent;

	public static final com.codename1.rad.models.Tag performerIn;

	public static final com.codename1.rad.models.Tag publishingPrinciples;

	public static final com.codename1.rad.models.Tag relatedTo;

	public static final com.codename1.rad.models.Tag seeks;

	public static final com.codename1.rad.models.Tag sibling;

	public static final com.codename1.rad.models.Tag sponsor;

	public static final com.codename1.rad.models.Tag spouse;

	public static final com.codename1.rad.models.Tag taxID;

	public static final com.codename1.rad.models.Tag telephone;

	public static final com.codename1.rad.models.Tag vatID;

	public static final com.codename1.rad.models.Tag weight;

	public static final com.codename1.rad.models.Tag workLocation;

	public static final com.codename1.rad.models.Tag worksFor;
}
