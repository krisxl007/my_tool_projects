package rpnmodecalculator.tools;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Map;
import java.util.Stack;

public class CommonToolTest {

    @Test
    public void pushAllToStack() throws Exception {
        String inputString = "1 2 3 4 5 + - * /";
        Stack<String> stack = CommonTool.pushAllToStack(inputString);

        Assertions.assertThat(stack)
                .containsSequence("1", "2", "3", "4", "5", "+", "-", "*", "/");
    }

    @Test
    public void isValidInput() throws Exception {
        String input1 = "10";
        String input2 = "undo";
        String input3 = "dummy_value";
        String input4 = null;

        boolean expectTrue1 = CommonTool.isValidInput(input1);
        boolean expectTrue2 = CommonTool.isValidInput(input2);
        boolean expectFalse1 = CommonTool.isValidInput(input3);
        boolean expectFalse2 = CommonTool.isValidInput(input4);

        Assertions.assertThat(expectTrue1).isTrue();
        Assertions.assertThat(expectTrue2).isTrue();
        Assertions.assertThat(expectFalse1).isFalse();
        Assertions.assertThat(expectFalse2).isFalse();
    }

    @Test
    public void isNumeric() throws Exception {
        String input1 = "10";
        String input2 = "-10";
        String input3 = "0";
        String input4 = "dummy_value";
        String input5 = null;

        boolean expectTrue1 = CommonTool.isNumeric(input1);
        boolean expectTrue2 = CommonTool.isNumeric(input2);
        boolean expectTrue3 = CommonTool.isNumeric(input3);
        boolean expectFalse1 = CommonTool.isNumeric(input4);
        boolean expectFalse2 = CommonTool.isNumeric(input5);

        Assertions.assertThat(expectTrue1).isTrue();
        Assertions.assertThat(expectTrue2).isTrue();
        Assertions.assertThat(expectTrue3).isTrue();
        Assertions.assertThat(expectFalse1).isFalse();
        Assertions.assertThat(expectFalse2).isFalse();
    }

    @Test
    public void generateMap() throws Exception {
        String inputString = "12 34 5 * * / /";
        Map<String, String> map = CommonTool.generateMap(inputString);

        Assertions.assertThat(map).containsValues("12", "34", "5", "*", "*", "/", "/");
    }

}