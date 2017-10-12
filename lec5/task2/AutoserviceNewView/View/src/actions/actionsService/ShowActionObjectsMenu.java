package actions.actionsService;

import api.IAction;
import builder.Builder;
import navigator.Navigator;

public class ShowActionObjectsMenu implements IAction {

    @Override
    public void execute() {
        Navigator.getInstance().navigate(Builder.getInstance().buildActionObjectMenu());
    }
}
