package com.senlaCourse.autoservice.comparator;

import java.util.Comparator;
import com.senlaCourse.autoservice.repairs.Master;

public class SortedByNameOfMaster implements Comparator<Master> {

    @Override
    public int compare(Master obj1, Master obj2) {
        return obj1.getName().compareTo(obj2.getName());
    }
}
