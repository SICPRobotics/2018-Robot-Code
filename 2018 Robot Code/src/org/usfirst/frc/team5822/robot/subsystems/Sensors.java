package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import com.ctre.phoenix.*;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class Sensors extends Subsystem 
{
	static ADXRS450_Gyro gyro;
	static Encoder leftEncoder, rightEncoder;
	static double gyroAngle;
	//static AnalogPotentiometer pot;
	
	public Sensors()
	{
		if (Robot.isOldRobot) 
		{
		//	pot = new AnalogPotentiometer(RobotMap.k_pot, 3600, -180); 
			return;
		}
		gyro = new ADXRS450_Gyro();
		
		leftEncoder = new Encoder(RobotMap.k_leftEncoder_A, RobotMap.k_leftEncoder_B, false, Encoder.EncodingType.k4X);
		leftEncoder.setMaxPeriod(.1);
		leftEncoder.setMinRate(10);
		leftEncoder.setDistancePerPulse(5);
		leftEncoder.setReverseDirection(true);
		leftEncoder.setSamplesToAverage(7);
		
		rightEncoder = new Encoder(RobotMap.k_rightEncoder_A, RobotMap.k_rightEncoder_B, false, Encoder.EncodingType.k4X);
		rightEncoder.setMaxPeriod(.1);
		rightEncoder.setMinRate(10);
		rightEncoder.setDistancePerPulse(.0532);
		rightEncoder.setReverseDirection(false);
		rightEncoder.setSamplesToAverage(7);
		rightEncoder.setReverseDirection(true);
		//pot = new AnalogPotentiometer(RobotMap.k_pot); 
	}
	
	public double getPot()
	{
	//	System.out.println("Sensors getPot");
	//	if (Robot.isOldRobot) return 0;
//		System.out.println("Pot: " + pot.get());
		//return pot.get();
		return 0;
		//TODO: move all pot stuff to new subsystem
	}
	
	public void resetEncoders()
	{
		System.out.println("Sensors resetEncoders");
		if (Robot.isOldRobot) return;
		rightEncoder.reset();
		leftEncoder.reset();
	}
	public void resetGyro()
	{
		System.out.println("Sensors resetGyro");
		if (Robot.isOldRobot) return;		
		gyro.reset();
		System.out.println(" Reset Gyro " + gyro.getAngle());
	}
	
	public double getGyro()
	{
		//System.out.println("Sensors getGyro");
		if (Robot.isOldRobot) return 0;
		return gyro.getAngle();
	}
	
	public double rightEncoderDistance()
	{
		System.out.println("Sensors rightEncoderDistance");
		if (Robot.isOldRobot) return 0;
		System.out.print("Right Encoder Distance: " + rightEncoder.getDistance() + " ");
		return rightEncoder.getDistance();
	}
	
    public void initDefaultCommand() {}
}

