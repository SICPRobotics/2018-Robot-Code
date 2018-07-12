package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ReleaseHook extends Command 
{
    public ReleaseHook() 
    {
    	requires(Robot.climber);
    }

    protected void initialize() {}

    protected void execute() 
    {
    	Robot.climber.release();
    }

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
