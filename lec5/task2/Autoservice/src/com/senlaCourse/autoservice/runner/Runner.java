package com.senlaCourse.autoservice.runner;

import com.senlaCourse.autoservice.api.controller.IMainMenu;
import com.senlaCourse.autoservice.controller.MainMenuController;
import com.senlaCourse.autoservice.util.Printer;
import menu.MainMenuClass;

public class Runner {

    public static void main(String[] args) throws Exception {

        IMainMenu controller = new MainMenuController();
        Printer printer = new Printer();

        MainMenuClass mainMenuClass = new MainMenuClass(controller, printer);
        mainMenuClass.show();
    }
}



