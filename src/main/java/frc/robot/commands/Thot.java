package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.mechanisms.Shooter;

public class Thot extends Command {

    public Thot() {
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
