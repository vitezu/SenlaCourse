package viewModule.actions.actionsService.order;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.util.DateUtil;
import com.senlaCourse.autoservice.util.Printer;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class GetOrdersIntervalTimeAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);
        DateUtil dateUtil = new DateUtil();
        Date dat1 = null;
        Date dat2= null;

        printer.printMessage("Enter date of begin of interval");
        String date1 = sc.next();
        printer.printMessage("Enter date of end of interval");
        String date2 = sc.next();
        try {
            dat1 = dateUtil.create(date1);
            dat2 = dateUtil.create(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        printer.printObject(ControllerImpl.getInstance().getOrdersIntervalTime(dat1, dat2));
    }
}

