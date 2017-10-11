package com.senlaCourse.autoservice.controller;
//
//import com.senlaCourse.autoservice.api.controller.*;
//import com.senlaCourse.autoservice.util.Printer;
//import menu.ActionObjectMenuClass;
//import menu.MasterServiceMenu;
//import menu.OrderServiceMenu;
//import menu.PlaceServiceMenu;

//public class MainMenuController implements IMainMenu {
//    private IController controller = new ControllerImpl();
//    private IActionMenu actionMenuController = new ActionMenuController();
//    private IPlaceServiceController placeServiceController = new PlaceServiceController();
//    private IMasterServiceController masterServiceController = new MasterServiceController();
//    private Printer printer = new Printer();
//
//    @Override
//    public void showActionObjectMenu() {
//        ActionObjectMenuClass actionObjectMenu = new ActionObjectMenuClass(actionMenuController, printer);
//        actionObjectMenu.show();
//    }
//
//    @Override
//    public void showOrderServiceMenu() {
//        OrderServiceMenu orderServiceMenu = new OrderServiceMenu(controller, printer);
//        orderServiceMenu.show();
//    }
//
//    @Override
//    public void showPlaceServiceMenu() {
//        PlaceServiceMenu placeServiceMenu = new PlaceServiceMenu(placeServiceController, printer);
//        placeServiceMenu.show();
//    }
//
//    @Override
//    public void showMasterServiceMenu() {
//        MasterServiceMenu masterServiceMenu = new MasterServiceMenu(masterServiceController, printer);
//        masterServiceMenu.show();
//    }
//
//}
