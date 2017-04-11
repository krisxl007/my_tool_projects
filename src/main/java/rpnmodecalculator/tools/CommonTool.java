package rpnmodecalculator.tools;

import org.apache.commons.lang3.math.NumberUtils;
import rpnmodecalculator.constant.OperatorConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class CommonTool {

    public static Stack<String> pushAllToStack(String str) {
        Stack<String> stack = new Stack<>();
        for(String each : str.split(" ")){
            stack.push(each);
        }
        return stack;
    }

    public static boolean isValidInput(String input) {
        if(OperatorConstant.allOperators.contains(input)) {
            return true;
        }else if(isNumeric(input)){
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String str){
        //TODO: find out better solution for checking a number
        return NumberUtils.isNumber(str);
    }


    public static Map<String, String> generateMap(String inputParameter) {
        Map<String, String> map = new LinkedHashMap<>();
        String temp = inputParameter;
        String[] parameters = inputParameter.split(" ");
        for(String parameter : parameters) {
            if(!"".equals(parameter)) {
                map.put(String.valueOf(temp.indexOf(parameter) + 1), parameter);
                if (OperatorConstant.allOperators.contains(parameter)) {
                    temp = temp.replaceFirst("[" + parameter + "]", " ");
                }
            }
        }
        return map;
    }
}
