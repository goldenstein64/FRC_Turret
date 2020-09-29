package frc.robot.systems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

public class Turn {
    public static WPI_TalonSRX talon = new WPI_TalonSRX(0);

    public static double speed = 0;

    public static void init() {
        talon.configFactoryDefault();

        double position = talon.getSelectedSensorPosition();
        System.out.println(position);
    }

    public static void turn(double speed) {
        Turn.speed = speed;
    }

    public static void update() {
        talon.set(TalonSRXControlMode.PercentOutput, speed);
    }
}