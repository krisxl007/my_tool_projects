package rpnmodecalculator.tools;

import java.math.BigDecimal;

public class RPNComputeTool {

    private static final int SCALE = 10;

    public static String plus(String firstTopNumber, String secondTopNumber) {
        BigDecimal firstNumber = new BigDecimal(firstTopNumber);
        BigDecimal secondNumber = new BigDecimal(secondTopNumber);
        return secondNumber.add(firstNumber).toPlainString();
    }

    public static String minus(String firstTopNumber, String secondTopNumber) {
        BigDecimal firstNumber = new BigDecimal(firstTopNumber);
        BigDecimal secondNumber = new BigDecimal(secondTopNumber);
        return secondNumber.subtract(firstNumber).toPlainString();
    }

    public static String multiply(String firstTopNumber, String secondTopNumber) {
        BigDecimal firstNumber = new BigDecimal(firstTopNumber);
        BigDecimal secondNumber = new BigDecimal(secondTopNumber);
        return secondNumber.multiply(firstNumber).toPlainString();
    }

    public static String divide(String firstTopNumber, String secondTopNumber) {
        BigDecimal firstNumber = new BigDecimal(firstTopNumber);
        BigDecimal secondNumber = new BigDecimal(secondTopNumber);
        return secondNumber.divide(firstNumber).toPlainString();
    }

    public static String sqrt(String topNumber) {
        BigDecimal sqrt = new BigDecimal(Math.sqrt(Double.valueOf(topNumber)));
        return sqrt.setScale(SCALE, BigDecimal.ROUND_DOWN).toPlainString();
    }
}
