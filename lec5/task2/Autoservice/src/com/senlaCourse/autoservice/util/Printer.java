package com.senlaCourse.autoservice.util;

import menu.enums.*;

public class Printer {
    public void printObject(Object object) {
        System.out.println(object);
    }

    public void printLineEmpty() {
        System.out.println();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printCommand(MainMenuEnum c) {
        System.out.println(c);
    }

    public void printCommand(ActionObjectMenuEnum c) {
        System.out.println(c);
    }

    public void printCommand(OrderServiceEnum c) {
        System.out.println(c);
    }

    public void printCommand(PlaceServiceEnum c) {
        System.out.println(c);
    }

    public void printCommand(MasterServiceEnum c) {
        System.out.println(c);
    }



}
