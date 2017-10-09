package menu;

import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.util.Printer;
import menu.enums.PlaceServiceEnum;

import java.util.Scanner;

public class PlaceServiceMenu {
    private IController controller;
    private Printer printer;

    public PlaceServiceMenu(IController controller, Printer printer) {
        this.controller = controller;
        this.printer = printer;
    }

    public void show() {
        int userChoice;
        Boolean flag = true;
        while (flag) {
            System.out.println("Select command");
            for (PlaceServiceEnum c : PlaceServiceEnum.values()) {
                System.out.println(c.getCode() + ") " + c.message());
            }
            Scanner scanner = new Scanner(System.in);
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    printer.printCommand(PlaceServiceEnum.get(userChoice));
                    controller.getFreePlaces();
                    break;
                case 2:
                    printer.printCommand(PlaceServiceEnum.get(userChoice));
                    controller.calcFreePlaces();
                    break;
                case 3:
                    printer.printCommand(PlaceServiceEnum.get(userChoice));
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }
    }
}
