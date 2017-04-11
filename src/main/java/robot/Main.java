package robot;

import robot.command.ICommand;
import robot.command.MarcoCommand;
import robot.handlers.ArgsToListHandler;
import robot.handlers.IArgsHandler;
import robot.tool.ArgsHelper;

import java.util.List;

/**
 * This is the main class for robot moving game
 * Command example:
     PLACE,1,2,EAST
     MOVE
     MOVE
     LEFT
     MOVE
     REPORT
     EXIT

   Output: 3,3,NORTH
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================================== ");
        System.out.println("Please input your commands as below example, end with exit: ");
        System.out.println("=========================================================== ");
        System.out.println("PLACE,1,2,EAST\n" +
                "MOVE\n" +
                "MOVE\n" +
                "LEFT\n" +
                "MOVE\n" +
                "REPORT\n" +
                "EXIT");
        System.out.println("=========================================================== ");

        IArgsHandler handler = new ArgsToListHandler(ArgsHelper.getInputArgs());
        List<String> commandList = (List<String>)handler.handle();

        ICommand command = new MarcoCommand(commandList);
        command.execute();
    }
}
