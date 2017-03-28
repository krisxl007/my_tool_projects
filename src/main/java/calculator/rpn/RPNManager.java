package calculator.rpn;

import calculator.tools.RPNComputeTool;
import java.util.*;
import static calculator.constant.OperatorConstant.*;

/**
 * This is the class to handle users input args
 * with Reverse Polish Notation algorithm.
 */
public class RPNManager {

    public List<String> baseList;
    private static final Stack<String> RPN_OPT_STACK = new Stack<>();
    private static final Stack<String> COMPUTE_STACK = new Stack<>();
    private static final List<String> POST_FIX_LIST = new LinkedList<>();

    public RPNManager(List<String> baseList) {
        this.baseList = baseList;
    }

    public String computeAndGetResult(List<String> postfixList) {
        for(String element : postfixList) {
            switch (element) {
                case OPT_PLUS :
                    COMPUTE_STACK
                            .push(RPNComputeTool.plus(COMPUTE_STACK.pop(), COMPUTE_STACK.pop()));
                    break;
                case OPT_MINUS :
                    COMPUTE_STACK
                            .push(RPNComputeTool.minus(COMPUTE_STACK.pop(), COMPUTE_STACK.pop()));
                    break;
                case OPT_MULTIPLY:
                    COMPUTE_STACK
                            .push(RPNComputeTool.multiply(COMPUTE_STACK.pop(), COMPUTE_STACK.pop()));
                    break;
                case OPT_DIVIDE :
                    COMPUTE_STACK
                            .push(RPNComputeTool.divide(COMPUTE_STACK.pop(), COMPUTE_STACK.pop()));
                    break;
                default:
                    COMPUTE_STACK.push(element);
                    break;
            }
        }

        return COMPUTE_STACK.pop();
    }

    public List<String> getPostfixList() {
        for(String element : baseList) {
            switch (element) {
                case OPT_PLUS :
                    handleLowerOperator(element);
                    break;
                case OPT_MINUS :
                    handleLowerOperator(element);
                    break;
                case OPT_MULTIPLY:
                    RPN_OPT_STACK.push(element);
                    break;
                case OPT_DIVIDE :
                    RPN_OPT_STACK.push(element);
                    break;
                case OPT_OPEN_PAREN :
                    RPN_OPT_STACK.push(element);
                    break;
                case OPT_CLOSE_PAREN :
                    while (!OPT_OPEN_PAREN.equals(RPN_OPT_STACK.peek())) {
                        POST_FIX_LIST.add(RPN_OPT_STACK.pop());
                    }
                    RPN_OPT_STACK.pop();
                    break;
                default:
                    POST_FIX_LIST.add(element);
                    break;
            }
        }

        while (!RPN_OPT_STACK.isEmpty()) {
            POST_FIX_LIST.add(RPN_OPT_STACK.pop());
        }

        return POST_FIX_LIST;
    }

    private void handleLowerOperator(String operator) {
        if(RPN_OPT_STACK.isEmpty()) {
            RPN_OPT_STACK.push(operator);
        } else if(OPT_MULTIPLY.equals(RPN_OPT_STACK.peek()) || OPT_DIVIDE.equals(RPN_OPT_STACK.peek())) {
            while (!RPN_OPT_STACK.isEmpty()) {
                POST_FIX_LIST.add(RPN_OPT_STACK.pop());
            }
            RPN_OPT_STACK.push(operator);
        } else {
            RPN_OPT_STACK.push(operator);
        }
    }
}
