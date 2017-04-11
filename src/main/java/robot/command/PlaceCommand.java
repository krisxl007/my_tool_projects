package robot.command;


import robot.Robot;
import robot.constant.Direction;
import robot.tool.CommandHelper;

public class PlaceCommand implements ICommand {

    private Robot robot;
    private String command;

    PlaceCommand(Robot robot, String command) {
        this.robot = robot;
        this.command = command;
    }

    @Override
    public void execute() {
        String[] data = command.split(",");

        try {
            int coordinateX = Integer.valueOf(data[1]);
            int coordinateY = Integer.valueOf(data[2]);
            Direction facing = Direction.valueOf(data[3]);

            if(!isOverEdge(coordinateX, coordinateY)) {
                robot.setCoordinateX(coordinateX);
                robot.setCoordinateY(coordinateY);
                robot.setFacing(facing);
            }else {
                System.out.println("Given coordinate over edge, please try again");
            }
        }catch (Exception ex) {
            System.out.println("Arguments is not correct: " + ex);
            throw new RuntimeException(ex);
        }
    }

    private boolean isOverEdge(int coordinateX, int coordinateY) {
        return !(coordinateX >= 0 && coordinateX <= getCheckingSize()
                && coordinateY >= 0 && coordinateY <= getCheckingSize());
    }

    private int getCheckingSize() {
        return CommandHelper.getConfigUnitSize() - 1;
    }
}
