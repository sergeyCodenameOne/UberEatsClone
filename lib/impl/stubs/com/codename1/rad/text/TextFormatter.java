/**
 *  This package contains text processing utilities such as date formatters and number formatters, which are used by CodeRAD for data conversion of properties.
 */
package com.codename1.rad.text;


/**
 *  Interface for objects that can format text.
 *  @author shannah
 */
public interface TextFormatter {

	public String format(String text);

	public String parse(String text);

	public boolean supportsParse();
}
