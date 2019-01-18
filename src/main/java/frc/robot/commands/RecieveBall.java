package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RecieveBall extends Command {
//    private Shooter shooter = new Shooter();
    public RecieveBall() {
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
