package frc.robot.systems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;

public class Camera {
    public static NetworkTable data = NetworkTableInstance.getDefault().getTable("limelight");

    public static boolean enabled = false;

    public static void init() {
        
    }

    public static void setEnabled(boolean enabled) {
        Camera.enabled = enabled;
    }

    public static void update() {
        boolean hasTarget = data.getEntry("tv").getDouble(0) == 1 ? true : false;
        //System.out.println(hasTarget);
    }
}