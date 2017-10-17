package viewModule.actions.actionObject;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Place;
import viewModule.util.InputCheck;

public class ActionAddPlace implements IAction {
    private InputCheck inputCheck = new InputCheck();
    private final String MESSAGE = "Enter uniq number of place";

    @Override
    public void execute() {
        Place place = new Place(inputCheck.getInt(MESSAGE));
        ControllerImpl.getInstance().addPlace(place);
    }
}
