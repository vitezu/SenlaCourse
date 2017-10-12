package actions.actionsService;

import api.IAction;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.service.PlaceServiceImpl;

import java.util.List;

public class GetAllPlacesAction implements IAction {
    @Override
    public void execute() {
        List<Place> places = PlaceServiceImpl.getInstance().getPlaceStore();
        for (Place element:places) {
            System.out.println(element.toString());
        }

        ShowPlaceServiceMenu placeServiceMenu = new ShowPlaceServiceMenu();
        placeServiceMenu.execute();
    }
}
