package calculator.tools;

import org.apache.commons.lang3.math.NumberUtils;

public class CommonTool {

    public static boolean isValidNumber(String number) {
        if(null == number) {
            throw new RuntimeException("Given number is null, please check again!");
        }else if(!isNumeric(number)) {
            throw new RuntimeException("Given number is not a valid number, please check again!");
        }else {
            return true;
        }

    }

    public static boolean isNumeric(String str){
        //TODO: find out better solution for checking a number
        return NumberUtils.isNumber(str);
    }
}
