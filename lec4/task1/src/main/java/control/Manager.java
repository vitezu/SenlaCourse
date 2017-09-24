package control;

import comparator.SortedByDateOfOrder;
import comparator.SortedByNameOfMaster;
import comparator.SortedByPrice;
import comparator.SortedByStateOfMaster;
import repairs.Master;
import repairs.Place;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager {
    List<Place> places = new ArrayList<Place>(15);
    List<Place> freePlaces = new ArrayList<Place>();
    List<Order> orders = new ArrayList<Order>();
    List<Master> masters = new ArrayList<Master>();

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
        Collections.sort(orders, new SortedByDateOfOrder());
        System.out.println("\n SortedByDateOfOrder");
        for(Order product : orders)
            System.out.println(product.toString());
    }
    public void sortedByPriceOfOrder () {
        Collections.sort(orders, new SortedByPrice());
        System.out.println("\n SortedByPrice");
        for(Order product : orders){
            System.out.println(product.toString());
        }
    }
    public void sortedByNameOfMaster() {
        Collections.sort(masters, new SortedByNameOfMaster());
        System.out.println("\n Sorted by name master");
        for (Master list : masters) {
            System.out.println(list.toString());
        }
    }
    public void sortedByStateOfMaster() {
        Collections.sort(masters, new SortedByStateOfMaster());
        System.out.println("\n Sorted by state master");
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