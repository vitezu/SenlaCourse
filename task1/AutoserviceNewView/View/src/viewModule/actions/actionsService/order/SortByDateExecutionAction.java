package viewModule.actions.actionsService.order;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.util.Printer;

public class SortByDateExecutionAction implements IAction {
    Printer printer = new Printer();

    @Override
    public void execute() {
        printer.printOrders("Sort by date of execution", ControllerImpl.getInstance().sortByDateOfExecution());
    }
}