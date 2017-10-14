package actions.actionsService.order;

import actions.actionsService.ShowOrderServiceMenu;
import api.IAction;
import com.senlaCourse.autoservice.service.OrderServiceImpl;
import com.senlaCourse.autoservice.util.Printer;

public class SortByDateStartAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        printer.printOrders("Sort by date of start order", OrderServiceImpl.getInstance().sortByDateOfStart());

        ShowOrderServiceMenu orderServiceMenu = new ShowOrderServiceMenu();
        orderServiceMenu.execute();
    }
}