package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArm extends Command 
{
	double desiredDegrees;
	static Sensors sensors;
	boolean finish;
	
    public MoveArm(double degrees) 
    {
   		requires(Robot.intakeArm);
        desiredDegrees = degrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    // IMPORTANT: Check that the motors are moving the right way.
    protected void execute() 
    {
    		
    		if(sensors.getPot() < desiredDegrees)
    		{
    			if (sensors.getPot() < desiredDegrees - 500)
    			{
    				Robot.intakeArm.armMotors(true, .7);
    			} 
    			else if (sensors.getPot() < desiredDegrees - 300)
    			{
    				Robot.intakeArm.armMotors(true, .4);
    			}
    			else if (sensors.getPot() < desiredDegrees - 200)
    			{
    				Robot.intakeArm.armMotors(true, .15);
    			}
    		} 
    		else if (sensors.getPot() > desiredDegrees)
    		{
    			if (sensors.getPot() < desiredDegrees + 500)
    			{
    				Robot.intakeArm.armMotors(true, .7);
    			} 
    			else if (sensors.getPot() < desiredDegrees + 300)
    			{
    				Robot.intakeArm.armMotors(true, .4);
    			}
    			else if (sensors.getPot() < desiredDegrees + 200)
    			{
    				Robot.intakeArm.armMotors(true, .15);
    			}
    		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    		if (finish)
    		{
    			if (Robot.sensors.getPot() > desiredDegrees)
    				return true;
    		}
    		else if (!finish)
    		{
    			if (Robot.sensors.getPot() < desiredDegrees)
    				return true;
    		}
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	
    }
}
