package com.senlaCourse.autoservice.stores;

import com.senlaCourse.autoservice.api.story.IMasterStore;
import com.senlaCourse.autoservice.entity.Master;

import java.util.ArrayList;
import java.util.List;

public class MasterStoreImpl implements IMasterStore {

    private List<Master> masters = new ArrayList<Master>();

    @Override
    public void delete(Master master) {
        masters.remove(master);
    }

    @Override
    public void add(Master master) {
        masters.add(master);
    }

    @Override
    public List<Master> getAll() {
        return masters;
    }

}
