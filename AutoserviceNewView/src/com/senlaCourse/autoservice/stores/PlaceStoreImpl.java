package com.senlaCourse.autoservice.stores;

import com.senlaCourse.autoservice.api.story.IPlaceStore;
import com.senlaCourse.autoservice.entity.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceStoreImpl implements IPlaceStore {

    private List<Place> places = new ArrayList<Place>();

    @Override
    public void add(Place place) {
        {
            places.add(place);
        }
    }

    @Override
    public List<Place> getAll() {
        return places;
    }

    @Override
    public void delete(Place place) {
        {
            int index = 0;
            boolean flag = false;
            for (int i=0; i<places.size(); i++){
                if (places.get(i).getNumPlace() == place.getNumPlace()){
                    flag = true;
                    index = i;
                    break;
                }
            }
            if (flag) {
                places.remove(index);
            }
            else {
                System.out.println("You cannot delete this element!");
            }
        }
    }
}
