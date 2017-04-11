package robot.constant;

import java.util.Arrays;
import java.util.List;

public enum Direction {
    NORTH, SOUTH, WEST, EAST;

    public static List<String> allDirections() {
       return Arrays.asList(NORTH.toString(), SOUTH.toString(), WEST.toString(), EAST.toString());
    }
}
