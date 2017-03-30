package robot.tool;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class CommandHelperTest {
    @Test
    public void checkIfPlaceCommand() throws Exception {
        boolean expectTrue = CommandHelper.checkIfPlaceCommand("PLACE,1,2,EAST");
        boolean expectFalse = CommandHelper.checkIfPlaceCommand("DUMMY,1,2,EAST");

        Assertions.assertThat(expectTrue).isTrue();
        Assertions.assertThat(expectFalse).isFalse();
    }

    @Test
    public void getConfigUnitSize() throws Exception {
        int size = CommandHelper.getConfigUnitSize();

        Assertions.assertThat(size).isEqualTo(5);
    }

}