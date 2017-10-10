package controller;

import builder.Builder;
import navigator.Navigator;

public class MenuController {

    private Builder builder;
    private Navigator navigator;

    public MenuController() {

    }

    public void run() {
        builder = new Builder();
        builder.buildMenu();

        navigator = new Navigator(builder.getRootMenu());
        navigator.printMenu();


        navigator.navigate();
    }

}
