package calculator.handlers;

import calculator.tools.ArgsHelper;

public class ArgsToListHandler extends AArgsHandler{

    @Override
    public Object handle(final String[] args) {
        if(isNull(args)) {
            System.out.println("Input Args can not be empty, please input again!");
            throw new RuntimeException("Input Args can not be empty, please input again!");
        }
        if(args.length > 1) {
            System.out.println("Not support more than one operand operation!");
            throw new RuntimeException("Not support more than one operand operation!");
        }

        return handleStringToList(args[0]);
    }

    public Object handleStringToList(final String arg) {
        return ArgsHelper.parseArgsToList(arg);
    }
}
