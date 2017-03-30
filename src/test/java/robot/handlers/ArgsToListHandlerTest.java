package robot.handlers;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;


public class ArgsToListHandlerTest {

    @Test
    public void givenSomeArgsShouldConvertToAList() throws Exception {

        String[] args = "PLACE,1,2,EAST MOVE MOVE LEFT PLACE,1,2,NORTH MOVE REPORT".split(" ");

        IArgsHandler handler = new ArgsToListHandler(args);
        List<String> argsList = (List<String>) handler.handle();

        Assertions.assertThat(argsList)
                .containsExactly("PLACE,1,2,EAST", "MOVE", "MOVE", "LEFT", "PLACE,1,2,NORTH", "MOVE", "REPORT");
    }

}