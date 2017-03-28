package calculator;

import calculator.handlers.ArgsToListHandler;
import calculator.handlers.IArgsHandler;
import calculator.rpn.RPNManager;
import calculator.tools.CommonTool;

import java.util.List;

import static calculator.constant.OperatorConstant.*;

/**
 * Created by Kris Li on 3/27/2017.
 *
 * This is the calculator main class and the implementation
 * with "Reverse Polish Notation (RPN)" algorithm that from
 * a data structure book I read recently.
 *
 */
public class Main {

    /**
     * @param args users input args "9+(3-1)*3+10/2" for instance
     */
    public static void main(String[] args) {
        IArgsHandler handler = new ArgsToListHandler();
        List<String> baseList = (List<String>) handler.handle(args);

        RPNManager manager = new RPNManager(baseList);
        List<String> postfixList = manager.getPostfixList();
        String result = manager.computeAndGetResult(postfixList);

        if(CommonTool.isValidNumber(result)) {
            System.out.println(result);
        }else {
            System.out.println("Input mathematical expression is invalid, please try again");
            System.out.println("Support operator: " + OPT_PLUS + OPT_MINUS + OPT_MULTIPLY + OPT_DIVIDE + OPT_OPEN_PAREN + OPT_CLOSE_PAREN);
        }
    }


}
