package com.senlaCourse.autoservice.stores;

import com.senlaCourse.autoservice.entity.Master;

import java.util.ArrayList;
import java.util.List;

public class MasterStoreImpl {
    private List<Master> masters = new ArrayList<Master>();

    public void delete(Master master) {
        masters.remove(master);
    }
    public void add(Master master) {
        masters.add(master);
    }

    public List<Master> getMasters() {
        return masters;
    }

    public void setMasters(List<Master> masters) {
        this.masters = masters;
    }
}
