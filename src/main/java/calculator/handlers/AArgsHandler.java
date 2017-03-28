package calculator.handlers;

public abstract class AArgsHandler implements IArgsHandler {

    protected boolean isNull(String[] args) {
        return args.length > 0 ? false : true;
    }
}
