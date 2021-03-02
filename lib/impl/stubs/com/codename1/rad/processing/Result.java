/**
 * 
 *         <h1>XPath based expression language designed to assist in JSON/XML parsing/generating</h1>
 *         <p>
 *             The {@link com.codename1.processing.Result} class provides a subset of 
 *             <a href="http://www.w3schools.com/xsl/xpath_intro.asp">XPath</a>, but it is not limited to just XML 
 *             documents, it can also work with JSON documents, and even with raw {@link java.util.Map} objects.
 *         </p>
 * 
 *         <p>
 *             As an example, we'll demonstrate how to process a response from the 
 *             <a href="https://developers.google.com/maps/documentation/geocoding/">Google Reverse Geocoder API</a>.  
 *             Lets start with this XML snippet:
 *         </p>
 * 
 *         <script src="https://gist.github.com/codenameone/6470330d1a30d30760ed.js"></script>
 * 
 *         <p>
 *              We want to extract some of the data above into simpler string results. We can do this using:
 *         </p>
 * 
 *         <script src="https://gist.github.com/codenameone/966f9061a610330f5d03.js"></script>
 *         
 *         <p>
 *             If you are at all familiar with processing responses from webservices, you will notice that what would 
 *             normally require several lines of code of selecting and testing nodes in regular java can now be 
 *             done in a single line using the new path expressions.
 *         </p>
 * 
 *         <p>
 *              In the code above, input can be any of:
 *         </p>
 *         <ul>
 *             <li>{@link java.lang.InputStream} directly from {@link com.codename1.io.ConnectionRequest#readResponse(java.io.InputStream)}</li>
 *             <li>XML or JSON document in the form of a {@code String}</li>
 *             <li>XML DOM {@link com.codename1.xml.Element} returned from {@link com.codename1.xml.XMLParser}</li>
 *             <li>JSON DOM {@link java.util.Map} returned from {@link com.codename1.io.JSONParser}</li>
 *         </ul>
 * 
 *         <p>
 *             To use the expression processor when calling a webservice, you could use something like the following to 
 *             parse JSON (notice this is interchangeable between JSON and XML):
 *         </p>
 * 
 *         <script src="https://gist.github.com/codenameone/16c2752f8eebbfe245cc.js"></script>
 *         
 *         <p>
 *             The returned JSON looks something like this (notice it's snipped because the data is too long):
 *         </p>
 *         
 *         <script src="https://gist.github.com/codenameone/58a213197634fb8ea4c3.js"></script>
 *         
 *         <img src="https://www.codenameone.com/img/developer-guide/processing-package.png" alt="Running the geocode sample above in the simulator">
 * 
 *      
 *         <p>The XML processor currently handles global selections by using a double slash anywhere within the 
 *             expression, for example:</p>
 * 
 * <script src="https://gist.github.com/codenameone/416f9814dc7922677208.js"></script>
 * 
 *         <blockquote><strong>NOTE:</strong> Notice that Google's JSON webservice uses plural form for each of 
 *             the node names in that API  (ie. results, address_components, and types) where they don't in the XML services
 *             (ie result, address_component etc.).</blockquote>
 * 
 *         <h2>Example 2</h2>
 *         <p>It also possible to do some more complex expressions.  We'll use the following XML fragment for the next batch of examples:</p>
 * 
 *         <script src="https://gist.github.com/codenameone/c51305d0bd2f0a67b861.js"></script>
 *         
 *         <p>Above, if you want to select the IDs of all players that are ranked in the top 2, you can use an 
 *             expression like:</p>
 *         <script src="https://gist.github.com/codenameone/a334a5705c37f63d6590.js"></script>
 * 
 *         <p>(Notice above that the expression is using an attribute for selecting both rank and id.  In JSON 
 *             documents, if you attempt to select an attribute, it will look for a child node under the attribute name you ask for).</p>
 * 
 *         <p>If a document is ordered, you might want to select nodes by their position, for example:</p>
 *         <script src="https://gist.github.com/codenameone/36174cb1e0db7539f46f.js"></script>
 *         
 *         <p>It is also possible to select parent nodes, by using the �..' expression.  For example:</p>
 *          <script src="https://gist.github.com/codenameone/dac601cd4ce442e7d082.js"></script>
 * 
 *          <p>Above, we globally find a lastname element with a value of �Hewitt', then grab the parent node of 
 *              lastname which happens to be the player node, then grab the id attribute from the player node.  
 *              Alternatively, you could get the same result from the following simpler statement:</p>
 * 
 *           <script src="https://gist.github.com/codenameone/66f32c76228dd494f2c1.js"></script>
 * 
 *           <p>It is also possible to nest expressions, for example:</p>
 * 
 *           <script src="https://gist.github.com/codenameone/1c02a6178b6004923c36.js"></script>
 * 
 *           <p>In the above example, if the player node had an address object, we'd be selecting all players from Canada.  
 *               This is a simple example of a nested expression, but they can get much more complex, which will be 
 *               required as the documents themselves get more complex.<br/> Moving on, to select a node based 
 *               on the existence of an attribute:</p>
 * 
 *            <script src="https://gist.github.com/codenameone/1ecccc99a5870508ee9c.js"></script>
 * 
 *            <p>Above, we selected the IDs of all ranked players.  Conversely, we can select the non-ranked players like this:</p>
 * 
 *            <script src="https://gist.github.com/codenameone/c3b8bf065f75450a6494.js"></script>
 * 
 *            <p>(Logical not (!) operators currently are not implemented).<br/>You can also select by the existence 
 *                of a child node.</p>
 * 
 *             <script src="https://gist.github.com/codenameone/3bdfd6be2cf62af5becd.js"></script>
 *             <p> Above, we selected all players that have a middle name.<br/> 
 *                     Keep in mind that the Codename One path expression language is not a full implementation of 
 *                     XPath 1.0, but does already handle many of the most useful features of the specification. </p>
 *     
 */
package com.codename1.rad.processing;


/**
 *  NOTE: This class is based on the core {@link com.codename1.processing.Result} class, but has been modified to improve performance,
 *  fix bugs, and add support for additional syntaxes.  We chose to "fork" the {@link com.codename1.processing.Result} rather than
 *  fix it because legacy software may depend on the old behaviour, even if it is considered a bug.  The safe solution, was to
 *  create a new class.
 *  
 *  An evaluator for a very small expression language to extract primitive types
 *  from structured information. This implementation is layered over the
 *  {@link com.codename1.io.JSONParser} and {@link com.codename1.xml.XMLParser} classes. This
 *  expression language allows applications to extract information from
 *  structured data returned by web services with minimal effort. You can read more about it {@link com.codename1.rad.processing here}.
 * 
 *  The expression language works a lot like a very small subset of XPath - the
 *  expression syntax uses the / character for sub-elements and square brackets
 *  for arrays.
 * 
 *  Some sample expressions:
 * 
 *  
 *   Simple expression, get the title of the first photo element::
 *   `/photos/photo[1]/title`
 * 
 *   Globally find the first name of a person with a last name of 'Coolman'::
 *   `//person[lastname='Coolman']/firstName`
 * 
 *   Get the latitude value of the second last result element::
 *   `/results[last()-1]/geometry/bounds/northeast/lat`
 * 
 *   Get the names of players from Germany::
 *   `/tournament/player[@nationality='Germany']/name`
 * 
 *   Get the purchase order numbers of any order with a lineitem worth over $5::
 *   `//order/lineitem[price > 5]/../@ponum`
 *  
 *  etc
 *  
 * 
 *  @author Eric Coolman (2012-03 - derivative work from original Sun source).
 */
public class Result {

	public static final String JSON = "json";

	public static final String XML = "xml";

	public static final char SEPARATOR = 47;

	public static final char ARRAY_START = 91;

	public static final char ARRAY_END = 93;

	/**
	 *  Create an evaluator object from a structured content document (XML, JSON,
	 *  etc) as a string.
	 * 
	 *  @param content structured content document as a string.
	 *  @param format an identifier for the type of content passed (ie. xml,
	 *  json, etc).
	 *  @return Result a result evaluator object
	 *  @throws IllegalArgumentException thrown if null content or format is
	 *  passed.
	 *  @since 7.0
	 */
	public static Result fromContent(String content, String format) {
	}

	/**
	 *  Create an evaluator object from a structured content document (XML, JSON,
	 *  etc) input stream. Normally you would use this method within a content
	 *  request implementation, for example:
	 * 
	 *  [source,java]
	 *  ----
	 *  ConnectionRequest request = new ConnectionRequest() {
	 *  	protected void readResponse(InputStream input) throws IOException {
	 *  		Result evaluator = Result.fromContent(input, Result.JSON);
	 *  		// ... evaluate the result here
	 *  	}
	 *  	// ... etc
	 *  };
	 *  ----
	 * 
	 * 
	 * 
	 * 
	 *  @param content structured content document as a string.
	 *  @param format an identifier for the type of content passed (ie. xml,
	 *  json, etc).
	 *  @return Result a result evaluator object
	 *  @throws IllegalArgumentException thrown if null content or format is
	 *  passed.
	 *  @since 7.0
	 */
	public static Result fromContent(java.io.InputStream content, String format) {
	}

	/**
	 *  Create an evaluator object from a structured content document (XML, JSON,
	 *  etc) input stream. Normally you would use this method within a content
	 *  request implementation, for example:
	 * 
	 *  [source,java]
	 *  ----
	 *  ConnectionRequest request = new ConnectionRequest() {
	 *  	protected void readResponse(InputStream input) throws IOException {
	 *  		Result evaluator = Result.fromContent(input, Result.JSON);
	 *  		// ... evaluate the result here
	 *  	}
	 *  	// ... etc
	 *  };
	 *  ----
	 * 
	 * 
	 * 
	 *  @param content structured content document as a string.
	 *  @param format an identifier for the type of content passed (ie. xml,
	 *  json, etc).
	 *  @return Result a result evaluator object
	 *  @throws IllegalArgumentException thrown if null content or format is
	 *  passed.
	 *  @since 7.0
	 */
	public static Result fromContent(java.io.Reader content, String format) {
	}

	/**
	 *  Create an evaluator object from a parsed XML DOM.
	 * 
	 *  @param content a parsed XML DOM.
	 *  @return Result a result evaluator object
	 *  @throws IllegalArgumentException thrown if null content is passed.
	 *  @since 7.0
	 */
	public static Result fromContent(com.codename1.xml.Element content) {
	}

	/**
	 *  Create an evaluator object from parsed JSON content DOM.
	 * 
	 *  @param content JSON content input stream
	 *  @return Result a result evaluator object
	 *  @since 7.0
	 */
	public static Result fromContent(java.util.Map content) {
	}

	/**
	 *  Returns a hashcode value for the object.
	 * 
	 *  @see Object#hashCode()
	 */
	public int hashCode() {
	}

	/**
	 *  Indicates whether some other object is "equal to" this one.
	 * 
	 *  @see Object#equals(Object)
	 */
	public boolean equals(Object other) {
	}

	/**
	 *  Convert the object to a formatted structured content document. For
	 *  example, an XML or JSON document.
	 * 
	 *  @return a structured content document as a string
	 */
	public String toString() {
	}

	/**
	 *  Get a boolean value from the requested path.
	 * 
	 *  For example: **JSON**
	 * 
	 *  [source,json]
	 *  ----
	 *  {
	 *  "settings" : [
	 *  {
	 *      "toggle" : "true",
	 *      ... etc
	 *  }
	 *  ----
	 * 
	 *  **Expression**
	 * 
	 *  [source,java]
	 *  ----
	 *  boolean value = result.getAsBoolean("/settings[0]/toggle");
	 *  ----
	 * 
	 *  @param path Path expression to evaluate
	 *  @return the value at the requested path
	 *  @throws IllegalArgumentException on error traversing the document, ie.
	 *  traversing into an array without using subscripts.
	 */
	public boolean getAsBoolean(String path) {
	}

	/**
	 *  Get an integer value from the requested path.
	 * 
	 *  For example: **JSON**
	 * 
	 *  [source,json]
	 *  ----
	 *  {
	 *  "settings"
	 *  {
	 *      "connection"
	 *      {
	 *           "max_retries" : "20",
	 *           ... etc
	 *      }
	 *  }
	 *  ----
	 * 
	 *  **Expression**
	 * 
	 *  [source,java]
	 *  ----
	 *  int value = result.getAsInteger("//connection/max_retries");
	 *  ----
	 * 
	 *  @param path Path expression to evaluate
	 *  @return the value at the requested path
	 *  @throws IllegalException on error traversing the document, ie. traversing
	 *  into an array without using subscripts.
	 */
	public int getAsInteger(String path) {
	}

	/**
	 *  Get a long value from the requested path.
	 * 
	 *  For example: **JSON**
	 * 
	 *  [source,java]
	 *  ----
	 *  {
	 *  "settings"
	 *  {
	 *      "connection"
	 *      {
	 *           "timeout_milliseconds" : "100000",
	 *           ... etc
	 *      }
	 *  }
	 *  ----
	 * 
	 *  **Expression**
	 * 
	 *  [source,java]
	 *  ----
	 *  long value = result.getAsLong("/settings/connection/timeout_milliseconds");
	 *  ----
	 * 
	 *  @param path Path expression to evaluate
	 *  @return the value at the requested path
	 *  @throws IllegalArgumentException on error traversing the document, ie.
	 *  traversing into an array without using subscripts.
	 */
	public long getAsLong(String path) {
	}

	/**
	 *  Get a double value from the requested path.
	 * 
	 *  For example: **JSON**:
	 * 
	 *  [source,json]
	 *  ----
	 *  {
	 *   "geometry" : {
	 *     "bounds" : {
	 *       "northeast" : {
	 *         "lat" : 42.94959820,
	 *         "lng" : -81.24873959999999
	 *        },
	 *        "southwest" : {
	 *          "lat" : 42.94830,
	 *          "lng" : -81.24901740000001
	 *        }
	 *     },
	 *     "location" : {
	 *       "lat" : 42.94886990,
	 *       "lng" : -81.24876030
	 *     },
	 *     "location_type" : "RANGE_INTERPOLATED",
	 *     "viewport" : {
	 *       "northeast" : {
	 *          "lat" : 42.95029808029150,
	 *          "lng" : -81.24752951970851
	 *       },
	 *       "southwest" : {
	 *          "lat" : 42.94760011970850,
	 *           "lng" : -81.25022748029151
	 *       }
	 *    }
	 *    // etc
	 *  ----
	 * 
	 *  **Expression:**
	 *  
	 *  [source,java]
	 *  ----
	 *  double neBoundsLat = result.getAsDouble("//bounds/northeast/lat");
	 *  double neBoundsLong = result.getAsDouble("//bounds/northeast/lng");
	 *  double swBoundsLat = result.getAsDouble("//bounds/southwest/lat");
	 *  double swBoundsLong = result.getAsDouble("//bounds/southwest/lng");
	 * 
	 *  double memberDiscount = result.getAsDouble("pricing.members.members");
	 *  ----
	 * 
	 *  @param path Path expression to evaluate
	 *  @return the value at the requested path
	 *  @throws IllegalArgumentException on error traversing the document, ie.
	 *  traversing into an array without using subscripts.
	 */
	public double getAsDouble(String path) {
	}

	/**
	 *  Get a string value from the requested path.
	 * 
	 *  For example: **JSON**
	 * 
	 *  [source,json]
	 *  ----
	 *  {
	 *  "profile"
	 *  {
	 *      "location"
	 *      {
	 *           "city" : "London",
	 *           "region" : "Ontario",
	 *           "country" : "Canada",
	 *           ... etc
	 *      },
	 *  }
	 *  ----
	 * 
	 *  **Expression**
	 * 
	 *  [source,java]
	 *  ----
	 *  String city = result.getAsDouble("//city");
	 *  String province = result.getAsDouble("//location//region");
	 *  String country = result.getAsDouble("profile//location//country");
	 *  ----
	 * 
	 *  @param path Path expression to evaluate
	 *  @return the value at the requested path
	 *  @throws IllegalArgumentException on error traversing the document, ie.
	 *  traversing into an array without using subscripts.
	 */
	public String getAsString(String path) {
	}

	/**
	 *  Get the object value from the requested path. This method may return a
	 *  Map, List, String, or null.
	 * 
	 *  @param path
	 *  @return the object at the given path, or null.
	 *  @throws IllegalArgumentException
	 */
	public Object get(String path) {
	}

	/**
	 *  Get the size of an array at the requested path.
	 * 
	 *  For example: **JSON**
	 * 
	 *  [source,json]
	 *  ----
	 *  {
	 *     "results" : [
	 *        {
	 *          "address_components" : [
	 *            {
	 *              "long_name" : "921-989",
	 *              "short_name" : "921-989",
	 *              "types" : [ "street_number" ]
	 *            },
	 *            {
	 *              "long_name" : "Country Club Crescent",
	 *              "short_name" : "Country Club Crescent",
	 *              "types" : [ "route" ]
	 *            },
	 *            {
	 *              "long_name" : "Ontario",
	 *              "short_name" : "ON",
	 *              "types" : [ "administrative_area_level_1", "political" ]
	 *            },
	 *            ... etc
	 *        }
	 *   }
	 *  ----
	 * 
	 *  **Expression**
	 * 
	 *  [source,java]
	 *  ----
	 *  int size = result.getSizeOfArray("/results[0]/address_components");
	 *  int size2 = result.getSizeOfArray("results");
	 *  int size3 = result.getSizeOfArray("/results[0]/address_components[2]/types");
	 *  ----
	 * 
	 *  @param path Path expression to evaluate
	 *  @return the value at the requested path
	 *  @throws IllegalArgumentException on error traversing the document, ie.
	 *  traversing into an array without using subscripts.
	 */
	public int getSizeOfArray(String path) {
	}

	/**
	 *  Get an array of string values from the requested path.
	 * 
	 *  For example: **JSON**
	 * 
	 *  [source,json]
	 *  ----
	 *  {
	 *     "results" : [
	 *        {
	 *          "address_components" : [
	 *            {
	 *              "long_name" : "921-989",
	 *              "short_name" : "921-989",
	 *              "types" : [ "street_number" ]
	 *            },
	 *            {
	 *              "long_name" : "Country Club Crescent",
	 *              "short_name" : "Country Club Crescent",
	 *              "types" : [ "route" ]
	 *            },
	 *            {
	 *              "long_name" : "Ontario",
	 *              "short_name" : "ON",
	 *              "types" : [ "administrative_area_level_1", "political" ]
	 *            },
	 *            ... etc
	 *        }
	 *   }
	 *  ----
	 * 
	 *  **Expression**
	 * 
	 *  [source,java]
	 *  ----
	 *  String types[] = result
	 *  		.getAsStringArray("/results[0]/address_components[2]/types");
	 *  ----
	 * 
	 *  @param path Path expression to evaluate
	 *  @return the value at the requested path
	 *  @throws IllegalArgumentException on error traversing the document, ie.
	 *  traversing into an array without using subscripts.
	 */
	public String[] getAsStringArray(String path) {
	}

	/**
	 *  Get an array of values from the requested path.
	 * 
	 *  For example: **JSON**
	 * 
	 *  [source,json]
	 *  ----
	 *  {
	 *     "results" : [
	 *        {
	 *          "address_components" : [
	 *            {
	 *              "long_name" : "921-989",
	 *              "short_name" : "921-989",
	 *              "types" : [ "street_number" ]
	 *            },
	 *            {
	 *              "long_name" : "Country Club Crescent",
	 *              "short_name" : "Country Club Crescent",
	 *              "types" : [ "route" ]
	 *            },
	 *            {
	 *              "long_name" : "Ontario",
	 *              "short_name" : "ON",
	 *              "types" : [ "administrative_area_level_1", "political" ]
	 *            },
	 *            ... etc
	 *        }
	 *   }
	 *  ----
	 * 
	 *  **Expression**
	 * 
	 *  [source,java]
	 *  ----
	 *  String types[] = result
	 *  		.getAsStringArray("/results[0]/address_components[2]/types");
	 *  ----
	 * 
	 *  @param path Path expression to evaluate
	 *  @return the value at the requested path
	 *  @throws IllegalArgumentException on error traversing the document, ie.
	 *  traversing into an array without using subscripts.
	 *  @throws NumberFormatException if the value at path can not be converted
	 *  to an integer.
	 */
	public int[] getAsIntegerArray(String path) {
	}

	/**
	 *  Get an array of values from the requested path.
	 *  [source,java]
	 *  ----
	 *  String types[] = result
	 *  		.getAsStringArray("/results[0]/address_components[2]/types");
	 *  ----
	 * 
	 *  @param path Path expression to evaluate
	 *  @return the value at the requested path
	 *  @throws IllegalArgumentException on error traversing the document, ie.
	 *  traversing into an array without using subscripts.
	 *  @throws NumberFormatException if the value at path can not be converted
	 *  to a long.
	 */
	public long[] getAsLongArray(String path) {
	}

	/**
	 *  Get an array of values from the requested path.
	 *  
	 *  [source,java]
	 *  ----
	 *  String types[] = result
	 *  		.getAsStringArray("/results[0]/address_components[2]/types");
	 *  ----
	 * 
	 *  @param path Path expression to evaluate
	 *  @return the value at the requested path
	 *  @throws IllegalArgumentException on error traversing the document, ie.
	 *  traversing into an array without using subscripts.
	 *  @throws NumberFormatException if the value at path can not be converted
	 *  to a double.
	 */
	public double[] getAsDoubleArray(String path) {
	}

	/**
	 *  Get an array of values from the requested path.
	 *  
	 *  [source,java]
	 *  ----
	 *  String types[] = result
	 *  		.getAsStringArray("/results[0]/address_components[2]/types");
	 *  ----
	 * 
	 *  @param path Path expression to evaluate
	 *  @return the value at the requested path
	 *  @throws IllegalArgumentException on error traversing the document, ie.
	 *  traversing into an array without using subscripts.
	 */
	public boolean[] getAsBooleanArray(String path) {
	}

	/**
	 *  Get a List of values from the requested path.
	 * 
	 *  For example: **JSON**
	 * 
	 *  [source,json]
	 *  {
	 *     "results" : [
	 *        {
	 *          "address_components" : [
	 *            {
	 *              "long_name" : "921-989",
	 *              "short_name" : "921-989",
	 *              "types" : [ "street_number" ]
	 *            },
	 *            {
	 *              "long_name" : "Country Club Crescent",
	 *              "short_name" : "Country Club Crescent",
	 *              "types" : [ "route" ]
	 *            },
	 *            ... etc
	 *        }
	 *   }
	 *  ----
	 * 
	 *  **Expression**
	 * 
	 *  [source,java]
	 *  ----
	 *  List addressComponents = result.getAsList("/results[0]/address_components");
	 *  result = Result.fromContent(addressComponents);
	 *  String longName = result.getAsString("[1]/long_name");
	 *  ----
	 * 
	 *  @param path Path expression to evaluate
	 *  @return the value at the requested path
	 *  @throws IllegalArgumentException on error traversing the document, ie.
	 *  traversing into an array without using subscripts.
	 */
	public java.util.List getAsArray(String path) {
	}

	public void mapNamespaceAlias(String namespaceURI, String alias) {
	}
}
