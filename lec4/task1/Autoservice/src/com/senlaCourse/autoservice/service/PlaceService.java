package com.senlaCourse.autoservice.service;

import com.senlaCourse.autoservice.api.IPlaceStore;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.stores.PlaceStoreImpl;
import com.senlaCourse.autoservice.util.Printer;

import java.util.List;

public class PlaceService {

    private final String MESSAGE1 = "Calculate free places in future";
    private final String MESSAGE2 = "Num of free places";
    private PlaceStoreImpl placeStore = new PlaceStoreImpl();

    Printer printer = new Printer();

    public void addPlace (Place place) {
        placeStore.add(place);
    }

    public void deletePlace (Place place) {
        placeStore.delete(place);
    }


    public void calcFreePlaces(List<Place> places, List<Master> masters)  {
        printer.printLineEmpty();
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
        printer.printObject((countFreePlace + countFreeMaster)/ 2);
    }
    public void getFreePlaces(List<Place> places) {
        System.out.println();
        System.out.println(MESSAGE2);
        for (Place place : places) {
            if (place.getStateFree() == true) {
                System.out.println(place);
            }
        }
    }

}
