package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArm extends Command 
{
	double armHeight;
	static Sensors sensors;

    public MoveArm(double height) 
    {
   		requires(Robot.driveTrain);
        armHeight = height;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    // Important: Check that the motors are moving the right way.
    protected void execute() 
    {
    		
    	if(sensors.getPotential() < armHeight)
    	{
    		while (sensors.getPotential() != armHeight)
    		{
    			Robot.driveTrain.armMotors(true);
    		}
    	} 
    	else if (sensors.getPotential() > armHeight)
    	{
    		while (sensors.getPotential() != armHeight)
    		{
    			Robot.driveTrain.armMotors(false);
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
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
