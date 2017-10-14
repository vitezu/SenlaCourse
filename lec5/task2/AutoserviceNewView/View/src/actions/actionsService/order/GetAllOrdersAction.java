package actions.actionsService.order;

import actions.actionsService.ShowOrderServiceMenu;
import api.IAction;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.service.OrderServiceImpl;
import com.senlaCourse.autoservice.util.Printer;

import java.util.List;

public class GetAllOrdersAction implements IAction {

    @Override
    public void execute() {
        Printer printer = new Printer();
        List<Order> orders = OrderServiceImpl.getInstance().getOrderStore();
        printer.printOrders("All orders", orders);

        ShowOrderServiceMenu orderServiceMenu = new ShowOrderServiceMenu();
        orderServiceMenu.execute();
    }
}
