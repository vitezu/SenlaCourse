package viewModule.actions.actionsService.order;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.util.Printer;

public class SortByDateStartAction implements IAction {
    Printer printer = new Printer();

    @Override
    public void execute() {
        printer.printOrders("Sort by date of start order", ControllerImpl.getInstance().sortByDateOfStart());
    }
}