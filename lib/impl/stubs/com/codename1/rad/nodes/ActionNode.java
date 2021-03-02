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
 *  A special {@link Node} that defines an action. When added to prescribed {@link Category}, an Action may manifest itself as a button,
 *  or a menu item.  The exact visual form of an can be customized using an {@link ActionViewFactory} to the node hierarchy.  It is up to the
 *  View to decide how to render actions that it finds in its node hierarchy, or whether to render them at all.  Generally a View will document
 *  which action categories it supports so that controllers know to register actions in those categories.  For example, the {@link ProfileAvatarView} supports
 *  the {@link com.codename1.rad.ui.entityviews.ProfileAvatarView#PROFILE_AVATAR_CLICKED_MENU} category.  Actions added to that category will be rendered
 *  as menu items in a popup menu that is shown when the user clicks the avatar.  If the user, then clicks on the menu item for the action, it will fire 
 *  an event which can be handled by the Controller.
 *  
 *  == Example
 *  
 *  .Excerpts from `ChatFormController`.  Defines a single action `send`, and adds it to the view.  Also handles the events when the `send` action is "fired".   See https://shannah.github.io/RADChatRoom/getting-started-tutorial.html[this tutorial,target=top] for a more comprehensive treatment of this material.
 * [source,java]
 * ----
 * public class ChatFormController extends FormController {
 *     // Define the "SEND" action for the chat room
 *     public static final ActionNode send = action( <1>
 *         enabledCondition(entity-> {
 *             return !entity.isEmpty(ChatRoom.inputBuffer);
 *         }),
 *         icon(FontImage.MATERIAL_SEND)
 *     );
 *     
 *     //... More action definitions
 *     
 *     public ChatFormController(Controller parent) {
 *         super(parent); <2>
 *         Form f = new Form("My First Chat Room", new BorderLayout());
 *         
 *         // Create a "view node" as a UI descriptor for the chat room.
 *         // This allows us to customize and extend the chat room.
 *         ViewNode viewNode = new ViewNode(
 *             actions(ChatRoomView.SEND_ACTION, send), <3>
 *             // ... more action definitions
 *         );
 *         
 *         // Add the viewNode as the 2nd parameter
 *         ChatRoomView view = new ChatRoomView(createViewModel(), viewNode, f); <4>
 *         f.add(CENTER, view);
 *         setView(f);
 *         
 *         // Handle the send action
 *         addActionListener(send, evt->{ <5>
 *             evt.consume();
 *             //.. code to handle the send action.
 *             
 *         });
 *     }
 * }
 * ----
 * <1> Define an action.
 * <2> Call `super(parent)` to register the given controller as its parent controller, so that unhandled events will propagate to it.
 * <3> Assign `send` action to the `SEND_ACTION` category (requirement of the `ChatRoomView` component). The `ChatRoomView` will check this category for the presense of an action.  If none is found, it simply won't include a send button in the UI, nor will it fire "send" events.
 * <4> Create a new `ChatRoomView`, passing it a dummy view model, and the `viewNode` that includes our action.
 * <5> Register a handler for the "send" action.  Notice that we could have registered this handler in the parent controller instead (i.e. the ApplicationController) because unhandled events would propagate up.  In this case, it makes more sense as a part of the ChatFormController though.
 * 
 *  @author shannah
 */
public class ActionNode extends Node implements Proxyable {

	public ActionNode(com.codename1.rad.models.Attribute[] atts) {
	}

	public void addActionListener(com.codename1.ui.events.ActionListener l) {
	}

	public com.codename1.rad.ui.ComponentDecorators getComponentDecorators() {
	}

	public void decorateComponent(com.codename1.ui.Component cmp) {
	}

	public EventFactoryNode getEventFactory() {
	}

	public com.codename1.rad.ui.ActionViewFactory getViewFactory() {
	}

	@java.lang.Override
	public com.codename1.rad.models.Attribute findAttribute(Class type) {
	}

	public com.codename1.rad.ui.ActionStyle getActionStyle() {
	}

	public boolean isTextStyle() {
	}

	public boolean isIconStyle() {
	}

	public com.codename1.rad.attributes.Badge getBadge() {
	}

	public com.codename1.rad.attributes.BadgeUIID getBadgeUIID() {
	}

	public ActionNode getSelected() {
	}

	public ActionNode getUnselected() {
	}

	public ActionNode getPressed() {
	}

	public ActionNode getDisabled() {
	}

	public ActionNode.Category getCategory() {
	}

	public com.codename1.rad.models.Property.Label getLabel() {
	}

	public com.codename1.rad.models.Property.Description getDescription() {
	}

	public com.codename1.rad.attributes.Condition getCondition() {
	}

	public com.codename1.rad.attributes.SelectedCondition getSelectedCondition() {
	}

	public ActionNode.EnabledCondition getEnabledCondition() {
	}

	public boolean isEnabled(com.codename1.rad.models.Entity entity) {
	}

	public boolean isSelected(com.codename1.rad.models.Entity entity) {
	}

	public com.codename1.rad.attributes.ImageIcon getImageIcon() {
	}

	public com.codename1.rad.attributes.MaterialIcon getMaterialIcon() {
	}

	public com.codename1.rad.attributes.TextIcon getTextIcon() {
	}

	@java.lang.Override
	public Node createProxy(Node parent) {
	}

	@java.lang.Override
	public boolean canProxy() {
	}

	public static ActionNode.ActionNodeEvent getActionNodeEvent(com.codename1.ui.events.ActionEvent evt) {
	}

	public static ActionNode.ActionNodeEvent getActionNodeEvent(com.codename1.ui.events.ActionEvent evt, ActionNode action) {
	}

	public static ActionNode getActionNode(com.codename1.ui.events.ActionEvent evt) {
	}

	public com.codename1.ui.events.ActionEvent fireEvent(com.codename1.rad.events.EventContext context) {
	}

	public com.codename1.ui.events.ActionEvent fireEvent(com.codename1.rad.models.Entity entity, com.codename1.ui.Component source) {
	}

	public com.codename1.ui.events.ActionEvent fireEvent(com.codename1.rad.models.Entity entity, com.codename1.ui.Component source, java.util.Map extraData) {
	}

	public String getLabelText() {
	}

	public String getLabelText(com.codename1.rad.models.Entity context) {
	}

	public com.codename1.ui.Component createView(com.codename1.rad.models.Entity entity) {
	}

	public com.codename1.ui.Command createCommand(com.codename1.rad.models.Entity entity, com.codename1.ui.Component source) {
	}

	public static class EnabledCondition {


		public EnabledCondition(com.codename1.rad.models.EntityTest value) {
		}
	}

	public static class Selected {


		public Selected(com.codename1.rad.models.Attribute[] atts) {
		}
	}

	public static class Disabled {


		public Disabled(com.codename1.rad.models.Attribute[] atts) {
		}
	}

	public static class Unselected {


		public Unselected(com.codename1.rad.models.Attribute[] atts) {
		}
	}

	public static class Pressed {


		public Pressed(com.codename1.rad.models.Attribute[] atts) {
		}
	}

	public static class Category {


		public Category(com.codename1.rad.models.Property.Name value) {
		}

		public Category() {
		}
	}

	public static class ActionNodeEvent {


		public ActionNodeEvent(com.codename1.rad.events.EventContext context) {
		}

		public ActionNode getAction() {
		}

		public com.codename1.rad.models.Entity getEntity() {
		}

		public com.codename1.rad.events.EventContext getContext() {
		}
	}
}
