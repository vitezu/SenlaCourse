package actions.actionObject;

import actions.actionsService.ShowActionObjectsMenu;
import api.IAction;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.service.PlaceServiceImpl;

import java.util.Scanner;

public class ActionAddPlace implements IAction {

    @Override
    public void execute() {
        System.out.println("Enter uniq number of place");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        Place place = new Place(number);

        PlaceServiceImpl.getInstance().addPlace(place);

        ShowActionObjectsMenu actionObjectsMenu = new ShowActionObjectsMenu();
        actionObjectsMenu.execute();
    }
}
