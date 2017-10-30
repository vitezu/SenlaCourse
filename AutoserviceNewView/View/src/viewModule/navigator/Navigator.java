package viewModule.navigator;

import viewModule.menu.Menu;

public class Navigator {

    private Menu currentMenu;

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void navigate(Integer index) {
        if (currentMenu.getMenuItems().get(index).getAction() != null) {
            currentMenu.getMenuItems().get(index).doAction();
        }
        currentMenu.getMenuItems().get(index).getNextMenu();
    }

    public Menu printMenu() {
        System.out.println(currentMenu.getName());
        for (int i = 0; i < currentMenu.getMenuItems().size(); i++) {
            System.out.println((i + 1) + ")" + currentMenu.getMenuItems().get(i).getTitle());
        }
        return currentMenu;
    }
}
