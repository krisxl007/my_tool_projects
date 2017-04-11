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

        Assertions.assertThat(stack).isInstanceOf(Stack.class);
        Assertions.assertThat(stack)
                .containsSequence("1", "2", "3", "4", "5", "+", "-", "*", "/");
    }

    @Test
    public void generateMap() throws Exception {
        String inputString = "12 34 5 * * / /";
        Map<String, String> map = CommonTool.generateMap(inputString);

        Assertions.assertThat(map).isInstanceOf(Map.class);
        Assertions.assertThat(map).containsValues("12", "34", "5", "*", "*", "/", "/");
    }

}