package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

public class Intake extends Command 
{
	double speed;
	
	public Intake(double d) 
    {
        requires(Robot.intakeArm);
        speed = d;   
    }

    protected void initialize() 
    {	
    	System.out.println("intake command starting");
    	if (speed < 0)
    	{
    		Robot.intakeArm.open();
    	}
    }

    protected void execute() 
    {
    	Robot.intakeArm.intakeMotors(speed);
    }

    protected boolean isFinished() 
    {
    	if (speed == 0)
    		return true;
        return false;
    }

    protected void end() {}
    
    protected void interrupted() 
    {	
    }
}
