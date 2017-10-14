package actions.actionsService.order;

import actions.actionsService.ShowOrderServiceMenu;
import api.IAction;
import com.senlaCourse.autoservice.service.OrderServiceImpl;
import com.senlaCourse.autoservice.util.Printer;

public class SortByDateExecutionAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        printer.printOrders("Sort by date of execution", OrderServiceImpl.getInstance().sortByDateOfExecution());

        ShowOrderServiceMenu orderServiceMenu = new ShowOrderServiceMenu();
        orderServiceMenu.execute();
    }
}