package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class MoveIntakeAuto extends Command 
{
	double speed;
	Timer timer = new Timer();
	
	public MoveIntakeAuto(double d) 
    {
        requires(Robot.intake);
        speed = d;   
    }

    protected void initialize() 
    {	
    	System.out.println("intake auto command starting");
    	timer.start();
    }

    protected void execute() 
    {
    	Robot.intake.intakeMotors(speed);
    }

    protected boolean isFinished() 
    {
    	if (timer.get() < 1.25)
    		return false;
    	return true;
    }

    protected void end() 
    {
    	Robot.intake.intakeMotors(0);
    }
    
    protected void interrupted() {}
}
