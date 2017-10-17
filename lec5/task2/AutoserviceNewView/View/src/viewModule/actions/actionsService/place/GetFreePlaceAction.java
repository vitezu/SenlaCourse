package viewModule.actions.actionsService.place;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.util.Printer;

public class GetFreePlaceAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        printer.printPlaces("Free places", ControllerImpl.getInstance().getFreePlaces());
    }
}