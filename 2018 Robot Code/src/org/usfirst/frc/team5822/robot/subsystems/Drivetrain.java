package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.sun.glass.ui.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem 
{
	WPI_TalonSRX frontL,frontR,rearL,rearR;
	DifferentialDrive robotBase;
	SpeedControllerGroup left, right; 	
	
	static boolean isBackwards;
	
	public Drivetrain()
	{
		frontL = new WPI_TalonSRX(RobotMap.k_frontLeft);
		rearL = new WPI_TalonSRX(RobotMap.k_rearLeft); // 2
		frontR = new WPI_TalonSRX(RobotMap.k_frontRight); //3
		rearR = new WPI_TalonSRX(RobotMap.k_rearRight); //4
		
		left = new SpeedControllerGroup(frontL, rearL);
		right = new SpeedControllerGroup(frontR, rearR);

		robotBase = new DifferentialDrive(left, right);
	}
	
    public void initDefaultCommand() {}
    
    public void cheesyDrive(Joystick j)
    {
    		double scale = j.getRawAxis(3) * -1;
		scale = ((scale + 1) / 5) + 0.6; 
		
		double moveValue = j.getRawAxis(1);
		double rotateValue = j.getRawAxis(0); 

		//dead zone on y axis value
		if (Math.abs(moveValue) < 0.005)
			moveValue = 0; 

		//creates a dead zone on x axis value only if the y axis value is small 
		if (Math.abs(rotateValue) < 0.005 && Math.abs(moveValue) < 0.1)
			rotateValue = 0;

		//scale down the values 
		moveValue = moveValue * scale * -1; 
		rotateValue = rotateValue * - 0.6; //rotation scale factor used last year (2016), can change 
		
		robotBase.arcadeDrive(moveValue, rotateValue, true);
    }
}

