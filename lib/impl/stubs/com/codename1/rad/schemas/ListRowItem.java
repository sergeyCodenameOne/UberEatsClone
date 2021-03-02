/**
 *  This package contains schemas (adapted from https://schema.org) which can be used to promote loose-coupling between CodeRAD components.
 */
package com.codename1.rad.schemas;


/**
 *  Schema with tags to identify properties in a list row item.
 *  @author shannah
 */
public interface ListRowItem extends Thing {

	public static final com.codename1.rad.models.Tag line1;

	public static final com.codename1.rad.models.Tag line2;

	public static final com.codename1.rad.models.Tag icon;
}
