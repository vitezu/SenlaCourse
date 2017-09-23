package restaurant;

import java.util.Arrays;

public class Kitchen {
    Cook[] cooks = new Cook[5];
    private Integer count = 0;

    public void addCook (Cook cook) {
        cooks[count] = cook;
        count++;
    }

    public void deleteCook (Cook cook) {
        for (int i = 0;i<cooks.length;i++) {
            if (cooks[i] == cook) {
                cooks[i] = null;
            }
        }
    }

    public void getCooksWithOrder () {
        for (int i =0;i<cooks.length;i++) {
            if (cooks[i]!= null) {
                System.out.println(cooks[i].getName() + " doing order № " + cooks[i].getOrder().getNumId());
            }
            else {
            break;
            }
        }
    }

    @Override
    public String toString() {
        return "Kitchen{" +
                "cooks=" + Arrays.toString(cooks) +
                ", count=" + count +
                '}';
    }
}
