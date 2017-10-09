package menu;

import com.senlaCourse.autoservice.api.controller.IMainMenu;
import com.senlaCourse.autoservice.util.Printer;
import menu.enums.MainMenuEnum;

import java.util.Scanner;

public class MainMenuClass {

    private IMainMenu controller;
    private Printer printer;

    public MainMenuClass(IMainMenu controller, Printer printer) {
        this.controller = controller;
        this.printer = printer;
    }

    public void show() {
        int userChoice;
        Boolean flag = true;
        while (flag) {
            System.out.println("Select command");
            for (MainMenuEnum c : MainMenuEnum.values()) {
                System.out.println(c.getCode() + ") " + c.message());
            }
            Scanner scanner = new Scanner(System.in);
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    printer.printCommand(MainMenuEnum.get(userChoice));
                    controller.showActionObjectMenu();
                    break;
                case 2:
                    printer.printCommand(MainMenuEnum.get(userChoice));
                    controller.showOrderServiceMenu();
                    break;
                case 3:
                    printer.printCommand(MainMenuEnum.get(userChoice));
                    controller.showPlaceServiceMenu();
                    break;
                case 4:
                    printer.printCommand(MainMenuEnum.get(userChoice));
                    controller.showMasterServiceMenu();
                    break;
                case 5:
                    printer.printCommand(MainMenuEnum.get(userChoice));
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }
    }
}

