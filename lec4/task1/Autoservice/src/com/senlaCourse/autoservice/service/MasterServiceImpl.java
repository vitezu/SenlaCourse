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
    private Printer printer = new Printer();
    private final ComparatorByNameOfMaster comparatorByNameOfMaster = new ComparatorByNameOfMaster();
    private final ComparatorByStateOfMaster comparatorByStateOfMaster = new ComparatorByStateOfMaster();
    private final String MESSAGE1 = "Sorted by name of master";
    private final String MESSAGE2 = "Sorted by state free of master";
    private IMasterStore masterStore = new MasterStoreImpl();

    @Override
    public void addMaster(Master master) {
        masterStore.add(master);
    }

    @Override
    public void deleteMaster(Master master) {
        masterStore.delete(master);
    }

    public List<Master> sortMaster(Comparator comparator, String mesage) {
        List<Master> mastersSorted = new ArrayList<>(masterStore.getAll());
        mastersSorted.sort(comparator);
        printer.printMessage(mesage);
        return mastersSorted;
    }

    @Override
    public void sortByNameOfMaster() {
        List<Master> mastersSorted = sortMaster(comparatorByNameOfMaster, MESSAGE1);
        for (Master master : mastersSorted)
            printer.printObject(master);
    }


    @Override
    public void sortByStateFree() {
        List<Master> mastersSorted = sortMaster(comparatorByStateOfMaster, MESSAGE2);
        for (Master master : mastersSorted)
            printer.printObject(master);
    }

    @Override
    public List<Master> getMasterStore() {
        return masterStore.getAll();
    }

    @Override
    public List<Master> getFreeMasters() {
        List<Master> masters = new ArrayList<Master>();
//        printer.printMessage(MESSAGE2);
        for (Master master : getMasterStore()) {
            if (master.getStateFree()) {
                masters.add(master);
//                printer.printObject(master);
            }
        }
        return masters;
    }
}
