package viewModule.actions.actionObject;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.controller.ControllerImpl;

import java.util.Date;
import java.util.Scanner;

public class ActionDeleteOrder implements IAction {

    @Override
    public void execute() {
        System.out.println("Enter uniq number of place for deleting");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        Order order = new Order(number, new Date(), new Date(), 0f);

        ControllerImpl.getInstance().deleteOrder(order);
    }
}
