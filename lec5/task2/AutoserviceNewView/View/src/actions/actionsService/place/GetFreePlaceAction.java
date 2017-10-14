package actions.actionsService.place;

import actions.actionsService.ShowPlaceServiceMenu;
import api.IAction;
import com.senlaCourse.autoservice.service.PlaceServiceImpl;
import com.senlaCourse.autoservice.util.Printer;

public class GetFreePlaceAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        printer.printPlaces("Free places", PlaceServiceImpl.getInstance().getFreePlaces());

        ShowPlaceServiceMenu placeServiceMenu = new ShowPlaceServiceMenu();
        placeServiceMenu.execute();
    }
}