package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Drivetrain extends PIDSubsystem 
{
	WPI_TalonSRX frontL, frontR, rearL, rearR;
	static DifferentialDrive robotBase;
	SpeedControllerGroup left, right, autoDrive; 	
	
	static double setpoint; 
	public static boolean isTurning; 
	static boolean isBackwards; 
	
	public Drivetrain()
	{
		super("driveTrain", .04, 0.00, 0); 
		setAbsoluteTolerance(0.001);
		getPIDController().setContinuous(false);
		setpoint = 0; 
		isTurning = false; 
		isBackwards = false; 
				
		frontL = new WPI_TalonSRX(RobotMap.k_frontLeft); 
		rearL = new WPI_TalonSRX(RobotMap.k_rearLeft); 
		rearL.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
		frontR = new WPI_TalonSRX(RobotMap.k_frontRight); 
		rearR = new WPI_TalonSRX(RobotMap.k_rearRight); 
		rearR.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
				
		//rearL.setInverted(false);
		//rearL.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0); 
		//frontR.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0); 
		
		left = new SpeedControllerGroup(frontL, rearL);
		right = new SpeedControllerGroup(frontR, rearR);
		autoDrive = new SpeedControllerGroup(left, right);

		robotBase = new DifferentialDrive(left, right);
	}
	
	public double encDistance()
	{
		double rightEnc, leftEnc;
		int nativeUnits1 = rearL.getSelectedSensorPosition(0);
		leftEnc = nativeUnits1 * .0046019424 * -1;//.0092038847;
		int nativeUnits2 = rearR.getSelectedSensorPosition(0);
		rightEnc = nativeUnits2 * .0046019424;
		double dist =(leftEnc + rightEnc) /2;
		
		System.out.println("enc at " + dist);
		return dist;
	}
	public void resetEncoders()
	{
		System.out.println("reset encoders");
		rearL.setSelectedSensorPosition(0, 0, 0);
		rearR.setSelectedSensorPosition(0,0,0);
		System.out.println("encoders at " + encDistance());
	}
	
	// returns the sensor value that is providing the feedback for the system
	protected double returnPIDInput() 
	{    	
		return Robot.sensors.getGyro(); 
    }

	public static void pidBackwards(boolean backwards)
	{
		isBackwards = backwards; 
	}
	public void drive() 
	{
		robotBase.arcadeDrive(.5,0);
	}
    protected void usePIDOutput(double output) 
    {
//    		System.out.println("Output: " + output);
//    		if(isBackwards)
//    		{
//    			robotBase.tankDrive(.5 + output, .5 - output);
//    		}
//    		else 
//    		{
//    			robotBase.tankDrive(-.4 - output,.4 + output);
//    		}
    }
	
	public void changeIsTurning(boolean val)
	{
		isTurning = val; 
	}
	
    public void initDefaultCommand() {}
    
    public void autoDrive(double speedLeft, double speedRight)
    {
    		left.set(speedLeft);
    		// Right side was set negative if it starts spinning
    		right.set(-speedRight);
    		//robotBase.tankDrive(speedLeft, speedRight);
    }
 
    
    public void cheesyDrive(Joystick j)
    {
    		double scale = j.getRawAxis(3) * -1;
    		scale = ((scale + 1) / 5) + 0.6; 
		
    		double moveValue = j.getRawAxis(1);
    		double rotateValue = j.getRawAxis(0); 

    		//Dead zone on y axis value
    		if (Math.abs(moveValue) < 0.005)
    		{
    			moveValue = 0; 
    		}
    		

    		//creates a dead zone on x axis value only if the y axis value is small 
    		if (Math.abs(rotateValue) < 0.005 && Math.abs(moveValue) < 0.1)
    		{
    			rotateValue = 0;
    		}

    		//scale down the values 
    		moveValue = moveValue * scale * -1; 
    		rotateValue = rotateValue; //rotation scale factor used last year (2016), can change 
		
    		robotBase.arcadeDrive(moveValue, rotateValue, true);
    }
}

