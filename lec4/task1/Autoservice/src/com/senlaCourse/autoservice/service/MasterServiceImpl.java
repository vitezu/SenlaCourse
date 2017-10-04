package com.senlaCourse.autoservice.service;

import com.senlaCourse.autoservice.api.service.IMasterService;
import com.senlaCourse.autoservice.api.story.IMasterStore;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.service.comparators.master.ComparatorByNameOfMaster;
import com.senlaCourse.autoservice.service.comparators.master.ComparatorByStateOfMaster;
import com.senlaCourse.autoservice.stores.MasterStoreImpl;
import com.senlaCourse.autoservice.util.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MasterServiceImpl implements IMasterService {
    Printer printer = new Printer();
    ComparatorByNameOfMaster comparatorByNameOfMaster = new ComparatorByNameOfMaster();
    ComparatorByStateOfMaster comparatorByStateOfMaster = new ComparatorByStateOfMaster();
    private final String MESSAGE1 = "Sorted by name of master";
    private final String MESSAGE2 = "Sorted by state free of master";
    private IMasterStore masterStore = new MasterStoreImpl();


    public void addMaster(Master master) {
        masterStore.add(master);
    }

    public void deleteMaster (Master master) {
        masterStore.delete(master);
    }
    public void sortByNameOfMaster(ArrayList<Master> masters) {
        List<Master> mastersSorted = (ArrayList<Master>) masters.clone();
        Collections.sort(mastersSorted, comparatorByNameOfMaster);
        printer.printLineEmpty();
        printer.printMessage(MESSAGE1);
        for (Master master : mastersSorted)
            printer.printObject(master);
    }
    public void sortByStateFree (ArrayList<Master> masters)  {
        List<Master> mastersSorted = (List<Master>) masters.clone();
        Collections.sort(mastersSorted, comparatorByStateOfMaster);
        printer.printLineEmpty();
        printer.printMessage(MESSAGE2);
        for (Master master : mastersSorted)
            printer.printObject(master);
    }
}
