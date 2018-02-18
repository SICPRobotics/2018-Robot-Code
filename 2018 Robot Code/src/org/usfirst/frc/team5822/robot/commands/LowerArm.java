package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerArm extends Command 
{
	double period, initPos, endTargetPos, deltaPos;
	Timer time;
	
    public LowerArm() 
    {
    	requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        period = 2;
        initPos = Robot.arm.getPot();
        endTargetPos = RobotMap.k_potFloor;
        deltaPos = endTargetPos - initPos;
        time = new Timer();

        Robot.arm.setSetpoint(initPos);
    	Robot.arm.enable();
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double progress = 1 - (period - time.get()) / period;
    	double targetPos = initPos + (progress * deltaPos);
    	Robot.arm.setSetpoint(targetPos);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	if (time.get() >= period)
    		return true;
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	time.stop();
    	time.reset();
    	Robot.arm.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
