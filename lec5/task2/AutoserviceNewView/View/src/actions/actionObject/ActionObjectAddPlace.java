package actions.actionObject;

import api.IActionObject;
import com.senlaCourse.autoservice.api.controller.IActionMenu;
import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.entity.Place;
import navigator.Navigator;

import java.util.Scanner;

public class ActionObjectAddPlace implements IActionObject {

    @Override
    public void execute(IController controller) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert num of place");
        Integer numPlace = scanner.nextInt();
        Place place = new Place(numPlace);
        controller.addPlace(place);
    }

    @Override
    public void navigateTo(Integer index) {
        Navigator.getInstance().navigate(index);
    }
}
