/**
 *  This package contains text processing utilities such as date formatters and number formatters, which are used by CodeRAD for data conversion of properties.
 */
package com.codename1.rad.text;


/**
 *  Interface for objects that can format and parse dates.
 *  @author shannah
 */
public interface DateFormatter {

	public String format(java.util.Date date);

	public java.util.Date parse(String date);

	public boolean supportsParse();
}
