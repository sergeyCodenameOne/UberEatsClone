/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  Encapsulates the selection of a list or table.
 *  @author shannah
 */
public class Selection {

	protected com.codename1.ui.util.EventDispatcher listeners;

	public Selection() {
	}

	public Selection(int firstRow, int lastRow, int firstColumn, int lastColumn) {
	}

	public int getFirstRow() {
	}

	public int getLastRow() {
	}

	public int getFirstColumn() {
	}

	public int getLastColumn() {
	}

	public boolean isSelected(int row, int column) {
	}

	public void addSelectionListener(com.codename1.ui.events.ActionListener l) {
	}

	public void removeSelectionListener(com.codename1.ui.events.ActionListener l) {
	}

	@java.lang.Override
	public boolean equals(Object obj) {
	}

	@java.lang.Override
	public int hashCode() {
	}

	public static class SelectionEvent {


		public static final int ADD = 1;

		public static final int REMOVE = 2;

		public SelectionEvent(Selection source, Selection selection, int type) {
		}

		public Selection getSelection() {
		}

		public int getType() {
		}
	}
}
