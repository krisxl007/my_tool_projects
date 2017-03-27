package calculator.handlers;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import java.util.List;

public class ArgsToListHandlerTest {

    private static final String[] GIVEN_ARGS = {"9+(3-1)*3+10/2"};

    @Test
    public void givenValidArgsThenReturnCorrectCharArray() {
        IArgsHandler handler = new ArgsToListHandler();
        List<String> convertedList = (List<String>) handler.handle(GIVEN_ARGS);

        Assertions.assertThat(convertedList)
                .containsExactly("9", "+", "(", "3", "-", "1", ")", "*", "3", "+", "10", "/", "2");
    }


}