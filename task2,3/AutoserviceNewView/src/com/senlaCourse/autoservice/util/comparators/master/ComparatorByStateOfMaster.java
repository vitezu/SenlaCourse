package com.senlaCourse.autoservice.util.comparators.master;

import com.senlaCourse.autoservice.entity.Master;

import java.util.Comparator;

public class ComparatorByStateOfMaster implements Comparator <Master> {

    @Override
    public int compare(Master obj1, Master obj2) {
        if (obj1.getStateFree() == null) {
            return (obj2.getStateFree() == null) ? 0 : -1;
        }
        if (obj2.getStateFree() == null) {
            return 1;
        }
        return  obj1.getStateFree().compareTo(obj2.getStateFree());
    }
}
