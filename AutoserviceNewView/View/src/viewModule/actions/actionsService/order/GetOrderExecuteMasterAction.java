package viewModule.actions.actionsService.order;

import com.senlaCourse.autoservice.util.Printer;
import viewModule.api.IAction;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import viewModule.util.InputCheck;

public class GetOrderExecuteMasterAction implements IAction {
    private InputCheck inputCheck = new InputCheck();
    private final String MESSAGE = "Enter uniq name of master";
    private Printer printer = new Printer();

    @Override
    public void execute() {
        String name = inputCheck.getString(MESSAGE);
        Master master = new Master(name);
        printer.printObject(ControllerImpl.getInstance().getOrderExecuteMaster(master));
    }
}
