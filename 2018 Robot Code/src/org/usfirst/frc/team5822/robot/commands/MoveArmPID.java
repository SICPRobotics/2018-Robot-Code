package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveArmPID extends Command 
{
	double setpoint;
  
	public MoveArmPID(double set) 
    {
    	requires(Robot.arm);
    	setpoint = set;
    }
	public MoveArmPID(double set, double min, double max) 
    {
    	requires(Robot.arm);
    	setpoint = set;
    	Robot.arm.setOutputRange(min, max);
    }
    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	System.out.println("starting move arm PID");
    	Robot.arm.setSetpoint(setpoint);
    	Robot.arm.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
