package viewModule.actions.actionObject;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Master;

import java.util.Scanner;

public class ActionAddMaster implements IAction {

    @Override
    public void execute() {
        System.out.println("Enter uniq name of master");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        Master master = new Master(name);

        ControllerImpl.getInstance().addMaster(master);
    }

}
