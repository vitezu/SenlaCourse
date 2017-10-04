package com.senlaCourse.autoservice.api.story;

import com.senlaCourse.autoservice.entity.Place;

import java.util.List;

public interface IPlaceStore extends IGeneric<Place> {

    @Override
    void delete(Place place);

    @Override
    void add(Place place);

    @Override
    List<Place> getAll();
}
