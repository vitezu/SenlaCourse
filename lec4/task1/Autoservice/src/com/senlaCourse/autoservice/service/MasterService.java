package com.senlaCourse.autoservice.service;

import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.service.comparators.master.ComparatorByNameOfMaster;
import com.senlaCourse.autoservice.service.comparators.master.ComparatorByStateOfMaster;
import com.senlaCourse.autoservice.util.Printer;

import java.util.ArrayList;
import java.util.Collections;

public class MasterService {
    Printer printer = new Printer();
    ComparatorByNameOfMaster comparatorByNameOfMaster = new ComparatorByNameOfMaster();
    ComparatorByStateOfMaster comparatorByStateOfMaster = new ComparatorByStateOfMaster();
    private final String MESSAGE1 = "Sorted by name of master";
    private final String MESSAGE2 = "Sorted by state free of master";


    public void sortByNameOfMaster(ArrayList<Master> masters) {
        ArrayList<Master> mastersSorted = (ArrayList<Master>) masters.clone();
        Collections.sort(mastersSorted, comparatorByNameOfMaster);
        printer.printLineEmpty();
        printer.printMessage(MESSAGE1);
        for (Master master : mastersSorted)
            printer.printObject(master);
    }
    public void sortByStateFree (ArrayList<Master> masters)  {
        ArrayList<Master> mastersSorted = (ArrayList<Master>) masters.clone();
        Collections.sort(mastersSorted, comparatorByStateOfMaster);
        printer.printLineEmpty();
        printer.printMessage(MESSAGE2);
        for (Master master : mastersSorted)
            printer.printObject(master);
    }
}
