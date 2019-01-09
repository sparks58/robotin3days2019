package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Shoot extends CommandGroup {
    public Shoot() {
        addSequential(new SpinWheel());
        addParallel(new BeGone());

    }
}
