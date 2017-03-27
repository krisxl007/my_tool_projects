package calculator.rpn;

import calculator.handlers.ArgsToListHandler;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class RPNManagerTest {

    private List<String> baseList;

    @Before
    public void setUp() throws Exception {
        ArgsToListHandler handler = new ArgsToListHandler();
        String givenExpression = "9+(3-1)*3+10/2";
        baseList = (List<String>) handler.handleStringToList(givenExpression);
    }

    @Test
    public void givenBaseListShouldReturnPostfixList() throws Exception {
        RPNManager manager = new RPNManager(baseList);
        List<String> postfixList = manager.getPostfixList();

        Assertions.assertThat(postfixList)
                .contains("9", "3", "1", "-", "3", "*", "+", "10", "2", "/", "+");
    }


    @Test
    public void givenExpressionShouldReturnComputedResult() throws Exception {
        BigDecimal expectedResult = new BigDecimal("20");

        RPNManager manager = new RPNManager(baseList);
        List<String> postfixList = manager.getPostfixList();
        String result = manager.computeAndGetResult(postfixList);

        Assertions.assertThat(result).isEqualTo(expectedResult.toString());
    }
}