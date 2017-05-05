package rpnmodecalculator.rpn;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RPNManagerTest {

    @Test
    public void compute_invalid_input_case() throws Exception {
        String input = "5 a";
        RPNManager manager = new RPNManager();
        manager.compute(input);

        Assertions.assertThat(manager.getStack()).containsOnly("5");
    }

    /**
     * Example 1
        5 2
        stack: 5 2
     * @throws Exception
     */
    @Test
    public void compute_case1() throws Exception {
        String input = "5 2";
        RPNManager manager = new RPNManager();
        manager.compute(input);

        Assertions.assertThat(manager.getStack()).containsSequence("5", "2");
    }

    /**
     Example 2
     2 sqrt
     stack: 1.4142135623
     clear 9 sqrt
     stack: 3
     * @throws Exception
     */
    @Test
    public void compute_case2() throws Exception {
        String input = "2 sqrt";
        String input2 = "clear 9 sqrt";
        RPNManager manager = new RPNManager();
        manager.compute(input);

        Assertions.assertThat(manager.getStack()).containsSequence("1.4142135623");

        manager.compute(input2);

        Assertions.assertThat(manager.getStack()).containsSequence("3.0000000000");
    }

    /**
     * Example 3
     5 2 -
     stack: 3
     3 -
     stack: 0
     clear
     stack:
     * @throws Exception
     */
    @Test
    public void compute_case3() throws Exception {
        String input = "5 2 -";
        String input2 = "3 -";
        String input3 = "clear";
        RPNManager manager = new RPNManager();
        manager.compute(input);

        Assertions.assertThat(manager.getStack()).containsSequence("3");

        manager.compute(input2);

        Assertions.assertThat(manager.getStack()).containsSequence("0");

        manager.compute(input3);

        Assertions.assertThat(manager.getStack()).isEmpty();
    }

    /**
     * Example 4
     5 4 3 2
     stack: 5 4 3 2
     undo undo *
     stack: 20
     5 *
     stack: 100
     undo
     stack: 20 5
     * @throws Exception
     */
    @Test
    public void compute_case4() throws Exception {
        String input = "5 4 3 2";
        String input2 = "undo undo *";
        String input3 = "5 *";
        String input4 = "undo";
        RPNManager manager = new RPNManager();
        manager.compute("clear");
        manager.compute(input);

        Assertions.assertThat(manager.getStack()).containsSequence("5", "4", "3", "2");

        manager.compute(input2);

        Assertions.assertThat(manager.getStack()).containsSequence("20");

        manager.compute(input3);

        Assertions.assertThat(manager.getStack()).containsSequence("100");

        manager.compute(input4);

        Assertions.assertThat(manager.getStack()).containsSequence("20", "5");
    }

    /**
     * Example 5
     7 12 2 /
     stack: 7 6
     *
     stack: 42
     4 /
     stack: 10.5
     * @throws Exception
     */
    @Test
    public void compute_case5() throws Exception {
        String input = "7 12 2 /";
        String input2 = "*";
        String input3 = "4 /";
        RPNManager manager = new RPNManager();
        manager.compute(input);

        Assertions.assertThat(manager.getStack()).containsSequence("7", "6");

        manager.compute(input2);

        Assertions.assertThat(manager.getStack()).containsSequence("42");

        manager.compute(input3);

        Assertions.assertThat(manager.getStack()).containsSequence("10.5");
    }

    /**
     * Example 6
     1 2 3 4 5
     stack: 1 2 3 4 5
     *
     stack: 1 2 3 20
     clear 3 4 -
     stack: - 1
     * @throws Exception
     */
    @Test
    public void compute_case6() throws Exception {
        String input = "1 2 3 4 5";
        String input2 = "*";
        String input3 = "clear 3 4 -";
        RPNManager manager = new RPNManager();
        manager.compute(input);

        Assertions.assertThat(manager.getStack()).containsSequence("1", "2", "3", "4", "5");

        manager.compute(input2);

        Assertions.assertThat(manager.getStack()).containsSequence("1", "2", "3", "20");

        manager.compute(input3);

        Assertions.assertThat(manager.getStack()).containsSequence("-1");
    }

    /**
     * Example 7
     1 2 3 4 5
     stack: 1 2 3 4 5
     * * * *
     stack: 120
     * @throws Exception
     */
    @Test
    public void compute_case7() throws Exception {
        String input = "1 2 3 4 5";
        String input2 = "* * * *";
        RPNManager manager = new RPNManager();
        manager.compute(input);

        Assertions.assertThat(manager.getStack()).containsSequence("1", "2", "3", "4", "5");

        manager.compute(input2);

        Assertions.assertThat(manager.getStack()).containsSequence("120");
    }
}