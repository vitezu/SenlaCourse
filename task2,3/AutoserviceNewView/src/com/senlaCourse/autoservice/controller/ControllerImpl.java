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
import config.Config;
import org.apache.log4j.Logger;

import java.sql.Time;
import java.util.*;

public class ControllerImpl implements IController {

    private static ControllerImpl instance = null;

    protected ControllerImpl() {
    }

    public static ControllerImpl getInstance() {
        if (instance == null) {
            instance = new ControllerImpl();
        }
        return instance;
    }

    private final String MESSAGE5 = "Sorted by price of operation order";
    private final String MESSAGE6 = "Sorted by date of operation order";
    private final String MESSAGE7 = "Sorted by date of execution operation order";

    private final ComparatorByDateOfOrder comparatorByDateOfOrder = new ComparatorByDateOfOrder();
    private final ComparatorByPriceOfOrder comparatorByPriceOfOrder = new ComparatorByPriceOfOrder();
    private final ComparatorByDateOfStart comparatorByDateOfStart = new ComparatorByDateOfStart();
    private final ComparatorByDateOfExecution comparatorByDateOfExecution = new ComparatorByDateOfExecution();
    private final ComparatorByNameOfMaster comparatorByNameOfMaster = new ComparatorByNameOfMaster();
    private final ComparatorByStateOfMaster comparatorByStateOfMaster = new ComparatorByStateOfMaster();

    private Logger logger = Logger.getLogger(ControllerImpl.class);
    private Printer printer = new Printer();
    private IOrderStore orderStore = new OrderStoreImpl();
    private PlaceStoreImpl placeStore = new PlaceStoreImpl();
    private IMasterStore masterStore = new MasterStoreImpl();
    private DateUtil dateUtil = new DateUtil();
    private Properties props = new Properties();

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
        Config.getInstance().loadProperties();
        props = Config.getInstance().getProperty();
        Boolean permit = Boolean.valueOf(props.getProperty("permitDelOrder"));
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
        Config.getInstance().loadProperties();
        props = Config.getInstance().getProperty();
        Boolean permit = Boolean.valueOf(props.getProperty("permitEditFreePlace"));
        if (permit) {
            placeStore.add(place);
        } else {
            System.out.println("Please, permit for add place");
        }
    }

    @Override
    public void deletePlace(Place place) {
        Config.getInstance().loadProperties();
        props = Config.getInstance().getProperty();
        Boolean permit = Boolean.valueOf(props.getProperty("permitEditFreePlace"));
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
    public void shiftTimeEnd(Date time, Order order) {
        Config.getInstance().loadProperties();
        props = Config.getInstance().getProperty();
        Boolean permit = Boolean.valueOf(props.getProperty("enableShiftTime"));
        if (permit) {
            Long time1 = order.getDateOfExecution().getTime();
            Long time2 = time.getTime();
            Long shiftTime = time1 + time2;
            order.setDateOfExecution(dateUtil.convertToDate(shiftTime));
        } else {
            System.out.println("Please, permit for shift time");
        }
    }

    @Override
    public void cloneOrder (Order order) {
        {
            Integer index = 0;
            boolean flag = false;
            for (int i=0; i<getOrderStore().size(); i++){
                if (getOrderStore().get(i).getNum() == order.getNum()){
                    flag = true;
                    index = i;
                }
            }
            if (flag) {
                try {
                    Order clonedOrder = (Order) getOrderStore().get(index).clone();
                    System.out.println("Clone is successfully");
                    addOrder(clonedOrder);
                } catch (CloneNotSupportedException e) {
                    logger.error("Order can not cloned");
                }
            }
            else {
                System.out.println("You cannot clone this order!");
            }
        }
    }
}
