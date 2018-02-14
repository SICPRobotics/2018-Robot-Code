package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArm extends Command 
{
	double desiredDegrees;
	
	boolean finish;
	
    public MoveArm(double degrees) 
    {
   		requires(Robot.intakeArm);
   		requires(Robot.sensors);
        desiredDegrees = degrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    		if(Robot.sensors.getPot() < desiredDegrees)
    			finish = true;
    		else if(Robot.sensors.getPot() > desiredDegrees)
    			finish = false;
    }

    // Called repeatedly when this Command is scheduled to run
    // IMPORTANT: Check that the motors are moving the right way.
    protected void execute() 
    {
    		
    		if(Robot.sensors.getPot() < desiredDegrees)
    		{
    			if (Robot.sensors.getPot() < desiredDegrees - 500)
    			{
    				Robot.intakeArm.armMotors(true, 1.0);
    			} 
    			else if (Robot.sensors.getPot() < desiredDegrees - 300)
    			{
    				Robot.intakeArm.armMotors(true, .5);
    			}
    			else if (Robot.sensors.getPot() < desiredDegrees - 200)
    			{
    				Robot.intakeArm.armMotors(true, .1);
    			}
    		} 
    		else if (Robot.sensors.getPot() > desiredDegrees)
    		{
    			if (Robot.sensors.getPot() > desiredDegrees + 500)
    			{
    				Robot.intakeArm.armMotors(false, 1.0);
    			} 
    			else if (Robot.sensors.getPot() > desiredDegrees + 300)
    			{
    				Robot.intakeArm.armMotors(false, .5);
    			}
    			else if (Robot.sensors.getPot() > desiredDegrees + 200)
    			{
    				Robot.intakeArm.armMotors(false, .1);
    			}
    			finish = false;
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
    		Robot.intakeArm.armMotors(true, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	
    }
}
