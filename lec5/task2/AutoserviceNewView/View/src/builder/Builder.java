package builder;

import actions.actionObject.*;
import actions.actionsPlaceService.ActionCalcFreePlace;
import menu.Menu;
import menuItems.MenuItems;

public class Builder {

    private Menu rootMenu;

    public Menu buildRootMenu() {
        Menu rootMenu = new Menu("Root manu");
        MenuItems actionObjects = new MenuItems("Action objects", null, buildActionObjectMenu());
        MenuItems placeService = new MenuItems("Place service", null, buildPlaceServiceMenu());
        MenuItems masterService = new MenuItems("Master service", null, rootMenu);
        MenuItems orderService = new MenuItems("Order service", null, rootMenu);

        MenuItems[] mainMenu = {actionObjects, placeService, masterService, orderService};
        rootMenu.setMenuItems(mainMenu);
        return rootMenu;
    }

    public Menu buildActionObjectMenu() {
        Menu menuActionObjects = new Menu("Action Objects menu ");
        MenuItems addPlace = new MenuItems("Add place", new ActionObjectAddPlace(), rootMenu);
        MenuItems addMaster = new MenuItems("Add master", new ActionObjectAddMaster(), rootMenu);
        MenuItems addOrder = new MenuItems("Add order", new ActionObjectAddOrder(), rootMenu);
        MenuItems deletePlace = new MenuItems("Delete place", new ActionObjectDeletePlace(), rootMenu);
        MenuItems deleteMaster = new MenuItems("Delete master", new ActionObjectDeleteMaster(), rootMenu);
        MenuItems deleteOrder = new MenuItems("Delete order", new ActionObjectDeleteOrder(), rootMenu);

        MenuItems[] itemsActionObject = {addPlace, addMaster, addOrder, deletePlace, deleteMaster, deleteOrder};
        menuActionObjects.setMenuItems(itemsActionObject);
        return menuActionObjects;
    }

    public Menu buildPlaceServiceMenu() {
        Menu menuPlaceService = new Menu("PLace service menu ");
        MenuItems calcFreePlaces = new MenuItems("Calc Free Places", new ActionCalcFreePlace(), rootMenu);
        MenuItems getterFreePlace = new MenuItems("Getter Free Place", new ActionCalcFreePlace(), rootMenu);
        MenuItems[] itemsPlaceService = {calcFreePlaces, getterFreePlace};
        menuPlaceService.setMenuItems(itemsPlaceService);
        return menuPlaceService;
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

}
