package com.senlaCourse.autoservice.controller;

import com.senlaCourse.autoservice.api.controller.IPlaceServiceController;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.service.MasterServiceImpl;
import com.senlaCourse.autoservice.service.PlaceServiceImpl;

import java.util.List;

public class PlaceServiceController implements IPlaceServiceController {

    @Override
    public List<Place> getFreePlaces() {
        return PlaceServiceImpl.getInstance().getFreePlaces();
    }

    @Override
    public void calcFreePlaces() {
        List<Place> places = getFreePlaces();
        List<Master> masters = getAllMasters();
        PlaceServiceImpl.getInstance().calcFreePlaces(places, masters);
    }

    @Override
    public List<Master> getAllMasters() {
        List<Master> masters = MasterServiceImpl.getInstance().getMasterStore();
        for (Master master : masters) {
            System.out.println(master);
        }
        return masters;
    }
}
