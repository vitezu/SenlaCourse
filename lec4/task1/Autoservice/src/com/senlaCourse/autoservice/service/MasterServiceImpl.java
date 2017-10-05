package com.senlaCourse.autoservice.service;

import com.senlaCourse.autoservice.api.service.IMasterService;
import com.senlaCourse.autoservice.api.story.IMasterStore;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.util.comparators.master.ComparatorByNameOfMaster;
import com.senlaCourse.autoservice.util.comparators.master.ComparatorByStateOfMaster;
import com.senlaCourse.autoservice.stores.MasterStoreImpl;
import com.senlaCourse.autoservice.util.Printer;

import java.util.ArrayList;
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

    @Override
    public void sortByNameOfMaster() {
        List<Master> mastersSorted = new ArrayList<>(masterStore.getAll());
        mastersSorted.sort(comparatorByNameOfMaster);
        printer.printMessage(MESSAGE1);
        for (Master master : mastersSorted)
            printer.printObject(master);
    }

    @Override
    public void sortByStateFree() {
        List<Master> mastersSorted = new ArrayList<>(masterStore.getAll());
        mastersSorted.sort(comparatorByStateOfMaster);
        printer.printMessage(MESSAGE2);
        for (Master master : mastersSorted)
            printer.printObject(master);
    }

    @Override
    public List<Master> getMasterStore() {
        return masterStore.getAll();
    }
}
