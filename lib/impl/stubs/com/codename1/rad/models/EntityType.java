/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  Encapsulates an entity "type" for an {@link Entity} class.  This is sort of like a "meta-class" that provides run-time support for data conversion, 
 *  property lookup, and property binding.  An EntityType should create its {@link Property}s in its instance initializer.  Typically, the entity type
 *  is declared as a static final anonymous class inside the {@link Entity} class definition as follows:
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
 *  Technically, you don't need to provide direct property access to your entity properties at all.  In our above `UserProfile` class we retained explicit references to the `name` and `description` properties, but we could have simply omitted this.  I.e. The following is also a perfectly valid entity type definition:
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
 *  
 *  == Property Types
 *  
 *  {@link EntityType} includes convenience methods for creating the standard property types:
 *  
 *  . {@link #string(com.codename1.rad.models.Attribute...) }
 *  . {@link #Integer(com.codename1.rad.models.Attribute...) }
 *  . {@link #Boolean(com.codename1.rad.models.Attribute...) }
 *  . {@link #Double(com.codename1.rad.models.Attribute...) }
 *  . {@link #date(com.codename1.rad.models.Attribute...) }
 *  . {@link #entity(java.lang.Class) } - an entity
 *  . {@link #list(java.lang.Class, com.codename1.rad.models.Attribute...) } - A list of entities.
 *  
 *  These methods will create the corresponding property and add it to the {@link EntityType} using {@link #addProperty(com.codename1.rad.models.Property) }.  You can also create custom property types by subclassing {@link AbstractProperty}
 *  
 *  @author shannah
 */
public class EntityType implements Iterable, EntityFactory {

	/**
	 *  Creates an entity type.
	 */
	public EntityType() {
	}

	/**
	 *  Creates an entity type with the given properties.
	 *  @param properties 
	 */
	public EntityType(Property[] properties) {
	}

	public EntityType getRowEntityType() {
	}

	public EntityType getListEntityType() {
	}

	public EntityFactory getRowFactory() {
	}

	public EntityFactory getListFactory() {
	}

	public static EntityFactory getFactory(Class type) {
	}

	public static EntityFactory getRowFactory(Class type) {
	}

	public static EntityFactory getListFactory(Class type) {
	}

	/**
	 *  Creates an entity for the given class.
	 *  @param type A class to create the entity for.  This can be either an EntityType class or an EntityClass
	 *  @return A new entity of the given type.
	 *  @throws IllegalArgumentException if either the entity type isn't registered or it fails to create an instance of it.
	 */
	public static Entity createEntityForClass(Class type) {
	}

	/**
	 *  Gets the singleton EntityType instance for the given EntityType class.
	 *  @param type The EntityType or Entity class.
	 *  @return The singleton EntityType instance for the given EntityType class.
	 */
	public static EntityType getEntityType(Class type) {
	}

	public Class getEntityClass() {
	}

	public static boolean isRegisteredEntityType(Class type) {
	}

	/**
	 *  Gets the ContentType of this EntityType.  Default is {@link ContentType#EntityType}.
	 *  @return The ContentType of this entity type.
	 */
	public ContentType getContentType() {
	}

	/**
	 *  Creates a new instance of this entity type.
	 *  @return 
	 */
	public Entity newInstance() {
	}

	public static void deregister(Class[] classes) {
	}

	public static void registerList(Class listClass, Class rowType) {
	}

	public static void registerList(Class listClass, Class rowType, EntityFactory factory) {
	}

	public static void register(Class[] classes) {
	}

	public static void register(Class cls, EntityFactory factory) {
	}

	public void setRowType(Class type) {
	}

	public void setListType(Class type) {
	}

	/**
	 *  Register an entity class and its optional factory.  This should be called before 
	 *  using an Entity class.
	 *  @param <T> 
	 *  @param cls The entity class to register.
	 *  @param factory The optional factory to create instances of this class. 
	 *  If the class is public and has a no-arg constructor, then a factory isn't 
	 *  necessary.  But if it is private or doesn't have a public no-arg constructor
	 *   you should provide a factory.
	 */
	public static void register(Class cls, EntityType et, EntityFactory factory) {
	}

	public EntityType factory(EntityFactory factory) {
	}

	public EntityFactory getFactory() {
	}

	/**
	 *  Adds a property to this EntityType.  
	 *  @param property The property to add.
	 */
	public void addProperty(Property property) {
	}

	/**
	 *  Adds a set of properties to this EntityType.
	 *  @param properties The properties to add.
	 */
	public void addAllProperties(Property[] properties) {
	}

	/**
	 *  Removes a property from this EntityType.
	 *  @param property The property to remove.
	 *  @return True if the property was removed.   False if no changes were made (i.e. it didn't have this property).
	 */
	public boolean removeProperty(Property property) {
	}

	@java.lang.Override
	public java.util.Iterator iterator() {
	}

	/**
	 *  Flag indicating whether this is a dynamic entity type.  Dynamic entity types are types that
	 *  have no specified schema (you can add any properties, to entities of this type, without being 
	 *  constrained by the properties defined in the EntityType.
	 *  
	 *  Entities that don't have a type specified with {@link Entity#setEntityType(com.codename1.rad.models.EntityType) }
	 *  will, by default have a dynamic entity type.
	 *  @return 
	 */
	public boolean isDynamic() {
	}

	/**
	 *  Checks if this entity type contains the given property.
	 *  @param property
	 *  @return 
	 */
	public boolean contains(Property property) {
	}

	/**
	 *  Creates a new string property on this entity type, and adds it to the property set.
	 *  @param atts The attributes of this property.
	 *  @return The resulting property.
	 */
	public StringProperty string(Attribute[] atts) {
	}

	/**
	 *  Creates a new property containing a specific Object type, and adds it to the property set.
	 *  @param <T> The type of object
	 *  @param type The Type of object.
	 *  @param atts Attributes for the property
	 *  @return The property.
	 */
	public SimpleProperty object(Class type, Attribute[] atts) {
	}

	/**
	 *  Creates a new date property, and adds it to the property set.
	 *  @param atts Attributes of the property
	 *  @return The property.
	 */
	public DateProperty date(Attribute[] atts) {
	}

	/**
	 *  Creates a new Integer property, and adds it to the property set.
	 *  @param atts Attributes of the property
	 *  @return The property.
	 */
	public IntProperty Integer(Attribute[] atts) {
	}

	/**
	 *  Creates a new Double property, and adds it to the property set.
	 *  @param atts Attributes of the property
	 *  @return The property.
	 */
	public DoubleProperty Double(Attribute[] atts) {
	}

	/**
	 *  Creates a new Boolean property, and adds it to the property set.
	 *  @param atts Attributes of the property
	 *  @return The property.
	 */
	public BooleanProperty Boolean(Attribute[] atts) {
	}

	/**
	 *  Creates a new ListProperty (i.e. a property containing an EntityList and adds it to the property set.
	 *  @param <T> The property type.  Subclass of EntityList.
	 *  @param type The property type.  Subclass of EntityList
	 *  @param atts THe attributes of the property
	 *  @return The property.
	 */
	public ListProperty compose(Class type, Attribute[] atts) {
	}

	/**
	 *  Alias of {@link #compose(java.lang.Class, com.codename1.rad.models.Attribute...) }.
	 *  @param <T> The property type.  Subclass of EntityList
	 *  @param type The property type.  Subclass of EntityList
	 *  @param atts The attributes of the property
	 *  @return The property.
	 */
	public ListProperty list(Class type, Attribute[] atts) {
	}

	/**
	 *  Creates a new EntityProperty (i.e. a property containing an Entity and adds it to the property set.
	 *  @param <T> The property type.  Subclass of Entity.
	 *  @param type The property type.  Subclass of Entity
	 *  @param atts THe attributes of the property
	 *  @return The property.
	 */
	public EntityProperty entity(Class type, Attribute[] atts) {
	}

	/**
	 *  Creates a label attribute.
	 *  @param label
	 *  @return The label attribute.
	 */
	public static Property.Label label(String label) {
	}

	/**
	 *  Creates a description attribute.
	 *  @param description
	 *  @return The description attribute.
	 */
	public static Property.Description description(String description) {
	}

	/**
	 *  Creates a widget attribute
	 *  @param atts
	 *  @return The widget attribute.
	 */
	public static Property.Widget widget(Attribute[] atts) {
	}

	/**
	 *  Creates a Tags attribute.
	 *  @param atts
	 *  @return 
	 */
	public static Tags tags(Tag[] atts) {
	}

	/**
	 *  Finds a property in the entity type matching the given tags.  The first tag resolving to a property is used.
	 *  @param tags The tags to look for.
	 *  @return The matching property, or null, if none found.
	 */
	public Property findProperty(Tag[] tags) {
	}

	/**
	 *  Gets a property value of an Entity.
	 *  @param prop The property
	 *  @param entity The entity.
	 *  @param outputType The output type to coerce the value to.
	 *  @return 
	 */
	public Object getPropertyValue(Property prop, Entity entity, ContentType outputType) {
	}

	/**
	 *  Sets a property value of an entity
	 *  @param prop The property
	 *  @param entity The entity.
	 *  @param inputType The input type from which to coerce the value.
	 *  @param data The value to set.s
	 */
	public void setPropertyValue(Property prop, Entity entity, ContentType inputType, Object data) {
	}

	/**
	 *  Gets property value of an entity as a string.
	 *  @param prop The property
	 *  @param entity The entity
	 *  @return The string value.
	 */
	public String getText(Property prop, Entity entity) {
	}

	/**
	 *  Sets the property value of an entity as a string.
	 *  @param prop The property
	 *  @param entity The entity
	 *  @param text The text to set.
	 */
	public void setText(Property prop, Entity entity, String text) {
	}

	/**
	 *  Gets property value of an entity as an int.
	 *  @param prop The property
	 *  @param entity The entity
	 *  @return The int value.
	 */
	public Integer getInt(Property prop, Entity entity) {
	}

	public void setInt(Property prop, Entity entity, int value) {
	}

	/**
	 *  Gets property value of an entity as a Double.
	 *  @param prop The property
	 *  @param entity The entity
	 *  @return The double value.
	 */
	public Double getDouble(Property prop, Entity entity) {
	}

	public void setDouble(Property prop, Entity entity, double val) {
	}

	public void setLong(Property prop, Entity entity, long val) {
	}

	/**
	 *  Gets property value of an entity as a long.
	 *  @param prop The property
	 *  @param entity The entity
	 *  @return The long value.
	 */
	public Long getLong(Property prop, Entity entity) {
	}

	/**
	 *  Gets property value of an entity as a float.
	 *  @param prop The property
	 *  @param entity The entity
	 *  @return The float value.
	 */
	public Float getFloat(Property prop, Entity entity) {
	}

	public void setFloat(Property prop, Entity entity, float val) {
	}

	/**
	 *  Gets property value of an entity as a boolean.
	 *  @param prop The property
	 *  @param entity The entity
	 *  @return The boolean value.
	 */
	public Boolean getBoolean(Property prop, Entity entity) {
	}

	public void setBoolean(Property prop, Entity entity, boolean val) {
	}

	public Object getPropertyValue(Tag tag, Entity entity, ContentType outputType) {
	}

	public boolean setPropertyValue(Tag tag, Entity entity, ContentType inputType, Object val) {
	}

	public Object getPropertyValue(Entity entity, ContentType outputType, Tag[] tags) {
	}

	public boolean setPropertyValue(Entity entity, ContentType inputType, Object val, Tag[] tags) {
	}

	public Object getPropertyValue(Tag tag, Entity entity, ContentType outputType, Object defaultVal) {
	}

	public String getText(Tag tag, Entity entity) {
	}

	public boolean setText(Tag tag, Entity entity, String text) {
	}

	public String getText(Entity entity, Tag[] tags) {
	}

	public boolean setText(Entity entity, String text, Tag[] tags) {
	}

	public Integer getInt(Tag prop, Entity entity) {
	}

	public boolean setInt(Tag prop, Entity entity, int val) {
	}

	public Integer getInt(Entity entity, Tag[] tags) {
	}

	public boolean setInt(Entity entity, int val, Tag[] tags) {
	}

	public Double getDouble(Entity entity, Tag[] tags) {
	}

	public boolean setDouble(Entity entity, double val, Tag[] tags) {
	}

	public Double getDouble(Tag prop, Entity entity) {
	}

	public boolean setDouble(Tag prop, Entity entity, double val) {
	}

	public Long getLong(Entity entity, Tag[] tags) {
	}

	public boolean setLong(Entity entity, long val, Tag[] tags) {
	}

	public Long getLong(Tag prop, Entity entity) {
	}

	public boolean setLong(Tag prop, Entity entity, long val) {
	}

	public Float getFloat(Tag prop, Entity entity) {
	}

	public boolean setFloat(Tag prop, Entity entity, float val) {
	}

	public Float getFloat(Entity entity, Tag[] tags) {
	}

	public boolean setFloat(Entity entity, float val, Tag[] tags) {
	}

	public Boolean getBoolean(Tag prop, Entity entity) {
	}

	public boolean setBoolean(Tag prop, Entity entity, boolean val) {
	}

	public Boolean getBoolean(Entity entity, Tag[] tags) {
	}

	public boolean setBoolean(Entity entity, boolean val, Tag[] tags) {
	}

	public String getText(Tag tag, Entity entity, String defaultVal) {
	}

	public Integer getInt(Tag prop, Entity entity, Integer defaultVal) {
	}

	public Double getDouble(Tag prop, Entity entity, Double defaultVal) {
	}

	public Float getFloat(Tag prop, Entity entity, Float defaultVal) {
	}

	public Boolean getBoolean(Tag prop, Entity entity, Boolean defaultVal) {
	}

	public java.util.Date getDate(Property prop, Entity entity) {
	}

	public java.util.Date getDate(Tag tag, Entity entity) {
	}

	public java.util.Date getDate(Entity entity, Tag[] tags) {
	}

	public void setDate(Property prop, Entity entity, java.util.Date date) {
	}

	public boolean setDate(Tag tag, Entity entity, java.util.Date date) {
	}

	public boolean setDate(Entity entity, java.util.Date date, Tag[] tags) {
	}

	@java.lang.Override
	public Entity createEntity(Class type) {
	}
}
