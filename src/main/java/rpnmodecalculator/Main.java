package rpnmodecalculator;

import rpnmodecalculator.rpn.RPNManager;
import java.util.Scanner;
import static rpnmodecalculator.constant.OperatorConstant.*;

public class Main {

    public static void main(String[] args) {

        RPNManager manager = new RPNManager();

        System.out.println("Support operators so far: " +
                OPT_PLUS + " " + OPT_MINUS + " " + OPT_MULTIPLY + " " +
                OPT_DIVIDE + " " + OPT_SQRT + " " + OPT_UNDO + " " + OPT_CLEAR);
        System.out.println("Please input your parameters：");

        while(true) {
            Scanner sc = new Scanner(System.in);
            manager.compute(sc.nextLine());

            System.out.println("Stack:" + manager.getStack());
        }
    }
}
