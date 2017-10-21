package viewModule.actions.actionsService.master;


import com.senlaCourse.autoservice.controller.ControllerImpl;
import viewModule.api.IAction;
import viewModule.util.InputCheck;

public class SerializeMasterAction implements IAction {
    private InputCheck inputCheck = new InputCheck();
    private final String MESSAGE = "Enter id of master";

    @Override
    public void execute() {
        ControllerImpl.getInstance().serializeMaster(inputCheck.getInt(MESSAGE));
    }
}
