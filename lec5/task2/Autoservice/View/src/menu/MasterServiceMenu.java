package menu;

import com.senlaCourse.autoservice.api.controller.IMasterServiceController;
import com.senlaCourse.autoservice.util.Printer;
import menu.enums.MasterServiceEnum;

import java.util.Scanner;

public class MasterServiceMenu {
    private IMasterServiceController controller;
    private Printer printer;

    public MasterServiceMenu(IMasterServiceController controller, Printer printer) {
        this.controller = controller;
        this.printer = printer;
    }

    public void show() {
        int userChoice;
        Boolean flag = true;
        while (flag) {
            System.out.println("Select command");
            for (MasterServiceEnum c : MasterServiceEnum.values()) {
                System.out.println(c.getCode() + ") " + c.message());
            }
            Scanner scanner = new Scanner(System.in);
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    printer.printCommand(MasterServiceEnum.get(userChoice));
                    controller.sortByNameOfMaster();
                    break;
                case 2:
                    printer.printCommand(MasterServiceEnum.get(userChoice));
                    controller.sortByStateFree();
                    break;
                case 3:
                    printer.printCommand(MasterServiceEnum.get(userChoice));
                    controller.getAllMasters();
                    break;
                case 4:
                    printer.printCommand(MasterServiceEnum.get(userChoice));
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }
    }
}
