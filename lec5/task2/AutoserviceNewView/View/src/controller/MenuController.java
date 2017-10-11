package controller;

import builder.Builder;
import menu.Menu;
import menuItems.MenuItems;
import navigator.Navigator;

import java.util.Scanner;

public class MenuController {

    private Builder builder;
    private Navigator navigator;

    public MenuController() {

    }

    public void run() {
        Menu rootMenu = new Menu("Main manu");

        Menu menuActionObjects = new Menu("Action Objects menu ");
        Menu menuPlaceService = new Menu("Place Service menu");

        MenuItems actionObjects = new MenuItems("Action objects", null, menuActionObjects);
        MenuItems placeService = new MenuItems("Place service", null, menuPlaceService);
        MenuItems masterService = new MenuItems("Master service", null, rootMenu);
        MenuItems orderService = new MenuItems("Order service", null, rootMenu);

        MenuItems[] mainMenu = {actionObjects, placeService, masterService, orderService};
        rootMenu.setMenuItems(mainMenu);

        navigator = new Navigator(rootMenu);
        navigator.printMenu();

        Scanner sc = new Scanner(System.in);
        System.out.println("Insert num of menu ");
        int index = sc.nextInt();
        navigator.navigate(index);

        navigator.printMenu();
    }

}
