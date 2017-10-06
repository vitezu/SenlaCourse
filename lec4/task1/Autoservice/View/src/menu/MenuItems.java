package menu;

import java.util.Scanner;

public class MenuItems {
    public void execute () {
        System.out.println("Select command");
        for (Command c : Command.values()) {
            System.out.println(c.getCode() + ") " + c.message());
        }
        int userChoice;
        Scanner scanner = new Scanner(System.in);
        userChoice = scanner.nextInt();

// Switch construct
        switch (userChoice) {
            case 1:
                System.out.println(Command.get(userChoice));   // This is where I want to call the class
//                Class1 class1 = new Class1();
//                class1.doSomething();
                break;
            case 2:
                System.out.println("Option 2 selected");  // this is where I want to call the class
                break;
            case 3:
                System.out.println("Exit selected");
                break;
            default:
                System.out.println("Invalid selection");
                break; // This break is not really necessary
        }
    }
}

