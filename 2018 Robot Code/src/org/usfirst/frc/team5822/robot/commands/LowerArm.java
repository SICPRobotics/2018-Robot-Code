package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class LowerArm extends Command 
{
	double period, initPos, endTargetPos, deltaPos;
	Timer time;
	
    public LowerArm() 
    {
    	requires(Robot.arm);
    }

    protected void initialize() 
    {
//        period = 2;
//        initPos = Robot.arm.getPot();
//        endTargetPos = RobotMap.k_potFloor;
//        deltaPos = endTargetPos - initPos;
    	  time = new Timer();
//
//        Robot.arm.setSetpoint(initPos);
//    	Robot.arm.enable();
//    	time.start();
    	Robot.arm.disable();
    	Robot.arm.armMotors(0);
    	time.start();
    }

    protected void execute() 
    {
    	Robot.arm.armMotors(-.1);
//    	double progress = 1 - (period - time.get()) / period;
//    	double targetPos = initPos + (progress * deltaPos);
//    	Robot.arm.setSetpoint(targetPos);
    }

    protected boolean isFinished() 
    {
    	if (time.get() >= .3)
    		return true;
    	return false;
    }

    protected void end() 
    {
//    	time.stop();
//    	time.reset();
    	Robot.arm.disable();
    	Robot.arm.armMotors(0);
    }

    protected void interrupted() {}
}
