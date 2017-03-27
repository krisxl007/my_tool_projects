package calculator.handlers;

/**
 * Created by Xin on 3/27/2017.
 */
public abstract class AArgsHandler implements IArgsHandler {

    protected boolean isNull(String[] args) {
        return args.length > 0 ? false : true;
    }
}
