package robot;

import robot.constant.Direction;

public class Robot {

    private static final Robot robot = new Robot();
    private Integer coordinateX;
    private Integer coordinateY;
    private Direction facing;

    private Robot() {}

    public static Robot getInstance() {
        return robot;
    }

    public void showCurrentLocation() {
        System.out.println("Robot current location: {" + coordinateX +
                "," + coordinateY + "}" + "," + facing);
    }

    public String getCurrentLocation() {
        return "(" + coordinateX + "," + coordinateY + ")" + "," + facing;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }
}
