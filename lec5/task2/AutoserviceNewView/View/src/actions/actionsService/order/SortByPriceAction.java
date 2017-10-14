package actions.actionsService.order;

import actions.actionsService.ShowOrderServiceMenu;
import api.IAction;
import com.senlaCourse.autoservice.service.OrderServiceImpl;
import com.senlaCourse.autoservice.util.Printer;

public class SortByPriceAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        printer.printOrders("Sort by price", OrderServiceImpl.getInstance().sortByPriceOfOrder());

        ShowOrderServiceMenu showOrderServiceMenu = new ShowOrderServiceMenu();
        showOrderServiceMenu.execute();
    }
}