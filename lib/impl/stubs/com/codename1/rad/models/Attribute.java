/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  The base class for all attributes of {@link com.codename1.rad.nodes.Node}s and {@link com.codename1.rad.models.Property}s .  Each type of attribute
 *  will be modeled by a subclass of {@link Attribute} to enable a declarative syntax for UI descriptors.  The {@link UI} class includes a large number
 *  of static methods for creating attributes of different types.
 *  
 *  {@link com.codename1.rad.nodes.Node} takes zero or more {@link Attribute} objects as parameters.  A {@link com.codename1.rad.nodes.Node} itself is a special
 *  kind of attribute that can contain child nodes.  Nodes can look up attributes of a given type using {@link com.codename1.rad.nodes.Node#findA ttribute(java.lang.Class) }. 
 *  
 *  == Example
 *  
 *  The following example demonstrates the use of declarative syntax to create a UI descriptor for form to edit an entity.  Each of the functions in this example actually creates
 *  an instance of an {@link Attribute} subclass.  E.g. `label("Delete") is just short form for `new LabelAttribute("Delete")`, but using the convenience {@link com.codename1.rad.ui.UI#label(java.lang.String) }
 *  static method.
 *  
 *  .A UI descriptor for a form to edit a "Person" entity
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
 *  @author shannah
 */
public class Attribute {

	public Attribute(Object value) {
	}

	public Object getValue() {
	}

	public void freeze() {
	}
}
