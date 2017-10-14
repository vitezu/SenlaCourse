package actions.actionsService.place;

import actions.actionsService.ShowPlaceServiceMenu;
import api.IAction;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.service.PlaceServiceImpl;
import com.senlaCourse.autoservice.util.Printer;

import java.util.List;

public class GetAllPlacesAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        printer.printPlaces("All places", PlaceServiceImpl.getInstance().getPlaceStore());

        ShowPlaceServiceMenu placeServiceMenu = new ShowPlaceServiceMenu();
        placeServiceMenu.execute();
    }
}
