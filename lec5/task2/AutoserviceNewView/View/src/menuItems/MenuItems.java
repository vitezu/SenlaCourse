package menuItems;

import api.IActionObject;
import com.senlaCourse.autoservice.api.controller.IController;
import menu.Menu;

public class MenuItems {
    private String title;
    private IActionObject action;
    private Menu nextMenu;


    public MenuItems(String title, IActionObject action, Menu nextMenu) {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
    }

    public String getTitle() {
        return title;
    }

    public void doAction() {

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
