package comparator;

import control.Order;
import java.util.Comparator;

public class SortedByDateOfOrder implements Comparator<Order> {
    @Override
    public int compare(Order obj1, Order obj2) {
        return obj1.getDateOfOrder().compareTo(obj2.getDateOfOrder());
    }
}
