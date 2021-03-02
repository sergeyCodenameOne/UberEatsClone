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
 *  Encapsulates a section of a Form.  {@link FormNodes} can contain multiple sections ({@link SectionNode}).
 *  
 *  == Supported Attributes
 *  
 *  . {@link Label} - A label/heading for the section.
 *  . {@link Description} - A description for the section.  Will be rendered in a {@link HelpButton}.
 *  . {@link Columns} - The number of columns in this section.
 *  . {@link FieldNode} - Can contain multiple fields.  These are the fields that should be rendered as a part of this section.
 *  . {@link ActionsNode} - Can contain multiple {@link ActionsNode} nodes to inject buttons and menus in various positions of the section.
 *  .. Categories include {@link com.codename1.rad.ui.ActionCategories#OVERFLOW_MENU}, {@link com.codename1.rad.ui.ActionCategories#TOP_LEFT_MENU}, {@link com.codename1.rad.ui.ActionCategories#TOP_RIGHT_MENU},
 *  {@link com.codename1.rad.ui.ActionCategories#BOTTOM_LEFT_MENU}, {@link com.codename1.rad.ui.ActionCategories#BOTTOM_RIGHT_MENU}.
 *  
 *  @see com.codename1.rad.ui.UI#section(com.codename1.rad.models.Attribute...) 
 *  
 *  
 *  @author shannah
 */
public class SectionNode extends Node implements Iterable {

	public SectionNode(com.codename1.rad.models.Attribute[] atts) {
	}

	@java.lang.Override
	public java.util.Iterator iterator() {
	}

	public void setAttributes(com.codename1.rad.models.Attribute[] atts) {
	}

	public com.codename1.rad.models.Property.Label getLabel() {
	}

	public com.codename1.rad.models.Property.Description getDescription() {
	}

	public com.codename1.rad.attributes.Columns getColumns() {
	}

	public class Fields {


		public Fields() {
		}

		@java.lang.Override
		public java.util.Iterator iterator() {
		}

		public void add(FieldNode node) {
		}
	}
}
