package com.senlaCourse.autoservice.service;

import com.senlaCourse.autoservice.api.service.IPlaceService;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.dependancy.DependancyInjection;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.stores.PlaceStoreImpl;
import com.senlaCourse.autoservice.util.Printer;

import java.util.ArrayList;
import java.util.List;

public class PlaceServiceImpl implements IPlaceService {

    private PlaceStoreImpl placeStore = (PlaceStoreImpl) DependancyInjection.getInstance().load(PlaceStoreImpl.class);

    Printer printer = new Printer();

    @Override
    public void addPlace(Place place) {
        placeStore.add(place);
    }

    @Override
    public void deletePlace(Place place) {
        placeStore.delete(place);
    }

    @Override
    public Integer calcFreePlaces() {
        Integer countFreePlace;
        Integer countFreeMaster;

        countFreePlace = getFreePlaces().size();
        countFreeMaster = ControllerImpl.getInstance().getFreeMasters().size();
        return (countFreeMaster + countFreePlace) / 2;
    }

    @Override
    public List<Place> getFreePlaces() {
        List<Place> places = new ArrayList<Place>();
        for (Place place : getPlaceStore()) {
            if (place.getStateFree()) {
                places.add(place);
            }
        }
        return places;
    }

    @Override
    public List<Place> getPlaceStore() {
        return placeStore.getAll();
    }

}
