package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn90 extends Command 
{
	double speed;
	boolean direction;
	
    public Turn90(boolean direction) 
    {
        requires(Robot.driveTrain);
        requires(Robot.sensors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double angle = Robot.sensors.getGyro();
    	if (angle < 0) 
    	{
    		angle = angle * -1;
    	}
    	
    	if (angle < 45)
    	{
    		speed  = Robot.sensors.getGyro() / 45 * .7;
    	}
    	else
    	{
    		speed = (90 - Robot.sensors.getGyro()) * .7;
    	}
    	if (direction)
    		Robot.driveTrain.autoDrive(-speed, speed);
    	else
    		Robot.driveTrain.autoDrive(speed, -speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	if (direction)
        {
       		if (90 > Robot.sensors.getGyro())
       		{
           		return true;
            }
        }
        if (!direction)
        {
       		if (-90 < Robot.sensors.getGyro())
       		{
       			return true;
            }
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
