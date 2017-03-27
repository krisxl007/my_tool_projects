package calculator.handlers;

import calculator.tools.ArgsHelper;

public class ArgsToListHandler extends AArgsHandler{

    @Override
    public Object handle(final String[] args) {
        if(isNull(args))
            throw new RuntimeException("Input Args can not be empty, please input again!");

        if(args.length > 1) {
            throw new RuntimeException("More than one operand operation!");
        }

        return handleStringToList(args[0]);
    }

    public Object handleStringToList(final String arg) {
        return ArgsHelper.parseArgsToList(arg);
    }
}
