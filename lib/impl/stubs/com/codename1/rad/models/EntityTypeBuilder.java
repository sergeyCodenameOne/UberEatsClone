/**
 *  This package contains classes for CodeRAD models, such as {@link Entity}, {@link Property}, and {@link Tag}.
 */
package com.codename1.rad.models;


/**
 *  A builder to help constructing EntityTypes  This provides, and possibly easier syntax
 *  alternative to creating EntityTypes as static internal classes of their associated Entity class.
 *  
 *  === Example
 *  
 *  [source,java]
 *  ----
 *  public static EntityType personType = new EntityTypeBuilder()
 *             .string(Person.name)
 *             .string(Person.email)
 *             .Date(Person.birthDate)
 *             .list(People.class, Person.children)
 *             .build();
 *    ----
 *  
 *  @author shannah
 */
public class EntityTypeBuilder {

	public EntityTypeBuilder() {
	}

	public EntityTypeBuilder entityClass(Class cls) {
	}

	public EntityTypeBuilder string(Attribute[] atts) {
	}

	public EntityTypeBuilder Double(Attribute[] atts) {
	}

	public EntityTypeBuilder Date(Attribute[] atts) {
	}

	public EntityTypeBuilder Integer(Attribute[] atts) {
	}

	public EntityTypeBuilder Boolean(Attribute[] atts) {
	}

	public EntityTypeBuilder list(Class listClass, Attribute[] atts) {
	}

	public EntityTypeBuilder entity(Class cls, Attribute[] atts) {
	}

	public EntityTypeBuilder object(Class cls, Attribute[] atts) {
	}

	public EntityTypeBuilder listType(Class listType) {
	}

	public EntityTypeBuilder rowType(Class rowType) {
	}

	public EntityTypeBuilder factory(EntityFactory factory) {
	}

	public EntityType build() {
	}

	public static EntityTypeBuilder entityTypeBuilder() {
	}

	public static EntityTypeBuilder entityTypeBuilder(Class cls) {
	}
}
