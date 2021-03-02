/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  A class for retrieving properties from an entity hierarchy in a dynamic way.  E.g.
 *  If you have an entity that is expected to have a property, which is itself an entity,
 *  which has a property that we want to retrieve.  This class encapsulates the retrieval
 *  of such a sub-property by specifying a "path" to the property.
 *  
 *  @author shannah
 */
public class PropertySelector {

	/**
	 *  Creates a new property selector
	 *  @param root The root entity to select properties on.
	 *  @param tags The tags to use for property selection.
	 */
	public PropertySelector(Entity root, Tag[] tags) {
	}

	/**
	 *  Creates a new property selector.
	 *  @param root The root entity to select properties on.
	 *  @param property The property to get values from.
	 */
	public PropertySelector(Entity root, Property property) {
	}

	/**
	 *  Creates a new property selector with the given parent selector.
	 *  @param parent The parent selector
	 *  @param tags The tags to select from.
	 */
	public PropertySelector(PropertySelector parent, Tag[] tags) {
	}

	/**
	 *  Creates a new property selector with the given parent selector.
	 *  @param parent THe parent selector
	 *  @param property The property.
	 */
	public PropertySelector(PropertySelector parent, Property property) {
	}

	/**
	 *  Adds a change listener on property.
	 *  @param l The listener to add.
	 */
	public void addPropertyChangeListener(com.codename1.ui.events.ActionListener l) {
	}

	/**
	 *  Removes property change listener from property.
	 *  @param l 
	 */
	public void removePropertyChangeListener(com.codename1.ui.events.ActionListener l) {
	}

	public boolean set(ContentType type, Object value) {
	}

	/**
	 *  Gets the property value as the given type.
	 *  @param <T> The type to coerce the property value to.
	 *  @param type The type to coerce the property value to.
	 *  @param defaultValue The default value which will be returned if either the property is not found, or is null.
	 *  @return 
	 */
	public Object get(ContentType type, Object defaultValue) {
	}

	/**
	 *  Creates a child selector on this property selector.
	 *  @param property The property to select on.
	 *  @return The child property selector.
	 */
	public PropertySelector createChildSelector(Property property) {
	}

	/**
	 *  Creates a child selector for this property selector.
	 *  @param tags The tags used to lookup the property in the child selector.
	 *  @return The child property selector.
	 */
	public PropertySelector createChildSelector(Tag[] tags) {
	}

	public PropertySelector createChildSelector(int index, Property property) {
	}

	public PropertySelector createChildSelector(int index, Tag[] tags) {
	}

	/**
	 *  Alias of {@link #createChildSelector(com.codename1.rad.models.Property) }
	 *  @param prop
	 *  @return 
	 */
	public PropertySelector child(Property prop) {
	}

	public PropertySelector child(int index, Property prop) {
	}

	/**
	 *  Alias of {@link #createChildSelector(com.codename1.rad.models.Tag...) }
	 *  @param tags
	 *  @return 
	 */
	public PropertySelector child(Tag[] tags) {
	}

	public PropertySelector child(int index, Tag[] tags) {
	}

	/**
	 *  Gets the selected property value as text.
	 *  @param defaultValue The value to return if the property value was null
	 *  @return The property value as text.
	 */
	public String getText(String defaultValue) {
	}

	public boolean setText(String value) {
	}

	/**
	 *  Gets the selected property as boolean
	 *  @param defaultVal The value to return if the property value was null.
	 *  @return The property as boolean.
	 */
	public Boolean getBoolean(boolean defaultVal) {
	}

	public boolean setBoolean(boolean val) {
	}

	/**
	 *  Gets the selected property value as Date.
	 *  @param defaultVal The value to return if the property value was null
	 *  @return The property value as date.
	 */
	public java.util.Date getDate(java.util.Date defaultVal) {
	}

	public boolean setDate(java.util.Date val) {
	}

	/**
	 *  Gets the selected property value as Entity.
	 *  @param defaultVal The value to return if the property value was null
	 *  @return The property value as entity.
	 */
	public Entity getEntity(Entity defaultVal) {
	}

	public boolean setEntity(Entity val) {
	}

	/**
	 *  Gets the selected property value as EntityList.
	 *  @param defaultVal The value to return if the property value was null
	 *  @return The property value as EntityList.
	 */
	public EntityList getEntityList(EntityList defaultVal) {
	}

	public boolean setEntityList(EntityList val) {
	}

	/**
	 *  Gets the selected property value as float.
	 *  @param defaultVal The value to return if the property value was null
	 *  @return The property value as float.
	 */
	public Float getFloat(float defaultVal) {
	}

	public boolean setFloat(float val) {
	}

	/**
	 *  Gets the selected property value as double.
	 *  @param defaultVal The value to return if the property value was null
	 *  @return The property value as double.
	 */
	public Double getDouble(double defaultVal) {
	}

	public boolean setDouble(double val) {
	}

	/**
	 *  Gets the selected property value as int.
	 *  @param defaultVal The value to return if the property value was null
	 *  @return The property value as int.
	 */
	public Integer getInt(int defaultVal) {
	}

	public boolean setInt(int val) {
	}

	/**
	 *  Checks if property is empty.
	 *  @return 
	 */
	public boolean isEmpty() {
	}

	/**
	 *  Checks if property is falsey.
	 *  @return 
	 */
	public boolean isFalsey() {
	}

	/**
	 *  Wrapper for {@link Entity#createImageToStorage(com.codename1.rad.models.Property, com.codename1.ui.EncodedImage) }
	 *  @param placeholder
	 *  @param adapter
	 *  @return Image
	 */
	public com.codename1.ui.Image createImageToStorage(com.codename1.ui.EncodedImage placeholder, com.codename1.ui.URLImage.ImageAdapter adapter) {
	}

	/**
	 *  Wrapper for {@link Entity#createImageToFile(com.codename1.rad.models.Tag, com.codename1.ui.EncodedImage) }
	 *  @param placeholder
	 *  @return 
	 */
	public com.codename1.ui.Image createImageToStorage(com.codename1.ui.EncodedImage placeholder) {
	}

	/**
	 *  Wrapper for {@link Entity#createImageToStorage(com.codename1.rad.models.Property, com.codename1.ui.EncodedImage) }
	 *  @param placeholder
	 *  @param storageFile
	 *  @return 
	 */
	public com.codename1.ui.Image createImageToStorage(com.codename1.ui.EncodedImage placeholder, String storageFile) {
	}

	/**
	 *  Wrapper for {@link #createImageToStorage(com.codename1.ui.EncodedImage) }
	 *  @param placeholder
	 *  @param storageFile
	 *  @param adapter
	 *  @return 
	 */
	public com.codename1.ui.Image createImageToStorage(com.codename1.ui.EncodedImage placeholder, String storageFile, com.codename1.ui.URLImage.ImageAdapter adapter) {
	}

	/**
	 *  Wrapper for {@link Entity#createImageToFile(com.codename1.rad.models.Property, com.codename1.ui.EncodedImage) }
	 *  @param placeholder
	 *  @param adapter
	 *  @return 
	 */
	public com.codename1.ui.Image createImageToFile(com.codename1.ui.EncodedImage placeholder, com.codename1.ui.URLImage.ImageAdapter adapter) {
	}

	/**
	 *  Wrapper for {@link Entity#createImageToFile(com.codename1.rad.models.Property, com.codename1.ui.EncodedImage) }
	 *  @param placeholder
	 *  @return 
	 */
	public com.codename1.ui.Image createImageToFile(com.codename1.ui.EncodedImage placeholder) {
	}

	/**
	 *  Wrapper for {@link Entity#createImageToFile(com.codename1.rad.models.Property, com.codename1.ui.EncodedImage) }
	 *  @param placeholder
	 *  @param file
	 *  @return 
	 */
	public com.codename1.ui.Image createImageToFile(com.codename1.ui.EncodedImage placeholder, String file) {
	}

	/**
	 *  Wrapper for {@link Entity#createImageToFile(com.codename1.rad.models.Property, com.codename1.ui.EncodedImage) }
	 *  @param placeholder
	 *  @param file
	 *  @param adapter
	 *  @return 
	 */
	public com.codename1.ui.Image createImageToFile(com.codename1.ui.EncodedImage placeholder, String file, com.codename1.ui.URLImage.ImageAdapter adapter) {
	}

	/**
	 *  Resolves the property of this property selector.
	 *  @return The property resolved by this property selector.
	 */
	public Property getLeafProperty() {
	}

	/**
	 *  Resolves the entity of this property selector.
	 *  @return The entity of this property selector.
	 */
	public Entity getLeafEntity() {
	}

	/**
	 *  Gets the parent property selector.
	 *  @return The parent property selector.
	 */
	public PropertySelector getParent() {
	}

	/**
	 *  Gets the root property selector.  If this selector is the root selector, then this will just 
	 *  return itself.  It it is a child selector, it will walk up its parent tree until it reaches the root.
	 *  @return 
	 */
	public PropertySelector getRoot() {
	}

	/**
	 *  Checks if the property of this selector exists.
	 *  @return 
	 */
	public boolean exists() {
	}

	public static PropertySelector propertySelector(Entity root, Property prop) {
	}

	public static PropertySelector propertySelector(Entity root, Tag[] tags) {
	}
}
