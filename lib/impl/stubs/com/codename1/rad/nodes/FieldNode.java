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
 *  A {@link Node} that represents a field (usually editable) on a form.  It can be added to a {@link FormNode}, or {@link SectionNode}, and 
 *  can be bound to a {@link Property} using either {@link Tags} or {@link PropertyNode} attributes.  
 *  
 *  
 *  
 *  == Supported Attributes
 *  
 *  As with any node, there isn't a fixed limit on the attributes that it can support, but common attributes that it accepts (and will be respected by the {@link EntityEditor} view,
 *  include:
 *  
 *  . {@link PropertyNode} - A property that this field is bound to.  Note that using a {@link PropertyNode} attribute produces strong coupling to the {@link Property}.  
 *  It is almost always better to use {@link Tags} instead to bind the field to a list of tags, and allow dynamic field binding.
 *  . {@link Tags} - A list of tags that this field will try to bind to dynamically.  When the {@link EntityEditor} is created, it will try lookup the property of the {@link Entity} that 
 *  contains one of these tags, and bind to that property.
 *  . {@link Label} - The widget label when rendered in the {@link EntityEditor}
 *  . {@link Description} - The widget description or help text when rendered in the {@link EntityEditor}.
 *  . {@link WidgetType} - The widget type to use for editing this property.  This is used by the {@link PropertyViewFactory} when creating the component.
 *  . {@link OptionsNode} - For widgets that have "options" to choose from, such as comboboxes, this allows you to specify the options that are available to select.
 *  . {@link Editable} - Whether this widget is editable.  (Though this attribute is often added to a parent node so that it is applied to all nodes in the branch.).
 *  
 *  == Creating Fields
 *  
 *  {@link com.codename1.rad.ui.UI} contains convenience methods for creating {@link FieldNode} nodes of specific types.  These are just thin wrappers around
 *  {@link #FieldNode(com.codename1.rad.models.Attribute...) } with {@link WidgetType} attributes set.  
 *  
 *  . {@link com.codename1.rad.ui.UI#textArea(com.codename1.rad.models.Attribute...)} - A multiline text area.
 *  . {@link com.codename1.rad.ui.UI#textField(com.codename1.rad.models.Attribute...) } - Single-line text field.
 *  . {@link com.codename1.rad.ui.UI#comboBox(com.codename1.rad.models.Attribute...) } - A combobox.
 *  . {@link com.codename1.rad.ui.UI#table(com.codename1.rad.models.Attribute...) } - A table
 *  
 *  NOTE: The {@link EntityEditor} class is still undergoing active development to add support for more widget types, improve styles, and add more features.
 *  
 *  == Example
 *  
 *  The following is an example of a UI descriptor for editing a "Person" entity.
 * 
 * .A UI descriptor for a form to edit a "Person" entity
 * [source,java]
 * ----
 * 
 * package com.codename1.demos.ddddemo;
 * 
 * import com.codename1.rad.ui.UI;
 * import com.codename1.rad.nodes.ActionNode;
 * import static com.codename1.demos.ddddemo.PersonEntityType.*;
 * import com.codename1.ui.FontImage;
 * import static com.codename1.ui.FontImage.MATERIAL_DELETE;
 * import static com.codename1.rad.nodes.FormNode.OVERFLOW_MENU;
 * import static com.codename1.rad.nodes.FormNode.BOTTOM_RIGHT_MENU;
 * import static com.codename1.rad.nodes.FormNode.TOP_LEFT_MENU;
 * 
 * 
 * public class PersonEditor extends UI {
 *     
 *     // Define some actions
 *     public static ActionNode 
 *         deleteAction = action(
 *             label("Delete"),
 *             description("Delete this user"),
 *             icon(MATERIAL_DELETE)
 *         ),
 *         showContactsAction = action(
 *             label("Open Contacts"),
 *             description("Show all contacts"),
 *             icon(FontImage.MATERIAL_CONTACTS)
 *         ),
 *         printAction = action(
 *             label("Print"),
 *             description("Print this page"),
 *             icon(FontImage.MATERIAL_PRINT)
 *         );
 *     
 *     {
 *         
 * 
 *         // Define the root form.
 *         form(
 *             actions(OVERFLOW_MENU, deleteAction, printAction),  <1>
 *             actions(TOP_LEFT_MENU, deleteAction, printAction, showContactsAction), <2>
 *             actions(BOTTOM_RIGHT_MENU, deleteAction, printAction), <3>
 *             editable(true),
 *             description("Please edit the person's information in the fields below"),
 *             label("Person Details"),
 *             columns(2),
 *             textField(
 *                 label("Name"),
 *                 description("Please enter your name"),
 *                 tags(Person.name)
 *             ),
 *             textField(
 *                 tags(description)
 *             ),
 *             comboBox(
 *                 tags(DemoTags.hairColor)
 *             ),
 *             section(
 *                 actions(TOP_LEFT_MENU, deleteAction, printAction),
 *                 columns(1),
 *                 label("Section 2"),
 *                 textArea(
 *                     tags(DemoTags.userProfile)
 *                 ),
 *                 table(actions(OVERFLOW_MENU, deleteAction, printAction),
 *                    label("Quick Links"),
 *                    description("Useful links related to this person"),
 *                    editable(true),
 *                    //property(quicklinks),
 *                    tags(com.codename1.rad.schemas.Person.url),
 *                    columns(new QuickLinkEditor().getAllFields())
 *                 )
 *             )
 *             
 *         );
 *     
 * }}
 * 
 * ----
 * <1> We add an overflow menu to the form.
 * <2> Add some actions to the top-left menu.
 * <3> Add some actions to the bottom-right menu.
 * 
 * Notice how succinct, yet readable this code is.  We can convert this into an actual view with the following:
 * 
 * [source,java]
 * ----
 * new EntityEditor(entity, new PersonEditor());
 * ----
 * 
 * And the result:
 * 
 * .The UI generated from the above UI descriptor.  All fields are bound to the entity, so changes to the entity will instantly update the UI, and vice-versa.
 * image::../../../../doc-files/EntityEditor.png[]
 *  
 *  @author shannah
 */
public class FieldNode extends Node implements Proxyable {

	public FieldNode(com.codename1.rad.models.Attribute[] atts) {
	}

	public FieldNode copy() {
	}

	@java.lang.Override
	public FieldNode createProxy(Node newParent) {
	}

	@java.lang.Override
	public boolean canProxy() {
	}

	public com.codename1.rad.ui.EntityEditor.LabelStyle getLabelStyle(com.codename1.rad.ui.EntityEditor.LabelStyle defaultStyle) {
	}

	public com.codename1.rad.ui.EntityEditor.DescriptionStyle getDescriptionStyle(com.codename1.rad.ui.EntityEditor.DescriptionStyle defaultStyle) {
	}

	/**
	 *  Gets the property for this field.  First this will check for an explicit
	 *  property setting using {@link #getProperty()}, and if none is foune, it will
	 *  resolve the tags against the given entity type to find the appropriate property
	 *  of the entity type.
	 *  @param context The entity type to find the property from, in case no property is explicitly set.
	 *  @return The property or null.
	 */
	public com.codename1.rad.models.Property getProperty(com.codename1.rad.models.EntityType context) {
	}

	public com.codename1.rad.models.Tags getTags() {
	}

	public PropertyNode getProperty() {
	}

	public com.codename1.rad.models.Attribute findAttribute(Class type, com.codename1.rad.models.EntityType entityType) {
	}

	@java.lang.Override
	public com.codename1.rad.models.Attribute findAttribute(Class type) {
	}

	public com.codename1.rad.models.Property.Label getLabel() {
	}

	public com.codename1.rad.models.Property.Label getLabel(com.codename1.rad.models.EntityType context) {
	}

	public com.codename1.rad.models.Property.Description getDescription() {
	}

	public com.codename1.rad.models.Property.Description getDescription(com.codename1.rad.models.EntityType context) {
	}

	public com.codename1.rad.attributes.WidgetType getWidgetType() {
	}

	public com.codename1.rad.attributes.WidgetType getWidgetType(com.codename1.rad.models.EntityType context) {
	}

	public com.codename1.rad.ui.PropertyViewFactory getViewFactory() {
	}

	public OptionsNode getOptions() {
	}

	public OptionsNode getOptions(com.codename1.rad.models.EntityType context) {
	}

	public boolean isEditable() {
	}

	/**
	 *  Gets a property selector for this field node.  If the filed contained
	 *  a PropertyNode or a Tags node, then it will construct a selector from those.
	 *  
	 *  Otherwise it will check for a {@link ProeprtySelectorAttribute}, and return 
	 *  a selector constructed form that, with the provided entity root.
	 *  @param context
	 *  @return A property selector, or null if no property or tag is set, and no property selector is set.
	 */
	public com.codename1.rad.models.PropertySelector getPropertySelector(com.codename1.rad.models.Entity context) {
	}

	public com.codename1.rad.ui.image.PropertyImageRenderer getIconRenderer() {
	}

	public static FieldNode createWithPropertySelector(com.codename1.rad.models.PropertySelector selector) {
	}

	public static FieldNode createWithTags(com.codename1.rad.models.Tag[] tags) {
	}

	public static FieldNode createdWithProperty(com.codename1.rad.models.Property prop) {
	}
}
