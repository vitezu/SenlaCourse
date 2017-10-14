package com.senlaCourse.autoservice.service;

import com.senlaCourse.autoservice.api.service.IMasterService;
import com.senlaCourse.autoservice.api.story.IMasterStore;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.util.comparators.master.ComparatorByNameOfMaster;
import com.senlaCourse.autoservice.util.comparators.master.ComparatorByStateOfMaster;
import com.senlaCourse.autoservice.stores.MasterStoreImpl;
import com.senlaCourse.autoservice.util.Printer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MasterServiceImpl implements IMasterService {

    private static MasterServiceImpl instance = null;

    protected MasterServiceImpl() {
    }

    ;

    public static MasterServiceImpl getInstance() {
        if (instance == null) {
            instance = new MasterServiceImpl();
        }
        return instance;
    }

    private Printer printer = new Printer();
    private final ComparatorByNameOfMaster comparatorByNameOfMaster = new ComparatorByNameOfMaster();
    private final ComparatorByStateOfMaster comparatorByStateOfMaster = new ComparatorByStateOfMaster();
    private IMasterStore masterStore = new MasterStoreImpl();

    @Override
    public void addMaster(Master master) {
        masterStore.add(master);
    }

    @Override
    public void deleteMaster(Master master) {
        masterStore.delete(master);
    }

    public List<Master> sortMaster(Comparator comparator) {
        List<Master> mastersSorted = new ArrayList<>(masterStore.getAll());
        mastersSorted.sort(comparator);
        return mastersSorted;
    }

    @Override
    public List<Master> sortByNameOfMaster() {
        List<Master> mastersSorted = sortMaster(comparatorByNameOfMaster);
        return mastersSorted;
    }

    @Override
    public List<Master> sortByStateFree() {
        List<Master> mastersSorted = sortMaster(comparatorByStateOfMaster);
        return mastersSorted;
    }

    @Override
    public List<Master> getMasterStore() {
        return masterStore.getAll();
    }

    @Override
    public List<Master> getFreeMasters() {
        List<Master> masters = new ArrayList<Master>();
        for (Master master : getMasterStore()) {
            if (master.getStateFree()) {
                masters.add(master);
            }
        }
        return masters;
    }
}
