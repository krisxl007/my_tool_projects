package robot;

import robot.command.ICommand;
import robot.command.MarcoCommand;
import robot.handlers.ArgsToListHandler;
import robot.handlers.IArgsHandler;

import java.util.List;

/**
 * This is the main class for robot moving game
 * Command example:
     PLACE,1,2,EAST MOVE MOVE LEFT MOVE REPORT
     Output: 3,3,NORTH
 */
public class Main {
    public static void main(String[] args) {
        IArgsHandler handler = new ArgsToListHandler(args);
        List<String> commandList = (List<String>)handler.handle();

        ICommand command = new MarcoCommand(commandList);
        command.execute();
    }
}
