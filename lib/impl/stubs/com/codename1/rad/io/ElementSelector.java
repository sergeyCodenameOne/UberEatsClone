package com.codename1.rad.io;


/**
 *  A query selector similar to the {@link com.codename1.ui.ComponentSelector} for working with XML documents.
 *  @author shannah
 */
public class ElementSelector implements Iterable, java.util.Set {

	/**
	 *  Creates an element selector with the given selector on the provided roots.
	 *  @param selector The selector.
	 *  @param roots The roots
	 */
	public ElementSelector(String selector, java.util.Set roots) {
	}

	/**
	 *  Creates a component selector that wraps the provided components.  The provided 
	 *  components are treated as the "results" of this selector.  Not the roots.  However
	 *  you can use {@link #find(java.lang.String) } to perform a query using this selector
	 *  as the roots.
	 *  @param cmps Components to add to this selector results.
	 */
	public ElementSelector(java.util.Set cmps) {
	}

	/**
	 *  Creates a element selector that wraps the provided elements.  The provided 
	 *  components are treated as the "results" of this selector.  Not the roots.  However
	 *  you can use {@link #find(java.lang.String) } to perform a query using this selector
	 *  as the roots.
	 *  @param els Components to add to this selector results.
	 */
	public ElementSelector(com.codename1.xml.Element[] els) {
	}

	/**
	 *  Creates a selector with the provided roots.  This will only search through the subtrees
	 *  of the provided roots to find results that match the provided selector string.
	 *  @param selector The selector string
	 *  @param roots The roots for this selector.
	 */
	public ElementSelector(String selector, com.codename1.xml.Element[] roots) {
	}

	/**
	 *  Creates a selector with the provided roots.  This will only search through the subtrees
	 *  of the provided roots to find results that match the provided selector string.
	 *  @param selector The selector string
	 *  @param roots The roots for this selector.
	 */
	public ElementSelector(String selector, java.util.Collection roots) {
	}

	/**
	 *  Retains only elements of the result set that are contained in the provided collection.
	 *  @param c
	 *  @return 
	 */
	public boolean retainAll(java.util.Collection c) {
	}

	/**
	 *  Removes all of the components in the provided collection from the result set.
	 *  @param c
	 *  @return 
	 */
	public boolean removeAll(java.util.Collection c) {
	}

	@java.lang.Override
	public void clear() {
	}

	@java.lang.Override
	public java.util.Iterator iterator() {
	}

	/**
	 *  Returns number of results found.
	 *  @return 
	 */
	public int size() {
	}

	/**
	 *  
	 *  @return True if there were no results.
	 */
	public boolean isEmpty() {
	}

	/**
	 *  Checks if an object is contained in result set.
	 *  @param o
	 *  @return 
	 */
	public boolean contains(Object o) {
	}

	/**
	 *  Returns results as an array.
	 *  @return 
	 */
	public Object[] toArray() {
	}

	/**
	 *  Returns results as an array.
	 *  @param <T>
	 *  @param a
	 *  @return 
	 */
	public Object[] toArray(Object[] a) {
	}

	/**
	 *  Explicitly adds a component to the result set.
	 *  @param e
	 *  @return True on success
	 */
	public boolean add(com.codename1.xml.Element e) {
	}

	/**
	 *  Appends a child component to the first container in this set.  Same as calling
	 *  {@link Container#add(com.codename1.ui.Component) } padding {@literal child} on first container
	 *  in this set.
	 *  @param child Component to add to container.
	 *  @return Self for chaining.
	 */
	public ElementSelector append(com.codename1.xml.Element child) {
	}

	/**
	 *  Appends a child component to the first container in this set.  Same as calling
	 *  {@link Container#add(java.lang.Object, com.codename1.ui.Component) } padding {@literal child} on first container
	 *  in this set.
	 *  @param constraint
	 *  @param child
	 *  @return 
	 */
	public ElementSelector append(Object constraint, com.codename1.xml.Element child) {
	}

	public ElementSelector setAttribute(String key, String value) {
	}

	/**
	 *  Gets an attribute value from the first item in this found set.
	 *  @param key
	 *  @return 
	 */
	public String getAttribute(String key) {
	}

	public ElementSelector setString(String key, String value) {
	}

	public ElementSelector setInt(String key, int value) {
	}

	public ElementSelector setDouble(String key, double value) {
	}

	public ElementSelector setBoolean(String key, boolean value) {
	}

	public ElementSelector setDate(String key, java.util.Date date, com.codename1.l10n.DateFormat fmt) {
	}

	/**
	 *  Gets a string value on this selector.  This uses a notation that allows you to target
	 *  the current result, or a subselection.
	 *  @param key The key.  E.g. "@attname" for attribute.  "tagname" for subtag.  "subselector/@attname", "subselector/tagname"
	 *  @param defaultValue The default value if no value is found.
	 *  @return 
	 */
	public String getString(String key, String defaultValue) {
	}

	/**
	 *  Gets an int value on this selector.  This uses a notation that allows you to target
	 *  the current result, or a subselection.
	 *  @param key The key.  E.g. "@attname" for attribute.  "tagname" for subtag.  "subselector/@attname", "subselector/tagname"
	 *  @param defaultValue The default value if no value is found.
	 *  @return 
	 */
	public int getInt(String key, int defaultValue) {
	}

	/**
	 *  Gets a double value on this selector.  This uses a notation that allows you to target
	 *  the current result, or a subselection.
	 *  @param key The key.  E.g. "@attname" for attribute.  "tagname" for subtag.  "subselector/@attname", "subselector/tagname"
	 *  @param defaultValue The default value if no value is found.
	 *  @return 
	 */
	public double getDouble(String key, double defaultValue) {
	}

	/**
	 *  Gets a boolean value on this selector.  This uses a notation that allows you to target
	 *  the current result, or a subselection.
	 *  @param key The key.  E.g. "@attname" for attribute.  "tagname" for subtag.  "subselector/@attname", "subselector/tagname"
	 *  @param defaultValue The default value if no value is found.
	 *  @return 
	 */
	public boolean getBoolean(String key, boolean defaultValue) {
	}

	/**
	 *  Gets a date value on this selector.  This uses a notation that allows you to target
	 *  the current result, or a subselection.
	 *  @param key The key.  E.g. "@attname" for attribute.  "tagname" for subtag.  "subselector/@attname", "subselector/tagname"
	 *  @param formats DateFormats to attempt to parse date with.
	 *  @return 
	 */
	public java.util.Date getDate(String key, com.codename1.l10n.DateFormat[] formats) {
	}

	/**
	 *  Explicitly removes a component from the result set.
	 *  @param o
	 *  @return Self for chaining.
	 */
	public boolean remove(Object o) {
	}

	/**
	 *  Checks if the result set contains all of the components found in the provided
	 *  collection.
	 *  @param c
	 *  @return 
	 */
	public boolean containsAll(java.util.Collection c) {
	}

	/**
	 *  Adds all components in the given collection to the result set.
	 *  @param c
	 *  @return 
	 */
	public boolean addAll(java.util.Collection c) {
	}

	public ElementSelector getChildAt(int index) {
	}

	public ElementSelector getParent() {
	}

	public int getChildIndex(com.codename1.xml.Element child) {
	}

	public ElementSelector getChildrenByTagName(String name) {
	}

	public ElementSelector getDescendantsByTagName(String name, int depth) {
	}

	public ElementSelector getDescendantsByTagName(String name) {
	}

	public ElementSelector getDescendantsByTagNameAndAttribute(String name, String tagName, int depth) {
	}

	public ElementSelector getElementById(String id) {
	}

	public ElementSelector getFirstChildByTagName(String name) {
	}

	public int getNumChildren() {
	}

	public String getText() {
	}

	public boolean hasTextChild() {
	}

	public ElementSelector removeAttribute(String attribute) {
	}

	public ElementSelector removeChildAt(int indx) {
	}

	public ElementSelector find(String selector) {
	}
}
