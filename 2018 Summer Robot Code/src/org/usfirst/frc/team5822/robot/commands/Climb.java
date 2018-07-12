package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command 
{
	public Climb(String side) 
    {
    	requires(Robot.climber);
    }

    protected void initialize() 
    {
    	Robot.c.setClosedLoopControl(false);
    }

    protected void execute() 
    {
    	Robot.climber.climbLeft();
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() 
    {
    	System.out.println("climbend");
    	Robot.c.setClosedLoopControl(true);
    }//hi

    protected void interrupted() {}
}
