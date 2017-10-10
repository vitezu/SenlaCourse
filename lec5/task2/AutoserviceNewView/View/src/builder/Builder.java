package builder;

import actions.actionObject.ActionAddMaster;
import actions.actionObject.ActionAddOrder;
import actions.actionObject.ActionAddPlace;
import actions.actionsPlaceService.ActionCalcFreePlace;
import menu.Menu;
import menuItems.MenuItems;

public class Builder {

    private Menu rootMenu;

    public void buildMenu() {
        rootMenu = new Menu("Main menu");
        Menu menuActionObjects = new Menu("Action Objects menu ");
        Menu menuPlaceService = new Menu("Place Service menu");

        MenuItems actionObjects = new MenuItems("Action objects", null, menuActionObjects);
        MenuItems placeService = new MenuItems("Place service", null, menuPlaceService);
        MenuItems masterService = new MenuItems("Master service", null, rootMenu);
        MenuItems orderService = new MenuItems("Order service", null, rootMenu);

        MenuItems addPlace = new MenuItems("Add place", new ActionAddPlace(), rootMenu);
        MenuItems addMaster = new MenuItems("Add master", new ActionAddMaster(), rootMenu);
        MenuItems addOrder = new MenuItems("Add order", new ActionAddOrder(), rootMenu);
//        MenuItems deletePlace = new MenuItems("Delete place", new OrderServiceMenu(), rootMenu);
//        MenuItems deleteMaster = new MenuItems("Delete master", new OrderServiceMenu(), rootMenu);
//        MenuItems deleteOrder = new MenuItems("Delete order", new OrderServiceMenu(), rootMenu);

        MenuItems calcFreePlaces = new MenuItems("Calc Free Places", new ActionCalcFreePlace(), rootMenu);
        MenuItems getterFreePlace = new MenuItems("Getter Free Place", new ActionCalcFreePlace(), rootMenu);


        MenuItems[] mainMenu = {actionObjects, placeService, masterService, orderService};
        rootMenu.setMenuItems(mainMenu);

        MenuItems[] itemsActionObject = {addPlace, addMaster, addOrder};
        menuActionObjects.setMenuItems(itemsActionObject);

        MenuItems[] itemsPlaceService = {calcFreePlaces, getterFreePlace};
        menuPlaceService.setMenuItems(itemsPlaceService);

    }

    public Menu getRootMenu() {
        return rootMenu;
    }

}
