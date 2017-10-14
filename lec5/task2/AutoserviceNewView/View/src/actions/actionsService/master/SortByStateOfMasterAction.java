package actions.actionsService.master;

import actions.actionsService.ShowMasterServiceMenu;
import api.IAction;
import com.senlaCourse.autoservice.service.MasterServiceImpl;
import com.senlaCourse.autoservice.util.Printer;

public class SortByStateOfMasterAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        printer.printMasters("Sort by state free", MasterServiceImpl.getInstance().sortByStateFree());

        ShowMasterServiceMenu showMasterServiceMenu = new ShowMasterServiceMenu();
        showMasterServiceMenu.execute();
    }
}