/**
 *  This package contains {@link Attribute} classes for use in UI descriptors.
 *  
 */
package com.codename1.rad.attributes;


/**
 *  An attribute for assigning a {@link NodeDecorator} to node.  This can be added to any {@link Node}, and will run the decorator on the node
 *  in its constructor after all of the attributes have been added.  Decorators are a handy way to package up complex node settings and apply
 *  them to a node with one big "stamp".
 *  @author shannah
 *  @see com.codename1.rad.ui.UI#decorator(com.codename1.rad.ui.NodeDecorator) 
 */
public class NodeDecoratorAttribute extends com.codename1.rad.models.Attribute {

	public NodeDecoratorAttribute(com.codename1.rad.ui.NodeDecorator value) {
	}
}
