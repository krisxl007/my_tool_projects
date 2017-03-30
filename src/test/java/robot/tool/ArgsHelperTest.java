package robot.tool;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class ArgsHelperTest {

    @Test
    public void givenValidArgsShouldReturnTrue() throws Exception {
        String[] args = "PLACE,1,2,EAST MOVE MOVE LEFT MOVE REPORT".split(" ");
        boolean expectTrue = ArgsHelper.isArgsValid(args);

        Assertions.assertThat(expectTrue).isTrue();
    }

    @Test
    public void givenInvalidArgsShouldReturnFalse() throws Exception {
        String[] args = "PLACE,1,2,EAST MOVE MOVE LEFT PLACE,invalidX,2,EAST MOVE REPORT".split(" ");
        boolean expectTrue = ArgsHelper.isArgsValid(args);

        Assertions.assertThat(expectTrue).isTrue();
    }

    @Test
    public void givenValidArgsShouldBeConvertToList() throws Exception {
        String[] args = "PLACE,1,2,EAST MOVE MOVE LEFT PLACE,1,2,EAST MOVE REPORT".split(" ");
        List<String> convertedList = ArgsHelper.buildCommandList(args);

        Assertions.assertThat(convertedList)
                .containsExactly("PLACE,1,2,EAST", "MOVE", "MOVE", "LEFT", "PLACE,1,2,EAST", "MOVE", "REPORT");
    }

}