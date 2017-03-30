package robot;

import robot.constant.Direction;

public class Robot {

    private static Robot robot;
    private Integer coordinateX;
    private Integer coordinateY;
    private Direction facing;

    private Robot() {}

    public static synchronized Robot getInstance() {
        if(null == robot) {
            robot = new Robot();
        }
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

    public void setCoordinateX(Integer coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Integer coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }
}
