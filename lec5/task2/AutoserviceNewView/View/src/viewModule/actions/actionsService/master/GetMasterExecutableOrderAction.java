package viewModule.actions.actionsService.master;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.util.Printer;
import viewModule.util.InputCheck;

public class GetMasterExecutableOrderAction implements IAction {
    private InputCheck inputCheck = new InputCheck();
    private final String MESSAGE = "Enter uniq num of order";
    private Printer printer = new Printer();

    @Override
    public void execute() {
        Integer num = inputCheck.getInt(MESSAGE);
        Order order = new Order(num);

        printer.printObject(ControllerImpl.getInstance().getMasterExecuteOrder(order));
    }
}