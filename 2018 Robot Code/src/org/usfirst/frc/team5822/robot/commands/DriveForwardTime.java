
package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardTime extends Command 
{
	double distance, startingPos, inputTime;
	Timer time;
	
    public DriveForwardTime(double timeToMove) 
    {
    	requires(Robot.driveTrain);
		requires(Robot.sensors);
		inputTime = timeToMove;    
		time = new Timer();
    }

    protected void initialize() 
    {
   		Robot.driveTrain.resetEncoders();
    	System.out.println("DriveForwardTime Init");
    	time.start();
    }

    protected void execute() 
    {
    	Robot.driveTrain.autoDrive(.4,.455);
    }

    protected boolean isFinished() 
    {
    	if (time.get() > inputTime)
    	{
    		return true;
    	}
    	return false;
    }
    
    protected void end() 
    {
    	System.out.println("End: Drive Forward");
    	time.reset();
    }

    protected void interrupted() {}
}
