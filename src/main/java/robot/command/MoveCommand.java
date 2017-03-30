package robot.command;

import robot.Robot;
import robot.constant.Direction;
import robot.tool.CommandHelper;

public class MoveCommand implements ICommand {

    private Robot robot;

    public MoveCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        Direction facing = robot.getFacing();
        int coordinateX = robot.getCoordinateX();
        int coordinateY = robot.getCoordinateY();

        if(Direction.NORTH.equals(facing)) {
            if(coordinateY == getCheckingSize()) {
                warn();
            }else {
                robot.setCoordinateY(coordinateY + 1);
            }
        }else if(Direction.SOUTH.equals(facing)) {
            if(coordinateY == 0) {
                warn();
            }else {
                robot.setCoordinateY(coordinateY - 1);
            }
        } else if(Direction.WEST.equals(facing)) {
            if(coordinateX == 0) {
                warn();
            }else {
                robot.setCoordinateX(coordinateX - 1);
            }
        } else if(Direction.EAST.equals(facing)) {
            if(coordinateX == getCheckingSize()) {
                warn();
            }else {
                robot.setCoordinateX(coordinateX + 1);
            }
        }
    }

    private int getCheckingSize() {
        return CommandHelper.getConfigUnitSize() - 1;
    }

    private void warn() {
        System.out.println("Warning! Can not move farward anymore!");
    }

}
