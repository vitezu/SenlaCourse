package viewModule.actions.actionObject;

import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Order;
import viewModule.api.IAction;
import viewModule.util.InputCheck;

public class CloneOrderAction implements IAction {
    private InputCheck inputCheck = new InputCheck();
    private final String MESSAGE1 = "Enter uniq number of order for clone";

    @Override
    public void execute() {
        Integer number = inputCheck.getInt(MESSAGE1);
        Order order = new Order(number);
        ControllerImpl.getInstance().cloneOrder(order);
    }
}
