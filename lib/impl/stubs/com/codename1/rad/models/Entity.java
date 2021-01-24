/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  The base class for *Model* objects in CodeRAD.  The {@link Entity} class contains all of the plumbing
 *  necessary for property binding, change listeners, property lookup, and data conversion.  Subclasses of {@link Entity}
 *  should define a static {@link EntityType} object which serves as a sort of meta-class for the entity class.  The {@link EntityType}
 *  keeps track of the properties in the entity, and provides property lookup via {@link Tag}s, which is necessary for loose-coupling.
 *  
 * ==== Example Entity Class
 * 
 * The following figure shows the definition of a very simple entity class:
 * 
 * [source,java]
 * ----
 * public class UserProfile extends Entity {
 *     public static StringProperty name, description; <1>
 *     public static final EntityType TYPE = new EntityType(){{ <2>
 *         name = string(); <3>
 *         description = string();
 *     }};
 *     {
 *         setEntityType(TYPE); <4>
 *     }
 * }
 * ----
 * <1> We define 2 properties of type {@link com.codename1.rad.models.StringProperty} on the class.  A `StringProperty` is simply a property that contains a {@link java.lang.String}.  These are defined `public static` so that we can access them conveniently from anywhere.
 * <2> We define an {@link com.codename1.rad.models.EntityType} for the class.  This is also `public static` because it is class-level (all objects of this class should share the same entity type).
 * <3> We create `name` and `description` properties on this entity type.  Notice that this code runs in the *instance intializer* of the EntityType (the `{{` and `}}` braces are not a typo).  Running this code inside the instance initializer will ensure that the properties are added to the `EntityType`'s property index.
 * <4> Inside the `UserProfile` instance initializer, we set the entity type to the entity type that we created above.
 * 
 * [NOTE]
 * ====
 * Why can't we just use POJOs for our models?*
 * 
 * The {@link com.codename1.rad.models.Entity} class provides a lot of useful plumbing that is necessary for building reusable components that can bind to each other.  This includes property lookup, property binding, change events, and data conversion.
 * ====
 * 
 * ==== Adding Tags to Properties
 * 
 * In the above entity class, we haven't "tagged" any of the properties so it can't be used as a view model for any view, unless that view has been specifically designed for this class, which would limit its reusability.  This is simple to remedy, though. Let's tag the `name` property with {@link com.codename1.rad.schemas.Thing#name}, and `description` with {@link com.codename1.rad.schemas.Thing#description}:
 * 
 * [source,java]
 * ----
 * name = string(tags(Thing.name));
 * description = string(tags(Thing.description));
 * ----
 * 
 * [TIP]
 * ====
 * Properties can contain multiple tags.  E.g. If we want the name field to also be treated as the "ID" field, we could do:
 * 
 * [source,java]
 * ----
 * name = string(tags(Thing.name, Thing.identifier));
 * ----
 * ====
 * 
 * ==== Accessing Property Values
 * 
 * We can access a property value using its property directly.  E.g.
 * 
 * [source,java]
 * ----
 * String name = model.get(UserProfile.name);
 * ----
 * 
 * Notice here we didn't need to cast the return value to "String" because the `Profile.name` property is declared as a string property.  
 * 
 * We can also access the "name" property using the `Thing.name` tag, which is what allows us to use this as a loosely coupled view model:
 * 
 * [source,java]
 * ----
 * String name = (String)model.get(Thing.name);
 * ----
 * 
 * [WARNING]
 * ====
 * When using tags to access properties, it is best to use one of the `getXXX(Tag)` variants that explicitly converts the content type.  E.g. {@link com.codename1.rad.models.Entity#getText(com.codename1.rad.models.Tag)}.  This is because there is no guarantee that a given entity is storing its `Thing.name` property as a String.  It could use any type of property.  Using `getText()` or `getBoolean()` will automatically handle data-conversion if possible.
 * 
 * See {@link com.codename1.rad.models.ContentType} for more information about data conversion in properties.
 * ====
 * 
 * Using the convenience wrapper `getText()` and `setText()` we can then set the values on the `name` property in a generic way:
 * 
 * [source,java]
 * ----
 * model.setText(Thing.name, "Steve");
 * String name = model.getText(Thing.name); // "Steve"
 * ----
 * 
 * [TIP]
 * ====
 * Technically, you don't need to provide direct property access to your entity properties at all.  In our above `UserProfile` class we retained explicit references to the `name` and `description` properties, but we could have simply omitted this.  I.e. The following is also a perfectly valid entity type definition:
 * 
 * .An entity type that doesn't retain explicit references to its properties.  The properties can still be accessed via their assigned tags.
 * [source,java]
 * ----
 * public class UserProfile extends Entity {
 *     public static final EntityType TYPE = new EntityType(){{
 *         string(tags(Thing.name));
 *         string(tags(Thing.description));
 *     }};
 *     {
 *         setEntityType(TYPE);
 *     }
 * }
 * ----
 * ====
 *  
 *  
 *  @author shannah
 */
public class Entity extends java.util.Observable {

	public Entity() {
	}

	/**
	 *  Adds a listener to be notified of changes to the given property.
	 *  @param property The property to listen on.
	 *  @param l The listener.
	 */
	public void addPropertyChangeListener(Property property, com.codename1.ui.events.ActionListener l) {
	}

	public boolean hasPropertyChangeListeners(Property prop) {
	}

	public boolean hasVetoablePropertyChangeListeners(Property prop) {
	}

	/**
	 *  Removes a property change listener.
	 *  @param property The property to listen to.
	 *  @param l The listener.
	 */
	public void removePropertyChangeListener(Property property, com.codename1.ui.events.ActionListener l) {
	}

	/**
	 *  Adds a listener to listen to all property changes on all properties.
	 *  @param l The listener.
	 */
	public void addPropertyChangeListener(com.codename1.ui.events.ActionListener l) {
	}

	/**
	 *  Removes property change listener.
	 *  @param l The listener.
	 */
	public void removePropertyChangeListener(com.codename1.ui.events.ActionListener l) {
	}

	/**
	 *  Fires a property change event to registered listeners.
	 *  @param pce The event.
	 */
	protected void firePropertyChangeEvent(PropertyChangeEvent pce) {
	}

	/**
	 *  Adds a listener to be notified of changes to the given property.
	 *  @param property The property to listen on.
	 *  @param l The listener.
	 */
	public void addVetoablePropertyChangeListener(Property property, com.codename1.ui.events.ActionListener l) {
	}

	/**
	 *  Removes a property change listener.
	 *  @param property The property to listen to.
	 *  @param l The listener.
	 */
	public void removeVetoablePropertyChangeListener(Property property, com.codename1.ui.events.ActionListener l) {
	}

	/**
	 *  Adds a listener to listen to all property changes on all properties.
	 *  @param l The listener.
	 */
	public void addVetoablePropertyChangeListener(com.codename1.ui.events.ActionListener l) {
	}

	/**
	 *  Removes property change listener.
	 *  @param l The listener.
	 */
	public void removeVetoablePropertyChangeListener(com.codename1.ui.events.ActionListener l) {
	}

	/**
	 *  Fires a property change event to registered listeners.
	 *  @param pce The event.
	 */
	protected void fireVetoablePropertyChangeEvent(VetoablePropertyChangeEvent pce) {
	}

	/**
	 *  Creates an image for a given property to storage.  This behaves similarly to the {@link URLImage#createToStorage(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String) }
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  
	 *  @param tag The tag used to look up the property to store.
	 *  @param placeholder The placeholder image.
	 *  @param adapter Adapter for manipulating the image.
	 *  @return The Image, usually a URLImage.
	 *  @see URLImage#createToStorage(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String) 
	 */
	public com.codename1.ui.Image createImageToStorage(Tag tag, com.codename1.ui.EncodedImage placeholder, com.codename1.ui.URLImage.ImageAdapter adapter) {
	}

	/**
	 *  Creates an image to storage on the given property. This behaves similarly to the {@link URLImage#createToStorage(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String) }
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  @param prop The property to store the image in.
	 *  @param placeholder The placeholder image.
	 *  @param adapter
	 *  @return The Image
	 */
	public com.codename1.ui.Image createImageToStorage(Property prop, com.codename1.ui.EncodedImage placeholder, com.codename1.ui.URLImage.ImageAdapter adapter) {
	}

	/**
	 *  Creates an image to storage on the given property. This behaves similarly to the {@link URLImage#createToStorage(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String) }
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  @param tag The tag used to look up the property to store.
	 *  @param placeholder The placeholder image.
	 *  @return The Image
	 */
	public com.codename1.ui.Image createImageToStorage(Tag tag, com.codename1.ui.EncodedImage placeholder) {
	}

	/**
	 *  Creates an image to storage on the given property. This behaves similarly to the {@link URLImage#createToStorage(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String) }
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  @param prop The property to store the image in.
	 *  @param placeholder The placeholder image.
	 *  @return The Image
	 */
	public com.codename1.ui.Image createImageToStorage(Property prop, com.codename1.ui.EncodedImage placeholder) {
	}

	/**
	 *  Creates an image for a given property to storage.  This behaves similarly to the {@link URLImage#createToStorage(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String) }
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  
	 *  @param tag The tag used to look up the property to store.
	 *  @param placeholder The placeholder image.
	 *  @param storageFile The storage key to store the image in.
	 *  @return The Image, usually a URLImage.
	 *  @see URLImage#createToStorage(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String) 
	 */
	public com.codename1.ui.Image createImageToStorage(Tag tag, com.codename1.ui.EncodedImage placeholder, String storageFile) {
	}

	/**
	 *  Creates an image to storage on the given property.This behaves similarly to the {@link URLImage#createToStorage(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String)}
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  @param prop The property to store the image in.
	 *  @param placeholder The placeholder image.
	 *  @param storageFile The storage key where the image should be cached.
	 *  @return The Image
	 */
	public com.codename1.ui.Image createImageToStorage(Property prop, com.codename1.ui.EncodedImage placeholder, String storageFile) {
	}

	/**
	 *  Creates an image for a given property to storage.This behaves similarly to the {@link URLImage#createToStorage(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String)}
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  
	 *  @param tag The tag used to look up the property to store.
	 *  @param placeholder The placeholder image.
	 *  @param storageFile The storage key to store the image in.
	 *  @param adapter Adapter to manipulate the image when loading.
	 *  @return The Image, usually a URLImage.
	 *  @see URLImage#createToStorage(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String) 
	 */
	public com.codename1.ui.Image createImageToStorage(Tag tag, com.codename1.ui.EncodedImage placeholder, String storageFile, com.codename1.ui.URLImage.ImageAdapter adapter) {
	}

	/**
	 *  Creates an image to storage on the given property.This behaves similarly to the {@link URLImage#createToStorage(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String)}
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  @param prop The property to store the image in.
	 *  @param placeholder The placeholder image.
	 *  @param storageFile The storage key where the image should be cached.
	 *  @param adapter Adapter to manipulate the image when loading.
	 *  @return The Image
	 */
	public com.codename1.ui.Image createImageToStorage(Property prop, com.codename1.ui.EncodedImage placeholder, String storageFile, com.codename1.ui.URLImage.ImageAdapter adapter) {
	}

	/**
	 *  Creates an image for a given property to file system. This behaves similarly to the {@link URLImage#createToFileSystem(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String, com.codename1.ui.URLImage.ImageAdapter) }
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  
	 *  @param tag The tag used to look up the property to store.
	 *  @param placeholder The placeholder image.
	 *  @param adapter Adapter to manipulate the image when loading.
	 *  @return The Image, usually a URLImage.
	 */
	public com.codename1.ui.Image createImageToFile(Tag tag, com.codename1.ui.EncodedImage placeholder, com.codename1.ui.URLImage.ImageAdapter adapter) {
	}

	/**
	 *  Creates an image for a given property to file system. This behaves similarly to the {@link URLImage#createToFileSystem(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String, com.codename1.ui.URLImage.ImageAdapter) }
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  
	 *  @param prop The property where the image url should be retrieved from.
	 *  @param placeholder The placeholder image.
	 *  @param adapter Adapter to manipulate the image when loading.
	 *  @return The Image, usually a URLImage.
	 */
	public com.codename1.ui.Image createImageToFile(Property prop, com.codename1.ui.EncodedImage placeholder, com.codename1.ui.URLImage.ImageAdapter adapter) {
	}

	/**
	 *  Creates an image for a given property to file system. This behaves similarly to the {@link URLImage#createToFileSystem(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String, com.codename1.ui.URLImage.ImageAdapter) }
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  
	 *  @param tag The tag used to look up the property to store.
	 *  @param placeholder The placeholder image.
	 *  @return The Image, usually a URLImage.
	 */
	public com.codename1.ui.Image createImageToFile(Tag tag, com.codename1.ui.EncodedImage placeholder) {
	}

	/**
	 *  Creates an image for a given property to file system. This behaves similarly to the {@link URLImage#createToFileSystem(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String, com.codename1.ui.URLImage.ImageAdapter) }
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  
	 *  @param prop The property where the image url should be retrieved from.
	 *  @param placeholder The placeholder image.
	 *  @return The Image, usually a URLImage.
	 */
	public com.codename1.ui.Image createImageToFile(Property prop, com.codename1.ui.EncodedImage placeholder) {
	}

	/**
	 *  Creates an image for a given property to file system.This behaves similarly to the {@link URLImage#createToFileSystem(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String, com.codename1.ui.URLImage.ImageAdapter)}
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  
	 *  @param tag The tag used to look up the property to store.
	 *  @param placeholder The placeholder image.
	 *  @param file The path where to cache the image in the file system.
	 *  @return The Image, usually a URLImage.
	 */
	public com.codename1.ui.Image createImageToFile(Tag tag, com.codename1.ui.EncodedImage placeholder, String file) {
	}

	/**
	 *  Creates an image for a given property to file system.This behaves similarly to the {@link URLImage#createToFileSystem(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String, com.codename1.ui.URLImage.ImageAdapter)}
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  
	 *  @param prop The property where the image URL should be retrieved from.
	 *  @param placeholder The placeholder image.
	 *  @param file The path where to cache the image in the file system.
	 *  @return The Image, usually a URLImage.
	 */
	public com.codename1.ui.Image createImageToFile(Property prop, com.codename1.ui.EncodedImage placeholder, String file) {
	}

	/**
	 *  Creates an image for a given property to file system.This behaves similarly to the {@link URLImage#createToFileSystem(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String, com.codename1.ui.URLImage.ImageAdapter)}
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  
	 *  @param tag The tag used to look up the property to store.
	 *  @param placeholder The placeholder image.
	 *  @param file The path where to cache the image in the file system.
	 *  @param adapter Adapter to manipulate the image on load.
	 *  @return The Image, usually a URLImage.
	 */
	public com.codename1.ui.Image createImageToFile(Tag tag, com.codename1.ui.EncodedImage placeholder, String file, com.codename1.ui.URLImage.ImageAdapter adapter) {
	}

	/**
	 *  Creates an image for a given property to file system.This behaves similarly to the {@link URLImage#createToFileSystem(com.codename1.ui.EncodedImage, java.lang.String, java.lang.String, com.codename1.ui.URLImage.ImageAdapter)}
	 *  except the URL is retrieved from the entity's property, instead of as a parameter.
	 *  
	 *  @param prop The property where the image URL should be retrieved from.
	 *  @param placeholder The placeholder image.
	 *  @param file The path where to cache the image in the file system.
	 *  @param adapter Adapter to manipulate the image on load.
	 *  @return The Image, usually a URLImage.
	 */
	public com.codename1.ui.Image createImageToFile(Property prop, com.codename1.ui.EncodedImage placeholder, String file, com.codename1.ui.URLImage.ImageAdapter adapter) {
	}

	/**
	 *  Sets the entity type for this entity.  The general pattern for entity definitions is to call
	 *  this either in the constructor, or in the instance INIT section, AFTER defining the Entity Type.
	 *  
	 *  E.g.
	 *  
	 *  [source,java]
	 *  ----
	 *  public class Person extends Entity {
	 *      public static final EntityType TYPE = new EntityType() {{
	 *          string(Thing.name);
	 *          string(Thing.description);
	 *      }};
	 *      {
	 *          setEntityType(TYPE);
	 *      }
	 *  }
	 *  ----
	 *  
	 *  @param entityType 
	 */
	public void setEntityType(EntityType entityType) {
	}

	/**
	 *  Gets the entity type of this entity.
	 *  
	 *  @return The entity type.
	 */
	public EntityType getEntityType() {
	}

	/**
	 *  Gets a property as an EntityList. 
	 *  @param tag The tag used to look up the property.  More than one tag can be supplied.  The first matching
	 *  tag (i.e. for which the entity has a corresponding property) will be used.
	 *  
	 *  @return The property value as an EntityList or null if no property was found matching any of the tags.
	 */
	public EntityList getEntityList(Tag[] tag) {
	}

	/**
	 *  Gets property as an EntityList
	 *  @param prop The property to retrieve.
	 *  @return The property as an EntityList, or null if the property value is not an EntityList.
	 */
	public EntityList getEntityList(Property prop) {
	}

	/**
	 *  Gets the a property as an Entity.
	 *  @param tag Tag list to search for matching properties.
	 *  @return The property value as an entity, or null if no such property found, or if matching property is not an entity.
	 */
	public Entity getEntity(Tag[] tag) {
	}

	/**
	 *  Gets the a property value as an Entity.
	 *  @param prop The property whose value we wish to retrieve.
	 *  @return The property value as an entity, or null if the property value is not an entity.
	 */
	public Entity getEntity(Property prop) {
	}

	/**
	 *  Gets the aggregate that this entity is a part of, or creates a new Aggregate with this entity as a its root.
	 *  @return the aggregate
	 */
	public Aggregate getAggregate() {
	}

	/**
	 *  {@inheritDoc }
	 */
	@java.lang.Override
	protected synchronized void clearChanged() {
	}

	/**
	 *  Gets a property value.
	 *  @param key The lookup key for the property.  This can be either a {@link Property}, a {@link Tag}, a {@link Tags},
	 *  or anything else.
	 *  
	 *  If {@link Tags} is supplied, then the first tag resolving to a property is used.
	 *  
	 *  @return The property value.
	 */
	public Object get(Object key) {
	}

	/**
	 *  Sets a property value.
	 *  
	 *  @param key The lookup key for the property.  This can be a {@link Property}, {@link Tag}, or {@link Tags}.
	 *  
	 *  If {@link Tags} is supplied, then the first tag resolving to a property is used.
	 *  
	 *  @param value The value to set.
	 */
	public void set(Object key, Object value) {
	}

	/**
	 *  Converts the entity to a Map.  This will return a Map whose keys correspond to the
	 *  keys supplied, and values are the correponding value in the entity.
	 *  @param keys The keys to use for lookup.  Can be {@link Tag}, {@link Property}, or {@link Tags}.
	 *  @return A Map with the specified properties.
	 */
	public java.util.Map toMap(Object[] keys) {
	}

	/**
	 *  Gets the value of the specified property.
	 *  @param <T>
	 *  @param prop The property to retrieve.
	 *  @return 
	 */
	public Object get(Property prop) {
	}

	/**
	 *  Finds the property corresponding to the given tags.
	 *  @param tags The tags to search for.  The first tag resolving to a property is used.
	 *  @return The matching property, or null if none found.
	 */
	public Property findProperty(Tag[] tags) {
	}

	/**
	 *  Gets a property as text.
	 *  @param prop The property
	 *  @return The property value as text.
	 */
	public String getText(Property prop) {
	}

	/**
	 *  Gets a property value as text.
	 *  @param tags The tags to search for.  The first tag resolving to a property is used.
	 *  @return The property value as text.
	 */
	public String getText(Tag[] tags) {
	}

	/**
	 *  Gets property value as Boolean.  Consider using {@link #isFalsey(com.codename1.rad.models.Property) } instead
	 *  of this method if it is possible that the property is null, or stores a type other than Boolean.  
	 *  @param prop The property.
	 *  @return The property value as boolean.
	 *  
	 */
	public Boolean getBoolean(Property prop) {
	}

	/**
	 *  Gets property value as Boolean. Consider using {@link #isFalsey(com.codename1.rad.models.Tag)  } instead
	 *  of this method if it is possible that the property is null, or stores a type other than Boolean. 
	 *  @param tags Tags to search for.  First tag resolving to a property is used.
	 *  @return The property value as a Boolean.
	 */
	public Boolean getBoolean(Tag[] tags) {
	}

	/**
	 *  Gets a property value as a Double.
	 *  @param prop The property.
	 *  @return The property value as a Double
	 */
	public Double getDouble(Property prop) {
	}

	/**
	 *  Gets property value as a Double.
	 *  @param tags Tags to search for.  First tag resolving to a property is used.
	 *  @return Property value as Double
	 */
	public Double getDouble(Tag[] tags) {
	}

	/**
	 *  Gets property value as Integer
	 *  @param prop Th property
	 *  @return The property value as Integer.
	 */
	public Integer getInt(Property prop) {
	}

	/**
	 *  Gets property value as an Integer.
	 *  @param tags Tags to search for.  First tag resolving to a property is used.
	 *  @return Property value as Integer
	 */
	public Integer getInt(Tag[] tags) {
	}

	/**
	 *  Gets property value as Long
	 *  @param prop Th property
	 *  @return The property value as Long.
	 */
	public Long getLong(Property prop) {
	}

	/**
	 *  Gets property value as a Long.
	 *  @param tags Tags to search for.  First tag resolving to a property is used.
	 *  @return Property value as Long
	 */
	public Long getLong(Tag[] tags) {
	}

	/**
	 *  Gets property value as given content type.
	 *  @param <V> Content Type
	 *  @param prop The property to get
	 *  @param contentType The content type.
	 *  @return The value as the given content type.
	 */
	public Object get(Property prop, ContentType contentType) {
	}

	/**
	 *  Sets property as given content type.
	 *  @param prop The property to set
	 *  @param inputType The content type of the input data
	 *  @param val The value to set.
	 */
	public void set(Property prop, ContentType inputType, Object val) {
	}

	/**
	 *  Sets the property value as the given content type.
	 *  @param tag The tag used to lookup the property.
	 *  @param inputType The content type of the value that is being set.
	 *  @param val The value.
	 *  @return true if it was successfully set.  false if it was not, generally due to 
	 *  no property being found matching the tag.
	 */
	public boolean set(Tag tag, ContentType inputType, Object val) {
	}

	/**
	 *  Sets the property value as the given content type.
	 *  @param inputType The content type of the input data.
	 *  @param val The value to set.
	 *  @param tags The tags used to lookup the property.  The first tag resolving to a property is used.
	 *  @return True if the value was set.  False if not. Usually false means that there was no property
	 *  matching the provided tags.
	 */
	public boolean set(ContentType inputType, Object val, Tag[] tags) {
	}

	public void setText(Property prop, String text) {
	}

	/**
	 *  Sets the given property as text.
	 *  @param tag The tag used to lookup the property.
	 *  @param text The text to set.
	 *  @return True if it was successful.  False otherwise.  False generally means that there was no
	 *  matching property.
	 */
	public boolean setText(Tag tag, String text) {
	}

	/**
	 *  Sets property as text
	 *  @param text Text to set as property value.
	 *  @param tags Tags used to lookup property.
	 *  @return True if successful. False if there were no matching properties.
	 */
	public boolean setText(String text, Tag[] tags) {
	}

	/**
	 *  Sets property as Double
	 *  @param prop The property to set
	 *  @param val The value to set.
	 */
	public void setDouble(Property prop, double val) {
	}

	/**
	 *  Sets property as double.
	 *  @param tag Tag used to lookup property.
	 *  @param val The value to set.
	 *  @return True if successful.  False if no matching properties were found for tag.
	 */
	public boolean setDouble(Tag tag, double val) {
	}

	/**
	 *  Sets property as double.
	 *  @param val The value to set.
	 *  @param tags Tags used to lookup property.
	 *  @return True if successful.  False if no matching properties were found for tags.
	 */
	public boolean setDouble(double val, Tag[] tags) {
	}

	/**
	 *  Sets property as Long
	 *  @param prop The property to set
	 *  @param val The value to set.
	 */
	public void setLong(Property prop, long val) {
	}

	/**
	 *  Sets property as long.
	 *  @param tag Tag used to lookup property.
	 *  @param val The value to set.
	 *  @return True if successful.  False if no matching properties were found for tag.
	 */
	public boolean setLong(Tag tag, long val) {
	}

	/**
	 *  Sets property as long.
	 *  @param val The value to set.
	 *  @param tags Tags used to lookup property.
	 *  @return True if successful.  False if no matching properties were found for tags.
	 */
	public boolean setLong(long val, Tag[] tags) {
	}

	/**
	 *  Sets property as Float
	 *  @param prop The property to set
	 *  @param val The value to set.
	 */
	public void setFloat(Property prop, float val) {
	}

	/**
	 *  Sets property as float.
	 *  @param tag Tag used to lookup property.
	 *  @param val The value to set.
	 *  @return True if successful.  False if no matching properties were found for tag.
	 */
	public boolean setFloat(Tag tag, float val) {
	}

	/**
	 *  Sets property as float.
	 *  @param val The value to set.
	 *  @param tags Tags used to lookup property.
	 *  @return True if successful.  False if no matching properties were found for tags.
	 */
	public boolean setFloat(float val, Tag[] tags) {
	}

	/**
	 *  Sets property as int
	 *  @param prop The property to set
	 *  @param val The value to set.
	 */
	public void setInt(Property prop, int val) {
	}

	/**
	 *  Sets property as int.
	 *  @param tag Tag used to lookup property.
	 *  @param val The value to set.
	 *  @return True if successful.  False if no matching properties were found for tag.
	 */
	public boolean setInt(Tag tag, int val) {
	}

	/**
	 *  Sets property as int.
	 *  @param val The value to set.
	 *  @param tags Tags used to lookup property.
	 *  @return True if successful.  False if no matching properties were found for tags.
	 */
	public boolean setInt(int val, Tag[] tags) {
	}

	/**
	 *  Sets property as boolean
	 *  @param prop The property to set
	 *  @param val The value to set.
	 */
	public void setBoolean(Property prop, boolean val) {
	}

	/**
	 *  Sets property as boolean.
	 *  @param tag Tag used to lookup property.
	 *  @param val The value to set.
	 *  @return True if successful.  False if no matching properties were found for tag.
	 */
	public boolean setBoolean(Tag tag, boolean val) {
	}

	/**
	 *  Sets property as boolean.
	 *  @param val The value to set.
	 *  @param tags Tags used to lookup property.
	 *  @return True if successful.  False if no matching properties were found for tags.
	 */
	public boolean setBoolean(boolean val, Tag[] tags) {
	}

	/**
	 *  Gets property as date
	 *  @param prop The property to set
	 *  @return The property as a date.
	 */
	public java.util.Date getDate(Property prop) {
	}

	/**
	 *  Gets property as date.
	 *  @param tags Tags used to lookup property.
	 *  @return The property as a Date.
	 */
	public java.util.Date getDate(Tag[] tags) {
	}

	/**
	 *  Sets property as Date
	 *  @param prop The property to set
	 *  @param date The value to set.
	 */
	public void setDate(Property prop, java.util.Date date) {
	}

	/**
	 *  Sets property as Date.
	 *  @param tag Tag used to lookup property.
	 *  @param date The value to set.
	 *  @return True if successful.  False if no matching properties were found for tag.
	 */
	public boolean setDate(Tag tag, java.util.Date date) {
	}

	/**
	 *  Sets property as Date.
	 *  @param date The value to set.
	 *  @param tags Tags used to lookup property.
	 *  @return True if successful.  False if no matching properties were found for tags.
	 */
	public boolean setDate(java.util.Date date, Tag[] tags) {
	}

	/**
	 *  Sets property as Entity
	 *  @param prop The property to set
	 *  @param e The value to set.
	 */
	public void setEntity(Property prop, Entity e) {
	}

	/**
	 *  Sets property as Entity.
	 *  @param tag Tag used to lookup property.
	 *  @param e The value to set.
	 *  @return True if successful.  False if no matching properties were found for tag.
	 */
	public boolean setEntity(Tag tag, Entity e) {
	}

	/**
	 *  Sets property as Entity.
	 *  @param e The value to set.
	 *  @param tags Tags used to lookup property.
	 *  @return True if successful.  False if no matching properties were found for tags.
	 */
	public boolean setEntity(Entity e, Tag[] tags) {
	}

	/**
	 *  Checks if property is an Entity.
	 *  @param prop The property.
	 *  @return True only if the property value is an Entity.
	 */
	public boolean isEntity(Property prop) {
	}

	/**
	 *  Checks if property is an entity.
	 *  @param tag The tag to lookup property.
	 *  @return True only if the property value is an entity.
	 */
	public boolean isEntity(Tag tag) {
	}

	/**
	 *  Checks if property is empty.  This includes if property is null, an empty string, or an EntityList that is empty.
	 *  @param prop The property
	 *  @return True if property value is empty.
	 */
	public boolean isEmpty(Property prop) {
	}

	/**
	 *  Checks if property is empty. This includes if property is null, an empty string, or an EntityList that is empty.
	 *  @param tag The tag used to lookup property.
	 *  @return True if property is empty.
	 */
	public boolean isEmpty(Tag tag) {
	}

	/**
	 *  Checks if property value is falsey.  This includes if the entity doesn't contain the property, if the property value is null,
	 *  or an empty string, or a boolean `false` value, is numeric with a `0` value, or is an empty EntityList.
	 *  @param prop The property to check.
	 *  @return True if the property value is "falsey".
	 */
	public boolean isFalsey(Property prop) {
	}

	/**
	 *  Checks if property value is falsey.  This includes if the entity doesn't contain the property, if the property value is null,
	 *  or an empty string, or a boolean `false` value, is numeric with a `0` value, or is an empty EntityList.
	 *  @param tag The tag to lookup the property.
	 *  @return True if property value is "falsey".
	 */
	public boolean isFalsey(Tag tag) {
	}

	/**
	 *  Marks a property value as "changed".  This will propagate a call to {@link #setChanged() }
	 *  (marking the whole object as changed), and it will fire a property change event, if the `firePropertyChange` argument
	 *  is true.
	 *  @param prop The property to mark as changed.
	 *  @param firePropertyChange True to fire a property change event to all listeners of this property.
	 */
	public void setChanged(Property prop, boolean firePropertyChange) {
	}

	/**
	 *  Adds an item to the given property.  Assumes that the property value is an EntityList.  If property is currently
	 *  null, it will attempt to create an EntityList for the property, and add a value.
	 *  @param prop The property to set.
	 *  @param value The entity to add to the property's entity list.
	 */
	public void add(Property prop, Entity value) {
	}

	/**
	 *  Gets property as an EntityList.  If the property is currently null, then this will attempt to create a 
	 *  new EntityList at this property, and return that.
	 *  @param prop The property.
	 *  @return The property value as an entity list.
	 *  @throws IllegalStateException If the property type is not an EntityList type.
	 */
	public EntityList getEntityListNonNull(Property prop) {
	}

	/**
	 *  Gets a property value as an Entity.  If the property value is currently null, then this will attempt to create
	 *  a new Entity at this property, and return that.
	 *  @param prop The property to get.
	 *  @return The property value as an Entity.
	 *  @throws IllegalStateException If the property type is not an Entity type.
	 */
	public Entity getEntityNonNull(Property prop) {
	}

	public static EntityTypeBuilder entityTypeBuilder(Class cls) {
	}
}
