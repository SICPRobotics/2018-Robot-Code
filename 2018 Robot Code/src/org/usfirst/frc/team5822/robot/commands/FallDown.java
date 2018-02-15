package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FallDown extends Command {

	int direction;
	
    public FallDown(int updown) 
    {
    	requires(Robot.antiFall);
    	direction = updown;
    }

    protected void initialize() 
    {
    }

    protected void execute() 
    {
    	if (direction == -1)
    	{
    		//go down
    		Robot.antiFall.reverse();
    	}
    	else
    	{
    		Robot.antiFall.forward();
    	}
    }

    protected boolean isFinished() 
    {
        return true;
    }
   
    protected void end() {}

    protected void interrupted() {}
}
