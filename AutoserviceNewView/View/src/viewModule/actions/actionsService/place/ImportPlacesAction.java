package viewModule.actions.actionsService.place;


import com.senlaCourse.autoservice.controller.ControllerImpl;
import viewModule.api.IAction;

public class ImportPlacesAction implements IAction {
    @Override
    public void execute() {
        System.out.println(ControllerImpl.getInstance().importPlaces());
    }
}
