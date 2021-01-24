package com.codename1.rad.ui.chatroom;


/**
 *  A view that provides a fully-functional user interface for a multi-user chat.
 *  @author shannah
 */
public class ChatRoomView extends com.codename1.rad.ui.AbstractEntityView {

	public static final com.codename1.rad.nodes.ActionNode.Category TEXT_ACTIONS;

	/**
	 *  Category used to register an action to be fired when the user hits "send".
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category SEND_ACTION;

	/**
	 *  Creates a chat room with the settings specified by the given node.  This will create
	 *  a new view model of type {@link ViewModel}.
	 *  @param node UI node descriptor.  This node can be used to add actions to the chat room.
	 */
	public ChatRoomView(com.codename1.rad.nodes.Node node, com.codename1.ui.Form form) {
	}

	/**
	 *  Creates a chat room view with a default view model of type {@link ViewModel}, and an empty
	 *  Node with no actions.
	 */
	public ChatRoomView(com.codename1.ui.Form form) {
	}

	/**
	 *  Creates a chat room view with the provided entity as the view model.  The view model can be any entity
	 *  with properties tagged with {@link ViewModel#messagesTag} and {@link ViewModel#inputBufferTag}.  See
	 *  {@link ViewModel} for a reference implementation and instructions on using custom entities
	 *  for a view model.
	 *  @param entity 
	 */
	public ChatRoomView(com.codename1.rad.models.Entity entity, com.codename1.ui.Form form) {
	}

	/**
	 *  Creates a new ChatRoomView with the given view model (entity) and node description.
	 *  @param entity The entity to use as the view model. The view model can be any entity
	 *  with properties tagged with {@link ViewModel#messagesTag} and {@link ViewModel#inputBufferTag}.  See
	 *  {@link ViewModel} for a reference implementation and instructions on using custom entities
	 *  for a view model.
	 *  @param node The Node used as the UI descriptor for the chat room.  Set things like actions on this node.
	 */
	public ChatRoomView(com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.Node node, com.codename1.ui.Form form) {
	}

	/**
	 *  Returns the ChatBubbleView that corresponds with the given message entity.
	 *  @param message
	 *  @return 
	 */
	public ChatBubbleView getChatBubbleView(com.codename1.rad.models.Entity message) {
	}

	/**
	 *  Scrolls the chat view to the given message.
	 *  @param message The message entity to scroll to.
	 */
	public void scrollToMessage(com.codename1.rad.models.Entity message) {
	}

	@java.lang.Override
	public void bind() {
	}

	@java.lang.Override
	public void update() {
	}

	@java.lang.Override
	public void commit() {
	}

	@java.lang.Override
	public com.codename1.rad.nodes.Node getViewNode() {
	}

	/**
	 *  A factory that can be added to a view node to "turn" it into a ChatRoomView.
	 */
	public static class ChatRoomViewFactory {


		public ChatRoomViewFactory() {
		}

		@java.lang.Override
		public com.codename1.rad.ui.EntityView createView(com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.ViewNode node) {
		}
	}

	/**
	 *  A reference view model for the ChatRoomView.  You do NOT need to use this class
	 *  for your view model as long as your own view model includes at least properties
	 *  with the {@link #messagesTag} and {@link #inputBufferTag}.
	 */
	public static class ViewModel {


		/**
		 *  InputBuffer property, which is bound to the text field for entering
		 *  messages.  
		 *  @see #inputBufferTag
		 */
		public static com.codename1.rad.models.StringProperty inputBuffer;

		/**
		 *  Messages property, which contains a list of chat messages to display
		 *  in the chat room.  See {@link ChatBubbleView.ViewModel} for a reference
		 *  implementation of an entity that can be used as the model for a chat message,
		 *  and description of which tags a custom entity must implement to be used
		 *  as a chat message view model.
		 *  
		 *  @see #messagesTag
		 *  @see ChatBubbleView.ViewModel
		 */
		public static com.codename1.rad.models.ListProperty messages;

		/**
		 *  Participants property, which contains a list of participants in this chat room.
		 *  Individual participants can be any entity type that implements the {@link Thing#name}
		 *  tag.
		 */
		public static com.codename1.rad.models.ListProperty participants;

		/**
		 *  Tag used to mark the "input buffer" property on an entity.  This is the one
		 *  *required* tag for an entity that you want to use as a view model for a
		 *  ChatRoomView.
		 */
		public static final com.codename1.rad.models.Tag inputBufferTag;

		/**
		 *  Tag used to mark the "participants" property of an entity.  This is an optional
		 *  tag.  If present, the ChatRoomView will be able to display avatars of the chatroom's
		 *  participants in the header.
		 */
		public static final com.codename1.rad.models.Tag participantsTag;

		/**
		 *  Tag used to mark the "messages" property of an entity.  This is a required
		 *  tag, and the property that is tagged with this should be an entity list
		 *  containing "chat message" entities.  See {@link ChatBubbleView.ViewModel} for a 
		 *  reference implementation of a chat message entity, and instructions on using 
		 *  your own custom entities for chat messages.
		 */
		public static final com.codename1.rad.models.Tag messagesTag;

		public ViewModel() {
		}

		/**
		 *  Sets the contents of the input buffer property.  The input buffer property
		 *  is bound to the text field that allows the user to enter text messages.
		 *  @param string
		 *  @return 
		 */
		public ChatRoomView.ViewModel inputBuffer(String string) {
		}

		/**
		 *  Adds chat messages to the chat room.  
		 *  @param entities "Chat message" entities to add.  See {@link ChatBubbleView.ViewModel} for a 
		 *  reference implementation of a "chat message" entity, and instructions on using custom entities
		 *  as "chat messages".
		 *  @return Self for chaining.
		 */
		public ChatRoomView.ViewModel addMessages(com.codename1.rad.models.Entity[] entities) {
		}

		/**
		 *  Removes chat messages from the chat room.
		 *  @param entities "Chat message" entities to add.  See {@link ChatBubbleView.ViewModel} for a 
		 *  reference implementation of a "chat message" entity, and instructions on using custom entities
		 *  as "chat messages".
		 *  @return 
		 */
		public ChatRoomView.ViewModel removeMessages(com.codename1.rad.models.Entity[] entities) {
		}

		/**
		 *  Adds participants to the chat room.  Individual participants can be any entity type that implements the {@link Thing#name}
		 *  tag.
		 *  @param entities Participants to add.  These can be any entity with a property tagged with {@link Thing#name}.
		 *  @return 
		 */
		public ChatRoomView.ViewModel addParticipants(com.codename1.rad.models.Entity[] entities) {
		}

		public ChatRoomView.ViewModel removeParticipants(com.codename1.rad.models.Entity[] entities) {
		}

		/**
		 *  Gets the input buffer string.
		 *  @return 
		 */
		public String getInputBuffer() {
		}

		/**
		 *  Gets the participants. Individual participants can be any entity type that implements the {@link Thing#name}
		 *  tag.
		 *  @return 
		 */
		public ChatRoomView.ViewModel.Participants getParticipants() {
		}

		/**
		 *  Gets the chat messages in this room.  See {@link ChatBubbleView.ViewModel} for a 
		 *  reference implementation of a "chat message" entity, and instructions on using custom entities
		 *  as "chat messages".
		 *  @return 
		 */
		public ChatRoomView.ViewModel.ChatMessages getMessages() {
		}

		/**
		 *  A list of chat messages
		 */
		public static class ChatMessages {


			public ChatMessages() {
			}
		}

		/**
		 *  A list of participants in a chat room.
		 */
		public static class Participants {


			public Participants() {
			}
		}
	}
}
