/**
 *  This package contains text processing utilities such as date formatters and number formatters, which are used by CodeRAD for data conversion of properties.
 */
package com.codename1.rad.text;


/**
 * 
 *  @author shannah
 */
public class DefaultTextFormatter implements TextFormatter {

	public DefaultTextFormatter(DefaultTextFormatter.FormatCallback callback) {
	}

	public DefaultTextFormatter(DefaultTextFormatter.FormatCallback callback, DefaultTextFormatter.ParseCallback parseCb) {
	}

	@java.lang.Override
	public String format(String text) {
	}

	@java.lang.Override
	public String parse(String text) {
	}

	@java.lang.Override
	public boolean supportsParse() {
	}

	public static interface class FormatCallback {


		public String format(String string) {
		}
	}

	public static interface class ParseCallback {


		public String parse(String string) {
		}
	}
}
