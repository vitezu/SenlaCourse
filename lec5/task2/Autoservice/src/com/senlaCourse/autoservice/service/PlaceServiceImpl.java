package com.senlaCourse.autoservice.service;

import com.senlaCourse.autoservice.api.service.IPlaceService;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.stores.PlaceStoreImpl;
import com.senlaCourse.autoservice.util.Printer;

import java.util.ArrayList;
import java.util.List;

public class PlaceServiceImpl implements IPlaceService {

    private static PlaceServiceImpl instance = null;

    protected PlaceServiceImpl() {};

    public static PlaceServiceImpl getInstance() {
        if (instance == null){
            instance = new PlaceServiceImpl();
        }
        return instance;
    }

    private final String MESSAGE1 = "Calculate free places in future";
    private final String MESSAGE2 = "Free places";
    private PlaceStoreImpl placeStore = new PlaceStoreImpl();

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
    public void calcFreePlaces(List<Place> places, List<Master> masters) {
        printer.printMessage(MESSAGE1);
        int countFreePlace = 0;
        int countFreeMaster = 0;

        for (Place place : places) {
            if (place.getStateFree()) {
                countFreePlace++;
            }
        }
        for (Master master : masters) {
            if (master.getStateFree()) {
                countFreeMaster++;
            }
        }
        printer.printObject((countFreePlace + countFreeMaster) / 2);
    }

    @Override
    public List<Place> getFreePlaces() {
        List<Place> places = new ArrayList<Place>();
        printer.printMessage(MESSAGE2);
            for (Place place : getPlaceStore()) {
                if (place.getStateFree()) {
                    places.add(place);
                    printer.printObject(place);
                }
            }
            return places;
    }

    @Override
    public List<Place> getPlaceStore() {
        return placeStore.getAll();
    }

}
