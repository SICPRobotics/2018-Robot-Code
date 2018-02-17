package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Climb extends Command 
{
	String hook;
	
    public Climb(String side) 
    {
        hook = side;
    	requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	if (!Robot.isOldRobot) {}
    	//	Robot.c.setClosedLoopControl(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if (hook == "left")
    		Robot.climber.climbLeft();
    	if (hook == "right")
    		Robot.climber.climbRight();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
