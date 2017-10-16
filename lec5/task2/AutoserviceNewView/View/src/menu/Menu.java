package menu;

import menuItems.MenuItem;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Logger logger = Logger.getLogger(Menu.class);
    private String name;
    List<MenuItem> menuItems;

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

    public void show() {
        System.out.println(name);
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ")" + menuItems.get(i).getTitle());
        }
        try {
            Scanner scanner = new Scanner(System.in);
            int index = scanner.nextInt() - 1;
            menuItems.get(index).doAction();
        } catch (IndexOutOfBoundsException exception) {
            logger.error("Index is not correct ", exception);
        }
    }
}
