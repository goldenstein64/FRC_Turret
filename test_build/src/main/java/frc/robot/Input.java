package frc.robot;

import frc.robot.systems.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.Joystick;

public class Input {

    public static Joystick controller = new Joystick(0);

    public static JoystickButton[] buttons = new JoystickButton[13];
    public static POVButton DPadDown = new POVButton(controller, 0);
    public static POVButton DPadRight = new POVButton(controller, 90);
    public static POVButton DPadUp = new POVButton(controller, 180);
    public static POVButton DPadLeft = new POVButton(controller, 270);

    public static boolean[] lastState = new boolean[13];

    public static void init() {
        for (int i = 1; i <= 12; i++) {
            buttons[i] = new JoystickButton(controller, i);
            lastState[i] = false;
        }
    }

    public static void update() {

        { // toggle camera
            boolean toggle = buttons[4].get();
            if (lastState[4] != toggle) {
                lastState[4] = toggle;
                Camera.setEnabled(toggle);
            }
        }

        { // turning
            double position = controller.getRawAxis(2);
        
            Turn.turn(position);
        }

        { // shooting
            boolean shoot = buttons[2].get();

            if (lastState[2] != shoot) {
                lastState[2] = shoot;
                Throw.setEnabled(shoot);
            }
        }
    }
}