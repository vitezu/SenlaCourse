package viewModule.menuController;

import viewModule.builder.Builder;
import viewModule.navigator.Navigator;

import java.util.Scanner;

public class MenuController {
    private Scanner scanner = new Scanner(System.in);
    private Navigator navigator = new Navigator();
    private Builder builder = new Builder();

    public void run() {
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();

        while (true) {
            Integer index = scanner.nextInt() - 1;
            navigator.navigate(index);
            if (navigator.getCurrentMenu().getMenuItems().get(index).getNextMenu() == null) {
                break;
            }
            navigator.setCurrentMenu(navigator.getCurrentMenu().getMenuItems().get(index).getNextMenu());
            navigator.printMenu();
        }
    }
}
