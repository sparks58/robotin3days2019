package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.BeGone;
import frc.robot.commands.Shoot;
import frc.robot.commands.Succ;

public class OI {
    public static XboxController xbox1 = new XboxController(0);
//    private static final XboxController xbox2 = new XboxController(2);

//    public static final
    Button shootButton = new JoystickButton(xbox1, 1)
        , succButton = new JoystickButton(xbox1,2)
        , kickButton = new JoystickButton(xbox1, 5);
    Succ succ = new Succ();
    Shoot shoot = new Shoot();
    BeGone beGone = new BeGone();

    OI() {
        shootButton.whenPressed(shoot);
        succButton.whenPressed(succ);
        kickButton.whenPressed(beGone);
    }
}
