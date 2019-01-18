package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Retract extends Command {

    public Retract() {
        requires(Robot.shooter);
    }
    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        Robot.shooter.unKick();

    }


}
