package org.usfirst.frc.team5822.robot.subsystems;

import javax.swing.JOptionPane;

import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Sensors extends Subsystem 
{
	static Potentiometer pot;
	static ADXRS450_Gyro gyro;
	static Encoder leftEncoder, rightEncoder;
	static double gyroAngle;
	
	public Sensors()
	{
		//pot = new AnalogPotentiometer(0, 360);
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
		
	}
	public double getPotential()
	{
		double returnPotential;
		returnPotential = pot.get();
		return returnPotential;
	}
	public static void resetEncoders()
	{
		rightEncoder.reset();
		leftEncoder.reset();
	}
	public static void resetGyro()
	{
		gyro.reset();
	}
	
	public static double getGyro()
	{
		gyroAngle = gyro.getAngle();
		return gyroAngle;
	}
	public static double rightEncoderDistance()
	{
		System.out.println("Right Encoder Distance: " + rightEncoder.getDistance());
		
		//Temporary measure to test the autoDrive
		return rightEncoder.getDistance();
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

