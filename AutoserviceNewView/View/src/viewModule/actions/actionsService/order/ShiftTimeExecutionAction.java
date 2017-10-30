package viewModule.actions.actionsService.order;

import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Order;
import viewModule.api.IAction;
import viewModule.util.InputCheck;

public class ShiftTimeExecutionAction implements IAction{
    private InputCheck inputCheck = new InputCheck();
    private final String MESSAGE1 = "Enter uniq number of order";
    private final String MESSAGE2 = "Enter num of hours to shift";


    @Override
    public void execute() {
        Integer number = inputCheck.getInt(MESSAGE1);
        Order order = new Order(number);

        Integer hour = inputCheck.getInt(MESSAGE2);
        ControllerImpl.getInstance().shiftTimeEnd(hour, order);
    }
}
