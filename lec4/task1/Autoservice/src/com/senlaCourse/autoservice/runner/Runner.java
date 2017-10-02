package com.senlaCourse.autoservice.runner;



import com.danco.training.TextFileWorker;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.service.MasterService;
import com.senlaCourse.autoservice.service.OrderService;
import com.senlaCourse.autoservice.service.PlaceService;
import com.senlaCourse.autoservice.stores.MasterStoreImpl;
import com.senlaCourse.autoservice.stores.OrderStoreImpl;
import com.senlaCourse.autoservice.stores.PlaceStoreImpl;
import com.senlaCourse.autoservice.util.DateUtil;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Runner {
    public static void main(String[] args) throws Exception {
        OrderStoreImpl orderStore = new OrderStoreImpl();
        OrderService orderService = new OrderService();
        MasterStoreImpl masterStore = new MasterStoreImpl();
        MasterService masterService = new MasterService();
        PlaceStoreImpl placeStore = new PlaceStoreImpl();
        PlaceService placeService = new PlaceService();
        DateUtil du = new DateUtil();

        Order order1 = new Order(1, du.create("01/10/2017"), null, 50.0f);
        Order order2 = new Order(2, du.create("11/08/2017"), null, 70.0f);
        Order order3 = new Order(3, du.create("13/07/2017"), null, 65.0f);
        Master master1 = new Master("Pupkin", true);
        Master master2 = new Master("Ivanov", true);
        Place place1 = new Place(1, true);
        Place place2 = new Place(2, true);


        orderStore.add(order1);
        orderStore.add(order2);
        orderStore.add(order3);
        orderService.sortByPriceOfOrder(orderStore.getOrders());
        orderService.sortByDateOfOrder(orderStore.getOrders());
        orderService.sortByDateOfExecution(orderStore.getOrders());
        orderService.sortByDateOfPlannedExecution(orderStore.getOrders());
        orderService.operateOrder(order1);
        orderService.sortByPriceOfOperationOrder(orderStore.getOrders());
        orderService.sortByDateOfOperationOrder(orderStore.getOrders());
        orderService.operateOrder(order1);
        orderService.operateOrder(order2);


        masterStore.add(master1);
        masterStore.add(master2);
        masterService.sortByNameOfMaster(masterStore.getMasters());
        masterService.sortByStateFree(masterStore.getMasters());

        master1.setOrder(order1);

        placeStore.add(place1);
        placeStore.add(place2);
        placeService.calcFreePlaces(placeStore.getPlaces(), masterStore.getMasters());
        placeService.getFreePlaces(placeStore.getPlaces());

        String[] arrayPlaces = new String[placeStore.getPlaces().size()];
        for (int i = 0; i < placeStore.getPlaces().size(); i++) {
            arrayPlaces[i] = String.valueOf(placeStore.getPlaces().get(i));
        }

        String[] arrayMasters = new String[masterStore.getMasters().size()];
        for (int i = 0; i < masterStore.getMasters().size(); i++) {
            arrayMasters[i] = String.valueOf(masterStore.getMasters().get(i));
        }

        String[] arrayOrders = new String[orderStore.getOrders().size()];
        for (int i = 0; i < orderStore.getOrders().size(); i++) {
            arrayOrders[i] = String.valueOf(orderStore.getOrders().get(i));
        }

        //Test write/rea file
        final String TEST_FILE = args[0];
        final String[] testValues = arrayOrders;

        // Create new file
        Path filePath = Paths.get(TEST_FILE);
        if (!Files.exists(filePath)){
            Files.createFile(filePath);
        }

        // Work example
        try {
            TextFileWorker fileWorker = new TextFileWorker(TEST_FILE);
            fileWorker.writeToFile(testValues);
            Object[] readedValues = fileWorker.readFromFile();
            for (Object s : readedValues) {
                System.out.println(s);
            }

            // Check result
            for (int i = 0; i < testValues.length; i++) {

                if (!readedValues[i].equals(testValues[i])) {
                    throw new RuntimeException("Error. Not equal values: " + readedValues[i] + " and " + testValues[i]);
                }
            }
        } finally {
//            Files.deleteIfExists(filePath);
        }
    }
}
