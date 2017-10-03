package com.senlaCourse.autoservice.api.service;

import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Place;
import java.util.List;

public interface IPlaceService {

    public void addPlace(Place place);

    public void deletePlace(Place place);

    public void calcFreePlaces(List<Place> places, List<Master> masters);

    public void getFreePlaces(List<Place> places);
}
