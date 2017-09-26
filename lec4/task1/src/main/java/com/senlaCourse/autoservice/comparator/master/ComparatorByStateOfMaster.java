package com.senlaCourse.autoservice.comparator.master;

import com.senlaCourse.autoservice.entity.Master;
import java.util.Comparator;

public class ComparatorByStateOfMaster implements Comparator <Master> {

    @Override
    public int compare(Master obj1, Master obj2) {
        return  obj1.getStateFree().compareTo(obj2.getStateFree());
    }
}
