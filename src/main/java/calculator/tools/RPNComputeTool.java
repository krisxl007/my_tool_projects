package calculator.tools;

import java.math.BigDecimal;

public class RPNComputeTool {

    public static String plus(String firstTopNumber, String secondTopNumber) {
        checkIfNumberValid(firstTopNumber, secondTopNumber);
        BigDecimal firstNumber = new BigDecimal(firstTopNumber);
        BigDecimal secondNumber = new BigDecimal(secondTopNumber);
        return secondNumber.add(firstNumber).toString();
    }

    public static String minus(String firstTopNumber, String secondTopNumber) {
        checkIfNumberValid(firstTopNumber, secondTopNumber);
        BigDecimal firstNumber = new BigDecimal(firstTopNumber);
        BigDecimal secondNumber = new BigDecimal(secondTopNumber);
        return secondNumber.subtract(firstNumber).toString();
    }

    public static String multiply(String firstTopNumber, String secondTopNumber) {
        checkIfNumberValid(firstTopNumber, secondTopNumber);
        BigDecimal firstNumber = new BigDecimal(firstTopNumber);
        BigDecimal secondNumber = new BigDecimal(secondTopNumber);
        return secondNumber.multiply(firstNumber).toString();
    }

    public static String divide(String firstTopNumber, String secondTopNumber) {
        checkIfNumberValid(firstTopNumber, secondTopNumber);
        BigDecimal firstNumber = new BigDecimal(firstTopNumber);
        BigDecimal secondNumber = new BigDecimal(secondTopNumber);
        return secondNumber.divide(firstNumber).toString();
    }

    private static void checkIfNumberValid(String firstNumber, String secondNumber) {
        CommonTool.isValidNumber(firstNumber);
        CommonTool.isValidNumber(secondNumber);
    }
}
