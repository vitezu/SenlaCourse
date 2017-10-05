package com.senlaCourse.autoservice.service;

import com.senlaCourse.autoservice.api.service.IPlaceService;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.stores.PlaceStoreImpl;
import com.senlaCourse.autoservice.util.Printer;

import java.util.List;

public class PlaceServiceImpl implements IPlaceService {

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
    public void getFreePlaces() {
        printer.printMessage(MESSAGE2);
            for (Place place : getPlaceStore()) {
                if (place.getStateFree()) {
                    printer.printObject(place);
                }
            }
    }

    @Override
    public List<Place> getPlaceStore() {
        return placeStore.getAll();
    }

}
