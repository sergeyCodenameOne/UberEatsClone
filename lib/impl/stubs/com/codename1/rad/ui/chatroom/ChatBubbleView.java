package com.codename1.rad.ui.chatroom;


/**
 *  A view for a single row/chat bubble in a Chat view.  This view is used to render rows for the {@link ChatRoomView}
 *  view.
 *  
 *  <h3>View Model Requirements</h3>
 *  
 *  <p>See {@link ViewModel} for a reference view model for use in this view.  However, you don't need to use this class.  Any 
 *  entity that implements the required properties will do.</p>
 *  
 *  <p><strong>Properties:</strong></p>
 *  
 *  <ul>
 *   <li><strong>{@link ChatMessage#text}</strong> - Required.  The text to appear in the chat bubble.</li>
 *   <li><strong>{@link ChatMessage#creator}</strong> - Optional.  The name of the person who sent the chat message.</li>
 *   <li><strong>{@link ChatMessage#thumbnailUrl}</strong> or {@link ListRowItem#icon} - Optional.  The icon or URL to 
 *      the user's avatar who posted the message.
 *   </li>
 *   <li><strong>{@link ChatMessage#datePublished}</strong> - Optional. The date-time the message was posted.</li>
 *   <li><strong>{@link ChatMessage#isOwnMessage}</strong> - Optional.  Boolean flag indicating that the message was posted by the current user.  
 *       If this isn't present, it will use an empty {@link ChatMessage#creator} field to imply "true" on this field.
 *  </li>
 *  
 *  </ul>
 *  
 *  <h3>Supported Actions</h3>
 *  
 *  <p>This view supports the following actions:</p>
 *  
 *  <ul>
 *   <li>{@link #CHAT_BUBBLE_CLICKED}</li>
 *   <li>{@link #CHAT_BUBBLE_LONG_PRESS}</li>
 *   <li>{@link #CHAT_BUBBLE_CLICKED_MENU}</li>
 *   <li>{@link #CHAT_BUBBLE_LONG_PRESS_MENU}</li>
 *   <li>{@link #CHAT_BUBBLE_BADGES}</li>
 *  </ul>
 *  
 *  <p>In addition to these actions, the poster's "icon" or thumbnail URL is rendered by the {@link ProfileAvatarView} view
 *  which supports several actions as well.  Actions defined on this chat bubble's view node will be accessible to the 
 *  embedded {@link ProfileAvatarView}.</p>
 *  
 *  
 *  
 *  
 *  @author shannah
 */
public class ChatBubbleView extends com.codename1.rad.ui.AbstractEntityView {

	/**
	 *  Actions displayed in popup menu when user long presses a chat bubble.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category CHAT_BUBBLE_LONG_PRESS_MENU;

	/**
	 *  Actions displayed in popup menu when user clicks chat bubble.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category CHAT_BUBBLE_CLICKED_MENU;

	/**
	 *  Action fired when user clicks chat bubble.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category CHAT_BUBBLE_CLICKED;

	/**
	 *  Action fired when user longpresses chat bubble.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category CHAT_BUBBLE_LONG_PRESS;

	/**
	 *  Actions displayed as "badges" of a chat bubble.
	 */
	public static final com.codename1.rad.nodes.ActionNode.Category CHAT_BUBBLE_BADGES;

	public static final com.codename1.rad.models.Tag TEXT;

	public static final com.codename1.rad.models.Tag icon;

	/**
	 *  View property that can be used to indicate that the chat room should use or not
	 *  use an overflow container for the time of a text.
	 */
	public static final com.codename1.rad.ui.ViewProperty USE_OVERFLOW_CONTAINER;

	/**
	 *  Creates a new chat bubble view for the given entity.
	 *  @param entity The view model.  See {@link ViewModel} for a reference view model, but custom classes will work fine.  The view expects properties with tags {@link ChatMessage#text},
	 *  {@link ListRowItem#icon} (or {@link ChatMessage#thumbnailUrl}, {@link ChatMessage#datePublished}, {@link ChatMessage#isOwnMessage}, {@link ChatMessage#typingInProgress},
	 *  and {@link ChatMessage#creator}.  However, if a property is missing, it will generally fall-back sensibly, just omitting that information.  The only critical
	 *  property is {@link ChatMessage#text} which is used as the text of the chat bubble.
	 *  @param viewNode The view descriptor. Used to pass view parameters, actions, and other view settings.
	 */
	public ChatBubbleView(com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.Node viewNode) {
	}

	@java.lang.Override
	protected void initComponent() {
	}

	@java.lang.Override
	protected void deinitialize() {
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
	 *  A list cell renderer for creating a row of {@link ChatBubbleView} inside an {@link EntityListView}.
	 */
	public static class ChatBubbleListCellRenderer {


		public ChatBubbleListCellRenderer() {
		}

		@java.lang.Override
		public com.codename1.rad.ui.EntityView getListCellRendererComponent(com.codename1.rad.ui.entityviews.EntityListView list, com.codename1.rad.models.Entity value, int index, boolean isSelected, boolean isFocused) {
		}
	}

	/**
	 *  This is a view model class that *may* be used as a model for the ChatBubbleView, as it 
	 *  defines properties with all of the required tags.  You can also use your own entity
	 *  for a view model as long as the entity contains properties with the given tags.  E.g.
	 *  You can use any entity as long as it includes at least a property with the {@link #messageTextTag} tag, which
	 *  is the same as {@link Comment#text}.
	 *  
	 *  <p>Note: If you use a custom view model, you needn't use the same content types for your properties.  E.g.
	 *  this sample view model's iconTag is a string URL.  But you could just as easily use an image property,
	 *  and the view will handle it properly.
	 *  
	 */
	public static class ViewModel {


		/**
		 *  Tag used for the date field.
		 */
		public static final com.codename1.rad.models.Tag dateTag;

		/**
		 *  Tag used for the "own" flag of a chat message to indicate that
		 *  the message originated from the current user, and not another user.  This flag
		 *  is used to determine which side (left or right) of the view the chat bubble
		 *  is displayed on.
		 *  
		 *  <p>If the view model entity does not contain a property with this tag, then it will
		 *  be inferred by the ChatBubbleView based on whether the "postedBy" property is empty.</p>
		 *  
		 *  @see ChatMessage#isOwnMessage
		 */
		public static final com.codename1.rad.models.Tag isOwnTag;

		/**
		 *  Tag used for boolean property which marks a chat message as a "favourite".
		 *  @see ChatMessage#isFavorite
		 */
		public static final com.codename1.rad.models.Tag isFavorite;

		/**
		 *  Tag used for the "icon" property of a chat message.  The field may be any content
		 *  type that can be converted to an {@link AsyncImage}.  This includes a string (with a URL,
		 *  fiile path, resource path, or storage key), or any other content type that can convert
		 *  to AsyncImage.
		 *  @see Comment#thumbnailUrl
		 */
		public static final com.codename1.rad.models.Tag iconTag;

		/**
		 *  Tag used for the 'posted by' property of a chat message.  This reference implementation
		 *  uses a String property for this, but you could just as well use an Entity content type
		 *  to store an actual entity of a user.
		 *  @see Comment#creator
		 */
		public static final com.codename1.rad.models.Tag postedByTag;

		/**
		 *  Tag used for the message text property of a chat message.  This is the only *required*
		 *  tag for an entity to be usable as a model for a ChatBubbleView.
		 *  
		 *  @see Comment#text
		 */
		public static final com.codename1.rad.models.Tag messageTextTag;

		/**
		 *  Tag used for boolean property that indicates typing is still in progress for a chat message.
		 *  
		 *  @see ChatMessage#typingInProgress
		 */
		public static final com.codename1.rad.models.Tag typingInProgressTag;

		public static final com.codename1.rad.models.Tag attachmentPlaceholder;

		public static com.codename1.rad.models.StringProperty postedBy;

		public static com.codename1.rad.models.StringProperty iconUrl;

		public static com.codename1.rad.models.StringProperty messageText;

		public static com.codename1.rad.models.StringProperty attachmentImageUrl;

		public static com.codename1.rad.models.BooleanProperty own;

		public static com.codename1.rad.models.BooleanProperty favorite;

		public static com.codename1.rad.models.BooleanProperty typingInProgress;

		public static com.codename1.rad.models.DateProperty date;

		public ViewModel() {
		}

		public ChatBubbleView.ViewModel postedBy(String username) {
		}

		public ChatBubbleView.ViewModel iconUrl(String url) {
		}

		public ChatBubbleView.ViewModel date(java.util.Date d) {
		}

		public ChatBubbleView.ViewModel messageText(String text) {
		}

		public ChatBubbleView.ViewModel isOwn(boolean o) {
		}

		public ChatBubbleView.ViewModel isFavorite(boolean o) {
		}

		public Boolean isTypingInProgress() {
		}

		public ChatBubbleView.ViewModel typingInProgress(boolean inProgress) {
		}

		public ChatBubbleView.ViewModel attachmentImageUrl(String imageUrl) {
		}

		public String getPostedBy() {
		}

		public String getIconUrl() {
		}

		public java.util.Date getDate() {
		}

		public Boolean isOwn() {
		}

		public Boolean isFavorite() {
		}

		public String getMessageText() {
		}

		public String getAttachmentImageUrl() {
		}
	}
}
