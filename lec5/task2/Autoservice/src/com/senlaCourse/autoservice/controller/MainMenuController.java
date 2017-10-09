package com.senlaCourse.autoservice.controller;

import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.api.controller.IMainMenuInterface;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.util.Printer;
import menu.ActionObjectMenuClass;
import menu.MasterServiceMenu;
import menu.OrderServiceMenu;
import menu.PlaceServiceMenu;

public class MainMenuController implements IMainMenuInterface {
    private IController controller = new ControllerImpl();
    private Printer printer = new Printer();

    @Override
    public void showActionObjectMenu() {
        ActionObjectMenuClass actionObjectMenu = new ActionObjectMenuClass(controller, printer);
        actionObjectMenu.show();
    }

    @Override
    public void showOrderServiceMenu() {
        OrderServiceMenu orderServiceMenu = new OrderServiceMenu(controller, printer);
        orderServiceMenu.show();
    }

    @Override
    public void showPlaceServiceMenu() {
        PlaceServiceMenu placeServiceMenu = new PlaceServiceMenu(controller, printer);
        placeServiceMenu.show();
    }

    @Override
    public void showMasterServiceMenu() {
        MasterServiceMenu masterServiceMenu = new MasterServiceMenu(controller, printer);
        masterServiceMenu.show();
    }

}
