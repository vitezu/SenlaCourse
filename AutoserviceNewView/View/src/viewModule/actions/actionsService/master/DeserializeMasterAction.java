package viewModule.actions.actionsService.master;

import com.senlaCourse.autoservice.controller.ControllerImpl;
import viewModule.api.IAction;

public class DeserializeMasterAction implements IAction {

    @Override
    public void execute() {
        System.out.println(ControllerImpl.getInstance().deserializeMaster());
    }
}
