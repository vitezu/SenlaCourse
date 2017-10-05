package com.senlaCourse.autoservice.stores;

import com.senlaCourse.autoservice.api.story.IPlaceStore;
import com.senlaCourse.autoservice.entity.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceStoreImpl implements IPlaceStore {

    private List<Place> places = new ArrayList<Place>();

    @Override
    public void add(Place place) {
        {
            places.add(place);
        }
    }

    @Override
    public List<Place> getAll() {
        return places;
    }

    @Override
    public void delete(Place place) {
        {
            places.remove(place);
        }
    }

}
