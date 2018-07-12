package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DisableArmPID extends Command 
{

    public DisableArmPID() 
    {
        requires(Robot.arm);
    }

    protected void initialize() 
    {
    	Robot.arm.disable();
    }

    protected void execute() {}

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() {}
    
    protected void interrupted() {}
}
