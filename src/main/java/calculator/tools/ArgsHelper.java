package calculator.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import static calculator.constant.OperatorConstant.*;
import static calculator.constant.OperatorConstant.OPT_CLOSE_PAREN;
import static calculator.constant.OperatorConstant.OPT_OPEN_PAREN;

public class ArgsHelper {

    private static String initExpress(String exp){
        String reStr;
        reStr = exp.replaceAll("\\s", "");
        if(reStr.startsWith("-")){
            reStr = "0"+reStr;
        }
        reStr = reStr.replaceAll("\\(-", "(0-");
        return reStr;
    }

    public static List<String> parseArgsToList(String baseExp) {
        List<String> expList = new ArrayList<>();
        String expInited = initExpress(baseExp);

        StringTokenizer st = new StringTokenizer(expInited,"+-*/^%()",true);
        while(st.hasMoreElements()){
            expList.add(st.nextElement().toString().trim());
        }

        return expList;
    }

    public static String[] getInputArgs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Support operators so far: " + OPT_PLUS + OPT_MINUS + OPT_MULTIPLY + OPT_DIVIDE + OPT_OPEN_PAREN + OPT_CLOSE_PAREN);
        System.out.println("Please input your mathematical expression：");
        return new String[]{sc.nextLine()};
    }
}
