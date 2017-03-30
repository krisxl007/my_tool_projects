package robot.command;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Arrays;
import java.util.List;


public class MarcoCommandTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void givenValidCommandShouldMove() throws Exception {
        List<String> commandList = Arrays.asList("PLACE,1,2,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "REPORT");
        ICommand command = new MarcoCommand(commandList);
        command.execute();

        Assertions.assertThat(systemOutRule.getLog()).containsOnlyOnce("Robot current location: {3,3},NORTH");
    }

    @Test
    public void givenValidCommandButOverEdgeShouldWarnAndStop() throws Exception {
        List<String> commandList = Arrays.asList("PLACE,2,2,SOUTH", "MOVE", "RIGHT", "MOVE", "MOVE", "MOVE", "REPORT");
        ICommand command = new MarcoCommand(commandList);
        command.execute();

        Assertions.assertThat(systemOutRule.getLog()).containsOnlyOnce("Warning! Can not move farward anymore!");
    }

}