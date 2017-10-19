package viewModule.actions.actionObject;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Master;
import viewModule.util.InputCheck;

public class ActionAddMaster implements IAction {
    private InputCheck inputCheck = new InputCheck();
    private final String MESSAGE = "Enter uniq name of master";

    @Override
    public void execute() {
        String name = inputCheck.getString(MESSAGE);
        Master master = new Master(name);
        ControllerImpl.getInstance().addMaster(master);
    }
}
