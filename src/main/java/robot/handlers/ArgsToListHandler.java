package robot.handlers;

import robot.tool.ArgsHelper;
import java.util.List;

public class ArgsToListHandler implements IArgsHandler{

    private String[] args;

    public ArgsToListHandler(String[] args) {
        this.args = args;
    }

    @Override
    public Object handle() {
        List<String> argsList;

        if(ArgsHelper.isArgsValid(args)) {
            argsList = ArgsHelper.buildCommandList(args);
        }else {
            System.out.println("Input arguments is invalid, please try again!");
            throw new RuntimeException();
        }

        return argsList;
    }
}
