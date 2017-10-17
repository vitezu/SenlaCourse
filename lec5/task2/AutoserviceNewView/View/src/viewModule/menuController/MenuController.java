package viewModule.menuController;

import com.senlaCourse.autoservice.util.Printer;
import viewModule.builder.Builder;
import viewModule.navigator.Navigator;
import viewModule.util.InputCheck;

import java.util.Scanner;

public class MenuController {
    private Navigator navigator = new Navigator();
    private Builder builder = new Builder();
    private Scanner scanner;
    private Printer printer = new Printer();

    public void run() {
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();
        while (true) {
            Integer index = 0;
            Boolean flag = false;
            index = getCheck(index, flag);
            navigator.navigate(index);
            if (navigator.getCurrentMenu().getMenuItems().get(index).getNextMenu() == null) {
                break;
            }
            navigator.setCurrentMenu(navigator.getCurrentMenu().getMenuItems().get(index).getNextMenu());
            navigator.printMenu();
        }
    }

    public Integer getCheck(Integer index, Boolean flag) {
        while (!flag) {
            printer.printMessage("Enter num of menu");
            scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                flag = true;
                index = scanner.nextInt() - 1;
            } else {
                printer.printMessage("Value is not correct");
            }
            if (index > navigator.getCurrentMenu().getMenuItems().size() || index < 0) {
                flag = false;
                printer.printMessage("Value is outside the range nums of menu");
            }
        }
        return index;
    }
}

