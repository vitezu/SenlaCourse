package viewModule.actions.actionsService.order;

import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;
import viewModule.api.IAction;
import viewModule.util.InputCheck;

public class ExportOrderAction implements IAction {
    private InputCheck inputCheck = new InputCheck();
    private final String MESSAGE = "Enter id of order";

    @Override
    public void execute() {
        Order order = ControllerImpl.getInstance().getOrderById(inputCheck.getInt(MESSAGE));
        ControllerImpl.getInstance().exportOrder(order);
    }
}
