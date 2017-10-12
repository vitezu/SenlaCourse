package actions.actionsService;

import api.IAction;
import builder.Builder;
import navigator.Navigator;

public class GoBackAction implements IAction {
    @Override
    public void execute() {
        Navigator.getInstance().navigate(Builder.getInstance().getRootMenu());
    }
}
