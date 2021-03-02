/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  A complex selection in a {@link Table} or List.  A complex selection is one that consists of 
 *  one or more sub-selections.
 *  @author shannah
 */
public class ComplexSelection extends Selection implements Iterable {

	public ComplexSelection() {
	}

	@java.lang.Override
	public int getFirstRow() {
	}

	@java.lang.Override
	public int getLastRow() {
	}

	@java.lang.Override
	public int getFirstColumn() {
	}

	@java.lang.Override
	public int getLastColumn() {
	}

	public void add(Selection sel) {
	}

	public void remove(Selection sel) {
	}

	public void replace(Selection sel) {
	}

	public void clear() {
	}

	@java.lang.Override
	public java.util.Iterator iterator() {
	}

	@java.lang.Override
	public boolean isSelected(int row, int column) {
	}

	@java.lang.Override
	public boolean equals(Object obj) {
	}

	@java.lang.Override
	public int hashCode() {
	}
}
