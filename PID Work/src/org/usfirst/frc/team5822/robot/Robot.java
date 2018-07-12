package org.usfirst.frc.team5822.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;

public class Robot extends TimedRobot 
{
	public static DriveTrain driveTrain = new DriveTrain();
	int _loops = 0;
	
	@Override
	public void robotInit() 
	{

	}

	@Override
	public void disabledInit() 
	{
//		driveTrain.disable();
		//System.out.println(driveTrain.resetGyro());
	}

	@Override
	public void disabledPeriodic() 
	{
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void autonomousInit() 
	{
		//System.out.println(driveTrain.resetGyro());
		System.out.println(driveTrain.gyroAngle());
		driveTrain.setSetpoint(0);
		driveTrain.enable();
	}

	@Override
	public void autonomousPeriodic() 
	{
		//Scheduler.getInstance().run();
		if (++_loops >= 10) 
		{
			_loops = 0;
			System.out.println(driveTrain.gyroAngle());
			System.out.println(driveTrain.motorSpeeds());
		}
	}

	@Override
	public void teleopInit() 
	{
		//driveTrain.disable();
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void teleopPeriodic() 
	{
		System.out.println(driveTrain.gyroAngle());
	}

	@Override
	public void testPeriodic() {}
}
