package actions.actionsPlaceService;

import api.IActionObject;
import com.senlaCourse.autoservice.api.controller.IController;
import navigator.Navigator;

public class ActionGetFreePlace implements IActionObject {

    @Override
    public void execute(IController controller)  {
        controller.getFreePlaces();
    }
    @Override
    public void navigateTo(Integer index) {
        Navigator.getInstance().navigate(index);
    }
}
