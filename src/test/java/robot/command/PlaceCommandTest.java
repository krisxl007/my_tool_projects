package robot.command;

import org.assertj.core.api.Assertions;
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
        PlaceCommand command = new PlaceCommand(robot, "PLACE,-1,-1,NORTH");
        command.execute();
        String currentLocation = robot.getCurrentLocation();

        Assertions.assertThat(currentLocation).containsOnlyOnce("(null,null),null");
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
}