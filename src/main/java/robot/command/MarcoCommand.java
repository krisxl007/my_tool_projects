package robot.command;

import robot.Robot;
import robot.constant.Action;
import robot.tool.CommandHelper;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MarcoCommand implements ICommand{

    private List<String> commandList = new LinkedList<>();

    public MarcoCommand(List<String> commandList) {
        this.commandList = commandList;
    }

    @Override
    public void execute() {
        Queue<ICommand> commands = new LinkedList<>();
        Robot robot = Robot.getInstance();
        initCommands(commands, robot);

        for(ICommand command : commands) {
            command.execute();
        }
    }

    private void initCommands(Queue<ICommand> commands, Robot robot) {
        for(String command : commandList) {
            if(CommandHelper.checkIfPlaceCommand(command)) {
                commands.add(new PlaceCommand(robot, command));
            }else {
                switch (command) {
                    case Action.MOVE:
                        commands.add(new MoveCommand(robot));
                        break;
                    case Action.LEFT:
                        commands.add(new TurnLeftCommand(robot));
                        break;
                    case Action.RIGHT:
                        commands.add(new TurnRightCommand(robot));
                        break;
                    case Action.REPORT:
                        commands.add(new ReportCommand(robot));
                        break;
                    default:
                        System.out.println(command + " is not a correct command!");
                        throw new RuntimeException("command error, will stop it!");
                }
            }
        }
    }
}
