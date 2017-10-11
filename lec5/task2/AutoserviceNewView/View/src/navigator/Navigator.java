package navigator;

import menu.Menu;

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

        switch (index) {
            case 1:
                Menu menuActionObjects = new Menu("Action Objects menu ");
                currentMenu.setMenuItems(menuActionObjects.getMenuItems());
                currentMenu.setName(menuActionObjects.getName());
                printMenu();
            case 2:
                Menu menuPlaceService = new Menu("Place Service menu");
                currentMenu.setMenuItems(menuPlaceService.getMenuItems());
                currentMenu.setName(menuPlaceService.getName());
                printMenu();
            case 3:

        }
    }
}
