package com.codename1.demos.ubereatsclone.views;

import com.codename1.demos.ubereatsclone.interfaces.Account;
import com.codename1.demos.ubereatsclone.models.RestaurantModel;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityList;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

import java.util.List;

public class FavoriteRestaurantsView extends AbstractEntityView {

    Container restsCnt;
    Node viewNode;

    public FavoriteRestaurantsView(Entity account, Node viewNode) {
        super(account);
        setUIID("FavoriteRestaurantsView");
        this.viewNode = viewNode;
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
//        setScrollableY(true);

        Label headerLabel = new Label("FAVORITES", "FavoriteHeaderLabel");
        Container headerCnt = BorderLayout.center(headerLabel);
        headerCnt.setUIID("FavoriteHeaderCnt");
        add(headerCnt);
        restsCnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        restsCnt.setScrollableY(true);
        add(restsCnt);

        update();
    }

    @Override
    public void update() {
        restsCnt.removeAll();
        if (getEntity().get(Account.favoriteRestaurants) instanceof EntityList){
            EntityList<Entity> restList = (EntityList<Entity>)getEntity().get(Account.favoriteRestaurants);
            for(Entity rest : restList){
                restsCnt.add(new FavoriteRestView((RestaurantModel) rest, viewNode));
            }
        }
    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return null;
    }

    public void addFavorite(Entity rest){
        restsCnt.add(new FavoriteRestView((RestaurantModel) rest, viewNode));
        restsCnt.revalidateWithAnimationSafety();
    }

    public void removeFavorite(Entity rest){
        List<Component> restaurants = restsCnt.getChildrenAsList(true);
        for(Component currRest : restaurants){
            if (currRest instanceof FavoriteRestView){
                if (((FavoriteRestView) currRest).getEntity() == rest){
                    restsCnt.removeComponent(currRest);
                }
            }
        }
        restsCnt.revalidateWithAnimationSafety();
    }
}
