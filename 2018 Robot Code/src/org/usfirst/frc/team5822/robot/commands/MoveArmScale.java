package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArmScale extends Command 
{
	double desiredDegrees, currentDegrees;
	boolean goingUp;
	
    public MoveArmScale(double degrees) 
    {
    	requires(Robot.arm);
   		requires(Robot.sensors);
        desiredDegrees = degrees;
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
    	else
    	{
    		speed = RobotMap.speedD;
    		System.out.println("Zone D");
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
