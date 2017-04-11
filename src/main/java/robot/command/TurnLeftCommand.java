package robot.command;

import robot.Robot;
import robot.constant.Direction;

public class TurnLeftCommand implements ICommand {

    private Robot robot;

    TurnLeftCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        Direction facing = robot.getFacing();

        if(Direction.NORTH.equals(facing)) {
            robot.setFacing(Direction.WEST);
        }else if(Direction.EAST.equals(facing)) {
            robot.setFacing(Direction.NORTH);
        }else if(Direction.SOUTH.equals(facing)) {
            robot.setFacing(Direction.EAST);
        }else if(Direction.WEST.equals(facing)) {
            robot.setFacing(Direction.SOUTH);
        }
    }
}
