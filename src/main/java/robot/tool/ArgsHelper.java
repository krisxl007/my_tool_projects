package robot.tool;

import robot.constant.Action;
import robot.constant.Direction;

import java.util.LinkedList;
import java.util.List;

public class ArgsHelper {

    public static boolean isArgsValid(String[] args) {
        String placeArg = args[0];
        if(!placeArg.toUpperCase().startsWith(Action.PLACE)) {
            System.out.println("Robot is not on the table yet, please use command " + Action.PLACE + " to place it!");
            return false;
        }else {
            for(String arg : args) {
                if(arg.toUpperCase().startsWith(Action.PLACE)) {
                    checkPlaceCommand(arg);
                }
            }
            return true;
        }
    }

    private static void checkPlaceCommand(String placeCommand) {
        String[] data = placeCommand.split(",");

        try {
            Integer.valueOf(data[1]);
            Integer.valueOf(data[2]);
            Direction.valueOf(data[3]);
        }catch (Exception ex) {
            System.out.println("Given PLACE command " + placeCommand + " is not in a correct format, " +
                    "please following format as: PLACE,2,3,NORTH");
        }
    }

    public static List<String> buildCommandList(String[] args) {
        List<String> commandList = new LinkedList<>();
        for(String arg : args) {
            commandList.add(arg.toUpperCase());
        }

        return commandList;
    }
}
