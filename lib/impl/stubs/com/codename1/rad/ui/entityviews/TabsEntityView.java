/**
 *  This package contains entity views - view components that are bound to an Entity value model.
 */
package com.codename1.rad.ui.entityviews;


/**
 *  An Tabs component that is backed by a view model.  You can specify the tabs in this
 *  view using the UI descriptor.
 *  
 *  .Example subclass of TabsEntityView  defining two tabs.
 *  image::https://shannah.github.io/CodeRAD/manual/images/TabsEntityView.png[]
 *  
 *  === View Model
 *  
 *  The view model does not need to conform necessarily to any particular schema, as the UI descriptor
 *  is fully responsible for the contents of the tabs.  The UI descriptor may refer to elements of the 
 *  view model for defining its contents though.
 *  
 *  === UI Descriptor
 *  
 *  The UI descriptor is expected to be a {@link ViewNode}, where its child nodes each correspond to a 
 *  tab in this tab component.  Each child node may be either a {@link ListNode} or a {@link ViewNode}.  
 *  The tab label should be specified by the {@link Label} attribute.  The tab contents will be defined
 *  by the {@link EntityViewFactory} for a view node, and the {@link EntityListCellRenderer} for a list
 *  node.  They should also each specify either a `property` or `tags` attribute that points to the view
 *  model, to retrieve the "sub" view model that should be used for the particular tab.
 *  
 *  
 *  === Source Examples
 *  
 *  .Example UI descriptor that specifies two tabs, each that renders a list.
 *  [source,java]
 *  ----
 *  ViewNode vn = new ViewNode(
 *         list(
 *             property(SearchTabsViewModel.forYou),
 *             label("For You"),
 *             cellRenderer(new TWTNewsList.TWTNewsListCellRenderer())
 *         ),
 *         list(
 *             property(SearchTabsViewModel.trending),
 *             label("Trending"),
 *             cellRenderer(new TWTNewsList.TWTNewsListCellRenderer())
 *         ),
 *         actions(TWTSearchButton.SEARCH_ACTION, search)
 *   );
 *  ----
 *  
 *  .Corresponding view model for above UI descriptor.
 *  [source,java]
 *  ----
 *  public static class SearchTabsViewModel extends Entity {
 *         public static Property forYou, trending, news, sports, fun;
 *         public static final EntityType TYPE = new EntityType() {{
 *             forYou = list(EntityList.class);
 *             trending = list(EntityList.class);
 *             news = list(EntityList.class);
 *             sports = list(EntityList.class);
 *             fun = list(EntityList.class);
 *         }};
 *         {
 *             setEntityType(TYPE);
 *         }
 *     }
 *  ----
 *  
 *  .Full View controller from the TweetAppUIKit demo that uses TabsEntityView with two tabs.  In this case,
 *  both tabs are list tabs.
 *  [source,java]
 *  ----
 * 
 * package com.codename1.demos.twitterui;
 * 
 * import ca.weblite.shared.components.CollapsibleHeaderContainer;
 * import com.codename1.demos.twitterui.models.NewsItem;
 * import com.codename1.demos.twitterui.models.UserProfile;
 * import com.codename1.rad.controllers.Controller;
 * import com.codename1.rad.models.Entity;
 * import com.codename1.rad.models.EntityList;
 * import com.codename1.rad.models.EntityType;
 * import com.codename1.rad.models.Property;
 * import com.codename1.rad.nodes.ActionNode;
 * import com.codename1.rad.nodes.ViewNode;
 * import com.codename1.rad.schemas.Thing;
 * import com.codename1.twitterui.models.TWTAuthor;
 * import com.codename1.twitterui.schemas.TWTNewsItem;
 * import java.util.Date;
 * import java.util.HashMap;
 * import java.util.Map;
 * import static com.codename1.rad.ui.UI.*;
 * import com.codename1.rad.ui.entityviews.TabsEntityView;
 * import com.codename1.twitterui.views.TWTNewsList;
 * import com.codename1.twitterui.views.TWTSearchButton;
 * import com.codename1.twitterui.views.TWTTabsView;
 * import com.codename1.twitterui.views.TWTTitleComponent;
 * import com.codename1.ui.Form;
 * 
 * 
 * public class SearchTabsController extends BaseFormController {
 *     public static final ActionNode search = action(
 *             
 *     );
 *     private Map<String,Entity> authors = new HashMap<>();
 *     
 *     public SearchTabsController(Controller parent) {
 *         super(parent);
 *         SearchTabsViewModel model = createViewModel();
 *         addLookup(model);
 *         TabsEntityView view = new TWTTabsView(model, getViewNode());
 *        
 *         CollapsibleHeaderContainer wrapper = new CollapsibleHeaderContainer(
 *                 new TWTTitleComponent(lookup(UserProfile.class), getViewNode(), new TWTSearchButton(lookup(UserProfile.class), getViewNode())),
 *                 view, 
 *                 view
 *         );
 *         setView(wrapper);
 *         
 *         addActionListener(search, evt->{
 *             evt.consume();
 *             Form form = new SearchFormController(this).getView();
 *             form.show();
 *         });
 *         
 *     }
 * 
 *     @Override
 *     protected ViewNode createViewNode() {
 *         ViewNode vn = new ViewNode(
 *                 list(
 *                     property(SearchTabsViewModel.forYou),
 *                     label("For You"),
 *                     cellRenderer(new TWTNewsList.TWTNewsListCellRenderer())
 *                 ),
 *                 list(
 *                     property(SearchTabsViewModel.trending),
 *                     label("Trending"),
 *                     cellRenderer(new TWTNewsList.TWTNewsListCellRenderer())
 *                 ),
 *                 actions(TWTSearchButton.SEARCH_ACTION, search)
 *         );
 *         return vn;
 *     }
 *     
 *     
 *     
 *     public static class SearchTabsViewModel extends Entity {
 *         public static Property forYou, trending, news, sports, fun;
 *         public static final EntityType TYPE = new EntityType() {{
 *             forYou = list(EntityList.class);
 *             trending = list(EntityList.class);
 *             news = list(EntityList.class);
 *             sports = list(EntityList.class);
 *             fun = list(EntityList.class);
 *         }};
 *         {
 *             setEntityType(TYPE);
 *         }
 *     }
 *     
 *     private NewsItem createItem(Entity creator, Date date, String headline, String thumbnailUrl) {
 *         NewsItem item = new NewsItem();
 *         item.setEntity(TWTNewsItem.creator, creator);
 *         item.setDate(TWTNewsItem.date, date);
 *         item.setText(TWTNewsItem.headline, headline);
 *         item.setText(TWTNewsItem.thumbnailUrl, thumbnailUrl);
 *         item.setText(TWTNewsItem.image, thumbnailUrl);
 *         return item;
 *     }
 *     
 *     private EntityList createSection() {
 *         EntityList out = new EntityList();
 *         String georgeThumb = "https://weblite.ca/cn1tests/radchat/george.jpg";
 *         String kramerThumb = "https://weblite.ca/cn1tests/radchat/kramer.jpg";
 *         String jerryThumb = "https://weblite.ca/cn1tests/radchat/jerry.jpg";
 *         Entity george = getOrCreateAuthor("George", "@kostanza", georgeThumb);
 *         Entity kramer = getOrCreateAuthor("Kramer", "@kramer", kramerThumb);
 *         Entity jerry = getOrCreateAuthor("Jerry", "@jerry", jerryThumb);
 *         long SECOND = 1000l;
 *         long MINUTE = SECOND * 60;
 *         long HOUR = MINUTE * 60;
 *         long DAY = HOUR * 24;
 *         long t = System.currentTimeMillis() - 2 * DAY;
 *         out.add(createItem(jerry, new Date(t), "Stunning Public Domain Waterfall Photos", "https://weblite.ca/cn1tests/radchat/waterfalls.jpg"));
 *         out.add(createItem(george, new Date(t), "Use the RADChatRoom library to quickly and easily add a nice-looking, ...", "https://www.codenameone.com/img/blog/chat-ui-kit-feature.jpg"));
 *         out.add(createItem(kramer, new Date(t), "EasyThread  makes it much easier to write multi-threaded code in Codename One.", "https://www.codenameone.com/img/blog/new-features.jpg"));
 *         out.add(createItem(jerry, new Date(t), "XCODE 11 IS NOW THE DEFAULT", "https://www.codenameone.com/img/blog/xcode-7.png"));
 *         out.add(createItem(kramer, new Date(t), "CSS styles can now be distributed inside a cn1lib.", "https://www.codenameone.com/img/blog/css-header.jpg"));
 *         out.add(createItem(george, new Date(t), "Iran's vast coronavirus burial pits are visible by satellite", "https://pbs.twimg.com/media/ES6gV-xXkAQwZ0Y?format=jpg&name=small"));
 *         out.add(createItem(george, new Date(t), "We've added the ability to position your Sheets in different locations on the screen.", "https://www.codenameone.com/img/blog/new-features.jpg"));
 *         return out;
 *     }
 *     
 *     private EntityList createTrendingSection() {
 *         EntityList out = new EntityList();
 *         String georgeThumb = "https://weblite.ca/cn1tests/radchat/george.jpg";
 *         String kramerThumb = "https://weblite.ca/cn1tests/radchat/kramer.jpg";
 *         Entity george = getOrCreateAuthor("George", "@kostanza", georgeThumb);
 *         Entity kramer = getOrCreateAuthor("Kramer", "@kramer", kramerThumb);
 *         long SECOND = 1000l;
 *         long MINUTE = SECOND * 60;
 *         long HOUR = MINUTE * 60;
 *         long DAY = HOUR * 24;
 *         long t = System.currentTimeMillis() - 2 * DAY;
 *         
 *         out.add(createItem(george, new Date(t), "Now you can create CN1Libs with embedded CSS Styles", "https://www.codenameone.com/img/blog/css-header.jpg"));
 *         out.add(createItem(george, new Date(t), "We now have a reliable way to avoid clipping the Notch and Task bar on the iPhone X.", "https://www.codenameone.com/img/blog/new-features.jpg"));
 *         return out;
 *     }
 *     
 *     private SearchTabsViewModel createViewModel() {
 *         SearchTabsViewModel out = new SearchTabsViewModel();
 *         out.set(SearchTabsViewModel.forYou, createSection());
 *         out.set(SearchTabsViewModel.fun, createSection());
 *         out.set(SearchTabsViewModel.news, createSection());
 *         out.set(SearchTabsViewModel.sports, createSection());
 *         out.set(SearchTabsViewModel.trending, createTrendingSection());
 *         return out;
 *     }
 *     
 *      private Entity getOrCreateAuthor(String name, String id, String iconUrl) {
 *         if (authors.containsKey(id)) {
 *             return authors.get(id);
 *         }
 *         Entity author = new TWTAuthor();
 *         author.set(Thing.name, name);
 *         author.set(Thing.identifier, id);
 *         author.set(Thing.thumbnailUrl, iconUrl);
 *         authors.put(id, author);
 *         return author;
 *         
 *     }
 * }
 * 
 *  ----
 *  @author shannah
 */
public class TabsEntityView extends com.codename1.rad.ui.AbstractEntityView implements ca.weblite.shared.components.CollapsibleHeaderContainer.ScrollableContainer {

	public TabsEntityView(com.codename1.rad.models.Entity entity, com.codename1.rad.nodes.ViewNode node) {
	}

	protected com.codename1.ui.Tabs createTabs() {
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
	 *  For use with CollapsibleHeaderContainer.  When tabs are used as the body
	 *  it needs to let the collapsible header container which container us
	 *  the current scrollable.
	 *  @return 
	 */
	@java.lang.Override
	public com.codename1.ui.Container getVerticalScroller() {
	}
}
