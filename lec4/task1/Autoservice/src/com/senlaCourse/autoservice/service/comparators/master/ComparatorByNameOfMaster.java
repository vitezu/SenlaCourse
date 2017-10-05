package com.senlaCourse.autoservice.service.comparators.master;

import com.senlaCourse.autoservice.entity.Master;

import java.util.Comparator;

public class ComparatorByNameOfMaster implements Comparator<Master> {

    @Override
    public int compare(Master obj1, Master obj2) {
        if (obj1.getName() == null) {
            return (obj2.getName() == null) ? 0 : -1;
        }
        if (obj2.getName() == null) {
            return 1;
        }
        return obj1.getName().compareTo(obj2.getName());
    }
}
