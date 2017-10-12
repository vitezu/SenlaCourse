package actions.actionsService;

import api.IAction;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.service.OrderServiceImpl;

import java.util.List;

public class GetAllOrdersAction implements IAction {

    @Override
    public void execute() {
        List<Order> orders = OrderServiceImpl.getInstance().getOrderStore();
        for (Order element:orders) {
            System.out.println(element.toString());
        }

        ShowOrderServiceMenu orderServiceMenu = new ShowOrderServiceMenu();
        orderServiceMenu.execute();
    }
}
