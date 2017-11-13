package viewModule.actions.actionsService.master;


import com.senlaCourse.autoservice.controller.ControllerImpl;
import viewModule.api.IAction;

public class ImportMastersAction implements IAction {
    @Override
    public void execute() {
        System.out.println(ControllerImpl.getInstance().importMasters());
    }
}
