package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArmScale extends Command 
{
	double currentDegrees;
	
    public MoveArmScale(double degrees) 
    {
    	requires(Robot.arm);
    }

    protected void initialize() {}

    protected void execute() 
    {
    	currentDegrees = Robot.arm.getPot();
    	double speed = 0;
  
    	if (currentDegrees < RobotMap.aTop)
    	{
    		speed = RobotMap.speedA;
    		System.out.println("Zone A");
    	}
    	else if (currentDegrees < RobotMap.bTop)
    	{
    		speed = RobotMap.speedB;
    		System.out.println("Zone B");
    	}
    	else if (currentDegrees < RobotMap.cTop)
    	{
    		speed = RobotMap.speedC;
    		System.out.println("Zone C");
    	}
    	else if (currentDegrees < RobotMap.dTop)
    	{
    		speed = RobotMap.speedD;
    		System.out.println("Zone D"); 
    	}
    	else if (currentDegrees < RobotMap.eTop)
    	{
    		speed = RobotMap.speedE;
    		System.out.println("Zone E"); 
    	}
    	else if (currentDegrees < RobotMap.fTop)
    	{
    		speed = RobotMap.speedF;
    		System.out.println("Zone F"); 
    	}
    	else if (currentDegrees < RobotMap.gTop)
    	{
    		speed = RobotMap.speedG;
    		System.out.println("Zone G"); 
    	}
    	else
    	{
    		speed = -.2;
    	}
    	
    	Robot.arm.armMotors(speed);
    }

    protected boolean isFinished() 
    {
    	return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
