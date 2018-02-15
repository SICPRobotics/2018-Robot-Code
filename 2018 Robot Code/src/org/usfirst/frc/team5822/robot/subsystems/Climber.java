package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem 
{
	WPI_VictorSPX climb1, climb2;
	SpeedControllerGroup climber;
	
	public Climber()
	{
		climb1 = new WPI_VictorSPX(RobotMap.k_climb1);
		climb2 = new WPI_VictorSPX(RobotMap.k_climb2);
		climber = new SpeedControllerGroup(climb1, climb2);
	}
	
	public void climb()
	{
		climber.set(.5);
	}
	
	
    public void initDefaultCommand() {}
}

