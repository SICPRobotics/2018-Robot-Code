package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Drivetrain extends PIDSubsystem 
{
	WPI_TalonSRX frontL, frontR, rearL, rearR;
	static DifferentialDrive robotBase;
	SpeedControllerGroup left, right;//, autoDrive; 	
	
	public Drivetrain()
	{
		super("driveTrain", .04, 0.00, 0); 
		setAbsoluteTolerance(0.001);
		getPIDController().setContinuous(false); 
				
		frontL = new WPI_TalonSRX(RobotMap.k_frontLeft); 
		rearL = new WPI_TalonSRX(RobotMap.k_rearLeft); 
		rearL.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
		frontR = new WPI_TalonSRX(RobotMap.k_frontRight); 
		rearR = new WPI_TalonSRX(RobotMap.k_rearRight); 
		rearR.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
	
		left = new SpeedControllerGroup(frontL, rearL);
		right = new SpeedControllerGroup(frontR, rearR);
		//autoDrive = new SpeedControllerGroup(left, right);

		robotBase = new DifferentialDrive(left, right);
	}
	
	public double encDistance()
	{
		double rightEnc, leftEnc;
		int nativeUnits1 = rearL.getSelectedSensorPosition(0);
		leftEnc = nativeUnits1 * .0046019424 * -1;
//		System.out.println("left enc: " + leftEnc);
		int nativeUnits2 = rearR.getSelectedSensorPosition(0);
		rightEnc = nativeUnits2 * .0046019424;
//		System.out.println("right enc: " + rightEnc);
		
		double dist = (leftEnc + rightEnc) /2;
//		System.out.println("dist: " + dist);
		return dist;
	}

//	public double rightEnc()
//	{
//		return rearR.getSelectedSensorPosition(0) * .0046019424;
//	}
//	
//	public double leftEnc()
//	{
//		return rearL.getSelectedSensorPosition(0) * .0046019424 * -1;
//	}
	
	public void resetEncoders()
	{
//		System.out.println("reset encoders \n\n\n\n\n");
		ErrorCode rL = rearL.setSelectedSensorPosition(0, 0, 10000);
//		
//		System.out.println("error code for left: " + rL);
		ErrorCode rR = rearR.setSelectedSensorPosition(0,0,10000);
//		System.out.println("error code for right: " + rR);
//		System.out.println("after reset encoders at " + encDistance());
	}
	
	protected double returnPIDInput() 
	{    	
		return Robot.sensors.getGyro(); 
    }

	public void driveForward() 
	{
		left.set(.4);
		right.set(.45);
		//robotBase.arcadeDrive(.4, 0); //had .63,.25 for worlds
		//System.out.println("right code now");
	}
	
	public void driveForwardHalf()
	{
		left.set(.4);
		right.set(.4);
		//robotBase.arcadeDrive(.4, 0); //had .5.25 for worlds
	}
	
	public void driveBackward() 
	{
		robotBase.arcadeDrive(-.5,0);
	}
    
	protected void usePIDOutput(double output) {}
	
    public void initDefaultCommand() {}
    
    public void autoDrive(double speedLeft, double speedRight)
    {
    	left.set(speedLeft);
    	right.set(-speedRight);
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
    	rotateValue = rotateValue * scale;	
    	robotBase.arcadeDrive(moveValue, rotateValue, true);
    }
    
    public void tankDrive(Joystick j1, Joystick j2)
    {
    	left.set(j1.getY());
    	right.set(j2.getY());
    }
}