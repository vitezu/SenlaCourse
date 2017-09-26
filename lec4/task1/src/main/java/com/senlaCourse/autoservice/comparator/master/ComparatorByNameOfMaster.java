package com.senlaCourse.autoservice.comparator.master;

import java.util.Comparator;
import com.senlaCourse.autoservice.entity.Master;

public class ComparatorByNameOfMaster implements Comparator<Master> {

    @Override
    public int compare(Master obj1, Master obj2) {
        return obj1.getName().compareTo(obj2.getName());
    }
}
