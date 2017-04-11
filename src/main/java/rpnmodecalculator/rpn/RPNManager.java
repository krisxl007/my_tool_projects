package rpnmodecalculator.rpn;

import rpnmodecalculator.tools.CommonTool;
import rpnmodecalculator.tools.RPNComputeTool;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static rpnmodecalculator.constant.OperatorConstant.*;

/**
 * This is the class to handle users input args
 * with Reverse Polish Notation algorithm.
 */
public class RPNManager {

    private final Stack<String> STACK = new Stack<>();
    private final Stack<String> UNDO_STACK = new Stack<>();

    public void compute(String inputParameter) {
        Map<String, String> parameters = CommonTool.generateMap(inputParameter);
        for(Map.Entry entry : parameters.entrySet()) {
            String element = (String) entry.getValue();
            try {
                if(CommonTool.isValidInput(element)) {
                    switch (element) {
                        case OPT_PLUS:
                            STACK.push(RPNComputeTool.plus(UNDO_STACK.push(STACK.pop()), UNDO_STACK.push(STACK.pop())));
                            break;
                        case OPT_MINUS:
                            STACK.push(RPNComputeTool.minus(UNDO_STACK.push(STACK.pop()), UNDO_STACK.push(STACK.pop())));
                            break;
                        case OPT_MULTIPLY:
                            STACK.push(RPNComputeTool.multiply(UNDO_STACK.push(STACK.pop()), UNDO_STACK.push(STACK.pop())));
                            break;
                        case OPT_DIVIDE:
                            STACK.push(RPNComputeTool.divide(UNDO_STACK.push(STACK.pop()), UNDO_STACK.push(STACK.pop())));
                            break;
                        case OPT_CLEAR:
                            STACK.clear();
                            break;
                        case OPT_SQRT:
                            STACK.push(RPNComputeTool.sqrt(UNDO_STACK.push(STACK.pop())));
                            break;
                        case OPT_UNDO:
                            STACK.pop();
                            if (!UNDO_STACK.isEmpty()) {
                                STACK.push(UNDO_STACK.pop());
                            }
                            if (!UNDO_STACK.isEmpty()) {
                                STACK.push(UNDO_STACK.pop());
                            }
                            break;
                        default:
                            STACK.push(element);
                            break;
                    }
                }
            }catch (EmptyStackException ese) {
                System.out.println("operator <" + element + "> (position: <" +
                        ((Integer.valueOf((String)entry.getKey())) + 1) + ">): insufficient parameters");
                System.out.println("Stack:" + STACK.push(UNDO_STACK.pop()));
                System.exit(0);
            }

        }
    }

    public Stack<String> getStack() {
        return STACK;
    }
}
