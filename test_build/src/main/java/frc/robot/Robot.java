/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import frc.robot.Input;
import frc.robot.systems.*;

/**
 * The VM is configured to automatically run this class. If you change the name
 * of this class or the package after creating this project, you must also
 * update the build.gradle file in the project.
 */
public class Robot extends TimedRobot {

	@Override
	public void robotInit() {
		System.out.println("init");

		Input.init();
		Camera.init();

		Turn.init();
		Throw.init();
	}

	@Override
	public void disabledInit() {
		Throw.setEnabled(false);
		Camera.setEnabled(false);
		Turn.turn(0);
	}

	@Override
	public void autonomousInit() {
		Throw.setEnabled(true);
	}

	@Override
	public void autonomousPeriodic() {
		Throw.update();
	}

	@Override
	public void teleopInit() {

	}

	@Override
	public void teleopPeriodic() {
		Input.update();
		Camera.update();

		Turn.update();
		Throw.update();
	}

	@Override
	public void testInit() {
	}

	@Override
	public void testPeriodic() {
	}
}
