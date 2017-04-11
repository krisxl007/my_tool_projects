package rpnmodecalculator.constant;

import java.util.Arrays;
import java.util.List;

public class OperatorConstant {

    public static final String OPT_PLUS = "+";
    public static final String OPT_MINUS = "-";
    public static final String OPT_MULTIPLY = "*";
    public static final String OPT_DIVIDE = "/";
    public static final String OPT_SQRT = "sqrt";
    public static final String OPT_UNDO = "undo";
    public static final String OPT_CLEAR = "clear";

    public static final List<String> allOperators
            = Arrays.asList(OPT_PLUS, OPT_MINUS, OPT_MULTIPLY, OPT_DIVIDE, OPT_SQRT, OPT_UNDO, OPT_CLEAR);
}
