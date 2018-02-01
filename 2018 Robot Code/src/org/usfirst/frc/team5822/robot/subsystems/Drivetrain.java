package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.sun.glass.ui.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem 
{
	WPI_TalonSRX frontL, frontR, rearL, rearR;
	
	VictorSP intakeRight, intakeLeft;
	
	DifferentialDrive robotBase;
	
	SpeedControllerGroup left, right, autoDrive; 	
	
	static boolean isBackwards;
	
	public Drivetrain()
	{
		frontL = new WPI_TalonSRX(RobotMap.k_frontLeft);
		rearL = new WPI_TalonSRX(RobotMap.k_rearLeft); // 2
		frontR = new WPI_TalonSRX(RobotMap.k_frontRight); //3
		rearR = new WPI_TalonSRX(RobotMap.k_rearRight); //4
		
		//intakeRight = new VictorSP(RobotMap.k_intakeRight);
		//intakeLeft = new VictorSP(RobotMap.k_intakeLeft);
		//intakeLeft.setInverted(true);
		
		left = new SpeedControllerGroup(frontL, rearL);
		right = new SpeedControllerGroup(frontR, rearR);
		autoDrive = new SpeedControllerGroup(left, right);

		robotBase = new DifferentialDrive(left, right);
	}
	
    public void initDefaultCommand() {}
    
    
    // One command for every intake situation
    // May not need oneSide but this can be taken out easily
    public void intakeMotors(double speed, boolean oneSide)
    {
    		if (!oneSide)
    		{
    			intakeRight.set(speed);
    			intakeLeft.set(speed);
    		} 
    		else if (oneSide)
    		{
    			intakeLeft.set(speed);
    			intakeRight.set(-speed - 0.8);
    		}
    }
    
    
    public void autoDrive(double speedLeft, double speedRight)
    {
    		left.set(speedLeft);
    		// Right side was set negative if it starts spinning
    		right.set(-speedRight);
    		// robotBase.(speed, speed);
    }
    
    public void cheesyDrive(Joystick j)
    {
    		double scale = j.getRawAxis(3) * -1;
    		scale = ((scale + 1) / 5) + 0.6; 
		
    		double moveValue = j.getRawAxis(1);
    		double rotateValue = j.getRawAxis(0); 

    		//Dead zone on y axis value
    		if (Math.abs(moveValue) < 0.005)
    			moveValue = 0; 

    		//creates a dead zone on x axis value only if the y axis value is small 
    		if (Math.abs(rotateValue) < 0.005 && Math.abs(moveValue) < 0.1)
    			rotateValue = 0;

    		//scale down the values 
    		moveValue = moveValue * scale * -1; 
    		rotateValue = rotateValue * 0.6; //rotation scale factor used last year (2016), can change 
		
    		robotBase.arcadeDrive(moveValue, rotateValue, true);
    }
}

