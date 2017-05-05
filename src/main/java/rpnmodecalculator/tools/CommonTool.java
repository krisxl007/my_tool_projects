package rpnmodecalculator.tools;

import org.apache.commons.lang3.math.NumberUtils;
import rpnmodecalculator.constant.OperatorConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonTool {

    public static Stack<String> pushAllToStack(String str) {
        return Stream.of(str.split(" "))
                .collect(Collectors.toCollection(Stack::new));
    }

    public static boolean isValidInput(String input) {
        return Optional.ofNullable(input)
                .map((n) -> isNumeric(n) || OperatorConstant.allOperators.contains(n))
                .orElse(false);
    }

    public static boolean isNumeric(String str){
        return NumberUtils.isCreatable(str);
    }


    public static Map<String, String> generateMap(String inputParameter) {
        final Map<String, String> map = new LinkedHashMap<>();
        final String[] temp = {inputParameter};

        Stream.of(inputParameter.split(" "))
                .filter(input -> !"".equals(input))
                .forEach((input) -> {
                    map.put(String.valueOf(temp[0].indexOf(input) + 1), input);
                    Optional.of(OperatorConstant.allOperators.contains(input))
                            .ifPresent((t) -> temp[0] = temp[0].replaceFirst("[" + input + "]", " "));

                });
        return map;
    }
}
