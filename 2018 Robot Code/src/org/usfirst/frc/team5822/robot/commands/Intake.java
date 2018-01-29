package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake extends Command 
{
	double speed;
	boolean side;
	
    public Intake(double d, boolean oneSide) 
    {
        requires(Robot.intake);
        speed = d;
        side = oneSide;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.intake.takeIn(speed, side);//speed set to 0
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        //Robot.intake.takeIn(0);
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.intake.takeIn(0, side);
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
