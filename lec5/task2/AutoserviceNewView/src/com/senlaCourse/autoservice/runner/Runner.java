package com.senlaCourse.autoservice.runner;

import builder.Builder;
import menu.Menu;
import navigator.Navigator;

public class Runner {

    public static void main(String[] args) throws Exception {

        Menu rootMenu = Builder.getInstance().buildRootMenu();
        Navigator.getInstance().navigate(rootMenu);
    }
}



