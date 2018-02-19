package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class FallDown extends Command 
{
	int direction;
	Timer timer;
	
    public FallDown(int updown) 
    {
    	requires(Robot.antiFall);
    	direction = updown;
    	timer = new Timer();
    }

    protected void initialize() 
    {
    	timer.start();
    }

    protected void execute() 
    {
    	Robot.antiFall.move(direction);
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
