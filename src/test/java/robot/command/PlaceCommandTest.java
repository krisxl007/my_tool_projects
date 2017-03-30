package robot.command;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import robot.Robot;

public class PlaceCommandTest {

    private Robot robot;

    @Before
    public void setUp() throws Exception {
        robot = Robot.getInstance();
        robot.setCoordinateY(null);
        robot.setCoordinateX(null);
        robot.setFacing(null);
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void givenValidArgsShouldPlaceToCorrectLocation() throws Exception {
        PlaceCommand command = new PlaceCommand(robot, "PLACE,2,2,NORTH");
        command.execute();
        String currentLocation = robot.getCurrentLocation();

        Assertions.assertThat(currentLocation).containsOnlyOnce("(2,2),NORTH");
    }

    @Test
    public void givenValidArgsButOverEdgeShouldWarnAndNotPlace() throws Exception {
        String currentLocation = robot.getCurrentLocation();
        PlaceCommand command = new PlaceCommand(robot, "PLACE,-1,-1,NORTH");
        command.execute();
        String newLocation = robot.getCurrentLocation();

        Assertions.assertThat(newLocation).containsOnlyOnce(currentLocation);
    }

    @Test
    public void givenInvalidFacingArgsShouldStopAndExit() throws Exception {
        expectedEx.expect(RuntimeException.class);

        PlaceCommand command = new PlaceCommand(robot, "PLACE,2,2,NORTH1");
        command.execute();
    }

    @Test
    public void givenInvalidCoordinateArgsShouldStopAndExit() throws Exception {
        expectedEx.expect(RuntimeException.class);

        PlaceCommand command = new PlaceCommand(robot, "PLACE,a,b,NORTH");
        command.execute();
    }

    @After
    public void tearDown() throws Exception {
        robot = null;
    }
}