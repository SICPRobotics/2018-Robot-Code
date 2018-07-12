package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.Robot;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Sensors extends Subsystem 
{
	static ADXRS450_Gyro gyro;
	static double gyroAngle;

	public Sensors()
	{
		gyro = new ADXRS450_Gyro();
	}

	public void resetGyro()
	{
		System.out.println("Sensors resetGyro");	
		gyro.reset();
		System.out.println(" Reset Gyro " + gyro.getAngle());
	}
	
	public double getGyro()
	{
	//	System.out.println("gyro: " + gyro.getAngle());
		return gyro.getAngle();
	}
	
    public void initDefaultCommand() {}
}

