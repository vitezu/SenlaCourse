package workingOfAnnotation;

import static workingOfAnnotation.ConfigurationProgramm.path1;
import static workingOfAnnotation.ConfigurationProgramm.path2;

public class Runner {

    private static final String PATH = "com.senlaCourse.autoservice.controller.ControllerImpl";

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        ConfigurationProgramm.getInstance().getParameters(PATH);

        System.out.println(Config.getInstance().getProps(path1));
        System.out.println(Config.getInstance().getProps(path2));

        ConfigurationProgramm.getInstance().setInjection(PATH);
    }
}
