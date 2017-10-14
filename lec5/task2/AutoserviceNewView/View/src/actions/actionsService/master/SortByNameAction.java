package actions.actionsService.master;

import actions.actionsService.ShowMasterServiceMenu;
import api.IAction;
import com.senlaCourse.autoservice.service.MasterServiceImpl;
import com.senlaCourse.autoservice.util.Printer;

public class SortByNameAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        printer.printMasters("Sort by name", MasterServiceImpl.getInstance().sortByNameOfMaster());

        ShowMasterServiceMenu showMasterServiceMenu = new ShowMasterServiceMenu();
        showMasterServiceMenu.execute();
    }
}