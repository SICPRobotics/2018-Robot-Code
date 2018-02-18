package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class OpenClose extends Command 
{
	boolean direction = true;
	
	public OpenClose() 
    {
    	requires(Robot.intake);
    }

    protected void initialize() 
    {
    	
    }

    protected void execute() 
    {
    	if (direction)
    		Robot.intake.open();
    	else if (!direction)
    		Robot.intake.shut();
    }

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() 
    {
    	direction = !direction;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
