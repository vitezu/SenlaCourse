package viewModule.actions.actionsService.order;


import com.senlaCourse.autoservice.controller.ControllerImpl;
import viewModule.api.IAction;

public class ImportOrdersAction implements IAction {
    @Override
    public void execute() {
        System.out.println(ControllerImpl.getInstance().importOrders());
    }
}
