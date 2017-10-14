package actions.actionsService.master;

import actions.actionsService.ShowMasterServiceMenu;
import api.IAction;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.service.MasterServiceImpl;
import com.senlaCourse.autoservice.util.Printer;

import java.util.Scanner;

public class GetMasterExecutableOrderAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);
        printer.printMessage("Enter uniq num of order");
        Integer num = sc.nextInt();
        Order order = new Order(num);

        printer.printObject(MasterServiceImpl.getInstance().getMasterExecuteOrder(order));

        ShowMasterServiceMenu showMasterServiceMenu = new ShowMasterServiceMenu();
        showMasterServiceMenu.execute();
    }
}