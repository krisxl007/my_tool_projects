package robot.command;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import robot.Robot;
import robot.constant.Direction;


public class TurnLeftCommandTest {

    private Robot robot;

    @Before
    public void setUp() throws Exception {
        robot = Robot.getInstance();
        robot.setCoordinateX(2);
        robot.setCoordinateY(2);
        robot.setFacing(Direction.NORTH);
    }

    @Test
    public void giveValidCommandShouldTurnLeft() throws Exception {
        TurnLeftCommand command = new TurnLeftCommand(robot);
        command.execute();
        String expectFacingWest = robot.getCurrentLocation();

        command.execute();
        String expectFacingSouth = robot.getCurrentLocation();

        command.execute();
        String expectFacingEest = robot.getCurrentLocation();

        command.execute();
        String expectFacingNorth = robot.getCurrentLocation();

        Assertions.assertThat(expectFacingWest).containsOnlyOnce(Direction.WEST.name());
        Assertions.assertThat(expectFacingSouth).containsOnlyOnce(Direction.SOUTH.name());
        Assertions.assertThat(expectFacingEest).containsOnlyOnce(Direction.EAST.name());
        Assertions.assertThat(expectFacingNorth).containsOnlyOnce(Direction.NORTH.name());
    }

    @After
    public void tearDown() throws Exception {
        robot = null;
    }
}