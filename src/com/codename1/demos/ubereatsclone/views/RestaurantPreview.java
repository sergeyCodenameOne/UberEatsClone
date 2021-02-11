package com.codename1.demos.ubereatsclone.views;

import com.codename1.components.ScaleImageButton;
import com.codename1.demos.ubereatsclone.interfaces.Restaurant;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;

import static com.codename1.ui.CN.convertToPixels;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class RestaurantPreview extends AbstractEntityView {

    Property nameProp, categoryProp, ratingProp, deliveryTimeProp, pictureProp;
    Node viewNode;

    private static EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("dish-placeholder.png"), false);

    public RestaurantPreview(Entity entity, Node viewNode){
        super(entity);
        setLayout(new BorderLayout());
        setUIID("RestaurantPreview");
        this.viewNode = viewNode;

        nameProp = entity.findProperty(Restaurant.name);
        categoryProp = entity.findProperty(Restaurant.category);
        ratingProp = entity.findProperty(Restaurant.rating);
        deliveryTimeProp = entity.findProperty(Restaurant.estimatedDeliveryTime);
        pictureProp = entity.findProperty(Restaurant.picture);

        Image restImage = entity.createImageToStorage(pictureProp, placeHolder);
        ScaleImageButton restImageButton = new ScaleImageButton(restImage){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension((int)(Display.getInstance().getDisplayWidth() / 1.5), Display.getInstance().getDisplayWidth() / 3);
            }
        };

        restImageButton.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_REST);
            if (action != null) {
                action.fireEvent(entity, RestaurantPreview.this);
            }
        });

        setLeadComponent(restImageButton);
        restImageButton.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label restNameLabel = new Label(entity.getText(nameProp), "RestPreviewNameLabel");
        Label restCategoryLabel = new Label(entity.getText(categoryProp), "RestPreviewCategoryLabel");

        Container restTopView = new Container(new LayeredLayout());
        restTopView.add(restImageButton);
        Container nameAndCategoryCnt = new Container(new BorderLayout());
        nameAndCategoryCnt.setUIID("RestaurantPreviewDetailsCnt");
        nameAndCategoryCnt.add(BorderLayout.SOUTH, BoxLayout.encloseY(restNameLabel, restCategoryLabel));
        restTopView.add(nameAndCategoryCnt);

        Label estimatedDeliveryTimeLabel = new Label(" " + entity.getInt(deliveryTimeProp) + " mins", "RestPreviewDeliveryTime");
        estimatedDeliveryTimeLabel.setIcon(getGlobalResources().getImage("delivery-time-icon.png").scaled(convertToPixels(4), convertToPixels(4)));
        Label ratingLabel = new Label(" " + entity.getDouble(ratingProp) + "/5", "RestPreviewRating");
        ratingLabel.setIcon(getGlobalResources().getImage("rating-icon.png").scaled(convertToPixels(4), convertToPixels(4)));

        add(BorderLayout.SOUTH, FlowLayout.encloseCenter(estimatedDeliveryTimeLabel, ratingLabel));
        add(BorderLayout.CENTER, restTopView);

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
