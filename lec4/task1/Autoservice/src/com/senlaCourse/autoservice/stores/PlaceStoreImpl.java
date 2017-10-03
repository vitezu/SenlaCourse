package com.senlaCourse.autoservice.stores;

import com.senlaCourse.autoservice.entity.Place;

import java.util.ArrayList;

public class PlaceStoreImpl {
    private ArrayList<Place> places = new ArrayList<Place>();

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
    public ArrayList<Place> getPlaces() {
        return places;
    }
    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }
}
