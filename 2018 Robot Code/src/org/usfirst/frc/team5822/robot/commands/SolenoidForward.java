package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class SolenoidForward extends Command 
{
    public SolenoidForward() 
    {
        requires(Robot.intake);
    }

    protected void initialize() 
    {
    	Robot.intake.forward();
    }

    protected void execute() {}

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}

 