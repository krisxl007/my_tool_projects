package calculator.tools;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ArgsHelperTest {

    @Test
    public void givenBaseExpressShouldBeConvertedToList() throws Exception {
        String givenExp = "9+(3-1)*3+10/2";
        List<String> expectedList = ArgsHelper.parseArgsToList(givenExp);

        Assert.assertEquals(13, expectedList.size());
    }

}