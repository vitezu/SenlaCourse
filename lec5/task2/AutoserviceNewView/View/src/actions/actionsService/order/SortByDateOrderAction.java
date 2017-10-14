package actions.actionsService.order;

import actions.actionsService.ShowOrderServiceMenu;
import api.IAction;
import com.senlaCourse.autoservice.service.OrderServiceImpl;
import com.senlaCourse.autoservice.util.Printer;

public class SortByDateOrderAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        printer.printOrders("Sort by date of order", OrderServiceImpl.getInstance().sortByDateOfOrder());

        ShowOrderServiceMenu orderServiceMenu = new ShowOrderServiceMenu();
        orderServiceMenu.execute();
    }
}