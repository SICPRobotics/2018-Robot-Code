package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Forward extends Command 
{
	Drivetrain newDriver = new Drivetrain();
	Sensors newSensors = new Sensors();
	boolean executedOnce;
	double distance;
	
    public Forward(double distanceTOmove) 
    {
    	distance = distanceTOmove + Sensors.rightEncoderDistance();
    	executedOnce = false;
    	requires(Robot.driveTrain);
    	newDriver.autoDrive(.5);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	System.out.println("Init");
    	newDriver.autoDrive(.2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    		newDriver.autoDrive(.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    		//if (distance < Sensors.rightEncoderDistance())
    		//{
    		//	return true;
    		//}
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
