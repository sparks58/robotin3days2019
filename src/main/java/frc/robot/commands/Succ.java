package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.mechanisms.Shooter;

public class Succ extends Command {
//    private Shooter shooter = new Shooter();
    public Succ() {
        requires(Robot.shooter);
        setTimeout(3);
    }
    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        Robot.shooter.shooterIn();
    }
}
