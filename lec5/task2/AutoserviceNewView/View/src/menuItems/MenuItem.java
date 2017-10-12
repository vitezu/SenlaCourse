package menuItems;

import api.IAction;

public class MenuItem {
    private String title;
    private IAction action;

    public MenuItem(String title, IAction action) {
        this.title = title;
        this.action = action;
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

    public void doAction()
    {
        action.execute();
    }
}
