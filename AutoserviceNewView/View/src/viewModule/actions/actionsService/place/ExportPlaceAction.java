package viewModule.actions.actionsService.place;

import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Place;
import viewModule.api.IAction;
import viewModule.util.InputCheck;

public class ExportPlaceAction implements IAction {
    private InputCheck inputCheck = new InputCheck();
    private final String MESSAGE = "Enter id of place";

    @Override
    public void execute() {
        Place place = ControllerImpl.getInstance().getPlaceById(inputCheck.getInt(MESSAGE));
        ControllerImpl.getInstance().exportPlace(place);
    }
}
