package actions.actionsService.place;

import actions.actionsService.ShowPlaceServiceMenu;
import api.IAction;
import com.senlaCourse.autoservice.service.PlaceServiceImpl;
import com.senlaCourse.autoservice.util.Printer;

public class CalcFreePlaceAction implements IAction {

    @Override
    public void execute() {
        Printer printer = new Printer();
        printer.printMessage("Num of free places in future");
        PlaceServiceImpl.getInstance().calcFreePlaces();

        ShowPlaceServiceMenu showPlaceServiceMenu = new ShowPlaceServiceMenu();
        showPlaceServiceMenu.execute();
    }
}
