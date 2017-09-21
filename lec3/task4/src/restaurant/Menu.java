package restaurant;


public class Menu {

private Food[] foods = new Food[4];
    private Integer n = 0;

public void addFood (Food food) {
    foods[n] = food;
    n++;
}

public void deleteFood (int n) {
    foods[n] = null;
}

public Food[] getMenu () {
    return foods;
}
}
