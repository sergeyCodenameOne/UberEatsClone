/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  A View that can render forms for editing an entity.  The form can be customized with a view descriptor to specify
 *  the sections, actions, layout, and fields to include in the form.
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
 *  
 *  @author shannah
 *  
 */
public class EntityEditor extends com.codename1.ui.Container {

	public static final com.codename1.rad.nodes.ActionNode.Category TOP_LEFT_TOOLBAR;

	public static final com.codename1.rad.nodes.ActionNode.Category TOP_RIGHT_TOOLBAR;

	public static final com.codename1.rad.nodes.ActionNode.Category MORE_MENU;

	public static final com.codename1.rad.nodes.ActionNode.Category BOTTOM_LEFT_TOOLBAR;

	public static final com.codename1.rad.nodes.ActionNode.Category BOTTOM_RIGHT_TOOLBAR;

	public static final com.codename1.rad.nodes.ActionNode.Category INLINE_LEFT;

	public static final com.codename1.rad.nodes.ActionNode.Category INLINE_RIGHT;

	public static final com.codename1.rad.nodes.ActionNode.Category INLINE_LEFT_LABEL;

	public static final com.codename1.rad.nodes.ActionNode.Category INLINE_RIGHT_LABEL;

	public EntityEditor(com.codename1.rad.models.Entity entity, UI uiDescriptor, EntityForm form) {
	}

	public EntityEditor(com.codename1.rad.models.Entity entity, UI uiDescriptor) {
	}

	public EntityEditor(com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.Node rootNode, EntityForm form) {
	}

	public EntityEditor(com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.Node rootNode) {
	}

	@java.lang.Override
	protected void initComponent() {
	}

	/**
	 *  The style used for rendering field labels.  Can be set on individual field nodes or on a parent node.
	 */
	public static final class LabelStyle {


		/**
		 *  Do not display label
		 */
		public static final EntityEditor.LabelStyle None;

		/**
		 *  Display the label.
		 */
		public static final EntityEditor.LabelStyle Default;

		public static EntityEditor.LabelStyle[] values() {
		}

		public static EntityEditor.LabelStyle valueOf(String name) {
		}
	}

	/**
	 *  Attribute for setting {@link LabelStyle}.
	 */
	public static class LabelStyleAttribute {


		public LabelStyleAttribute(EntityEditor.LabelStyle value) {
		}
	}

	/**
	 *  Attribute for setting {@link DescriptionStyle}
	 */
	public static final class DescriptionStyle {


		/**
		 *  Don't display description
		 */
		public static final EntityEditor.DescriptionStyle None;

		/**
		 *  Display field description as a {@link HelpButton}
		 */
		public static final EntityEditor.DescriptionStyle HelpButton;

		/**
		 *  Display description as text
		 */
		public static final EntityEditor.DescriptionStyle SpanLabel;

		public static EntityEditor.DescriptionStyle[] values() {
		}

		public static EntityEditor.DescriptionStyle valueOf(String name) {
		}
	}

	public static class DescriptionStyleAttribute {


		public DescriptionStyleAttribute(EntityEditor.DescriptionStyle style) {
		}
	}

	public class SectionEditor {


		public SectionEditor(com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.SectionNode section) {
		}

		@java.lang.Override
		protected void initComponent() {
		}
	}
}
