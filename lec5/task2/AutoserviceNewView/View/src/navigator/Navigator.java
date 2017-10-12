package navigator;

import menu.Menu;

public class Navigator {
    private static Navigator instance = null;

    protected Navigator() {
    }

    public static Navigator getInstance() {
        if (instance == null) {
            instance = new Navigator();
        }
        return instance;
    }

    private Menu currentMenu;


    public void navigate(Menu menu) {
        currentMenu = menu;
        currentMenu.show();
    }
}
