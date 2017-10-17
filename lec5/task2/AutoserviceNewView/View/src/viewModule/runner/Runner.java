package viewModule.runner;

import viewModule.menuController.MenuController;

public class Runner {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.run();
    }
}
