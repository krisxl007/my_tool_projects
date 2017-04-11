package robot.tool;

import org.apache.commons.lang3.math.NumberUtils;
import robot.constant.Action;
import robot.constant.Direction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ArgsHelper {

    public static boolean isArgsValid(String[] args) {
        String placeArg = args[0];
        if(!placeArg.toUpperCase().startsWith(Action.PLACE)) {
            System.out.println("Robot is not on the table yet, please use command " + Action.PLACE + " to place it!");
            return false;
        }else {
            for(String arg : args) {
                if(arg.toUpperCase().startsWith(Action.PLACE)) {
                    isValidPlaceCommand(arg);
                }
            }
            return true;
        }
    }

    private static boolean isValidPlaceCommand(String placeCommand) {
        String[] data = placeCommand.split(",");
        String coordinateX = data[1];
        String coordinateY = data[2];
        String facing = data[3];

        if(isNumeric(coordinateX) && isNumeric(coordinateY) && isValidDirection(facing))
            return true;
        else
            System.out.println("Given PLACE command " + placeCommand + " is not in a correct format, " +
                    "please following format as: PLACE,2,3,NORTH");
        return false;
    }

    public static List<String> buildCommandList(String[] args) {
        List<String> commandList = new LinkedList<>();
        for(String arg : args) {
            commandList.add(arg.toUpperCase());
        }

        return commandList;
    }

    public static String[] getInputArgs() {
        List<String> args = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        String line;
        while (!Action.EXIT.equalsIgnoreCase(line = sc.nextLine())) {
            args.add(line);
        }
        sc.close();

        return args.toArray(new String[args.size()]);
    }

    private static boolean isNumeric(String str){
        //TODO: find out better solution for checking a number
        return NumberUtils.isNumber(str);
    }

    private static boolean isValidDirection(String str){
        return Direction.allDirections().contains(str);
    }
}
