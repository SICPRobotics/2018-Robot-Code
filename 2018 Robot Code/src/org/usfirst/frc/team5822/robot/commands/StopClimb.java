package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class StopClimb extends Command 
{
	boolean isLeftTrigger;
	
    public StopClimb(boolean leftSide) 
    {
        requires(Robot.climber);
        isLeftTrigger = leftSide;
    }

    protected void initialize() {}

    protected void execute() 
    {
    	if(isLeftTrigger)
    		Robot.climber.stopClimbLeft();
    	else
    		Robot.climber.stopClimbRight();
    }

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
