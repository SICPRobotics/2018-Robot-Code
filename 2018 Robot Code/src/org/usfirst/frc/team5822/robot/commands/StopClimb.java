package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class StopClimb extends Command 
{
    public StopClimb() 
    {
        requires(Robot.climber);
    }

    protected void initialize() {}

    protected void execute() 
    {
   		Robot.climber.stopClimbLeft();
    }

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
