package viewModule.util;

import com.senlaCourse.autoservice.util.Printer;
import viewModule.navigator.Navigator;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InputCheck {
    private Scanner scanner;
    private Printer printer = new Printer();

    public Integer getInt(String message) {
        Integer num = null;
        printer.printMessage(message);
        scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            printer.printMessage("Value is not correct. Try again.");
        }
        return num;
    }

    public Float getFloat(String message) {
        Float num = null;
        printer.printMessage(message);
        scanner = new Scanner(System.in);
        if (scanner.hasNextFloat()) {
            num = scanner.nextFloat();
        } else {
            printer.printMessage("Value is not correct. Try again.");
        }
        return num;
    }

    public String getString(String message) {
        String name = null;
        printer.printMessage(message);
        scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            name = scanner.next();
        } else {
            printer.printMessage("Value is not correct. Try again.");
        }
        return name;
    }
   }
