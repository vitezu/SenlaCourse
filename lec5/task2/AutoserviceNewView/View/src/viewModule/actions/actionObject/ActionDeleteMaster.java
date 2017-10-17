package viewModule.actions.actionObject;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Master;

import java.util.Scanner;

public class ActionDeleteMaster implements IAction {

    @Override
    public void execute() {
        System.out.println("Enter uniq name of master for deleting");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        Master master = new Master(name);

        ControllerImpl.getInstance().deleteMaster(master);
    }
}
