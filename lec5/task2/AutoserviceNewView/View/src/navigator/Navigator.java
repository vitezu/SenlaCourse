package navigator;

import menu.Menu;

import java.util.Scanner;

public class Navigator {
    private Menu currentMenu;

    public Navigator(Menu menu) {
        currentMenu = menu;
    }

    public void printMenu() {
        System.out.println(currentMenu.getName());
        for (int i = 0; i < currentMenu.getMenuItems().length; i++) {
            System.out.println((i + 1) + ")" + currentMenu.getMenuItems()[i].getTitle());
        }
    }

    public void navigate(Integer index) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert num of menu");
        index = sc.nextInt();
        if (index == 1) {
//            currentMenu.setMenuItems(menuActionObjects);
        }
    }
}
