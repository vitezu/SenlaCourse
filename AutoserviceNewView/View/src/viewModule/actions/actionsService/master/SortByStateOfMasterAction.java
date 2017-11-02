package viewModule.actions.actionsService.master;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.util.Printer;

public class SortByStateOfMasterAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        printer.printMasters("Sort by state free", ControllerImpl.getInstance().sortByStateFree());
    }
}