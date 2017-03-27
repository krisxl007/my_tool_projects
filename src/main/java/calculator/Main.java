package calculator;

import calculator.handlers.ArgsToListHandler;
import calculator.handlers.IArgsHandler;
import calculator.rpn.RPNManager;

import java.util.List;

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

        System.out.println(result);
    }


}
