/**
 *  This package contains text processing utilities such as date formatters and number formatters, which are used by CodeRAD for data conversion of properties.
 */
package com.codename1.rad.text;


/**
 *  Interface for an object that can format and parse numbers.
 *  @author shannah
 */
public interface NumberFormatter {

	public String format(Number number);

	public Number parse(String number);
}
