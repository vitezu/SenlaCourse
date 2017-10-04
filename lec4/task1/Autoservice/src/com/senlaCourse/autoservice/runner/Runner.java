package com.senlaCourse.autoservice.runner;

import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.util.DateUtil;

public class Runner {
    public static void main(String[] args) throws Exception {
        IController controller = new ControllerImpl();
        DateUtil du = new DateUtil();

        Order order1 = new Order(1, du.create("01/10/2017"), null, 50.0f);
        Order order2 = new Order(2, du.create("11/08/2017"), null, 70.0f);
        Order order3 = new Order(3, du.create("13/07/2017"), null, 65.0f);
        Master master1 = new Master("Pupkin", true);
        Master master2 = new Master("Ivanov", true);
        Place place1 = new Place(1, true);
        Place place2 = new Place(2, true);

        controller.addPlace(place1);
        controller.addPlace(place2);
        controller.addOrder(order1);
        controller.addOrder(order2);
        controller.addOrder(order3);
        controller.sortByPriceOfOrder();
        controller.sortByDateOfOrder();
        controller.sortByDateOfExecution();
        controller.sortByDateOfPlannedExecution();
        controller.operateOrder(order1);
        controller.sortByPriceOfOperationOrder();
        controller.sortByDateOfOperationOrder();
        controller.operateOrder(order1);
        controller.operateOrder(order2);
        controller.addMaster(master1);
        controller.addMaster(master2);
        controller.sortByNameOfMaster();
        controller.sortByStateFree();
        master1.setOrder(order1);

//        System.out.println(controller.getPlaceService().getplaceStore().getPlaces());
//
//        controller.deletePlace(place2);
//        System.out.println(controller.getPlaceService().getplaceStore().getPlaces());


//        controller.calcFreePlaces();
//        controller.getFreePlaces();


    }
}
