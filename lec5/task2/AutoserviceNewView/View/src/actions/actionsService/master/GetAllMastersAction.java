package actions.actionsService.master;

import actions.actionsService.ShowMasterServiceMenu;
import api.IAction;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.service.MasterServiceImpl;
import com.senlaCourse.autoservice.service.PlaceServiceImpl;
import com.senlaCourse.autoservice.util.Printer;

import java.util.List;

public class GetAllMastersAction implements IAction {
    @Override
    public void execute() {
        Printer printer = new Printer();
        printer.printMasters("All masters", MasterServiceImpl.getInstance().getMasterStore());

        ShowMasterServiceMenu showMasterServiceMenu = new ShowMasterServiceMenu();
        showMasterServiceMenu.execute();
    }
}
