package viewModule.actions.actionObject;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import viewModule.util.InputCheck;

import java.util.Date;

public class ActionDeleteOrder implements IAction {
    private InputCheck inputCheck = new InputCheck();
    private final String MESSAGE1 = "Enter uniq number of order";

    @Override
    public void execute() {
        Integer number = inputCheck.getInt(MESSAGE1);
        Order order = new Order(number, new Date(), new Date(), 0f);
        ControllerImpl.getInstance().deleteOrder(order);
    }
}
