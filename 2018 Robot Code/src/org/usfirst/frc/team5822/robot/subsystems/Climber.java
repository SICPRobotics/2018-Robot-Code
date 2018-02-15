package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem 
{
	VictorSP climb1, climb2;
	
	public Climber()
	{
		climb1 = new VictorSP(RobotMap.k_climb1);
		climb2 = new VictorSP(RobotMap.k_climb2);
	}
	
	public void climbLeft()
	{
		climb1.set(.5);
	}
	public void climbRight()
	{
		climb2.set(.5);
	}
	public void releaseLeft()
	{
		//move left servo
	}
	public void releaseRight()
	{
		//move right servo
	}
		
    public void initDefaultCommand() {}
}

