package viewModule.actions.actionsService.place;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.util.Printer;

public class CalcFreePlaceAction implements IAction {

    @Override
    public void execute() {
        Printer printer = new Printer();
        printer.printMessage("Num of free places in future");
        ControllerImpl.getInstance().calcFreePlaces();
    }
}
