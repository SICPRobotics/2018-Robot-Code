
package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command 
{
	double distance, startingPos;
	Timer time; 
	
    public DriveForward(double distanceTOmove) 
    {
    	requires(Robot.driveTrain);
		requires(Robot.sensors);
		distance = distanceTOmove;    
		time = new Timer();
    }

    protected void initialize() 
    {
   		Robot.driveTrain.resetEncoders();
    	System.out.println("DriveForward Init");
    	startingPos = Robot.driveTrain.encDistance();
    	System.out.println("starting pos: " + startingPos);
    	time.start();
    }

    protected void execute() 
    {
    	System.out.println("encoder distance: " + Robot.driveTrain.encDistance());
    	if (time.get() > .3)
    		Robot.driveTrain.drive();
    }

    protected boolean isFinished() 
    {
    	if (Robot.driveTrain.encDistance() > distance && time.get() > .3)
    	{
    		return true;
    	}
    	return false;
    }
    
    protected void end() 
    {
    	System.out.println("End: Drive Forward");
    }

    protected void interrupted() {}
}
