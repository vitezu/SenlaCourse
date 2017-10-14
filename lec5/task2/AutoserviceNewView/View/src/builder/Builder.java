package builder;

import actions.actionObject.*;
import actions.actionsService.*;
import actions.actionsService.master.GetAllMastersAction;
import actions.actionsService.master.SortByNameAction;
import actions.actionsService.master.SortByStateOfMasterAction;
import actions.actionsService.order.*;
import actions.actionsService.place.CalcFreePlaceAction;
import actions.actionsService.place.GetAllPlacesAction;
import actions.actionsService.place.GetFreePlaceAction;
import menu.Menu;
import menuItems.MenuItem;

public class Builder {

    private static Builder instance = null;

    protected Builder() {
    }

    public static Builder getInstance() {
        if (instance == null) {
            instance = new Builder();
        }
        return instance;
    }

    private Menu rootMenu;

    public Menu buildRootMenu() {
        Menu rootMenu = new Menu("Root menu ");
        rootMenu.addMenuItem(new MenuItem("Show Action Objects Menu", new ShowActionObjectsMenu()));
        rootMenu.addMenuItem(new MenuItem("Show Place Service Menu", new ShowPlaceServiceMenu()));
        rootMenu.addMenuItem(new MenuItem("Show Master Service Menu", new ShowMasterServiceMenu()));
        rootMenu.addMenuItem(new MenuItem("Show Order Service Menu", new ShowOrderServiceMenu()));
        rootMenu.addMenuItem(new MenuItem("Exit", new ExitAction()));
        this.rootMenu = rootMenu;
        return rootMenu;
    }

    public Menu buildActionObjectMenu() {
        Menu menuActionObjects = new Menu("Action Objects Menu ");
        menuActionObjects.addMenuItem(new MenuItem("Add place", new ActionAddPlace()));
        menuActionObjects.addMenuItem(new MenuItem("Delete place", new ActionDeletePlace()));
        menuActionObjects.addMenuItem(new MenuItem("Add master", new ActionAddMaster()));
        menuActionObjects.addMenuItem(new MenuItem("Delete master", new ActionDeleteMaster()));
        menuActionObjects.addMenuItem(new MenuItem("Add Order", new ActionAddOrder()));
        menuActionObjects.addMenuItem(new MenuItem("Delete order", new ActionDeleteOrder()));
        menuActionObjects.addMenuItem(new MenuItem("Go Back", new GoBackAction()));
        return menuActionObjects;
    }

    public Menu buildPlaceServiceMenu() {
        Menu menuPlaceService = new Menu("Place Service Menu ");
        menuPlaceService.addMenuItem(new MenuItem("Get all places", new GetAllPlacesAction()));
        menuPlaceService.addMenuItem(new MenuItem("Get free places", new GetFreePlaceAction()));
        menuPlaceService.addMenuItem(new MenuItem("Calculate free place", new CalcFreePlaceAction()));
        menuPlaceService.addMenuItem(new MenuItem("Go Back", new GoBackAction()));
        return menuPlaceService;
    }

    public Menu buildOrderServiceMenu() {
        Menu menuOrderService = new Menu("Order Service Menu ");
        menuOrderService.addMenuItem(new MenuItem("Get all orders", new GetAllOrdersAction()));
        menuOrderService.addMenuItem(new MenuItem("Sort by price", new SortByPriceAction()));
        menuOrderService.addMenuItem(new MenuItem("Sort by date of order", new SortByDateOrderAction()));
        menuOrderService.addMenuItem(new MenuItem("Sort by date of execution order", new SortByDateExecutionAction()));
        menuOrderService.addMenuItem(new MenuItem("Sort by date of start order", new SortByDateStartAction()));
        menuOrderService.addMenuItem(new MenuItem("Go Back", new GoBackAction()));
        return menuOrderService;
    }

    public Menu buildMasterServiceMenu() {
        Menu menuMasterService = new Menu("Master Service Menu ");
        menuMasterService.addMenuItem(new MenuItem("Get all masters", new GetAllMastersAction()));
        menuMasterService.addMenuItem(new MenuItem("Sort by name of masters", new SortByNameAction()));
        menuMasterService.addMenuItem(new MenuItem("Sort by state of masters", new SortByStateOfMasterAction()));
        menuMasterService.addMenuItem(new MenuItem("Go Back", new GoBackAction()));
        return menuMasterService;
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}
