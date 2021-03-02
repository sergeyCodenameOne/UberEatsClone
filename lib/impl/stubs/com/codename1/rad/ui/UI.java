/**
 *  This package contains the foundation classes for CodeRAD views.  Nodes, Attributes, UI descriptors, etc..
 */
package com.codename1.rad.ui;


/**
 *  The base class for UI descriptors. This class sits at the foundation of CodeRAD's dynamic form generation
 *  capability.
 *  
 *  See {@link FormNode} for some usage examples.
 *  
 *  @author shannah
 */
public class UI extends com.codename1.rad.models.EntityType implements ActionCategories, WidgetTypes {

	public UI() {
	}

	public static StrongCache getCache() {
	}

	public static void setDefaultListCellRenderer(EntityListCellRenderer renderer) {
	}

	public static EntityListCellRenderer getDefaultListCellRenderer() {
	}

	public static void setDefaultEntityViewFactory(EntityViewFactory factory) {
	}

	public static com.codename1.rad.nodes.ActionsNode removeAction(com.codename1.rad.nodes.ActionNode removeAction) {
	}

	public static com.codename1.rad.nodes.ActionsNode selectAction(com.codename1.rad.nodes.ActionNode selectAction) {
	}

	public static com.codename1.rad.nodes.ActionsNode addAction(com.codename1.rad.nodes.ActionNode insertAction) {
	}

	public static EntityViewFactory getDefaultEntityViewFactory() {
	}

	public static ActionViewFactory getDefaultActionViewFactory() {
	}

	public static void setDefaultActionViewFactory(ActionViewFactory factory) {
	}

	public static com.codename1.rad.events.EventFactory getDefaultEventFactory() {
	}

	public static void setDefaultEventFactory(com.codename1.rad.events.EventFactory factory) {
	}

	public static PropertyViewFactory getDefaultPropertyViewFactory() {
	}

	public static void setDefaultPropertyViewFactory(PropertyViewFactory factory) {
	}

	public static ca.weblite.shared.components.table.TableCellRenderer getDefaultTableCellRenderer() {
	}

	public static void setDefaultTableCellRenderer(ca.weblite.shared.components.table.TableCellRenderer renderer) {
	}

	public static ca.weblite.shared.components.table.TableCellEditor getDefaultTableCellEditor() {
	}

	public static void setDefaultTableCellEditor(ca.weblite.shared.components.table.TableCellEditor editor) {
	}

	public static com.codename1.io.File getTempDir() {
	}

	public static com.codename1.io.File getTempFile(String name) {
	}

	public static com.codename1.rad.nodes.EntityViewFactoryNode viewFactory(EntityViewFactory factory, com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.ActionViewFactoryNode actionViewFactory(ActionViewFactory factory, com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.ActionViewFactoryNode viewFactory(ActionViewFactory factory, com.codename1.rad.models.Attribute[] atts) {
	}

	protected com.codename1.rad.nodes.FormNode form(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.attributes.UIID uiid(String uiid) {
	}

	public static com.codename1.rad.attributes.UIID uiid(com.codename1.rad.models.StringProvider provider) {
	}

	public static com.codename1.rad.attributes.UIID uiid(String uiid, com.codename1.rad.models.StringProvider provider) {
	}

	public static com.codename1.rad.attributes.IconUIID iconUiid(String uiid) {
	}

	public static com.codename1.rad.attributes.BadgeUIID badgeUiid(String uiid) {
	}

	public static com.codename1.rad.attributes.Badge badge(String badgeText) {
	}

	public static com.codename1.rad.attributes.Badge badge(String badgeText, com.codename1.rad.models.StringProvider provider) {
	}

	public static com.codename1.rad.nodes.SectionNode section(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.FieldNode field(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.attributes.Columns columns(int cols) {
	}

	public static com.codename1.rad.nodes.PropertyNode property(com.codename1.rad.models.Property prop, com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.attributes.PropertySelectorAttribute property(com.codename1.rad.models.PropertySelectorProvider value) {
	}

	public static com.codename1.rad.attributes.PropertySelectorAttribute property(com.codename1.rad.models.PropertySelector value) {
	}

	public static com.codename1.rad.attributes.PropertyImageRendererAttribute iconRenderer(image.PropertyImageRenderer renderer) {
	}

	public static com.codename1.rad.attributes.ActionStyleAttribute actionStyle(ActionStyle style) {
	}

	public static com.codename1.rad.attributes.NodeDecoratorAttribute decorator(NodeDecorator decorator) {
	}

	public static com.codename1.rad.nodes.FieldNode textField(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.FieldNode htmlComponent(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.propertyviews.ButtonListPropertyView.ButtonListLayoutAttribute buttonListLayout(com.codename1.rad.propertyviews.ButtonListPropertyView.ButtonListLayout layout) {
	}

	public static com.codename1.rad.propertyviews.ButtonListPropertyView.ButtonListLayoutAttribute buttonListY() {
	}

	public static com.codename1.rad.propertyviews.ButtonListPropertyView.ButtonListLayoutAttribute buttonListX() {
	}

	public static com.codename1.rad.propertyviews.ButtonListPropertyView.ButtonListLayoutAttribute buttonListFlow() {
	}

	public static com.codename1.rad.propertyviews.ButtonListPropertyView.ButtonListLayoutAttribute buttonListGrid() {
	}

	public static com.codename1.rad.nodes.FieldNode radioList(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.FieldNode radioListY(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.FieldNode checkboxList(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.FieldNode checkboxListY(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.FieldNode switchList(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.FieldNode checkbox(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.FieldNode radio(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.FieldNode toggleSwitch(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.FieldNode switchListY(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.FieldNode textArea(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.FieldNode comboBox(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.TableColumns columns(com.codename1.rad.nodes.FieldNode[] atts) {
	}

	public static com.codename1.rad.nodes.FieldNode table(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.attributes.TableCellRendererAttribute cellRenderer(ca.weblite.shared.components.table.TableCellRenderer renderer) {
	}

	public static com.codename1.rad.attributes.TableCellEditorAttribute cellEditor(ca.weblite.shared.components.table.TableCellEditor editor) {
	}

	public static com.codename1.rad.attributes.ListCellRendererAttribute cellRenderer(EntityListCellRenderer renderer) {
	}

	public static com.codename1.rad.nodes.PropertyViewFactoryNode propertyViewFactory(PropertyViewFactory factory, com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.PropertyViewFactoryNode viewFactoryFactory(PropertyViewFactory factory, com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.PropertyViewFactoryNode factory(PropertyViewFactory factory, com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.PropertyViewFactoryNode propertyView(PropertyViewFactory factory, com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.EventFactoryNode eventFactory(com.codename1.rad.events.EventFactory factory, com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.EventFactoryNode event(com.codename1.rad.events.EventFactory factory, com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.EventFactoryNode factory(com.codename1.rad.events.EventFactory factory, com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.ActionNode action(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.attributes.SelectedCondition selectedCondition(com.codename1.rad.models.EntityTest test) {
	}

	public static com.codename1.rad.nodes.ActionNode.EnabledCondition enabledCondition(com.codename1.rad.models.EntityTest test) {
	}

	public static com.codename1.rad.attributes.Condition condition(com.codename1.rad.models.EntityTest test) {
	}

	public static com.codename1.rad.nodes.ActionNode.Selected selected(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.ActionNode.Disabled disabled(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.ActionNode.Pressed pressed(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.ActionsNode actions(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.ActionsNode actions(com.codename1.rad.nodes.ActionNode.Category category, Actions actions) {
	}

	public static com.codename1.rad.attributes.MaterialIcon icon(char icon) {
	}

	public static com.codename1.rad.attributes.ImageIcon icon(com.codename1.ui.Image icon) {
	}

	public static com.codename1.rad.models.TextFormatterAttribute textFormat(com.codename1.rad.text.TextFormatter fmt) {
	}

	public static com.codename1.rad.models.TextFormatterAttribute textFormat(com.codename1.rad.text.DefaultTextFormatter.FormatCallback fmt) {
	}

	public static com.codename1.rad.models.TextFormatterAttribute textFormat(com.codename1.rad.text.DefaultTextFormatter.FormatCallback fmt, com.codename1.rad.text.DefaultTextFormatter.ParseCallback parse) {
	}

	public static com.codename1.rad.models.DateFormatterAttribute dateFormat(com.codename1.rad.text.DateFormatter fmt) {
	}

	public static com.codename1.rad.models.DateFormatterAttribute shortDateFormat() {
	}

	public static com.codename1.rad.models.DateFormatterAttribute longDateFormat() {
	}

	public static com.codename1.rad.models.DateFormatterAttribute dateTimeFormat() {
	}

	public static com.codename1.rad.models.DateFormatterAttribute shortDateTimeFormat() {
	}

	public static com.codename1.rad.models.DateFormatterAttribute mediumDateTimeFormat() {
	}

	public static com.codename1.rad.models.DateFormatterAttribute timeAgoFormat() {
	}

	public static com.codename1.rad.models.NumberFormatterAttribute decimalFormat(int decimalPlaces) {
	}

	public static com.codename1.rad.models.NumberFormatterAttribute currencyFormat() {
	}

	public static com.codename1.rad.models.NumberFormatterAttribute intFormat() {
	}

	public static com.codename1.rad.models.Property.Editable editable(boolean editable) {
	}

	public com.codename1.rad.nodes.FormNode getRoot() {
	}

	public com.codename1.rad.nodes.FieldNode[] getAllFields() {
	}

	public static com.codename1.rad.nodes.RowTemplateNode rowTemplate(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.nodes.ListNode list(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.attributes.IconRendererAttribute iconRenderer(image.EntityImageRenderer renderer) {
	}

	public static com.codename1.rad.nodes.ViewNode view(com.codename1.rad.models.Attribute[] atts) {
	}

	public static com.codename1.rad.attributes.ViewPropertyParameterAttribute param(ViewProperty prop, Object value) {
	}

	public static com.codename1.rad.attributes.ViewPropertyParameterAttribute param(ViewProperty prop, com.codename1.rad.models.Tag[] tags) {
	}

	public static com.codename1.rad.attributes.TextIcon icon(String text) {
	}

	public static com.codename1.rad.attributes.TextIcon icon(String text, com.codename1.rad.models.StringProvider provider) {
	}

	public static com.codename1.rad.attributes.TextIcon icon(com.codename1.rad.models.StringProvider provider) {
	}

	public static com.codename1.rad.models.Property.Label label(String label) {
	}

	public static com.codename1.rad.models.Property.Label label(String label, com.codename1.rad.models.StringProvider provider) {
	}

	public static com.codename1.rad.models.Property.Label label(com.codename1.rad.models.StringProvider provider) {
	}

	public static com.codename1.rad.nodes.OptionsNode options(com.codename1.ui.list.ListModel model, com.codename1.rad.models.Attribute[] atts) {
	}

	public static synchronized void runOnImageProcessingThread(Runnable r) {
	}

	public static com.codename1.rad.models.Property.GetterAttribute getter(com.codename1.rad.models.Property.Getter g) {
	}

	public static com.codename1.rad.models.Property.SetterAttribute setter(com.codename1.rad.models.Property.Setter s) {
	}
}
