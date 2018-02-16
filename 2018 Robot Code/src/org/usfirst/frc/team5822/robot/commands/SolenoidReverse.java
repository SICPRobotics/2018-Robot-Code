package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SolenoidReverse extends Command 
{

    public SolenoidReverse() 
    {
        requires(Robot.intakeArm);
    }

    protected void initialize() 
    {
    	Robot.intakeArm.reverse();
    }

    protected void execute() {}

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
