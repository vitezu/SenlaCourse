package com.senlaCourse.autoservice.runner;

import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.util.DateUtil;
import com.senlaCourse.autoservice.util.Printer;
import com.senlaCourse.autoservice.util.WriterReaderFile;

import java.util.Date;

public class Runner {
    private static final String FILE_PLACE =  "places.txt";
    private static final String FILE_ORDER =  "orders.txt";
    private static final String FILE_MASTER =  "masters.txt";

    public static void main(String[] args) throws Exception {

        IController controller = new ControllerImpl();
        Printer printer = new Printer();
        DateUtil du = new DateUtil();
        WriterReaderFile writerReaderFile = new WriterReaderFile();

        Order order1 = new Order(1, du.create("01/10/2017"), du.create("02/11/2017"), 45.0f);
        Order order2 = new Order(2, du.create("11/08/2017"), du.create("05/10/2017"), 70.0f);
        Order order3 = new Order(3, du.create("13/07/2017"), du.create("15/09/2017"), 65.0f);
        Master master1 = new Master("Pupkin", true);
        Master master2 = new Master("Ivanov", true);
        Place place1 = new Place(1, true);
        Place place2 = new Place(2, false);

        controller.addPlace(place1);
        controller.addPlace(place2);
        controller.addOrder(order1);
        controller.addOrder(order2);
        controller.addOrder(order3);
        controller.addMaster(master1);
        controller.addMaster(master2);

        controller.getAllOrders();
        System.out.println(controller.getAllPlaces());


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

        controller.operateOrder(order1);
        controller.operateOrder(order2);
        printer.printLineEmpty();
        controller.sortByPriceOfOperationOrder();
        printer.printLineEmpty();
        controller.sortByDateOfExecutionOperationOrder();
        printer.printLineEmpty();
        controller.sortByDateOfOperationOrder();

        master1.setOrder(order1);
        controller.closeOrder(order1, du.create("11/10/2017"));
        printer.printLineEmpty();
        controller.sortByNameOfMaster();
        printer.printLineEmpty();
        controller.sortByStateFree();
        printer.printLineEmpty();
        controller.getFreePlaces();
        printer.printLineEmpty();

//        controller.calcFreePlaces();

        writerReaderFile.worker(controller.convertInArrayOfPlaces(), FILE_PLACE);
        writerReaderFile.worker(controller.convertInArrayOfOrders(), FILE_ORDER);
        writerReaderFile.worker(controller.convertInArrayOfMasters(), FILE_MASTER);

    }
}
