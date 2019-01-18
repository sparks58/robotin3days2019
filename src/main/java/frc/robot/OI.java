package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Extend;
import frc.robot.commands.Shoot;
import frc.robot.commands.RecieveBall;

public class OI {
    public static XboxController xbox1 = new XboxController(0);
//    private static final XboxController xbox2 = new XboxController(2);

//    public static final
    Button shootButton = new JoystickButton(xbox1, 1)
        , succButton = new JoystickButton(xbox1,2)
        , kickButton = new JoystickButton(xbox1, 5);
    RecieveBall recieveBall = new RecieveBall();
    Shoot shoot = new Shoot();
    Extend extend = new Extend();

    OI() {
        shootButton.whenPressed(shoot);
        succButton.whenPressed(recieveBall);
        kickButton.whenPressed(extend);
    }
}
