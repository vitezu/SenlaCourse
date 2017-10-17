package viewModule.actions.actionsService.order;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.util.Printer;

public class SortByPriceAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        printer.printOrders("Sort by price", ControllerImpl.getInstance().sortByPriceOfOrder());
    }
}