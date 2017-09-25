package com.senlaCourse.autoservice.control;

import com.senlaCourse.autoservice.comparator.SortedByDateOfOrder;
import com.senlaCourse.autoservice.comparator.SortedByNameOfMaster;
import com.senlaCourse.autoservice.comparator.SortedByPrice;
import com.senlaCourse.autoservice.comparator.SortedByStateOfMaster;
import com.senlaCourse.autoservice.repairs.Master;
import com.senlaCourse.autoservice.repairs.Place;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager {
    private final String MESSANGE1 = "Sorted By Date of order";
    private final String MESSANGE2 = "Sorted By Price of order";
    private final String MESSANGE3 = "Sorted by name master";
    private final String MESSANGE4 = "Sorted by state master";

    private List<Place> places = new ArrayList<Place>(15);
    private List<Place> freePlaces = new ArrayList<Place>();
    private List<Order> orders = new ArrayList<Order>();
    private List<Master> masters = new ArrayList<Master>();

    public void addPlace(Place place) {
        {
            places.add(place);
        }
    }
    public void deletePlace(Place place) {
        {
            places.remove(place);
        }
    }
    public void deleteOrder(Order order) {
        {
            places.remove(order);
        }
    }
    public void deleteMaster(Master master) {
        masters.remove(master);
    }
    public void addOrder(Order order) {
        {
            orders.add(order);
        }
    }
    public void addMaster(Master master) {
        masters.add(master);
    }
    public void sortedByDateOfOrder () {
        System.out.println();
        Collections.sort(orders, new SortedByDateOfOrder());
        System.out.println(MESSANGE1);
        for(Order product : orders)
            System.out.println(product.toString());
    }
    public void sortedByPriceOfOrder () {
        System.out.println();
        Collections.sort(orders, new SortedByPrice());
        System.out.println(MESSANGE2);
        for(Order product : orders){
            System.out.println(product.toString());
        }
    }
    public void sortedByNameOfMaster() {
        System.out.println();
        Collections.sort(masters, new SortedByNameOfMaster());
        System.out.println(MESSANGE3);
        for (Master list : masters) {
            System.out.println(list.toString());
        }
    }
    public void sortedByStateOfMaster() {
        System.out.println();
        Collections.sort(masters, new SortedByStateOfMaster());
        System.out.println(MESSANGE4);
        for (Master list : masters)
            System.out.println(list.toString());
    }
    public List<Place> getFreePlaces() {
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).getStateFree() == true) {
                freePlaces.add(places.get(i));
            } else {
                break;
            }
        }
        return freePlaces;
    }
}