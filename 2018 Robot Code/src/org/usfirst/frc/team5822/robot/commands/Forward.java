package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Forward extends Command 
{
	boolean executedOnce;
	double distance;
	
    public Forward(double distanceTOmove) 
    {
    	distance = distanceTOmove;
    	executedOnce = false;
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	System.out.println("move forward: " + distance);
    	executedOnce = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return !executedOnce;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    }
}
