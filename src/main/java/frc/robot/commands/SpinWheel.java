package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SpinWheel extends Command {
    SpinWheel() {
        requires(Robot.shooter);
        setTimeout(4.0);
    }

    @Override
    protected void execute() {
        Robot.shooter.shooterOut();
    }

    @Override
    protected void end() {
        Robot.shooter.stop();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}
