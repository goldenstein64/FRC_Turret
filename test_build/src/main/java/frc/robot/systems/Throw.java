package frc.robot.systems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

public class Throw {
    public static WPI_TalonSRX talonMain = new WPI_TalonSRX(4);
    public static WPI_VictorSPX victorSlave = new WPI_VictorSPX(2);

    public static boolean enabled = false;

    public static void init() {
        talonMain.configFactoryDefault();
        victorSlave.configFactoryDefault();

        victorSlave.follow(talonMain);
        victorSlave.setInverted(InvertType.FollowMaster);

        talonMain.setSelectedSensorPosition(0);
        victorSlave.setSelectedSensorPosition(0);

    }

    public static void setEnabled(boolean enabled) {
        Throw.enabled = enabled;
    }

    public static void update() {
        talonMain.set(ControlMode.PercentOutput, Throw.enabled ? -1 : 0);
    }
}