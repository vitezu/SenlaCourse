package viewModule.actions.actionsService.order;

import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.util.DateUtil;
import viewModule.api.IAction;
import viewModule.util.InputCheck;

import java.util.Date;

public class ShiftTimeExecutionAction implements IAction{
    private InputCheck inputCheck = new InputCheck();
    private DateUtil dateUtil = new DateUtil();
    private final String MESSAGE1 = "Enter uniq number of order";
    private final String MESSAGE2 = "Enter time in format hh:mm";


    @Override
    public void execute() {
        Integer number = inputCheck.getInt(MESSAGE1);
        Order order = new Order(number, new Date(), new Date(), 0f);

        String time = inputCheck.getString(MESSAGE2);
        Date dat = dateUtil.createTime(time);
        ControllerImpl.getInstance().shiftTimeEnd(dat, order);
    }
}
