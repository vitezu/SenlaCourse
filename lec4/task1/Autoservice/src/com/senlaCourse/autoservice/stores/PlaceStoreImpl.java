package com.senlaCourse.autoservice.stores;

import com.senlaCourse.autoservice.entity.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceStoreImpl {
    private List<Place> places = new ArrayList<Place>(15);

    public void add(Place place) {
        {
            places.add(place);
        }
    }
    public void delete(Place place) {
        {
            places.remove(place);
        }
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
