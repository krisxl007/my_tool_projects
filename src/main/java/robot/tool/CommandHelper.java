package robot.tool;

import robot.constant.Action;

import java.io.IOException;
import java.util.Properties;

public class CommandHelper {

    public static boolean checkIfPlaceCommand(String command) {
        return command.startsWith(Action.PLACE);
    }

    public static int getConfigUnitSize() {
        Properties properties = new Properties();
        int size = 0;
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("robot.properties"));
            size = Integer.valueOf(properties.getProperty("unit.size"));
        } catch (IOException e) {
            System.out.println("Properties file not found!");
        }
        return size;
    }
}
