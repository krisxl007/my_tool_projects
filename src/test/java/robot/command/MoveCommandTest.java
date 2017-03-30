package robot.command;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import robot.Robot;
import robot.constant.Direction;

public class MoveCommandTest {

    private Robot robot;

    @Before
    public void setUp() throws Exception {
        robot = Robot.getInstance();
        robot.setCoordinateX(2);
        robot.setCoordinateY(2);
        robot.setFacing(Direction.NORTH);
    }

    @Test
    public void givenValidCommandIfNotOverEdgeShouldMoveFarward() throws Exception {
        MoveCommand command = new MoveCommand(robot);
        command.execute();
        String currentLocation1 = robot.getCurrentLocation();

        command.execute();
        String currentLocation2 = robot.getCurrentLocation();

        Assertions.assertThat(currentLocation1).containsOnlyOnce("(2,3)");
        Assertions.assertThat(currentLocation2).containsOnlyOnce("(2,4)");
    }

    @Test
    public void givenValidCommandButOverEdgeShouldWarnAndNotMoving() throws Exception {
        MoveCommand command = new MoveCommand(robot);
        robot.setCoordinateX(2);
        robot.setCoordinateY(4);
        command.execute();
        String currentLocation = robot.getCurrentLocation();

        Assertions.assertThat(currentLocation).containsOnlyOnce("(2,4)");

    }

}