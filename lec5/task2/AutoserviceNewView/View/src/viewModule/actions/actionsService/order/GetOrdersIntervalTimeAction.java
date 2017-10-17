package viewModule.actions.actionsService.order;

import org.apache.log4j.Logger;
import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.util.DateUtil;
import com.senlaCourse.autoservice.util.Printer;

import java.util.Date;
import java.util.Scanner;

public class GetOrdersIntervalTimeAction implements IAction {
    private Scanner scanner = new Scanner(System.in);
    private Printer printer = new Printer();
    private DateUtil dateUtil = new DateUtil();
    private Date dat1;
    private Date dat2;

    @Override
    public void execute() {
        printer.printMessage("Enter date of begin of interval");
        String date1 = scanner.next();
        printer.printMessage("Enter date of end of interval");
        String date2 = scanner.next();
        dat1 = dateUtil.create(date1);
        dat2 = dateUtil.create(date2);
        printer.printObject(ControllerImpl.getInstance().getOrdersIntervalTime(dat1, dat2));
    }
}

