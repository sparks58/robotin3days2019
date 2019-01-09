package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Kick extends CommandGroup {
    public Kick() {
        addSequential(new BeGone());
        addSequential(new WaitCommand(3));
        addSequential(new Thot());
    }
}
