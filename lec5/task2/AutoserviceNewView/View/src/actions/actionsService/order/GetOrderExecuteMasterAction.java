package actions.actionsService.order;

import actions.actionsService.ShowOrderServiceMenu;
import api.IAction;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.service.OrderServiceImpl;
import com.senlaCourse.autoservice.util.Printer;

import java.util.Scanner;

public class GetOrderExecuteMasterAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);
        printer.printMessage("Enter uniq name of master");
        String name = sc.next();
        Master master = new Master(name);

        printer.printObject(OrderServiceImpl.getInstance().getOrderExecuteMaster(master));

        ShowOrderServiceMenu showOrderServiceMenu = new ShowOrderServiceMenu();
        showOrderServiceMenu.execute();
    }
}
