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
        builder = new Builder();

        navigator = new Navigator(builder.buildRootMenu());
        navigator.printMenu();

        Scanner sc = new Scanner(System.in);
        System.out.println("Insert num of menu ");
        int index = sc.nextInt();
        navigator.navigate(index);

        navigator.printMenu();
    }
}
