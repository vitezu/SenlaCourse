package viewModule.menu;

import viewModule.menuItems.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name;
    private List<MenuItem> menuItems;

    public Menu(String name) {
        this.name = name;
        this.menuItems = new ArrayList<MenuItem>();
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
