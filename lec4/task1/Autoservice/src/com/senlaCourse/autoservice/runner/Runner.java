package com.senlaCourse.autoservice.runner;

import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.util.DateUtil;
import com.senlaCourse.autoservice.util.Printer;
import com.senlaCourse.autoservice.util.WriterReaderFile;

public class Runner {
    private final static String MESSAGE1 = "Sorted by name of master";
    private final static String MESSAGE2 = "Sorted by state free of master";
    private final static String MESSAGE3 = "Calculate free places in future";
    private final static String MESSAGE4 = "Free places";
    private final static String MESSAGE5 = "Sorted by date of order";
    private final static String MESSAGE6 = "Sorted by price of order";
    private final static String MESSAGE7 = "Sorted by date of start";
    private final static String MESSAGE8 = "Sorted by date of execution";
    private final static String MESSAGE9 = "Sorted by price of operation order";
    private final static String MESSAGE10 = "Sorted by date of operation order";
    private final static String MESSAGE11 = "Sorted by date of execution operation order";
    private static final String FILE_PLACE = "places.txt";
    private static final String FILE_ORDER = "orders.txt";
    private static final String FILE_MASTER = "masters.txt";
    private Printer printer = new Printer();

    public static void main(String[] args) throws Exception {

        IController controller = new ControllerImpl();
        Printer printer = new Printer();
        DateUtil du = new DateUtil();
        WriterReaderFile writerReaderFile = new WriterReaderFile();

        Master master1 = new Master("Pupkin");
        Master master2 = new Master("Ivanov");
        Place place1 = new Place(1, true);
        Place place2 = new Place(2, true);

        controller.addPlace(place1);
        controller.addPlace(place2);
        controller.addMaster(master1);
        controller.addMaster(master2);
        controller.createOrder(1, 20f);
        controller.createOrder(2, 30f);
        controller.createOrder(3, 40f);

        printer.printMasters(MESSAGE1, controller.sortByNameOfMaster());
        printer.printMasters(MESSAGE2, controller.sortByStateFree());
        printer.printPlaces(MESSAGE4, controller.getFreePlaces());
        printer.printOrders(MESSAGE5, controller.sortByDateOfOrder());
        printer.printOrders(MESSAGE6, controller.sortByPriceOfOrder());
        printer.printOrders(MESSAGE7, controller.sortByDateOfPlannedExecution());
        printer.printOrders(MESSAGE8, controller.sortByDateOfExecution());

        writerReaderFile.writeToFile("place.txt", controller.convertInArrayOfPlaces());
        writerReaderFile.readFromFile();
    }
}



