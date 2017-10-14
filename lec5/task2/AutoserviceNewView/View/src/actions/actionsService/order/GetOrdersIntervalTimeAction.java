package actions.actionsService.order;

import actions.actionsService.ShowOrderServiceMenu;
import api.IAction;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.service.OrderServiceImpl;
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

        printer.printObject(OrderServiceImpl.getInstance().getOrdersIntervalTime(dat1, dat2));

        ShowOrderServiceMenu showOrderServiceMenu = new ShowOrderServiceMenu();
        showOrderServiceMenu.execute();
    }
}
//    Scanner scanner = new Scanner(System.in);
//System.out.println("Enter the Date ");
//
//        String date = scanner.next();
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//        Date date2=null;
//        try {
//        //Parsing the String
//        date2 = dateFormat.parse(date);
//        } catch (ParseException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//        }
//        System.out.println(date2);
