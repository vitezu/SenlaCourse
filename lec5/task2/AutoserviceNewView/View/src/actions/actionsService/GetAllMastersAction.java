package actions.actionsService;

import api.IAction;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.service.MasterServiceImpl;

import java.util.List;

public class GetAllMastersAction implements IAction {
    @Override
    public void execute() {
        List<Master> masters = MasterServiceImpl.getInstance().getMasterStore();
        for (Master element : masters) {
            System.out.println(element.toString());
        }

        ShowPlaceServiceMenu placeServiceMenu = new ShowPlaceServiceMenu();
        placeServiceMenu.execute();
    }
}
