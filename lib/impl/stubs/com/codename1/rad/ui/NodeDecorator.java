/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  A decorator that can be added to a node via {@link NodeDecoratorAttribute} which 
 *  will be run just after the node is added to its parent.
 *  
 *   = Example
 *  
 *  The following code snippet shows the use of a list node to render a contact list.
 *  
 *  [source,java]
 *  ----
 *  package com.codename1.demos.ddddemo;
 * 
 * 
 * import com.codename1.rad.ui.UI;
 * import static com.codename1.rad.ui.UI.action;
 * import static com.codename1.rad.ui.UI.icon;
 * import com.codename1.rad.ui.decorators.ContactListDecorator;
 * import com.codename1.rad.nodes.ActionNode;
 * import static com.codename1.rad.models.EntityType.description;
 * import static com.codename1.rad.models.EntityType.label;
 * import com.codename1.ui.FontImage;
 * import static com.codename1.ui.FontImage.MATERIAL_DELETE;
 * 
 * 
 * 
 * public class ContactList extends UI {
 *     // ... define some actions
 *     form(
 *         list(
 *             rowTemplate(
 *                 actions(LEFT_SWIPE_MENU, chat2) <1>
 *             ),
 *             decorator(new ContactListDecorator()) <2>
 *         )
 *     );
 * }}
 *  ----
 *  <1> Add an action "chat2" (which was defined elsewhere in this example), to the {@link com.codename1.rad.ui.ActionCategories#LEFT_SWIPE_MENU} category which
 *  is rendered in the left side of a {@link SwipeContainer}.
 *  <2> This makes use of the {@link com.codename1.rad.ui.decorators.ContactListDecorator} attribute which applies the custom renderer to the list to create the contact list look.
 *  
 *  And the result is
 *  
 *  image::../nodes/doc-files/ContactList.png[]
 *  
 *  In this example, a lot of the magic is hidden in the ContactListDecorator as it adds some extra attributes to get the desired effect here.  It is quite a simple decorator though, so
 *  it can be instructive to look at the source to see what it does:
 *  
 *  [source,java]
 *  ----
 * package com.codename1.rad.ui.decorators;
 * 
 * import com.codename1.rad.ui.ActionCategories;
 * import com.codename1.rad.ui.ActionStyle;
 * import com.codename1.rad.ui.Actions;
 * import com.codename1.rad.ui.NodeDecorator;
 * import com.codename1.rad.ui.UI;
 * import static com.codename1.rad.ui.UI.iconRenderer;
 * import com.codename1.rad.attributes.UIID;
 * import com.codename1.rad.models.Tag;
 * import com.codename1.rad.ui.entityviews.MultiButtonEntityView;
 * import com.codename1.rad.ui.image.FirstCharEntityImageRenderer;
 * import com.codename1.rad.nodes.ActionNode;
 * import com.codename1.rad.nodes.ActionsNode;
 * import com.codename1.rad.nodes.ListNode;
 * import com.codename1.rad.nodes.Node;
 * import com.codename1.rad.schemas.ListRowItem;
 * import com.codename1.rad.schemas.Thing;
 * 
 * /**
 *  A decorator that can be used with a {@link ListNode} to style it like a Contact list.
 *  @author shannah
 * {slash}
 * public class ContactListDecorator implements NodeDecorator, ActionCategories {
 *     
 *     
 *     @Override
 *     public void decorate(Node node) {
 *         if (!(node instanceof ListNode)) {
 *             return;
 *         }
 *         ListNode listNode = (ListNode)node;
 *         Node rowTemplate = listNode.getRowTemplate();
 *         rowTemplate.setAttributes(UI.param(MultiButtonEntityView.LINE1_UIID, "ContactListLine1")); <1>
 *         rowTemplate.setAttributes(UI.param(MultiButtonEntityView.LINE2_UIID, "ContactListLine2")); <2>
 *         for (ActionNode n : rowTemplate.getActions(ActionCategories.LEFT_SWIPE_MENU)) {
 *             n.setAttributes(UI.actionStyle(ActionStyle.IconOnly));
 *             n.setAttributes(new UIID("SwipeableContainerButton"));
 *         }
 *         ActionNode removeAction = listNode.getAction(ActionCategories.LIST_REMOVE_ACTION);
 *         if (removeAction != null) {
 *             removeAction.setAttributes(UI.actionStyle(ActionStyle.IconOnly));
 *             removeAction.setAttributes(new UIID("SwipeableContainerButton"));
 *         }
 * 
 *         
 *         
 *         //swipeLeftNode.setAttributes(LEFT_SWIPE_MENU);
 *         //listNode.getRowTemplate().setAttributes(swipeLeftNode);
 *         node.setAttributes(iconRenderer(new FirstCharEntityImageRenderer(10))); <3>
 *         node.setAttributes(UI.param(MultiButtonEntityView.ICON, Thing.name)); <4>
 *         
 *     }
 * 
 *     
 * }
 * 
 * ----
 *  <1> We set a view parameter {@link com.codename1.rad.ui.entityviews.MultiButtonEntityView#LINE1_UIID} which overrides the UIID of line 1 of the {@link com.codename1.rad.ui.entityviews.MultiButtonEntityView} that renders each row
 *  This applies a style from the CodeRAD stylesheet.
 *  <2> We also override the UIID of line 2 of the MultieButtonEntityView.
 *  <3> We set the icon renderer to {@link FirstCharEntityImageRenderer} which renders the first letter of the row entity's name in a nice circle.
 *  <4> We override the field of the entity that is used for icon rendering, so that it will take the first name of the {@link Thing#name} field instead of the icon field, which
 *  would be the default field.
 *  
 *  NOTE: {@link NodeDecorator} attributes are executed after all other attributes have been added to a node.  It can be used to change the attributes and child nodes of the node.  
 *  
 *  
 *  @author shannah
 *  @see UI#decorator(com.codename1.rad.ui.NodeDecorator) 
 */
public interface NodeDecorator {

	public void decorate(com.codename1.rad.nodes.Node node);
}
