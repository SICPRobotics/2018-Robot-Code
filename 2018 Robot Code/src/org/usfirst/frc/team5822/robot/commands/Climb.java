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
    	//TODO: add back in
    	//Robot.c.setClosedLoopControl(false);
    }

    protected void execute() 
    {
    	if (hook == "left")
    		Robot.climber.climbLeft();
    	if (hook == "right")
    		Robot.climber.climbRight();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
