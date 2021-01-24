/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  A special kind of attribute that enables loose coupling of components in CodeRAD. Adding {@link Tags} to a {@link Property} definition results in the ability to look up
 *  that property by the tag.  This means that Views don't need to know which properties its view model has.  It just need to require that the view model
 *  tags its properties in a way that it can understand.
 *  
 *  [INFO]
 * ====
 * https://schema.org provides a large set of schemas for common data types that one might need in an application.  It provides a base schema, https://schema.org/Thing[Thing] that includes properties that may be common to any type of "thing", such as `name`, `description`, `identifier`, `image` etc..  This schema has been ported into Java as the {@link com.codename1.rad.schemas.Thing} interface.  
 * 
 * Each property has a corresponding {@link com.codename1.rad.models.Tag} defined.
 * ====
 * 
 * The concept of tags is a simple one, but they have powerful effect.  If a view needs to render its model's "phone number" (e.g. a contact list view), then it doesn't need to know anything about the properties in the model.  It is able to look up the phone number of the model by the `Person.telephone` tag:
 * 
 * [source.java]
 * ----
 * String telephone = model.getText(Person.telephone);
 * ----
 * 
 * As long as the model includes a property that is tagged with the `Person.telephone` tag, this will work.  If the model doesn't include this property, then this will simply return null.
 * 
 * You can check if the model's entity type contains such a property using:
 * 
 * [source,java]
 * ----
 * Property telephoneProp = model.getEntityType().findProperty(Person.telephone);
 * ----
 * 
 * This will be `null` if there is no such property.
 * 
 * This simple trick allows us to completely decouple components from each other.  As long as they can agree on a common set of "Tags", they'll be able to bind to each other seamlessly.
 * 
 * The following diagram depicts how Tags can be used as a sort of "glue" layer between the View and the Model, and Action categories (discussed later under "Controllers") as a glue lasyer between the View and the Controller.  
 * 
 * .Tags are used to bind views to the appropriate properties of their view model using loose coupling.  Action categories are used to bind views to their controllers using loose coupling.
 * image::../../../../doc-files/Entity-Property-Tag-MVC.png[]
 *  @author shannah
 *  
 *  
 *  @see Tags
 *  @see EntityType#tags(com.codename1.rad.models.Tag...) 
 *  @see com.codename1.rad.ui.UI#tags(com.codename1.rad.models.Tag...) 
 */
public class Tag extends Attribute {

	/**
	 *  Creates a new Tag with given name.
	 *  @param value A name for the tag.  Used for debugging mainly.
	 */
	public Tag(Property.Name value) {
	}

	/**
	 *  Creates a new Tag with given name.
	 *  @param str The name of the tag.  Used for debugging mainly.
	 */
	public Tag(String str) {
	}

	/**
	 *  Creates a new Tag.
	 */
	public Tag() {
	}

	/**
	 *  Gets the name of the tag.
	 *  @return 
	 */
	public String getName() {
	}

	@java.lang.Override
	public String toString() {
	}
}
