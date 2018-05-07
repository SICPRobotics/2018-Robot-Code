package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArmClimb extends Command 
{
	double currentDegrees;
	
    public MoveArmClimb() 
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
    		System.out.println("Zone A" + " pot: " + Robot.arm.getPot());
    	}
    	else if (currentDegrees < RobotMap.bTop)
    	{
    		speed = RobotMap.speedB;
    		System.out.println("Zone B" + " pot: " + Robot.arm.getPot());
    	}
    	else if (currentDegrees < RobotMap.cTop)
    	{
    		speed = RobotMap.speedC;
    		System.out.println("Zone C" + " pot: " + Robot.arm.getPot());
    	}
    	else if (currentDegrees < RobotMap.dTop)
    	{
    		speed = RobotMap.speedD;
    		System.out.println("Zone D" + " pot: " + Robot.arm.getPot()); 
    	}
    	else if (currentDegrees < RobotMap.eTop)
    	{
    		speed = RobotMap.speedE;
    		System.out.println("Zone E" + " pot: " + Robot.arm.getPot()); 
    	}
    	else if (currentDegrees < RobotMap.fTop)
    	{
    		speed = RobotMap.speedF;
    		System.out.println("Zone F" + " pot: " + Robot.arm.getPot());
    	}
    	else if (currentDegrees < RobotMap.gTop)
    	{
    		speed = .4;
    		System.out.println("Zone G" + " pot: " + Robot.arm.getPot()); 
    	}
    	else 
    	{
    		speed = .3;
    		System.out.println("Climb - set to " + speed + " pot: " + Robot.arm.getPot()); 
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
