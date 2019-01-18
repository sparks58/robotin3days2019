package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ShootGroup extends CommandGroup {
    public ShootGroup() {
        addSequential(new Extend());
        addSequential(new WaitCommand(3));
        addSequential(new Retract());
    }
}
