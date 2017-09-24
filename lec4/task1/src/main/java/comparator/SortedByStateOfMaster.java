package comparator;

import repairs.Master;
import java.util.Comparator;

public class SortedByStateOfMaster implements Comparator <Master> {

    @Override
    public int compare(Master obj1, Master obj2) {
        return  obj1.getStatFree().compareTo(obj2.getStatFree());
    }
}
