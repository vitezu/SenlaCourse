package viewModule.builder;

import viewModule.actions.actionObject.*;
import viewModule.actions.actionsService.master.*;
import viewModule.actions.actionsService.order.*;
import viewModule.actions.actionsService.place.*;
import viewModule.menu.Menu;
import viewModule.menuItems.MenuItem;

public class Builder {

    private Menu rootMenu;

    public Builder() {
        buildRootMenu();
    }

    private Menu buildRootMenu() {
        rootMenu = new Menu("Root viewModule.menu ");
        rootMenu.addMenuItem(new MenuItem("Show Action Objects Menu", buildActionObjectMenu()));
        rootMenu.addMenuItem(new MenuItem("Show Place Service Menu", buildPlaceServiceMenu()));
        rootMenu.addMenuItem(new MenuItem("Show Master Service Menu", buildMasterServiceMenu()));
        rootMenu.addMenuItem(new MenuItem("Show Order Service Menu", buildOrderServiceMenu()));
        rootMenu.addMenuItem(new MenuItem("Exit"));
        return rootMenu;
    }

    private Menu buildActionObjectMenu() {
        Menu menuActionObjects = new Menu("Action Objects Menu ");
        menuActionObjects.addMenuItem(new MenuItem("Add place", new ActionAddPlace(), menuActionObjects));
        menuActionObjects.addMenuItem(new MenuItem("Delete place", new ActionDeletePlace(), menuActionObjects));
        menuActionObjects.addMenuItem(new MenuItem("Add master", new ActionAddMaster(), menuActionObjects));
        menuActionObjects.addMenuItem(new MenuItem("Delete master", new ActionDeleteMaster(), menuActionObjects));
        menuActionObjects.addMenuItem(new MenuItem("Add Order", new ActionAddOrder(), menuActionObjects));
        menuActionObjects.addMenuItem(new MenuItem("Delete order", new ActionDeleteOrder(), menuActionObjects));
        menuActionObjects.addMenuItem(new MenuItem("Go Back", getRootMenu()));
        return menuActionObjects;
    }

    private Menu buildPlaceServiceMenu() {
        Menu menuPlaceService = new Menu("Place Service Menu ");
        menuPlaceService.addMenuItem(new MenuItem("Get all places", new GetAllPlacesAction(), menuPlaceService));
        menuPlaceService.addMenuItem(new MenuItem("Get free places", new GetFreePlaceAction(), menuPlaceService));
        menuPlaceService.addMenuItem(new MenuItem("Calculate free place", new CalcFreePlaceAction(), menuPlaceService));
        menuPlaceService.addMenuItem(new MenuItem("Export place", new ExportPlaceAction(), menuPlaceService));
        menuPlaceService.addMenuItem(new MenuItem("Import places", new ImportPlacesAction(), menuPlaceService));
        menuPlaceService.addMenuItem(new MenuItem("Go Back", getRootMenu()));
        return menuPlaceService;
    }

    private Menu buildOrderServiceMenu() {
        Menu menuOrderService = new Menu("Order Service Menu ");
        menuOrderService.addMenuItem(new MenuItem("Get all orders", new GetAllOrdersAction(), menuOrderService));
        menuOrderService.addMenuItem(new MenuItem("Sort by price", new SortByPriceAction(), menuOrderService));
        menuOrderService.addMenuItem(new MenuItem("Sort by date of order", new SortByDateOrderAction(), menuOrderService));
        menuOrderService.addMenuItem(new MenuItem("Sort by date of execution order", new SortByDateExecutionAction(), menuOrderService));
        menuOrderService.addMenuItem(new MenuItem("Sort by date of start order", new SortByDateStartAction(), menuOrderService));
        menuOrderService.addMenuItem(new MenuItem("Get order executable concrete master", new GetOrderExecuteMasterAction(), menuOrderService));
        menuOrderService.addMenuItem(new MenuItem("Get orders in interval of time", new GetOrdersIntervalTimeAction(), menuOrderService));
        menuOrderService.addMenuItem(new MenuItem("Shift time execution", new ShiftTimeExecutionAction(), menuOrderService));
        menuOrderService.addMenuItem(new MenuItem("Clone object", new CloneOrderAction(), menuOrderService));
        menuOrderService.addMenuItem(new MenuItem("Export order", new ExportOrderAction(), menuOrderService));
        menuOrderService.addMenuItem(new MenuItem("Import orders", new ImportOrdersAction(), menuOrderService));
        menuOrderService.addMenuItem(new MenuItem("Go Back", getRootMenu()));
        return menuOrderService;
    }

    private Menu buildMasterServiceMenu() {
        Menu menuMasterService = new Menu("Master Service Menu ");
        menuMasterService.addMenuItem(new MenuItem("Get all masters", new GetAllMastersAction(), menuMasterService));
        menuMasterService.addMenuItem(new MenuItem("Sort by name of masters", new SortByNameAction(), menuMasterService));
        menuMasterService.addMenuItem(new MenuItem("Sort by state of masters", new SortByStateOfMasterAction(), menuMasterService));
        menuMasterService.addMenuItem(new MenuItem("Get master execute concrete order", new GetMasterExecutableOrderAction(), menuMasterService));
        menuMasterService.addMenuItem(new MenuItem("Serialize master", new SerializeMasterAction(), menuMasterService));
        menuMasterService.addMenuItem(new MenuItem("Deserialize master", new DeserializeMasterAction(), menuMasterService));
        menuMasterService.addMenuItem(new MenuItem("Export master", new ExportMasterAction(), menuMasterService));
        menuMasterService.addMenuItem(new MenuItem("Import masters", new ImportMastersAction(), menuMasterService));
        menuMasterService.addMenuItem(new MenuItem("Go Back", getRootMenu()));
        return menuMasterService;
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}
