package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Extend extends Command {

    public Extend() {
        requires(Robot.shooter);
        setTimeout(1);
    }
    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void execute() {
        Robot.shooter.kick();

    }

    @Override
    protected void end() {
        Robot.shooter.unKick();
    }
}
