package viewModule.actions.actionsService.master;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.util.Printer;

public class SortByNameAction implements IAction {
    Printer printer = new Printer();

    @Override
    public void execute() {
        printer.printMasters("Sort by name", ControllerImpl.getInstance().sortByNameOfMaster());
    }
}