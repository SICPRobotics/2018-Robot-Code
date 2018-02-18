package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SolenoidReverse extends Command 
{

    public SolenoidReverse() 
    {
        requires(Robot.intake);
    }

    protected void initialize() 
    {
    	Robot.intake.reverse();
    }

    protected void execute() {}

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
