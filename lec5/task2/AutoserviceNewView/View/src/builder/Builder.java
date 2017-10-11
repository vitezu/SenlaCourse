package builder;

import menu.Menu;

public class Builder {

    private Menu rootMenu;

    public void buildMenu() {
        rootMenu = new Menu("Main menu");
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

}
