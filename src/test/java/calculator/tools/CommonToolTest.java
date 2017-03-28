package calculator.tools;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonToolTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();


    @Test
    public void givenValidNumberShouldReturnTrue() throws Exception {
        boolean value = CommonTool.isValidNumber("123.456");

        assertThat(value).isTrue();
    }

    @Test()
    public void givenNullValueShouldThrowRuntimeException() throws Exception {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Given number is null, please check again!");

        CommonTool.isValidNumber(null);
    }

    @Test
    public void givenInvalidNumberShouldThrowRuntimeException() throws Exception {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Given number is not a valid number, please check again!");

        CommonTool.isValidNumber("invalidNumber");
    }

    @Test
    public void givenSeveralValidNumbersShouldReturnTrue() throws Exception {
        boolean value1 = CommonTool.isNumeric("12345");
        boolean value2 = CommonTool.isNumeric("-12345");
        boolean value3 = CommonTool.isNumeric("12345.6789");
        boolean value4 = CommonTool.isNumeric("-12345.6789");
        boolean value5 = CommonTool.isNumeric("0");

        Assertions.assertThat(value1).isTrue();
        Assertions.assertThat(value2).isTrue();
        Assertions.assertThat(value3).isTrue();
        Assertions.assertThat(value4).isTrue();
        Assertions.assertThat(value5).isTrue();
    }

    @Test
    public void givenSeveralInvalidNumbersShouldReturnFalse() throws Exception {
        boolean value1 = CommonTool.isNumeric("abc");
        boolean value2 = CommonTool.isNumeric("-1ab");
        boolean value3 = CommonTool.isNumeric("12.345.67.89");
        boolean value4 = CommonTool.isNumeric("0.0.0");
        boolean value5 = CommonTool.isNumeric(null);

        Assertions.assertThat(value1).isFalse();
        Assertions.assertThat(value2).isFalse();
        Assertions.assertThat(value3).isFalse();
        Assertions.assertThat(value4).isFalse();
        Assertions.assertThat(value5).isFalse();
    }

}