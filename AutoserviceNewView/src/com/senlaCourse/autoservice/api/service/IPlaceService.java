package com.senlaCourse.autoservice.api.service;

import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Place;

import java.util.List;

public interface IPlaceService {

    void addPlace(Place place);

    void deletePlace(Place place);

    Integer calcFreePlaces();

    List<Place> getFreePlaces();

    List<Place> getPlaceStore ();
}
