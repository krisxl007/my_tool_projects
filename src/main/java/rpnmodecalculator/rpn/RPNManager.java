package rpnmodecalculator.rpn;

import rpnmodecalculator.tools.CommonTool;
import rpnmodecalculator.tools.RPNComputeTool;

import java.util.*;

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
                Optional.of(CommonTool.isValidInput(element)).filter(isTrue -> isTrue).ifPresent(t -> {
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
                            Optional.of(!UNDO_STACK.isEmpty())
                                    .filter(isTrue -> isTrue)
                                    .ifPresent(n -> STACK.push(UNDO_STACK.pop()));
                            Optional.of(!UNDO_STACK.isEmpty())
                                    .filter(isTrue -> isTrue)
                                    .ifPresent(n -> STACK.push(UNDO_STACK.pop()));
                            break;
                        default:
                            STACK.push(element);
                            break;
                    }
                });
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
