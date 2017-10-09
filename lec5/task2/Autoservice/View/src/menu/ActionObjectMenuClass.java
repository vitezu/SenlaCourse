package menu;

import com.senlaCourse.autoservice.api.controller.IActionMenu;
import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.util.Printer;
import menu.enums.ActionObjectMenuEnum;

import java.util.Scanner;

public class ActionObjectMenuClass {

    private IActionMenu controller;
    private Printer printer;

    public ActionObjectMenuClass(IActionMenu controller, Printer printer) {
        this.controller = controller;
        this.printer = printer;
    }

    public void show() {
        int userChoice;
        Boolean flag = true;
        while (flag) {
            System.out.println("Select command");
            for (ActionObjectMenuEnum c : ActionObjectMenuEnum.values()) {
                System.out.println(c.getCode() + ") " + c.message());
            }
            Scanner scanner = new Scanner(System.in);
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    printer.printCommand(ActionObjectMenuEnum.get(userChoice));
                    printer.printMessage("Insert num of order");
                    Integer numOrder = scanner.nextInt();
                    printer.printMessage("insert price");
                    Float price = scanner.nextFloat();
                    controller.createOrder(numOrder, price);
                    break;
                case 2:
                    printer.printCommand(ActionObjectMenuEnum.get(userChoice));
                    printer.printMessage("Insert num of place");
                    Integer numPlace = scanner.nextInt();
                    Place place = new Place(numPlace);
                    controller.addPlace(place);
                    break;
                case 3:
                    printer.printCommand(ActionObjectMenuEnum.get(userChoice));
                    printer.printMessage("Insert name of master");
                    String nameMaster = scanner.next();
                    Master master = new Master(nameMaster);
                    controller.addMaster(master);
                    break;
                case 7:
                    printer.printCommand(ActionObjectMenuEnum.get(userChoice));
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }
    }
}
