package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem 
{
	VictorSP climb1, climb2;
	Servo servo1, servo2;
	
	public Climber()
	{
		climb1 = new VictorSP(RobotMap.k_climb1);
		climb2 = new VictorSP(RobotMap.k_climb2);
		servo1 = new Servo(RobotMap.k_servo1);
		servo2 = new Servo(RobotMap.k_servo2);
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

