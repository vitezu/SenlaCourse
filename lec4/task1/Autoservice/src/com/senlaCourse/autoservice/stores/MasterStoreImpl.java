package com.senlaCourse.autoservice.stores;

import com.senlaCourse.autoservice.entity.Master;

import java.util.ArrayList;

public class MasterStoreImpl {
    private ArrayList<Master> masters = new ArrayList<Master>();

    public void delete(Master master) {
        masters.remove(master);
    }
    public void add(Master master) {
        masters.add(master);
    }

    public ArrayList<Master> getMasters() {
        return masters;
    }

    public void setMasters(ArrayList<Master> masters) {
        this.masters = masters;
    }
}
