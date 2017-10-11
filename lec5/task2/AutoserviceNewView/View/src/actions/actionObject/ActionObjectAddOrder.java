package actions.actionObject;

import api.IActionObject;
import com.senlaCourse.autoservice.api.controller.IActionMenu;
import com.senlaCourse.autoservice.api.controller.IController;
import navigator.Navigator;

import java.util.Scanner;

public class ActionObjectAddOrder implements IActionObject {

    @Override
    public void execute(IController controller) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert num of order");
        Integer num = scanner.nextInt();
        System.out.println("Insert price of order");
        Float price = scanner.nextFloat();
        controller.createOrder(num,price );
    }

    @Override
    public void navigateTo(Integer index) {
        Navigator.getInstance().navigate(index);
    }
}
