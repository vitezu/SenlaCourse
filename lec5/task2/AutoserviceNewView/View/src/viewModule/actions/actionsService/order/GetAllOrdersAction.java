package viewModule.actions.actionsService.order;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.util.Printer;

import java.util.List;

public class GetAllOrdersAction implements IAction {
    Printer printer = new Printer();

    @Override
    public void execute() {
        List<Order> orders = ControllerImpl.getInstance().getOrderStore();
        printer.printOrders("All orders", orders);
    }
}
