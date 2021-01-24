/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  An attribute whose sole purpose is to contain tags.  When tags are added to a {@link Property} or {@link FieldNode}, they are always wrapped inside a {@link Tags} attribute.
 *  @author shannah
 *  @see Tag
 *  @see EntityType#tags(com.codename1.rad.models.Tag...) 
 *  @see com.codename1.rad.ui.UI#tags(com.codename1.rad.models.Tag...) 
 */
public class Tags extends Attribute implements Iterable {

	public Tags(Tag[] value) {
	}

	@java.lang.Override
	public Tag[] getValue() {
	}

	public void addTags(Tag[] tags) {
	}

	@java.lang.Override
	public java.util.Iterator iterator() {
	}

	public boolean isEmpty() {
	}

	public boolean intersects(Tags tags) {
	}

	public boolean contains(Tag tag) {
	}

	public Tag[] toArray() {
	}
}
