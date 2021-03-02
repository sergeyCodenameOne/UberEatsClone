package com.codename1.rad.io;


/**
 *  A class that can parse XML or JSON data structures into Entity objects.
 *  
 *  === Example 1:
 *  
 *  [source,java]
 *  ----
 *  
 *    public static final Tag publications = new Tag("Publications");
 *         
 *         public static EntityType personType = new EntityTypeBuilder()
 *             .string(Person.name)
 *             .string(Person.email)
 *             .Date(Person.birthDate)
 *             .list(People.class, Person.children)
 *             .list(Publications.class, publications)
 *             .build();
 *         
 *         public static EntityType publicationType = new EntityTypeBuilder()
 *                 .string(Thing.name)
 *                 .string(Thing.description)
 *                 .build();
 *         
 *         
 *         public static class PersonModel extends Entity {
 *             
 *             {
 *                 setEntityType(personType);
 *             }
 *         }
 *         
 *         
 *         public static class People extends EntityList<PersonModel> {
 *             {
 *                 setRowType(personType);
 *             }
 *         }
 *         
 *         public static class PublicationModel extends Entity {
 *             {
 *                 setEntityType(publicationType);
 *             }
 *         }
 *         
 *         public static class Publications extends EntityList<PublicationModel> {
 *             {
 *                 setRowType(publicationType);
 *             }
 *         }
 *         
 *         static {
 *             new PersonModel();
 *             new PublicationModel();
 *         }
 *         ...
 *  
 *   private void nestedXMLAttsTest() throws Exception {
 *         
 *         assertTrue(personType.newInstance() instanceof PersonModel, "persontype should create a Person, but created "+personType.newInstance());
 *         
 *         ResultParser parser = new ResultParser(personType)
 *                 .property("@name", Person.name)
 *                 .property("@email", Person.email)
 *                 .property("@dob", Person.birthDate, new SimpleDateFormat("MMM d, yyyy"))
 *                 .property("./children/person", Person.children)
 *                 .property("./publication", publications)
 *                 ;
 *         
 *         ResultParser publicationParser = new ResultParser(publicationType)
 *                 .property("@name", Thing.name)
 *                 .property(".", Thing.description);
 *         parser.add(publicationParser);
 *         
 *         String json = "<person name=\"Paul\" email=\"paul@example.com\" dob=\"December 27, 1978\">"
 *                 + "<children><person name=\"Jim\" email=\"jim@example.com\" dob=\"January 10, 1979\"/>"
 *                 + "<person name=\"Jill\" email=\"jill@example.com\" dob=\"January 11, 1979\"/></children><publication name=\"Time Magazine\">Political and current event stories</publication>"
 *                 + "<publication name=\"Vancouver Sun\"/></person>";
 *         XMLParser xparser = new XMLParser();
 *         Element root = xparser.parse(new StringReader("<?xml version='1.0'?>\n"+json));
 *         Entity person = parser.parseRow(Result.fromContent(root), personType.newInstance());
 *         assertEqual("Paul", person.getText(Person.name));
 *         assertEqual("paul@example.com", person.getText(Person.email));
 *         
 *         People children = (People)person.get(Person.children);
 *         assertEqual(2, children.size());
 *         assertEqual("Jim", children.get(0).get(Person.name));
 *         assertEqual("jim@example.com", children.get(0).get(Person.email));
 *         assertEqual("Jill", children.get(1).get(Person.name));
 *         assertEqual("jill@example.com", children.get(1).get(Person.email));
 *         
 *         Publications pubs = (Publications)person.get(publications);
 *         assertEqual(2, pubs.size());
 *         assertEqual("Time Magazine", pubs.get(0).get(Thing.name));
 *         assertEqual("Vancouver Sun", pubs.get(1).get(Thing.name));
 *         assertEqual("Political and current event stories", pubs.get(0).get(Thing.description));
 *         
 *     }
 *     ----
 *  
 *  @author shannah
 */
public class ResultParser implements com.codename1.rad.models.EntityFactory {

	/**
	 *  Creates a new ResultParser for the given entity type.
	 *  @param type The entity type that this parser can parse to.
	 */
	public ResultParser(com.codename1.rad.models.EntityType type) {
	}

	/**
	 *  Gets the root parser of this parser group.  Multiple parsers can be grouped togther so that XML or JSON structures
	 *  which include more than one type of entity can all be parsed with one parser group.  Parsers are grouped together using the 
	 *  {@link #add(com.codename1.rad.io.ResultParser...) } method, but the "first" parser in a group is always considered to 
	 *  be the root parser.
	 *  
	 *  If you call {@link #add(com.codename1.rad.io.ResultParser...) } on a child parser of the group, it will actually add the
	 *  parser to the root parser, so that the parser group forms a single level tree with a root and a number of leaves.
	 *  
	 *  @return The root result parser in the group.
	 */
	public ResultParser getRootParser() {
	}

	/**
	 *  Adds parsers to the parser group  Parsers can be grouped together so that XML/JSON documents that contain more than
	 *  one type of entity can be parsed correctly.
	 *  @param parsers The The parsers to add.
	 *  @return Self for chaining.
	 */
	public ResultParser add(ResultParser[] parsers) {
	}

	/**
	 *  Gets the parser that is registered for the given entity type.  Each parser can only be registered for a single entity type, but
	 *  parsers can be grouped together using {@link #add(com.codename1.rad.io.ResultParser...) }.  
	 *  @param type The entity type to retrieve a parser for.
	 *  @return The corresponding parser, or null if none could be found.
	 */
	public ResultParser getParserFor(com.codename1.rad.models.EntityType type) {
	}

	@java.lang.Override
	public com.codename1.rad.models.Entity createEntity(Class type) {
	}

	/**
	 *  Add support for parsing a particular property.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param getter The getter to use for "Getting" the property.
	 *  @param property The property to bind to.
	 *  @param parserCallback A callback to use for parsing the property.
	 *  @return Self for chaining.
	 */
	public ResultParser property(String resultPropertySelector, ResultParser.Getter getter, com.codename1.rad.models.Property property, ResultParser.PropertyParserCallback parserCallback) {
	}

	/**
	 *  Add support for parsing a particular property.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param property The property to bind to.
	 *  @param parserCallback A callback to use for parsing the property.
	 *  @return Self for chaining.
	 */
	public ResultParser property(String resultPropertySelector, com.codename1.rad.models.Property property, ResultParser.PropertyParserCallback parserCallback) {
	}

	/**
	 *  Add support for parsing a particular property.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param getter The getter to use for "Getting" the property.
	 *  @param property The property to bind to.
	 *  @return Self for chaining.
	 */
	public ResultParser property(String resultPropertySelector, ResultParser.Getter getter, com.codename1.rad.models.Property property) {
	}

	/**
	 *  Add support for parsing a particular property.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param property The property to bind to.
	 *  @return Self for chaining.
	 */
	public ResultParser property(String resultPropertySelector, com.codename1.rad.models.Property property) {
	}

	/**
	 *  Add support for parsing a particular property.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param parserCallback A callback to use for parsing the property.
	 *  @param tags Tags for resolving the property to bind to.
	 *  @return Self for chaining.
	 */
	public ResultParser property(String resultPropertySelector, ResultParser.PropertyParserCallback parserCallback, com.codename1.rad.models.Tag[] tags) {
	}

	/**
	 *  Add support for parsing a particular property.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tags Tags for resolving the property to bind to.
	 *  @return Self for chaining.
	 */
	public ResultParser property(String resultPropertySelector, com.codename1.rad.models.Tag[] tags) {
	}

	/**
	 *  Add support for parsing a particular property.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param parserCallback A callback to use for parsing the property.
	 *  @param tag Tag for resolving the property to bind to.
	 *  @return Self for chaining.
	 */
	public ResultParser property(String resultPropertySelector, com.codename1.rad.models.Tag tag, ResultParser.PropertyParserCallback parserCallback) {
	}

	/**
	 *  Add support for parsing a particular property.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tag Tag for resolving the property to bind to.
	 *  @param dateFormat Date format for formatting date data in  property.
	 *  @return Self for chaining.
	 */
	public ResultParser property(String resultPropertySelector, com.codename1.rad.models.Tag tag, com.codename1.l10n.SimpleDateFormat dateFormat) {
	}

	/**
	 *  Adds a string property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tag The tag to map to in the entity.
	 *  @param dateFormat DateFormat for parsing dates.
	 *  @return 
	 */
	public ResultParser string(String resultPropertySelector, com.codename1.rad.models.Tag tag, com.codename1.l10n.SimpleDateFormat dateFormat) {
	}

	/**
	 *  Adds a string property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tag The tag to map to in the entity.
	 *  @param callback A custom parser to use for parsing the content.
	 *  @return Self for chaining.
	 */
	public ResultParser string(String resultPropertySelector, com.codename1.rad.models.Tag tag, ResultParser.PropertyParserCallback callback) {
	}

	/**
	 *  Adds a string property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tags The tags to map to in the entity.
	 *  @return Self for chaining.
	 */
	public ResultParser string(String resultPropertySelector, com.codename1.rad.models.Tag[] tags) {
	}

	/**
	 *  Adds a string property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param callback Custom parser to use for parsing the property value.
	 *  @param tags The tags to map to in the entity.
	 *  @return Self for chaining.
	 */
	public ResultParser string(String resultPropertySelector, ResultParser.PropertyParserCallback callback, com.codename1.rad.models.Tag[] tags) {
	}

	/**
	 *  Adds a string property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param prop The property to bind to.
	 *  @return Self for chaining.
	 */
	public ResultParser string(String resultPropertySelector, com.codename1.rad.models.Property prop) {
	}

	/**
	 *  Adds a string property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param prop The property to bind to.
	 *  @param callback Custom parser to use for parsing the property value.
	 *  @return Self for chaining.
	 */
	public ResultParser string(String resultPropertySelector, com.codename1.rad.models.Property prop, ResultParser.PropertyParserCallback callback) {
	}

	/**
	 *  Adds an integer property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tag The tag for the property to bind to in the entity.
	 *  @param dateFormat Date format for parsing dates.
	 *  @return Self for chaining.
	 */
	public ResultParser Integer(String resultPropertySelector, com.codename1.rad.models.Tag tag, com.codename1.l10n.SimpleDateFormat dateFormat) {
	}

	/**
	 *  Adds an integer property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tag The tag for the property to bind to in the entity.
	 *  @param callback Custom parser to use for parsing the property value.
	 *  @return Self for chaining.
	 */
	public ResultParser Integer(String resultPropertySelector, com.codename1.rad.models.Tag tag, ResultParser.PropertyParserCallback callback) {
	}

	/**
	 *  Adds an integer property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tags The tags for the property to bind to in the entity.
	 *  @return Self for chaining.
	 */
	public ResultParser Integer(String resultPropertySelector, com.codename1.rad.models.Tag[] tags) {
	}

	/**
	 *  Adds an integer property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tags The tags for the property to bind to in the entity.
	 *  @param callback Custom parser to use for parsing the property value.
	 *  @return Self for chaining.
	 */
	public ResultParser Integer(String resultPropertySelector, ResultParser.PropertyParserCallback callback, com.codename1.rad.models.Tag[] tags) {
	}

	/**
	 *  Adds an integer property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param prop The property to bind to in the entity.
	 *  @return Self for chaining.
	 */
	public ResultParser Integer(String resultPropertySelector, com.codename1.rad.models.Property prop) {
	}

	/**
	 *  Adds an integer property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param prop The property to bind to in the entity.
	 *  @param callback Custom parser to use for parsing the property value.
	 *  @return Self for chaining.
	 */
	public ResultParser Integer(String resultPropertySelector, com.codename1.rad.models.Property prop, ResultParser.PropertyParserCallback callback) {
	}

	/**
	 *  Adds an double property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tag The tag for the property to bind to in the entity.
	 *  @param dateFormat Date format for parsing dates.
	 *  @return Self for chaining.
	 */
	public ResultParser Double(String resultPropertySelector, com.codename1.rad.models.Tag tag, com.codename1.l10n.SimpleDateFormat dateFormat) {
	}

	/**
	 *  Adds an double property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tag The tag for the property to bind to in the entity.
	 *  @param callback Custom parser to use for parsing the property value.
	 *  @return Self for chaining.
	 */
	public ResultParser Double(String resultPropertySelector, com.codename1.rad.models.Tag tag, ResultParser.PropertyParserCallback callback) {
	}

	/**
	 *  Adds an double property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tags The tags for the property to bind to in the entity.
	 *  @return Self for chaining.
	 */
	public ResultParser Double(String resultPropertySelector, com.codename1.rad.models.Tag[] tags) {
	}

	/**
	 *  Adds an double property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param callback The custom parser to use for parsing the property value.
	 *  @param tags The tags for the property to bind to in the entity.
	 *  @return Self for chaining.
	 */
	public ResultParser Double(String resultPropertySelector, ResultParser.PropertyParserCallback callback, com.codename1.rad.models.Tag[] tags) {
	}

	/**
	 *  Adds an double property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param prop The property to bind to in the entity.
	 *  @return Self for chaining.
	 */
	public ResultParser Double(String resultPropertySelector, com.codename1.rad.models.Property prop) {
	}

	/**
	 *  Adds an double property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param prop The property to bind to in the entity.
	 *  @param callback Custom parser to parse the property value.
	 *  @return Self for chaining.
	 */
	public ResultParser Double(String resultPropertySelector, com.codename1.rad.models.Property prop, ResultParser.PropertyParserCallback callback) {
	}

	/**
	 *  Adds a boolean property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tag The tag to bind to in the entity.
	 *  @param dateFormat Date format for parsing dates.
	 *  @return Self for chaining.
	 */
	public ResultParser Boolean(String resultPropertySelector, com.codename1.rad.models.Tag tag, com.codename1.l10n.SimpleDateFormat dateFormat) {
	}

	/**
	 *  Adds a boolean property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tag The tag to bind to in the entity.
	 *  @param callback Custom parser to parse the property.
	 *  @return Self for chaining.
	 */
	public ResultParser Boolean(String resultPropertySelector, com.codename1.rad.models.Tag tag, ResultParser.PropertyParserCallback callback) {
	}

	/**
	 *  Adds a boolean property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tags The tags to bind to in the entity.
	 *  @return Self for chaining.
	 */
	public ResultParser Boolean(String resultPropertySelector, com.codename1.rad.models.Tag[] tags) {
	}

	/**
	 *  Adds a boolean property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param callback Custom parser for parsing the property.
	 *  @param tags The tags to bind to in the entity.
	 *  @return Self for chaining.
	 */
	public ResultParser Boolean(String resultPropertySelector, ResultParser.PropertyParserCallback callback, com.codename1.rad.models.Tag[] tags) {
	}

	/**
	 *  Adds a boolean property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param prop Property to bind to in the entity.
	 *  @return Self for chaining.
	 */
	public ResultParser Boolean(String resultPropertySelector, com.codename1.rad.models.Property prop) {
	}

	/**
	 *  Adds a boolean property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param prop Property to bind to in the entity.
	 *  @param callback Custom parser for parsing the property.
	 *  @return Self for chaining.
	 */
	public ResultParser Boolean(String resultPropertySelector, com.codename1.rad.models.Property prop, ResultParser.PropertyParserCallback callback) {
	}

	/**
	 *  Adds a long property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tag The tag to bind to in the entity.
	 *  @param dateFormat Date format for parsing dates.
	 *  @return Self for chaining.
	 */
	public ResultParser Long(String resultPropertySelector, com.codename1.rad.models.Tag tag, com.codename1.l10n.SimpleDateFormat dateFormat) {
	}

	/**
	 *  Adds a long property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tag The tag to bind to in the entity.
	 *  @param callback Custom parser to parse the property.
	 *  @return Self for chaining.
	 */
	public ResultParser Long(String resultPropertySelector, com.codename1.rad.models.Tag tag, ResultParser.PropertyParserCallback callback) {
	}

	/**
	 *  Adds a long property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param tags The tags to bind to in the entity.
	 *  @return Self for chaining.
	 */
	public ResultParser Long(String resultPropertySelector, com.codename1.rad.models.Tag[] tags) {
	}

	/**
	 *  Adds a long property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param callback Custom parser for parsing the property.
	 *  @param tags The tags to bind to in the entity.
	 *  @return Self for chaining.
	 */
	public ResultParser Long(String resultPropertySelector, ResultParser.PropertyParserCallback callback, com.codename1.rad.models.Tag[] tags) {
	}

	/**
	 *  Adds a long property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param prop Property to bind to in the entity.
	 *  @return Self for chaining.
	 */
	public ResultParser Long(String resultPropertySelector, com.codename1.rad.models.Property prop) {
	}

	/**
	 *  Adds a long property parser.
	 *  @param resultPropertySelector The selector (in the {@link Result} expression language for retrieving the property from a Result.
	 *  @param prop Property to bind to in the entity.
	 *  @param callback Custom parser for parsing the property.
	 *  @return Self for chaining.
	 */
	public ResultParser Long(String resultPropertySelector, com.codename1.rad.models.Property prop, ResultParser.PropertyParserCallback callback) {
	}

	/**
	 *  Creates and adds a new parser for the given entity type.
	 *  @param type The type to create a parser for
	 *  @return The new parser.
	 */
	public ResultParser entityType(com.codename1.rad.models.EntityType type) {
	}

	public ResultParser entityType(Class type) {
	}

	/**
	 *  Parses a list of Maps or Elements into an EntityList.
	 *  @param rows The rows to parse.
	 *  @param out The entity list to append to.
	 *  @return The resulting entity list (same as input parameter).
	 *  @throws IOException If parsing failed.
	 */
	public com.codename1.rad.models.EntityList parse(java.util.List rows, com.codename1.rad.models.EntityList out) {
	}

	/**
	 *  Parses a result into the provided EntityList.
	 *  @param result The result to parse. This should be rooted with a list/array.
	 *  @param out The entitylist to add results to.
	 *  @return
	 *  @throws IOException 
	 */
	public com.codename1.rad.models.EntityList parse(com.codename1.rad.processing.Result result, com.codename1.rad.models.EntityList out) {
	}

	public com.codename1.rad.models.Entity parseXML(String xml, com.codename1.rad.models.Entity dest) {
	}

	public com.codename1.rad.models.Entity parseXML(java.io.InputStream xml, com.codename1.rad.models.Entity dest) {
	}

	public com.codename1.rad.models.Entity parseXML(java.io.Reader xml, com.codename1.rad.models.Entity dest) {
	}

	public com.codename1.rad.models.Entity parseJSON(String json, com.codename1.rad.models.Entity dest) {
	}

	public com.codename1.rad.models.Entity parseJSON(java.io.InputStream json, com.codename1.rad.models.Entity dest) {
	}

	public com.codename1.rad.models.Entity parseJSON(java.io.Reader json, com.codename1.rad.models.Entity dest) {
	}

	/**
	 *  Parse a single row of a result into the given row entity.
	 *  @param rowResult The rowResult.
	 *  @param rowEntity The row entity.
	 *  @return The resulting entity.  Same as input rowEntity.
	 *  @throws IOException if parsing fails.
	 */
	public com.codename1.rad.models.Entity parseRow(com.codename1.rad.processing.Result rowResult, com.codename1.rad.models.Entity rowEntity) {
	}

	public static ResultParser resultParser(Class type) {
	}

	public static ResultParser resultParser(com.codename1.rad.models.EntityType type) {
	}

	/**
	 *  Interface that can be implemented and passed to any of the property methods to provide
	 *  custom parsing of values retrieved from JSON/XML content.
	 */
	public static interface class PropertyParserCallback {


		public Object parse(Object val) {
		}
	}
}
