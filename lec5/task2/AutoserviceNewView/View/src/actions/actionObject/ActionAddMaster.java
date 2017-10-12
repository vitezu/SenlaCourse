package actions.actionObject;

import actions.actionsService.ShowActionObjectsMenu;
import api.IAction;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.service.MasterServiceImpl;

import java.util.Scanner;

public class ActionAddMaster implements IAction {

    @Override
    public void execute() {
        System.out.println("Enter uniq name of master");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        Master master = new Master(name);

        MasterServiceImpl.getInstance().addMaster(master);

        ShowActionObjectsMenu actionObjectsMenu = new ShowActionObjectsMenu();
        actionObjectsMenu.execute();
    }

}
