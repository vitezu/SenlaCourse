package menu;

import menuItems.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String name;
    List<MenuItem> menuItems;

    public Menu (String name) {
        this.name = name;
        this.menuItems = new ArrayList<MenuItem>();
    }

    public String getName() {return name;}

    public void setName(String value) {this.name = value;}

    public void addMenuItem(MenuItem item) {menuItems.add(item);}
    public void show()
    {
        System.out.println(name);
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ")" + menuItems.get(i).getTitle());
        }

        Scanner scanner = new Scanner(System.in);

        int index = scanner.nextInt() - 1;
        menuItems.get(index).doAction();
    }

}
