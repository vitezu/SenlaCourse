package viewModule.actions.actionsService.master;

import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Master;
import viewModule.api.IAction;
import viewModule.util.InputCheck;

public class ExportMasterAction implements IAction {
    private InputCheck inputCheck = new InputCheck();
    private final String MESSAGE = "Enter id of master";

    @Override
    public void execute() {
        Master master = ControllerImpl.getInstance().getMasterById(inputCheck.getInt(MESSAGE));
        ControllerImpl.getInstance().exportMaster(master);
    }
}
