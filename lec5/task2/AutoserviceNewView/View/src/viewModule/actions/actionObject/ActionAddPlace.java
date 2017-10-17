package viewModule.actions.actionObject;

import viewModule.api.IAction;
import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Place;

import java.util.Scanner;

public class ActionAddPlace implements IAction {

    @Override
    public void execute() {
        System.out.println("Enter uniq number of place");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        Place place = new Place(number);

        ControllerImpl.getInstance().addPlace(place);
    }
}
