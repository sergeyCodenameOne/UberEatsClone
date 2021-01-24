package com.codename1.demos.ubereatsclone.views;

import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.demos.ubereatsclone.interfaces.Dish;
import com.codename1.l10n.L10NManager;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class DishPreview<T extends Entity> extends AbstractEntityView<T> {

    private Node viewNode;
    private Property nameProp, descriptionProp, pictureUrlProp, priceProp;

    public static final ActionNode.Category DISH_CLICKED = new ActionNode.Category();

    private static EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("dish-placeholder.png"), false);//TODO change the placeHolder

    public DishPreview(T entity, Node viewNode) {
        super(entity);
        setUIID("DishPreview");
        setLayout(new BorderLayout());

        this.viewNode = viewNode;
        nameProp = entity.findProperty(Dish.name);
        descriptionProp = entity.findProperty(Dish.description);
        pictureUrlProp = entity.findProperty(Dish.pictureUrl);
        priceProp = entity.findProperty(Dish.price);

        Image dishImage = entity.createImageToStorage(pictureUrlProp, placeHolder);
        ScaleImageLabel dishImageLabel = new ScaleImageLabel(dishImage){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 300);
            }
        };

        MultiButton dishPreview = new MultiButton(entity.getText(nameProp));
        dishPreview.setTextLine2(entity.getText(descriptionProp));
        dishPreview.setTextLine3(L10NManager.getInstance().formatCurrency(entity.getDouble(priceProp)));
        dishPreview.setUIID("DishPreviewInfo");
        dishPreview.setUIIDLine1("DishPreviewName");
        dishPreview.setUIIDLine2("DishPreviewDescription");
        dishPreview.setUIIDLine3("DishPreviewPrice");

        add(BorderLayout.NORTH, dishImageLabel);
        add(BorderLayout.CENTER, dishPreview);
        setLeadComponent(dishPreview);

        dishPreview.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(DISH_CLICKED);
            if (action != null) {
                System.out.println("DISH_CLICKED action fired");
                action.fireEvent(entity, DishPreview.this);
            }
        });
    }

    @Override
    public void update() {

    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return viewNode;
    }
}
