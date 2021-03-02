/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  A base class for a transformer that can be registered with {@link ContentType} to add support for converting between content types. 
 *  
 *  It should rarely be necessary to implement a custom DataTransformer as the built-in content types will handle most cases, and if a custom ContentType is introduced,
 *  it will generally know how to convert to and from the basic types.  This would only be necessary for converting between two content types that 
 *  are not base types and do not know about each other.
 *  @author shannah
 */
public class DataTransformer extends Attribute {

	public DataTransformer() {
	}

	/**
	 *  Checks to see if this transformer supports the given source and target content types.
	 *  @param source The source content type.
	 *  @param target The target content type.
	 *  @return 
	 */
	public boolean supports(ContentType source, ContentType target) {
	}

	/**
	 *  Transforms data from one content type to another.
	 *  @param <T> The source type representation class.
	 *  @param <V> The target type representation class.
	 *  @param source The source type
	 *  @param target The target type
	 *  @param data The data to be converted.
	 *  @return 
	 */
	public Object transform(ContentType source, ContentType target, Object data) {
	}
}
