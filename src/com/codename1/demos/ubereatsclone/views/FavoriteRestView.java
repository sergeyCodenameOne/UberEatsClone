package com.codename1.demos.ubereatsclone.views;

import com.codename1.components.ScaleImageButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.demos.ubereatsclone.interfaces.Dish;
import com.codename1.demos.ubereatsclone.interfaces.FoodCategory;
import com.codename1.demos.ubereatsclone.interfaces.Restaurant;
import com.codename1.demos.ubereatsclone.models.RestaurantModel;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class FavoriteRestView extends AbstractEntityView {

    private static EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("dish-placeholder.png"), false);

    public FavoriteRestView(RestaurantModel rest, Node viewNode) {
        super(rest);
        setUIID("FavoriteRestView");
        setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
        Label dishesNumber = new Label(rest.getDishesCount() + " Dishes", "DishesCount");
        Image dishesImage = FontImage.createMaterial(FontImage.MATERIAL_RESTAURANT, UIManager.getInstance().getComponentStyle("DishesCountImage"));

        dishesNumber.setIcon(dishesImage);
        Image restImage = rest.createImageToStorage(Restaurant.picture, placeHolder);
        ScaleImageButton restImageButton = new ScaleImageButton(restImage);
        restImageButton.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(HomeView.ENTER_REST);
            if (action != null) {
                action.fireEvent(rest, FavoriteRestView.this);
            }
        });
        setLeadComponent(restImageButton);
        restImageButton.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Container restImageCnt = new Container(new BorderLayout()){
            @Override
            public Dimension getPreferredSize() {
                Dimension dim =  super.getPreferredSize();
                dim.setHeight(Display.getInstance().getDisplayHeight() / 4);
                return dim;
            }
        };
        restImageCnt.setUIID("FavoriteRestImageCnt");
        restImageCnt.add(BorderLayout.SOUTH, dishesNumber).add(BorderLayout.CENTER, restImageButton);

        EntityList<Entity> dishes;
        Image firstDish, secondDish, thirdDish;
        if(rest.getEntity(Restaurant.menu) instanceof EntityList){
            EntityList<Entity> categories = (EntityList<Entity>) rest.getEntity(Restaurant.menu);
            if (categories.get(0).get(FoodCategory.dishes) instanceof EntityList){
                dishes = (EntityList) categories.get(0).get(FoodCategory.dishes);

                firstDish = dishes.get(0).createImageToStorage(Dish.pictureUrl, placeHolder);
                secondDish = dishes.get(1).createImageToStorage(Dish.pictureUrl, placeHolder);
                thirdDish = dishes.get(2).createImageToStorage(Dish.pictureUrl, placeHolder);

                ScaleImageLabel firstDishImageLabel = new ScaleImageLabel(firstDish);
                ScaleImageLabel secondDishImageLabel = new ScaleImageLabel(secondDish);
                ScaleImageLabel thirdDishImageLabel = new ScaleImageLabel(thirdDish);
                firstDishImageLabel.setUIID("FavoriteDishExample");
                secondDishImageLabel.setUIID("FavoriteDishExample");
                thirdDishImageLabel.setUIID("FavoriteDishExample");
                Container dishesSampleCnt = new Container(new GridLayout(1)){
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(Display.getInstance().getDisplayWidth() / 4, Display.getInstance().getDisplayHeight() / 4);
                    }
                };
                dishesSampleCnt.setUIID("DishesSampleCnt");
                dishesSampleCnt.addAll(firstDishImageLabel, secondDishImageLabel, thirdDishImageLabel);
                add(BorderLayout.CENTER, restImageCnt).
                        add(BorderLayout.NORTH, new Label(rest.getText(Restaurant.name), "FavoriteRestName")).
                        add(BorderLayout.EAST, dishesSampleCnt);
            }
        }
    }


    @Override
    public Dimension getPreferredSize() {
        Dimension dim = super.getPreferredSize();
        dim.setHeight(Display.getInstance().getDisplayHeight() / 3);
        return dim;
    }

    @Override
    public void update() {

    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return null;
    }
}
