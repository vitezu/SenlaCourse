package com.senlaCourse.autoservice.api.controller;

import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Place;

import java.util.List;

public interface IPlaceServiceController {

    List<Place> getFreePlaces();

    void calcFreePlaces();

    List<Master> getAllMasters();
}
