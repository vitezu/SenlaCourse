package com.senlaCourse.autoservice.runner;

import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.util.DateUtil;
import com.senlaCourse.autoservice.util.Printer;
import com.senlaCourse.autoservice.util.WriterReaderFile;

public class Runner {
    private static final String FILE_PLACE = "places.txt";
    private static final String FILE_ORDER = "orders.txt";
    private static final String FILE_MASTER = "masters.txt";

    public static void main(String[] args) throws Exception {

        IController controller = new ControllerImpl();
        Printer printer = new Printer();
        DateUtil du = new DateUtil();
        WriterReaderFile writerReaderFile = new WriterReaderFile(FILE_PLACE);

        Master master1 = new Master("Pupkin");
        Master master2 = new Master("Ivanov");
        Place place1 = new Place(1, true);
        Place place2 = new Place(2, false);

        controller.addPlace(place1);
        controller.addPlace(place2);
        controller.addMaster(master1);
        controller.addMaster(master2);
        controller.createOrder(1, 20f);
        controller.createOrder(2, 30f);
        controller.createOrder(3, 40f);

        controller.sortByNameOfMaster();

        controller.getAllOrders();
        printer.printLineEmpty();
        controller.sortByPriceOfOrder();
        printer.printLineEmpty();
        controller.sortByDateOfOrder();
        printer.printLineEmpty();
        controller.sortByDateOfExecution();
        printer.printLineEmpty();
        controller.sortByDateOfPlannedExecution();

        printer.printLineEmpty();
        controller.sortByPriceOfOperationOrder();
        printer.printLineEmpty();
        controller.sortByDateOfExecutionOperationOrder();
        printer.printLineEmpty();
        controller.sortByDateOfOperationOrder();

        printer.printLineEmpty();
        controller.sortByNameOfMaster();
        printer.printLineEmpty();
        controller.sortByStateFree();
        printer.printLineEmpty();
        controller.getFreePlaces();
        printer.printLineEmpty();

        writerReaderFile.writeToFile(controller.convertInArrayOfPlaces());
        writerReaderFile.readFromFile();
    }
}



