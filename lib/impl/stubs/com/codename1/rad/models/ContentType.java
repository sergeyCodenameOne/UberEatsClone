/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  Encapsulates a content type.  This class is the basis of all data conversions in CodeRAD.  All properties have an assigned
 *  {@link ContentType}.  When a property is bound to a view, the view will use the content type to convert the property's 
 *  value into a form that it can handle.
 *  
 *  == Base Content Types
 *  
 *  . {@link #Text} - Plain text, stored in a {@link String}.
 *  . {@link #BooleanType} - A {@link Boolean} value.
 *  . {@link #IntegerType} - An {@link Integer} value.
 *  . {@link #DoubleType} - A {@link Double} value.
 *  . {@link #FloatType} - A {@link Float} value.
 *  . {@link #LongType} - A {@link Long} value.
 *  . {@link #EntityType} - An {@link Entity} value.
 *  . {@link #EntityListType} - An {@link EntityList} value.
 *  . {@link #DateType} - A {@link java.util.Date} value.
 *  
 *  == Converting Data From One Type to Another
 *  
 *  Use {@link #convert(com.codename1.rad.models.ContentType, java.lang.Object, com.codename1.rad.models.ContentType) } to convert data from one type to another.  For example, to convert a String to an Integer, you could do:
 *  
 *  [source,java]
 *  ----
 *  int value = ContentType.convert(ContentType.Text, "10", ContentType.IntegerType);
 *  ----
 *  
 *  {@link Property}, {@link EntityType}, and {@link Entity} all include convenience methods for retrieving property values in the basic content types.  
 *  E.g. {@link Entity#getText(com.codename1.rad.models.Property) }, which will return the property value as a `String` no matter what content type the property actually stores.
 *  
 *  == Custom Content Types
 *  
 *  If you have a property that has a custom content type, you can implement it by extending {@link ContentType} and providing implementations for {@link #to(com.codename1.rad.models.ContentType, java.lang.Object) } and
 *  {@link #canConvertTo(com.codename1.rad.models.ContentType) }; or {@link #from(com.codename1.rad.models.ContentType, java.lang.Object) } and {@link #canConvertFrom(com.codename1.rad.models.ContentType) }; or all of these methods.
 *  
 *  @author shannah
 */
public class ContentType {

	public static final ContentType Text;

	public static final ContentType BooleanType;

	public static final ContentType IntegerType;

	public static final ContentType LongType;

	public static final ContentType FloatType;

	public static final ContentType DoubleType;

	public static final ContentType EntityType;

	public static final ContentType EntityListType;

	public static final ContentType DateType;

	public ContentType(Property.Name name, Class representationClass) {
	}

	/**
	 *  @return the representationClass
	 */
	public Class getRepresentationClass() {
	}

	public boolean isEntity() {
	}

	public boolean isEntityList() {
	}

	/**
	 *  @return the name
	 */
	public Property.Name getName() {
	}

	@java.lang.Override
	public String toString() {
	}

	@java.lang.Override
	public boolean equals(Object obj) {
	}

	@java.lang.Override
	public int hashCode() {
	}

	public Object to(ContentType otherType, Object data) {
	}

	public boolean canConvertTo(ContentType otherType) {
	}

	public Object from(ContentType otherType, Object data) {
	}

	public boolean canConvertFrom(ContentType otherType) {
	}

	public static Object convert(ContentType sourceType, Object sourceData, ContentType targetType) {
	}

	public static ContentType createObjectType(Class representationClass) {
	}
}
