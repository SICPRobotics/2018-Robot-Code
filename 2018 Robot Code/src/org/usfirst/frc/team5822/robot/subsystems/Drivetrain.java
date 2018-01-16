package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivetrain extends Subsystem 
{
	WPI_TalonSRX frontL,frontR,rearL,rearR;
	DifferentialDrive robotBase;
	SpeedControllerGroup left, right; 	
	
	public Drivetrain()
	{
		frontL = new WPI_TalonSRX(RobotMap.k_frontLeft);
		rearL = new WPI_TalonSRX(RobotMap.k_rearLeft);
		frontR = new WPI_TalonSRX(RobotMap.k_frontRight);
		rearR = new WPI_TalonSRX(RobotMap.k_rearRight);
		
		left = new SpeedControllerGroup(frontL, rearL);
		right = new SpeedControllerGroup(frontR, rearR);

		robotBase = new DifferentialDrive(left, right);
	}
	
    public void initDefaultCommand() {}
    
    public void cheesyDrive(Joystick j)
    {
    	//add dead zone
    	robotBase.arcadeDrive(j.getY()*-1, j.getX()*-1, true);
    }
}

