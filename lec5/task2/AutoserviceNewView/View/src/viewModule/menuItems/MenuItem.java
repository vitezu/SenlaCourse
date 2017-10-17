package viewModule.menuItems;

import viewModule.api.IAction;
import viewModule.menu.Menu;

public class MenuItem {
    private String title;
    private IAction action;
    private Menu nextMenu;

    public MenuItem(String title, IAction action, Menu nextMenu) {
        this(title, nextMenu);
        this.action = action;
    }

    public MenuItem(String title, Menu nextMenu) {
        this(title);
        this.nextMenu = nextMenu;
    }

    public MenuItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IAction getAction() {
        return action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public void doAction() {
        action.execute();
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    public void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }
}
