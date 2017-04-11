package rpnmodecalculator.tools;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RPNComputeToolTest {

    private String firstNumber1 = "5";
    private String secondNumber1 = "10";
    private String firstNumber2 = "5.3";
    private String secondNumber2 = "10.6";
    private String firstNumber3 = "-5.3";
    private String secondNumber3 = "-10.6";

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void giveTwoNumberToComputePlusResult() throws Exception {
        String result1 = RPNComputeTool.plus(firstNumber1, secondNumber1);
        String result2 = RPNComputeTool.plus(firstNumber2, secondNumber2);
        String result3 = RPNComputeTool.plus(firstNumber3, secondNumber3);

        Assertions.assertThat(result1).isEqualTo("15");
        Assertions.assertThat(result2).isEqualTo("15.9");
        Assertions.assertThat(result3).isEqualTo("-15.9");
    }

    @Test
    public void giveTwoNumberToComputeMinusResult() throws Exception {
        String result1 = RPNComputeTool.minus(firstNumber1, secondNumber1);
        String result2 = RPNComputeTool.minus(firstNumber2, secondNumber2);
        String result3 = RPNComputeTool.minus(firstNumber3, secondNumber3);

        Assertions.assertThat(result1).isEqualTo("5");
        Assertions.assertThat(result2).isEqualTo("5.3");
        Assertions.assertThat(result3).isEqualTo("-5.3");
    }

    @Test
    public void giveTwoNumberToComputeMultiplyResult() throws Exception {
        String result1 = RPNComputeTool.multiply(firstNumber1, secondNumber1);
        String result2 = RPNComputeTool.multiply(firstNumber2, secondNumber2);
        String result3 = RPNComputeTool.multiply(firstNumber3, secondNumber3);

        Assertions.assertThat(result1).isEqualTo("50");
        Assertions.assertThat(result2).isEqualTo("56.18");
        Assertions.assertThat(result3).isEqualTo("56.18");
    }

    @Test
    public void giveTwoNumberToComputeDivideResult() throws Exception {
        String result1 = RPNComputeTool.divide(firstNumber1, secondNumber1);
        String result2 = RPNComputeTool.divide(firstNumber2, secondNumber2);
        String result3 = RPNComputeTool.divide(firstNumber3, secondNumber3);

        Assertions.assertThat(result1).isEqualTo("2");
        Assertions.assertThat(result2).isEqualTo("2");
        Assertions.assertThat(result3).isEqualTo("2");
    }

    @Test
    public void giveValidNumberShouldComputeSqrt() throws Exception {
        String givenNumber = "2";
        String result = RPNComputeTool.sqrt(givenNumber);;

        Assertions.assertThat(result).isEqualTo("1.4142135623");
    }
}