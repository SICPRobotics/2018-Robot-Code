package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class SolenoidForward extends Command 
{
    public SolenoidForward() 
    {
        requires(Robot.intakeArm);
    }

    protected void initialize() 
    {
    	Robot.intakeArm.forward();
    }

    protected void execute() {}

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}

 