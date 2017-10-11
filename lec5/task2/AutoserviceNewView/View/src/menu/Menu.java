package menu;

import menuItems.MenuItems;

public class Menu {
    private String name;
    private MenuItems[] menuItems;

    public Menu (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuItems[] getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(MenuItems[] menuItems) {
        this.menuItems = menuItems;
    }
}
