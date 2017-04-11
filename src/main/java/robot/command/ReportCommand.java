package robot.command;

import robot.Robot;

public class ReportCommand implements ICommand {

    private Robot robot;

    ReportCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.showCurrentLocation();
    }
}
