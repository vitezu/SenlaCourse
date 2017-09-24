package comparator;


import control.Order;

import java.util.Comparator;

public class SortedByPrice implements Comparator<Order>
    {
        public int compare(Order obj1, Order obj2)
        {
            float price1 = obj1.getPrice();
            float price2 = obj2.getPrice();

            if (price1 > price2) {
                return 1;
            } else if (price1 < price2) {
                return -1;
            } else {
                return 0;
            }
        }
    }

