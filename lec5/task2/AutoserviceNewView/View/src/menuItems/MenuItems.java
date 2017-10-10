package menuItems;

import api.IAction;
import com.senlaCourse.autoservice.api.controller.IController;
import menu.Menu;

public class MenuItems {
    private String title;
    private IAction action;
    private Menu nextMenu;
    private IController controller;

    public MenuItems(String title, IAction action, Menu nextMenu) {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
    }

    public String getTitle() {
        return title;
    }

        public MenuItems (String title) {
       this.title = title;
    }

    public void doAction () {
        action.execute(controller);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MenuItems{");
        sb.append("title='").append(title).append('\'');
        sb.append(", action=").append(action);
        sb.append(", rootMenu=").append(nextMenu);
        sb.append('}');
        return sb.toString();
    }
}
