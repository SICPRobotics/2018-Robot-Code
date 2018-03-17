package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class FallDown extends Command 
{
	double speed;
	Timer timer;
	
    public FallDown(double updown) 
    {
    	requires(Robot.antiFall);
    	speed = updown;
    	timer = new Timer();
    }

    protected void initialize() 
    {
    	timer.start();
    }

    protected void execute() 
    {
    	Robot.antiFall.move(speed);
    }

    protected boolean isFinished() 
    {
    	if (timer.get() > .5)
    		return true;
    	return false;
    }
   
    protected void end() 
    {
    	timer.stop();
    	timer.reset();
    }

    protected void interrupted() {}
}
