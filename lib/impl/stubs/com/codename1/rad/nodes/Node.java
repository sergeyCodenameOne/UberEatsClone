/**
 *  This package contains {@link Node} classes for use inside UI descriptors.
 *  
 *  = Models
 *  :toc:
 *  
 *  == Introduction
 *  
 *  === Entities
 *  
 *  === EntityTypes
 *  
 *  
 *  === Properties
 *  
 *  
 *  === Attributes
 *  
 *  
 *  === Tags
 *  
 *  
 *  
 */
package com.codename1.rad.nodes;


/**
 *  A special type of attribute that can contain child nodes.  This is the basis of the UI descriptor hierarchy. 
 *  
 *  @author shannah
 */
public abstract class Node extends com.codename1.rad.models.Attribute {

	/**
	 *  Node attributes.
	 */
	protected final com.codename1.rad.models.AttributeSet attributes;

	protected final com.codename1.rad.ui.NodeList childNodes;

	/**
	 *  View parameters which can be used for setting properties in views.
	 */
	protected final java.util.Map viewParameters;

	protected final java.util.Map actions;

	/**
	 *  Create a new node with given value and provided attributes.
	 *  @param value Node value, may be null.
	 *  @param atts Atrributes to set in the node.
	 */
	public Node(Object value, com.codename1.rad.models.Attribute[] atts) {
	}

	/**
	 *  Create a proxy for this node.  The node class must implement {@link Proxyable}
	 *  @param parent The parent node of the proxy node.
	 *  @return The proxy node.
	 */
	public Node proxy(Node parent) {
	}

	/**
	 *  Returns true if this node can be proxied.  Default return value is false.  Subclasses
	 *  that allow proxying should implement the Proxyable interface, and return true
	 *  for this method.
	 *  @return 
	 */
	public boolean canProxy() {
	}

	/**
	 *  Converts this node into a proxy node.
	 *  @param originalNode 
	 */
	public void setProxying(Node originalNode) {
	}

	/**
	 *  Gets the node that this node proxies.
	 *  @return 
	 */
	public Node getProxying() {
	}

	/**
	 *  Returns the original node in a proxy chain.  If this node is not proxying any
	 *  nodes, then it will return itself.
	 *  @return 
	 */
	public Node getCanonicalNode() {
	}

	/**
	 *  Gets an iterator for iterating up the proxy chain.  If this is not a proxy node
	 *  then this will return an empty iterator.
	 *  @return 
	 */
	public java.util.Iterator proxyingIterator() {
	}

	/**
	 *  Sets the parent node.  You cannot re-assign a non-null parent on a node that
	 *  already has a non-null parent.  A workaround is to first set parent to null, then
	 *  set the parent again to the new parent.  Some node types, such as Actions, need
	 *  to appear in multiple places in the UI tree.  In such cases, a proxy node is created
	 *  for the action in the various positions of the tree.
	 *  @param parent 
	 */
	public void setParent(Node parent) {
	}

	/**
	 *  Returns an attribute of the given type for this node.  If this is a proxy node, 
	 *  it will first check its own attributes.  If none is found, it will check the
	 *  node that it is proxying for the attribute.
	 *  @param <V> The type of attribute to return.
	 *  @param type The attribute type.
	 *  @return The attribute, or null, if this node doesn't have an attribute of this type.
	 */
	public com.codename1.rad.models.Attribute findAttribute(Class type) {
	}

	/**
	 *  Find an attribute in this node, or a parent node.  This first checks the current 
	 *  node for the given attribute. If none is found, it will check the parent node.
	 *  It will walk up the UI tree to the root until it finds an attribute of this type.
	 *  If none is found, it will check the proxy node, and walk up the tree from there.
	 *  @param <V> The attribute type to retrieve.
	 *  @param type The attribute type.
	 *  @return An attribute of the given type, or null if none found.
	 */
	public com.codename1.rad.models.Attribute findInheritedAttribute(Class type) {
	}

	/**
	 *  Gets a view parameter for this node.  This will walk up the tree until it finds 
	 *  a parameter for the given view property.  View properties are defined generally inside
	 *  the View that consumes them.  You can then set values or bindings on these properties
	 *  in the UI tree using the {@link UI#param()} method.
	 *  @param <V> The view parameter type
	 *  @param prop The property to retrieve.
	 *  @return The property parameter, or null if none found.
	 */
	public com.codename1.rad.ui.ViewPropertyParameter getViewParameter(com.codename1.rad.ui.ViewProperty prop) {
	}

	/**
	 *  Gets the value of a view parameter.
	 *  @param <V>
	 *  @param prop
	 *  @return 
	 */
	public Object getViewParameterValue(com.codename1.rad.ui.ViewProperty prop) {
	}

	/**
	 *  Gets the value of a view parameter
	 *  @param <V> The ViewProperty type.
	 *  @param prop The view property
	 *  @param defaultValue The default value returned in the case where no such view property is found on this node.
	 *  @return The view parameter value.
	 */
	public Object getViewParameterValue(com.codename1.rad.ui.ViewProperty prop, Object defaultValue) {
	}

	/**
	 *  Checks if this node has the given view parameter.
	 *  @param prop
	 *  @return 
	 */
	public boolean hasViewParameter(com.codename1.rad.ui.ViewProperty prop) {
	}

	/**
	 *  Gets a view parameter for this node.  This will walk up the tree until it finds 
	 *  a parameter for the given view property.  View properties are defined generally inside
	 *  the View that consumes them.  You can then set values or bindings on these properties
	 *  in the UI tree using the {@link UI#param()} method.
	 *  @param <V> The view parameter type.
	 *  @param prop The property to retrieve.
	 *  @param defaultVal Default value in case no property found.
	 *  @return 
	 */
	public com.codename1.rad.ui.ViewPropertyParameter getViewParameter(com.codename1.rad.ui.ViewProperty prop, com.codename1.rad.ui.ViewPropertyParameter defaultVal) {
	}

	/**
	 *  Gets the parent node of this node.
	 *  @return 
	 */
	public Node getParent() {
	}

	/**
	 *  Gets the first ancestor whose class matches the given type.
	 *  @param <V> 
	 *  @param type The class
	 *  @return The first matching ancestor or null
	 */
	public Node getAncestor(Class type) {
	}

	public Object getValue() {
	}

	public void setAttributesIfNotExists(com.codename1.rad.models.Attribute[] atts) {
	}

	/**
	 *  Sets attributes on this node.
	 *  @param atts The attributes to set.
	 */
	public void setAttributes(com.codename1.rad.models.Attribute[] atts) {
	}

	/**
	 *  Gets the child nodes of this node.  If this is a proxying node, this will include both the 
	 *  actual child nodes, and the nodes of the node that this is proxying for.
	 *  @return 
	 */
	public com.codename1.rad.ui.NodeList getChildNodes() {
	}

	/**
	 *  Gets the child nodes of this node that are FieldNode instances.
	 *  @param tags
	 *  @return 
	 */
	public com.codename1.rad.ui.NodeList getChildFieldNodes(com.codename1.rad.models.Tags tags) {
	}

	/**
	 *  Gets the child nodes of this node of the given type.
	 *  @param type
	 *  @return 
	 */
	public com.codename1.rad.ui.NodeList getChildNodes(Class type) {
	}

	/**
	 *  Gets a child node of this node of the given type.
	 *  @param <V>
	 *  @param type
	 *  @return 
	 */
	public Object getChildNode(Class type) {
	}

	/**
	 *  Gets actions on this node in the given category.  This will not include 
	 *  actions defined in parent nodes.  See {@link #getInheritedActions(com.codename1.rad.nodes.ActionNode.Category) }
	 *  if you want to also include actions defined in parents.
	 *  @param category
	 *  @return 
	 */
	public com.codename1.rad.ui.Actions getActions(ActionNode.Category category) {
	}

	/**
	 *  Gets an action defined on this node that matches the given category.  This will
	 *  not check parent nodes for matching actions.  See {@link #getInheritedAction(com.codename1.rad.nodes.ActionNode.Category) }
	 *  if you want to also check parent nodes for matching actions.
	 *  @param category
	 *  @return 
	 */
	public ActionNode getAction(ActionNode.Category category) {
	}

	/**
	 *  Gets actions on this node, and parent node(s) in the given category.
	 *  @param category 
	 *  @return 
	 */
	public com.codename1.rad.ui.Actions getInheritedActions(ActionNode.Category category) {
	}

	/**
	 *  Gets action matching the given category in this node.  If none is found
	 *  in the current node, it will check the parent node for matches.
	 *  @param category
	 *  @return 
	 */
	public ActionNode getInheritedAction(ActionNode.Category category) {
	}

	/**
	 *  Flattens attributes in provided arrays into a single Attribute[] array.
	 *  @param arrs
	 *  @return 
	 */
	protected static final com.codename1.rad.models.Attribute[] merge(com.codename1.rad.models.Attribute[][] arrs) {
	}

	protected static final com.codename1.rad.models.Attribute[] mergeRecursive(com.codename1.rad.models.Attribute[][] arrs) {
	}

	/**
	 *  Gets the value of the {@link UIID} attribute on this node.  This will not check the parent node.
	 *  @param defaultVal Default returned if the node does not contain a UIID attribute.
	 *  @return 
	 */
	public String getUIID(String defaultVal) {
	}

	public String getUIID(com.codename1.rad.models.Entity context, String defaultVal) {
	}

	/**
	 *  Gets {@link UIID} attribute of this node.  This will not check the parent node.
	 *  @return 
	 */
	public com.codename1.rad.attributes.UIID getUIID() {
	}

	/**
	 *  Gets {@link UIIDPrefix} value of this node.  This will not check the parent node.
	 *  @param defaultVal
	 *  @return 
	 */
	public String getUIIDPrefix(String defaultVal) {
	}

	/**
	 *  Gets {@link UIIDPrefix} attribute of this node.  This will crawl up the parent hierarchy
	 *  until it finds a UIIDPrefix setting.
	 *  @return 
	 */
	public com.codename1.rad.attributes.UIIDPrefix getUIIDPrefix() {
	}

	/**
	 *  Gets {@link IconUIID} attribute of this node.  This will NOT check the parent node.
	 *  @return 
	 */
	public com.codename1.rad.attributes.IconUIID getIconUIID() {
	}

	/**
	 *  Gets {@link DataFormatterAttribute} of this node.  This will crawl up the parent hierarchy
	 *  until it finds a date formatter.
	 *  @return 
	 */
	public com.codename1.rad.models.DateFormatterAttribute getDateFormatter() {
	}

	/**
	 *  Gets {@link TextFormatterAttribute} of this node.  THis will crawl up the parent hierarchy
	 *  until it finds a text formatter.
	 *  @return 
	 */
	public com.codename1.rad.models.TextFormatterAttribute getTextFormatter() {
	}

	/**
	 *  Gets {@link NumberFormatterAttribute} of this node.
	 *  @return 
	 */
	public com.codename1.rad.models.NumberFormatterAttribute getNumberFormatter() {
	}

	/**
	 *  Convenience method that casts a node to the given type.
	 *  @param <V>
	 *  @param type
	 *  @return 
	 */
	public Node as(Class type) {
	}

	/**
	 *  Creates a property selector on the given entity using (in order of decreasing precedence):
	 *  
	 *  1. A {@link PropertyNode} attribute on the node.
	 *  2. A {@link Tags} attribute on the node.
	 *  3. A {@link PropertySelectorAttribute} on the node.
	 *  
	 *  @param entity The entity on which the property selector should be created.
	 *  @return The property selector.
	 */
	public com.codename1.rad.models.PropertySelector createPropertySelector(com.codename1.rad.models.Entity entity) {
	}
}
