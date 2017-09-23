package restaurant;

import java.util.Arrays;

public class Menu {

private Food[] foods = new Food[10];
    private Integer count = 0;

public void addFood (Food food) {
    foods[count] = food;
    count++;
}

public void deleteFood (Food food) {
        for (int i = 0;i<foods.length;i++) {
            if (foods[i] == food) {
                foods[i] = null;
            }
        }
}
    public void getMenu () {
        System.out.println("Menu:");
        for (int i =0;i<foods.length;i++) {
            if (foods[i]!= null) {
                System.out.println(foods[i].getName() + " price " + foods[i].getPrice());
            }
            else {
                break;
            }
        }
}

    @Override
    public String toString() {
        return "Menu{" +
                "foods=" + Arrays.toString(foods) +
                ", count=" + count +
                '}';
    }
}
