package menu;

import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.util.Printer;
import menu.enums.OrderServiceEnum;

import java.util.Scanner;

public class OrderServiceMenu {
    private IController controller;
    private Printer printer;

    public OrderServiceMenu(IController controller, Printer printer) {
        this.controller = controller;
        this.printer = printer;
    }

    public void show() {
        int userChoice;
        Boolean flag = true;
        while (flag) {
            System.out.println("Select command");
            for (OrderServiceEnum c : OrderServiceEnum.values()) {
                System.out.println(c.getCode() + ") " + c.message());
            }
            Scanner scanner = new Scanner(System.in);
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    printer.printCommand(OrderServiceEnum.get(userChoice));
                    controller.sortByPriceOfOrder();
                    break;
                case 2:
                    printer.printCommand(OrderServiceEnum.get(userChoice));
                    controller.sortByDateOfOrder();
                    break;
                case 3:
                    printer.printCommand(OrderServiceEnum.get(userChoice));
                    controller.sortByDateOfStart();
                    break;
                case 4:
                    printer.printCommand(OrderServiceEnum.get(userChoice));
                    controller.sortByDateOfExecution();
                    break;
                case 5:
                    printer.printCommand(OrderServiceEnum.get(userChoice));
                    controller.sortByPriceOfOperationOrder();
                    break;
                case 6:
                    printer.printCommand(OrderServiceEnum.get(userChoice));
                    controller.sortByDateOfOperationOrder();
                    break;
                case 7:
                    printer.printCommand(OrderServiceEnum.get(userChoice));

                    break;
                case 8:
                    printer.printCommand(OrderServiceEnum.get(userChoice));

                    break;
                case 9:
                    printer.printCommand(OrderServiceEnum.get(userChoice));

                    break;
                case 10:
                    printer.printCommand(OrderServiceEnum.get(userChoice));
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }
    }
}
