package actions.actionObject;

import actions.actionsService.ShowActionObjectsMenu;
import api.IAction;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.service.MasterServiceImpl;
import com.senlaCourse.autoservice.service.OrderServiceImpl;
import com.senlaCourse.autoservice.service.PlaceServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ActionAddOrder implements IAction {

    @Override
    public void execute() {
        List<Place> freePlaces = PlaceServiceImpl.getInstance().getFreePlaces();
        List<Master> freeMasters = MasterServiceImpl.getInstance().getFreeMasters();
        List<Order> orders = OrderServiceImpl.getInstance().sortByDateOfExecution();

        Date dateNow = new Date();

        System.out.println("Enter uniq number of order");
        Scanner scanner = new Scanner(System.in);
        Integer num = scanner.nextInt();

        System.out.println("Enter price of order");
        scanner = new Scanner(System.in);
        Float price = scanner.nextFloat();

        Order newOrder = new Order(num, dateNow, dateNow, price);

        Place place = new Place();
        if (freePlaces.size() > 0) {
            place = freePlaces.get(0);
        } else {
            if (orders.size() > 0) {
                Order order = orders.get(0);
                place = order.getPlace();

                if (newOrder.getDateOfStart().getTime() < order.getDateOfEnd().getTime()) {
                    newOrder.setDateOfStart(order.getDateOfEnd());
                }
            }
        }

        Master master = new Master();
        if (freeMasters.size() > 0) {
            master = freeMasters.get(0);
        } else {
            if (orders.size() > 0) {
                Order order = orders.get(0);
                master = order.getMaster();

                if (newOrder.getDateOfStart().getTime() < order.getDateOfEnd().getTime()) {
                    newOrder.setDateOfStart(order.getDateOfEnd());
                }
            }
        }

        if (master.getName() != null && place.getNumPlace() != null) {
            master.setStateFree(false);
            place.setStateFree(false);
            newOrder.setMaster(master);
            newOrder.setPlace(place);
            master.setOrder(newOrder);

            OrderServiceImpl.getInstance().addOrder(newOrder);
        } else {
            System.out.println("Place or master not exist!!!");
        }

        ShowActionObjectsMenu actionObjectsMenu = new ShowActionObjectsMenu();
        actionObjectsMenu.execute();
    }
}
