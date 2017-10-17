package viewModule.actions.actionsService.order;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.util.Printer;

public class SortByDateOrderAction implements IAction {
    Printer printer = new Printer();

    @Override
    public void execute() {
        printer.printOrders("Sort by date of order", ControllerImpl.getInstance().sortByDateOfOrder());
    }
}