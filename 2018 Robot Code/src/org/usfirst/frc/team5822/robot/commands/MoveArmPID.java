package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

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

	protected void initialize() 
    {
    	System.out.println("starting move arm PID");
    	Robot.arm.setSetpoint(setpoint);
    	if (setpoint != 0)
    		Robot.arm.enable();
    }

    protected void execute() {}

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() {}
    protected void interrupted() {}
}
