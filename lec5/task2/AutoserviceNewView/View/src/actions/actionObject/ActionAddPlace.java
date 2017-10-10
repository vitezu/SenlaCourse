package actions.actionObject;

import api.IAction;
import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.entity.Place;

import java.util.Scanner;

public class ActionAddPlace implements IAction {

    @Override
    public void execute(IController controller) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert num of place");
        Integer numPlace = scanner.nextInt();
        Place place = new Place(numPlace);
        controller.addPlace(place);
    }
}
