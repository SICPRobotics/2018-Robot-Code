package org.usfirst.frc.team5822.robot.subsystems;

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
	
	public Sensors()
	{
//		pot = new AnalogPotentiometer(0, 360);
//		gyro = new ADXRS450_Gyro();
//		leftEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
//		leftEncoder.setMaxPeriod(.1);
//		leftEncoder.setMinRate(10);
//		leftEncoder.setDistancePerPulse(5);
//		leftEncoder.setReverseDirection(true);
//		leftEncoder.setSamplesToAverage(7);
//		
		//rightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		//rightEncoder.setMaxPeriod(.1);
		//rightEncoder.setMinRate(10);
		//rightEncoder.setDistancePerPulse(.0532);
		//rightEncoder.setReverseDirection(false);
		//rightEncoder.setSamplesToAverage(7);
		
	}
	public double getPotential()
	{
		double returnPotential;
		returnPotential = pot.get();
		return returnPotential;
	}
	public static void resetGyro()
	{
		leftEncoder.reset();
		rightEncoder.reset();
	}

	public static double rightEncoderDistance()
	{
		System.out.println("Right Encoder");
		return 90;
		
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

