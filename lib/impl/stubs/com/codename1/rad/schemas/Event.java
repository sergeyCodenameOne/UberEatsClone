/**
 *  This package contains schemas (adapted from https://schema.org) which can be used to promote loose-coupling between CodeRAD components.
 */
package com.codename1.rad.schemas;


/**
 *  From https://schema.org/Event
 *  @author shannah
 */
public interface Event extends Thing {

	public static final com.codename1.rad.models.Tag about;

	public static final com.codename1.rad.models.Tag actor;

	public static final com.codename1.rad.models.Tag aggregateRating;

	public static final com.codename1.rad.models.Tag attendee;

	public static final com.codename1.rad.models.Tag audience;

	public static final com.codename1.rad.models.Tag composer;

	public static final com.codename1.rad.models.Tag contributor;

	public static final com.codename1.rad.models.Tag director;

	public static final com.codename1.rad.models.Tag doorTime;

	public static final com.codename1.rad.models.Tag duration;

	public static final com.codename1.rad.models.Tag endDate;

	public static final com.codename1.rad.models.Tag eventSchedule;

	public static final com.codename1.rad.models.Tag eventStatus;

	public static final com.codename1.rad.models.Tag funder;

	public static final com.codename1.rad.models.Tag inLanguage;

	public static final com.codename1.rad.models.Tag isAccessibleForFree;

	public static final com.codename1.rad.models.Tag location;

	public static final com.codename1.rad.models.Tag maximumAttendeeCapacity;

	public static final com.codename1.rad.models.Tag offers;

	public static final com.codename1.rad.models.Tag organizer;

	public static final com.codename1.rad.models.Tag performer;

	public static final com.codename1.rad.models.Tag previousStartDate;

	public static final com.codename1.rad.models.Tag recordedIn;

	public static final com.codename1.rad.models.Tag remainingAttendeeCapacity;

	public static final com.codename1.rad.models.Tag review;

	public static final com.codename1.rad.models.Tag sponsor;

	public static final com.codename1.rad.models.Tag startDate;

	public static final com.codename1.rad.models.Tag subEvent;

	public static final com.codename1.rad.models.Tag superEvent;

	public static final com.codename1.rad.models.Tag translator;

	public static final com.codename1.rad.models.Tag typicalAgeRange;

	public static final com.codename1.rad.models.Tag workFeatured;

	public static final com.codename1.rad.models.Tag workPerformed;
}
