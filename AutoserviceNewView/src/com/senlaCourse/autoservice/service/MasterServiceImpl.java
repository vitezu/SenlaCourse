package com.senlaCourse.autoservice.service;

import com.senlaCourse.autoservice.api.service.IMasterService;
import com.senlaCourse.autoservice.api.story.IMasterStore;
import com.senlaCourse.autoservice.dependancy.DependancyInjection;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.util.comparators.master.ComparatorByNameOfMaster;
import com.senlaCourse.autoservice.util.comparators.master.ComparatorByStateOfMaster;
import com.senlaCourse.autoservice.stores.MasterStoreImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MasterServiceImpl implements IMasterService {

    private static final ComparatorByNameOfMaster COMPARATOR_BY_NAME_OF_MASTER = new ComparatorByNameOfMaster();
    private static final ComparatorByStateOfMaster COMPARATOR_BY_STATE_OF_MASTER = new ComparatorByStateOfMaster();
    private IMasterStore masterStore = (IMasterStore) DependancyInjection.getInstance().load(IMasterStore.class);

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
        List<Master> mastersSorted = sortMaster(COMPARATOR_BY_NAME_OF_MASTER);
        return mastersSorted;
    }

    @Override
    public List<Master> sortByStateFree() {
        List<Master> mastersSorted = sortMaster(COMPARATOR_BY_STATE_OF_MASTER);
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
            return null;
        }
        return master;
    }
}
