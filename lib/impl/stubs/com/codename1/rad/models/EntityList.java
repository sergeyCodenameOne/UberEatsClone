/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  Encapsulates a list of entities. This list is observable, as it will fire {@link EntityListEvent} events when items are added 
 *  and removed from this list.
 *  @author shannah
 */
public class EntityList extends Entity implements Iterable {

	public EntityList(int maxLen) {
	}

	public EntityList(EntityType rowType, int maxLen) {
	}

	public EntityList(EntityType rowType, int maxLen, java.util.List internalList) {
	}

	public EntityList() {
	}

	/**
	 *  @return the rowType
	 */
	public EntityType getRowType() {
	}

	/**
	 *  @param rowType the rowType to set
	 */
	public void setRowType(EntityType rowType) {
	}

	/**
	 *  Starts a transaction to keep track of adds and removes so that listeners
	 *  can be notified in bulk.
	 */
	public void startTransaction() {
	}

	/**
	 *  Commits a transaction, and notifies listeners that the transaction is complete.
	 *  
	 */
	public void commitTransaction() {
	}

	protected void fireTransactionEvent(EntityList.TransactionEvent evt) {
	}

	/**
	 *  Can be overridden by subclasses to create an alternate collection type
	 *  for the entity list.  Default implementation uses an ArrayList.
	 *  @return 
	 */
	protected java.util.List createInternalList() {
	}

	/**
	 *  Triggers an {@link EntityListInvalidatedEvent} to listeners to instruct 
	 *  them that the list has changed in ways that cannot be reconstructed by
	 *  the typical Add/Remove events, and that views should resynchronize their
	 *  state with the list.
	 *  
	 *  This method should not be called inside a transaction.
	 *  @throws IllegalStateException if called inside a transaction.
	 */
	public void invalidate() {
	}

	@java.lang.Override
	public java.util.Iterator iterator() {
	}

	/**
	 *  Adds an item to the list.  This will trigger a {@link VetoableEntityAddedEvent} before the add, and a
	 *  {@link EntityAddedEvent} after the add.
	 *  @param link 
	 */
	public void add(Entity link) {
	}

	protected Entity beforeAdd(Entity link) {
	}

	protected Entity beforeRemove(Entity link) {
	}

	/**
	 *  Removes an item from the list.  This will trigger a {@link VetoableEntityRemovedEvent} before the removal, 
	 *  and a {@link EntityRemovedEvent} after the removal.
	 *  
	 *  @param link The item to add
	 *  @return True if the item was removed.  False if the item wasn't found or was not removed.
	 */
	public boolean remove(Entity link) {
	}

	/**
	 *  Removes all items from the list.  This will fire {@link VetoableEntityRemovedEvent} and {@link EntityRemovedEvent} events
	 *  before/after each item is removed.
	 */
	public void clear() {
	}

	/**
	 *  Returns the number of items in the list.
	 *  @return 
	 */
	public int size() {
	}

	/**
	 *  Gets item at index.
	 *  @param index The index of the item to get.
	 *  @return 
	 */
	public Entity get(int index) {
	}

	/**
	 *  Gets the current index of in the list of the given item.
	 */
	public int indexOf(Entity item) {
	}

	/**
	 *  Fires {@link EntityAddedEvent} event to listeners.  
	 *  @param e
	 *  @param index 
	 */
	protected void fireEntityAdded(Entity e, int index) {
	}

	/**
	 *  Fires {@link EntityRemovedEvent} to listeners.
	 *  @param e
	 *  @param index 
	 */
	protected void fireEntityRemoved(Entity e, int index) {
	}

	/**
	 *  Add listener to be notified of events on this list.  Listeners will be notified of
	 *  the following event types:
	 *  
	 *  . {@link EntityAddedEvent} - After an item is added.
	 *  . {@link EntityRemovedEvent} - After an item is removed.
	 *  . {@link VetoableEntityAddedEvent} - Before an item is added.
	 *  . {@link VetoableEntityRemovedEvent} - Before an item is removed.
	 *  . {@link TransactionEvent} - On {@link #startTransaction() } and {@link #commitTransaction() }.
	 *  
	 *  @param l 
	 *  @see #removeActionListener(com.codename1.ui.events.ActionListener) 
	 */
	public void addActionListener(com.codename1.ui.events.ActionListener l) {
	}

	/**
	 *  Removes listener.
	 *  
	 *  @param l 
	 *  @see #addActionListener(com.codename1.ui.events.ActionListener) 
	 */
	public void removeActionListener(com.codename1.ui.events.ActionListener l) {
	}

	public static class EntityListEvent {


		public EntityListEvent(EntityList source) {
		}

		public EntityList.TransactionEvent getTransaction() {
		}
	}

	/**
	 *  An event to encapsulate transactions on a list.  
	 *  
	 *  A transaction can be used to 
	 *  group together multiple add/remove events so that listeners can choose to handle
	 *  them in bulk. The {@link #startTransaction() } method can be used to start a 
	 *  transaction on a list.   It will fire the {@link TransactionEvent} to the listeners.  
	 *  The {@link #commitTransaction() } method can be used to end a transaction.  It will again
	 *  fire a {@link TransactionEvent} to the listeners.  Listeners can distinguish between
	 *  the start and end of a transaction using the {@link #isComplete() } method, which 
	 *  will return {@literal true} if the transaction has been completed.
	 *  
	 *  Listeners can check to see if an "add" or "remove" event was part of a transaction
	 *  using {@link EntityEvent#getTransaction() }.  If it finds that it is part of a transaction
	 *  the view may decide to wait until it receives the TransactionEvent before it responds to
	 *  the change.
	 *  
	 *  === Example
	 *  
	 *  [source,java]
	 *  ----
	 *  myEntityList.addActionListener(evt -> {
	 *      EntityAddedEvent addedEvent = evt.as(EntityAddedEvent.class);
	 *      if (addedEvent != null && addedEvent.getTransaction() == null) {
	 *          // This was an add event and NOT inside a transaction.
	 *          // Respond to this add directly.
	 *          Entity addedEntity = addedEvent.getEntity();
	 *          // .... etc...
	 *          return;
	 *      }
	 *      EntityRemovedEvent removedEvent = evt.as(EntityRemovedEvent.class);
	 *      if (removedEvent != null && removedEvent.getTransaction() == null) {
	 *          // This was an add event and NOT inside a transaction.
	 *          // Respond to this add directly.
	 *          Entity removedEntity = removedEvent.getEntity();
	 *          // .... etc...
	 *          return;
	 *      }
	 *      TransactionEvent transactionEvent = evt.as(TransactionEvent.class);
	 *      if (transactionEvent != null && transactionEvent.isComplete() && 
	 *              !transactionEvent.isEmpty()) {
	 *          // This event marked the end of a transaction.  Let's process
	 *          // all of the Add and Remove events in this transaction together
	 *          for (EntityEvent e : transactionEvent) {
	 *              addedEvent = e.as(EntityAddedEvent.class);
	 *              if (addedEvent != null) {
	 *                  // Process add event
	 *                  // ...
	 *                  continue;
	 *              }
	 *              removedEvent = e.as(EntityRemovedEvent.class);
	 *              if (removedEvent != null) {
	 *                  // Process remove event
	 *                  // ...
	 *                  continue;
	 *              }
	 *          }
	 *          return;
	 *      }
	 *              
	 *      
	 *  });
	 *  ----
	 *  
	 *  
	 */
	public static class TransactionEvent {


		/**
		 *  Creates a new TransactionEvent with the given EntityList source.  Generally you don't call this
		 *  method directly.  Start a transaction with {@link #startTransaction() }.  The TransactionEvent will
		 *  be delivered to listeners both on {@link #startTransaction() } and {@link #commitTransaction() }
		 *  @param source 
		 */
		public TransactionEvent(EntityList source) {
		}

		/**
		 *  Checks if this transaction has no add/remove events.
		 *  @return True if this transaction is empty.
		 */
		public boolean isEmpty() {
		}

		/**
		 *  Gets the number of add/remove events in this transaction.
		 *  @return 
		 */
		public int size() {
		}

		/**
		 *  Gets the add or remove event at the given index.
		 *  @param index The index of the add/remove event.
		 *  @return The event at the given index.  Either a {@link EntityAddedEvent} or {@link EntityRemovedEvent}
		 */
		public EntityList.EntityEvent get(int index) {
		}

		/**
		 *  Adds an event to the transaction.  Generally don't call this method directly.  The 
		 *  entity list will automatically add events to the current transaction as they happen.
		 *  @param evt 
		 */
		public void addEvent(EntityList.EntityEvent evt) {
		}

		/**
		 *  Removes an event from the transaction.  Generally don't call this method directly.
		 *  @param evt 
		 */
		public void removeEvent(EntityList.EntityEvent evt) {
		}

		/**
		 *  Checks if the transaction is complete.  A TransactionEvent is fired twice: once on {@link #startTransaction() } and
		 *  then again on {@link #commitTransaction() }.  {@link #isComplete() } will return {@literal false} in {@link #startTransaction() }
		 *  and {@literal true} in {@link #commitTransaction() }.
		 *  @return 
		 */
		public boolean isComplete() {
		}

		/**
		 *  Iterator to iterate over the add/remove events within this transaction.
		 *  @return 
		 */
		@java.lang.Override
		public java.util.Iterator iterator() {
		}
	}

	public static class EntityEvent {


		public EntityEvent(EntityList source, Entity entity, int index) {
		}

		public Entity getEntity() {
		}

		public int getIndex() {
		}

		/**
		 *  Sets the transaction that this event is part of.  Generally don't call this method directly. Use
		 *  {@link TransactionEvent#addEvent(com.codename1.rad.models.EntityList.EntityEvent) } instead.
		 *  @param transaction 
		 */
		public void setTransaction(EntityList.TransactionEvent transaction) {
		}

		/**
		 *  Gets the transaction that this event is part of, or {@literal null} if it is 
		 *  not part of a transaction.
		 *  @return 
		 */
		@java.lang.Override
		public EntityList.TransactionEvent getTransaction() {
		}
	}

	/**
	 *  A type of entity event which is fired *before* the add/remove occurs, and allows
	 *  the listener to veto/cancel the add/remove.
	 *  
	 *  This event type can be handy if you need to be notified of a change before it is made, if, for
	 *  example you need to know the state of the list before the change.  This is used by the {@link PropertySelector}
	 *  to detect when sub-properties may have been invalidated because a parent entity has been removed from a list.
	 */
	public static class VetoableEntityEvent {


		public VetoableEntityEvent(EntityList source, Entity entity, int index) {
		}

		/**
		 *  Veto the add/remove.
		 *  @param reason The reason for the veto.
		 */
		public void veto(String reason) {
		}

		/**
		 *  Checks if the add/remove has been vetoed.
		 */
		public boolean isVetoed() {
		}

		/**
		 *  Gets the reason for the veto, or null, if no veto was made.
		 *  @return 
		 */
		public String getReason() {
		}
	}

	/**
	 *  Event fired *before* an item is added to the list.
	 *  
	 *  @see EntityAddedEvent
	 */
	public static class VetoableEntityAddedEvent {


		public VetoableEntityAddedEvent(EntityList source, Entity entity, int index) {
		}
	}

	/**
	 *  Event fired *before* an item is removed from the list.
	 *  
	 *  @see EntityRemovedEvent
	 */
	public static class VetoableEntityRemovedEvent {


		public VetoableEntityRemovedEvent(EntityList source, Entity entity, int index) {
		}
	}

	/**
	 *  Event fired *after* an item is added to the list.
	 *  @see VetoableEntityAddedEvent
	 *  @see TransactionEvent For handling bulk-add events.
	 */
	public static class EntityAddedEvent {


		public EntityAddedEvent(EntityList source, Entity entity, int index) {
		}
	}

	/**
	 *  Event fired *after* an item is removed from the list.
	 *  @see VetoableEntityRemovedEvent
	 *  @see TransactionEvent For handling bulk-remove events.
	 */
	public static class EntityRemovedEvent {


		public EntityRemovedEvent(EntityList source, Entity entity, int index) {
		}
	}

	/**
	 *  An event that is fired when the statue of the list has changed in ways
	 *  that cannot be synchronized using Add/Remove events.  Listeners should 
	 *  resynchronize their state with the state of the list.
	 */
	public static class EntityListInvalidatedEvent {


		public EntityListInvalidatedEvent(EntityList source) {
		}
	}

	/**
	 *  Exception thrown if a veto listener vetos and add/remove.
	 */
	public static class VetoException {


		public VetoException(EntityList.VetoableEntityEvent evt) {
		}

		public EntityList.VetoableEntityEvent getVetoableEntityEvent() {
		}
	}
}
