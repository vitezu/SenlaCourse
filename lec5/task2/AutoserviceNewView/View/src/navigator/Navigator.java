package navigator;

import builder.Builder;
import menu.Menu;

public class Navigator {
    private Menu currentMenu;

    private static Navigator instance = null;
    protected Navigator() {};

    public static Navigator getInstance() {
        if (instance == null){
            instance = new Navigator();
        }
        return instance;
    }


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
       Builder builder = new Builder();

        switch (index) {
            case 1:
                setCurrentMenu(builder.buildActionObjectMenu());
            case 2:
                setCurrentMenu(builder.buildPlaceServiceMenu());
            case 3:

        }
    }

    public void setCurrentMenu(Menu menu) {
        currentMenu.setMenuItems(menu.getMenuItems());
        currentMenu.setName(menu.getName());
        printMenu();
    }
}
