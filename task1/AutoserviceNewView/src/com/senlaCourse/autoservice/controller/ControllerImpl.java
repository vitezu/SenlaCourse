package com.senlaCourse.autoservice.controller;

import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.api.story.IMasterStore;
import com.senlaCourse.autoservice.api.story.IOrderStore;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.stores.MasterStoreImpl;
import com.senlaCourse.autoservice.stores.OrderStoreImpl;
import com.senlaCourse.autoservice.stores.PlaceStoreImpl;
import com.senlaCourse.autoservice.util.DateUtil;
import com.senlaCourse.autoservice.util.Printer;
import com.senlaCourse.autoservice.util.StateOrder;
import com.senlaCourse.autoservice.util.comparators.master.ComparatorByNameOfMaster;
import com.senlaCourse.autoservice.util.comparators.master.ComparatorByStateOfMaster;
import com.senlaCourse.autoservice.util.comparators.order.ComparatorByDateOfExecution;
import com.senlaCourse.autoservice.util.comparators.order.ComparatorByDateOfOrder;
import com.senlaCourse.autoservice.util.comparators.order.ComparatorByDateOfStart;
import com.senlaCourse.autoservice.util.comparators.order.ComparatorByPriceOfOrder;
import com.senlaCourse.autoservice.util.csv.CsvUtil;
import com.senlaCourse.autoservice.util.serialization.Serialization;
import com.sun.org.apache.xpath.internal.operations.Bool;
import config.Config;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class ControllerImpl implements IController {
    private final String MESSAGE5 = "Sorted by price of operation order";
    private final String MESSAGE6 = "Sorted by date of operation order";
    private final String MESSAGE7 = "Sorted by date of execution operation order";
    private final String csvMaster = "master.csv";
    private final String csvPlace = "place.csv";
    private final String csvOrder = "order.csv";

    private final ComparatorByDateOfOrder comparatorByDateOfOrder = new ComparatorByDateOfOrder();
    private final ComparatorByPriceOfOrder comparatorByPriceOfOrder = new ComparatorByPriceOfOrder();
    private final ComparatorByDateOfStart comparatorByDateOfStart = new ComparatorByDateOfStart();
    private final ComparatorByDateOfExecution comparatorByDateOfExecution = new ComparatorByDateOfExecution();
    private final ComparatorByNameOfMaster comparatorByNameOfMaster = new ComparatorByNameOfMaster();
    private final ComparatorByStateOfMaster comparatorByStateOfMaster = new ComparatorByStateOfMaster();

    private Calendar calendar = Calendar.getInstance();
    private Printer printer = new Printer();
    private IOrderStore orderStore = new OrderStoreImpl();
    private PlaceStoreImpl placeStore = new PlaceStoreImpl();
    private IMasterStore masterStore = new MasterStoreImpl();
    private DateUtil dateUtil = new DateUtil();
    private Properties props = new Properties();
    private Logger logger = Logger.getLogger(ControllerImpl.class);
    private Serialization ser;
    private static ControllerImpl instance = null;

    protected ControllerImpl() {
    }

    public static ControllerImpl getInstance() {
        if (instance == null) {
            instance = new ControllerImpl();
        }
        return instance;
    }


    @Override
    public void addMaster(Master master) {
        masterStore.add(master);
    }

    @Override
    public void deleteMaster(Master master) {
        masterStore.delete(master);
    }

    public List<Master> sortMaster(Comparator comparator) {
        List<Master> mastersSorted = new ArrayList<>(masterStore.getAll());
        mastersSorted.sort(comparator);
        return mastersSorted;
    }

    @Override
    public List<Master> sortByNameOfMaster() {
        List<Master> mastersSorted = sortMaster(comparatorByNameOfMaster);
        return mastersSorted;
    }

    @Override
    public List<Master> sortByStateFree() {
        List<Master> mastersSorted = sortMaster(comparatorByStateOfMaster);
        return mastersSorted;
    }

    @Override
    public List<Master> getMasterStore() {
        return masterStore.getAll();
    }

    @Override
    public List<Master> getFreeMasters() {
        List<Master> masters = new ArrayList<Master>();
        for (Master master : getMasterStore()) {
            if (master.getStateFree()) {
                masters.add(master);
            }
        }
        return masters;
    }

    @Override
    public Master getMasterExecuteOrder(Order order) {
        Master master = new Master();
        for (Master mas : getMasterStore()) {
            if (mas.getOrder().getNum().equals(order.getNum())) {
                master = mas;
            }
        }
        if (master.getName() == null) {
            System.out.println("Master with this num of  order does not exist");
            return null;
        }
        return master;
    }


    @Override
    public void addOrder(Order order) {
        orderStore.add(order);
    }

    @Override
    public void deleteOrder(Order order) {
        Boolean permit = Config.getInstance().getBoolProperties("permitDelOrder");
        if (permit) {

            orderStore.delete(order);
            order.setStateOrder(StateOrder.DELETED);
        } else {
            System.out.println("Please, permit for delete order");
        }
    }

    public List<Order> ordersSorted(Comparator comparator) {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(comparator);
        return ordersSorted;
    }

    @Override
    public List<Order> sortByDateOfOrder() {
        List<Order> ordersSorted = ordersSorted(comparatorByDateOfOrder);
        return ordersSorted;
    }

    @Override
    public List<Order> sortByPriceOfOrder() {
        List<Order> ordersSorted = ordersSorted(comparatorByPriceOfOrder);
        return ordersSorted;
    }

    @Override
    public List<Order> sortByDateOfStart() {
        List<Order> ordersSorted = ordersSorted(comparatorByDateOfStart);
        return ordersSorted;
    }

    @Override
    public List<Order> sortByDateOfExecution() {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(comparatorByDateOfExecution);
        return ordersSorted;
    }

    @Override
    public void sortByPriceOfOperationOrder() {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(comparatorByPriceOfOrder);
        printer.printMessage(MESSAGE5);
        for (Order order : ordersSorted) {
            if (order.getStateOrder() == StateOrder.OPERATING) printer.printObject(order);
        }
    }

    @Override
    public void sortByDateOfExecutionOperationOrder() {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(comparatorByDateOfExecution);
        printer.printMessage(MESSAGE7);
        for (Order order : ordersSorted) {
            if (order.getStateOrder() == StateOrder.OPERATING) printer.printObject(order);
        }
    }

    @Override
    public void sortByDateOfOperationOrder() {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(comparatorByDateOfOrder);
        printer.printMessage(MESSAGE6);
        for (Order order : ordersSorted) {
            if (order.getStateOrder() == StateOrder.OPERATING) printer.printObject(order);
        }
    }

    @Override
    public void cancelOrder(Order order) {
        order.setStateOrder(StateOrder.CANCELED);
    }

    @Override
    public void closeOrder(Order order, Date date) {
        order.setStateOrder(StateOrder.COMPLETED);
        order.setDateOfExecution(date);
    }

    @Override
    public void operateOrder(Order order) {
        order.setStateOrder(StateOrder.OPERATING);
    }

    @Override
    public List<Order> getOrderStore() {
        return orderStore.getAll();
    }

    @Override
    public Order getOrderExecuteMaster(Master master) {
        Order order = new Order();
        for (Order or : getOrderStore()) {
            if (or.getMaster().getName().equals(master.getName())) {
                order = or;
            }
        }
        if (order.getNum() == null) {
            System.out.println("Order with this name of master does not exist");
            return null;
        }
        return order;
    }

    @Override
    public List<Order> getOrdersIntervalTime(Date date1, Date date2) {
        List<Order> orders = new ArrayList<Order>();
        for (Order order : getOrderStore()) {
            if (date1.getTime() < order.getDateOfOrder().getTime() && order.getDateOfOrder().getTime() < date2.getTime()) {
                orders.add(order);
            }
        }
        if (orders.size() == 0) {
            System.out.println("No orders in this interval time");
        }
        return orders;
    }

    @Override
    public void addPlace(Place place) {
        Boolean permit = Config.getInstance().getBoolProperties("permitEditFreePlace");
        if (permit) {
            placeStore.add(place);
        } else {
            System.out.println("Please, permit for add place");
        }
    }

    @Override
    public void deletePlace(Place place) {
        Config.getInstance().loadProperties();
        Boolean permit = Config.getInstance().getBoolProperties("permitEditFreePlace");
        if (permit) {
            placeStore.delete(place);
        } else {
            System.out.println("Please, permit for delete place");
        }
    }

    @Override
    public Integer calcFreePlaces() {
        Integer countFreePlace;
        Integer countFreeMaster;

        countFreePlace = getFreePlaces().size();
        countFreeMaster = ControllerImpl.getInstance().getFreeMasters().size();
        return (countFreeMaster + countFreePlace) / 2;
    }

    @Override
    public List<Place> getFreePlaces() {
        List<Place> places = new ArrayList<Place>();
        for (Place place : getPlaceStore()) {
            if (place.getStateFree()) {
                places.add(place);
            }
        }
        return places;
    }

    @Override
    public List<Place> getPlaceStore() {
        return placeStore.getAll();
    }

    @Override
    public void shiftTimeEnd(Integer hour, Order order) {
        {
            int index = 0;
            boolean flag = false;
            for (int i = 0; i < getOrderStore().size(); i++) {
                if (getOrderStore().get(i).getNum() == order.getNum()) {
                    flag = true;
                    index = i;
                }
            }
            if (flag) {
                Boolean permit = Config.getInstance().getBoolProperties("enableShiftTime");
                if (permit) {
                    calendar.setTime(getOrderStore().get(index).getDateOfExecution());
                    calendar.add(Calendar.HOUR, hour);
                    getOrderStore().get(index).setDateOfExecution(calendar.getTime());
                } else {
                    System.out.println("Please, permit for shift time");
                }
            } else {
                System.out.println("Num order is not correct");
            }
        }
    }

    @Override
    public void cloneOrder(Order order) {
        {
            Integer index = 0;
            boolean flag = false;
            for (int i = 0; i < getOrderStore().size(); i++) {
                if (getOrderStore().get(i).getNum() == order.getNum()) {
                    flag = true;
                    index = i;
                }
            }
            if (flag) {
                try {
                    Order clonedOrder = (Order) getOrderStore().get(index).clone();
                    clonedOrder.setId(getOrderStore().get(getOrderStore().size() - 1).getId() + 1);
                    System.out.println("Clone is successfully");
                    addOrder(clonedOrder);
                } catch (CloneNotSupportedException e) {
                    logger.error("Order can not cloned");
                }
            } else {
                System.out.println("You cannot clone this order!");
            }
        }
    }

    @Override
    public void serializeMaster(Integer id) {
        ser = new Serialization();
        ser.serialize(getMasterById(id), "masterSerial");
    }

    @Override
    public Master deserializeMaster() {
        ser = new Serialization();
        return (Master) ser.deserialize("masterSerial");
    }

    @Override
    public void serializePlace(Place place) {

        ser.serialize(place, "placeSerial");
    }

    @Override
    public Place deserializePlace() {

        return (Place) ser.deserialize("placeSerial");
    }

    @Override
    public void serializeOrder(Order order) {

        ser.serialize(order, "orderSerial");
    }

    @Override
    public Order deserializeOrder() {

        return (Order) ser.deserialize("orderSerial");
    }

    @Override
    public Master getMasterById(Integer id) {
        Master newMaster = new Master();
        for (Master master : getMasterStore())
            if (master.getId() == id) {
                newMaster = master;
            }
        return newMaster;
    }

    @Override
    public Place getPlaceById(Integer id) {
        Place newPlace = new Place();
        for (Place plaace : getPlaceStore())
            if (plaace.getId() == id) {
                newPlace = plaace;
            }
        return newPlace;
    }

    @Override
    public Order getOrderById(Integer id) {
        Order newOrder = new Order();
        for (Order order : getOrderStore())
            if (order.getId() == id) {
                newOrder = order;
            }
        return newOrder;
    }

    @Override
    public void exportMaster(Master master) {

        try (FileWriter writer = new FileWriter(csvMaster)) {

            List<Master> masters = ControllerImpl.getInstance().getMasterStore();

            CsvUtil.writeLine(writer, Arrays.asList("id", "name", "StateFree"));

            for (Master m : masters) {

                List<String> list = new ArrayList<>();
                list.add(String.valueOf(m.getId()));
                list.add(m.getName());
                list.add(String.valueOf(m.getStateFree()));

                CsvUtil.writeLine(writer, list);
            }
        } catch (IOException e) {
            logger.error("IO error");
        }
    }

    @Override
    public List<Master> importMasters() {
        List<Master> listMasters = getMasterStore();
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvMaster))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] masters = line.split(cvsSplitBy);
                Boolean flag = false;
                if (masters.length > 0) {
                    Master mas = new Master(Integer.parseInt(masters[0]), masters[1], Boolean.parseBoolean(masters[2]));
                    for (Master master : listMasters) {
                        if (master.getId() == Integer.parseInt(masters[0])) {
                            flag = true;
                            listMasters.set(listMasters.indexOf(master), mas);
                            break;
                        }
                    }
                    if (!flag) {
                        addMaster(mas);
                    }
                }
            }
        } catch (IOException e) {
            logger.error("IO error");
        }
        return listMasters;
    }

    @Override
    public void exportPlace(Place place) {

        try (FileWriter writer = new FileWriter(csvPlace)) {

            List<Place> places = ControllerImpl.getInstance().getPlaceStore();

            CsvUtil.writeLine(writer, Arrays.asList("id", "numPlace", "StateFree"));

            for (Place m : places) {

                List<String> list = new ArrayList<>();
                list.add(String.valueOf(m.getId()));
                list.add(String.valueOf(m.getNumPlace()));
                list.add(String.valueOf(m.getStateFree()));

                CsvUtil.writeLine(writer, list);
            }
        } catch (IOException e) {
            logger.error("IO error");
        }
    }

    @Override
    public List<Place> importPlaces() {
        List<Place> listPlaces = getPlaceStore();
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvPlace))) {

            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] places = line.split(cvsSplitBy);

                if (places.length > 0) {
                    Boolean flag = false;
                    Place pl = new Place(Integer.parseInt(places[0]), Integer.parseInt(places[1]), Boolean.parseBoolean(places[2]));
                    for (Place place : listPlaces) {
                        if (place.getId() == Integer.parseInt(places[0])) {
                            listPlaces.set(listPlaces.indexOf(place), pl);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        listPlaces.add(pl);
                    }
                }
            }
        } catch (IOException e) {
            logger.error("IO error");
        }
        return listPlaces;
    }

    @Override
    public void exportOrder(Order order) {

        try (FileWriter writer = new FileWriter(csvOrder)) {

            List<Order> orders = ControllerImpl.getInstance().getOrderStore();

            CsvUtil.writeLine(writer, Arrays.asList("id", "numOrder", "DateOfOrder", "DateOfStart", "DateOfExecution", "Price"));

            for (Order m : orders) {

                List<String> list = new ArrayList<>();
                list.add(String.valueOf(m.getId()));
                list.add(String.valueOf(m.getNum()));
                list.add(String.valueOf(m.getDateOfOrder()));
                list.add(String.valueOf(m.getDateOfStart()));
                list.add(String.valueOf(m.getDateOfExecution()));
                list.add(String.valueOf(m.getPrice()));

                CsvUtil.writeLine(writer, list);
            }
        } catch (IOException e) {
            logger.error("IO error");
        }
    }

    @Override
    public List<Order> importOrders() {

        String line = "";
        String cvsSplitBy = ",";
        List<Order> listOrders = getOrderStore();

        try (BufferedReader br = new BufferedReader(new FileReader(csvOrder))) {

            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] orders = line.split(cvsSplitBy);
                Boolean flag = false;
                if (orders.length > 0) {
                    Order o = new Order(Integer.parseInt(orders[0]), Integer.parseInt(orders[1]), dateUtil.create(orders[2]), dateUtil.create(orders[3]), dateUtil.create(orders[4]), Float.parseFloat(orders[5]));
                    for (Order order : listOrders) {
                        if (order.getId() == Integer.parseInt(orders[0])) {
                            listOrders.set(listOrders.indexOf(order), o);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        listOrders.add(o);
                    }
                }
            }
        } catch (IOException e) {
            logger.error("IO error");
        }
        return listOrders;
    }
}

