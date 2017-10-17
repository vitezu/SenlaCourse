package viewModule.actions.actionsService.master;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.util.Printer;

import java.util.Scanner;

public class GetMasterExecutableOrderAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);
        printer.printMessage("Enter uniq num of order");
        Integer num = sc.nextInt();
        Order order = new Order(num);

        printer.printObject(ControllerImpl.getInstance().getMasterExecuteOrder(order));
    }
}