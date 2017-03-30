package robot.command;

import robot.Robot;
import robot.constant.Direction;

public class TurnRightCommand implements ICommand {

    private Robot robot;

    public TurnRightCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        Direction facing = robot.getFacing();

        if(Direction.NORTH.equals(facing)) {
            robot.setFacing(Direction.EAST);
        }else if(Direction.EAST.equals(facing)) {
            robot.setFacing(Direction.SOUTH);
        }else if(Direction.SOUTH.equals(facing)) {
            robot.setFacing(Direction.WEST);
        }else if(Direction.WEST.equals(facing)) {
            robot.setFacing(Direction.NORTH);
        }
    }
}
