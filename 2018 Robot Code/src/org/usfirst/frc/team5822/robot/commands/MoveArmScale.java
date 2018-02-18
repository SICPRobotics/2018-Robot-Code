package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArmScale extends Command 
{
	double desiredDegrees, currentDegrees;
	boolean goingUp;
	
    public MoveArmScale(double degrees) 
    {
    	requires(Robot.intake);
   		requires(Robot.sensors);
        desiredDegrees = degrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    }

    protected void execute() 
    {
    	currentDegrees = Robot.sensors.getPot();
    	double speed = 0;
  
    	if (currentDegrees < RobotMap.aTop)
    		speed = RobotMap.speedUpA;
    	else if (currentDegrees < RobotMap.bTop)
    		speed = RobotMap.speedUpB;
    	else if (currentDegrees < RobotMap.cTop)
    		speed = RobotMap.speedUpC;
    	else
    		speed = RobotMap.speedUpD;
    	
    	Robot.arm.armMotors(speed);
    }

    protected boolean isFinished() 
    {
    	if (Robot.arm.getPot() > RobotMap.cTop)
    		return true;
    	return false;
    }

    protected void end() 
    {
    	System.out.println("Finished MoveArmScale, starting MoveArmPID");
    	Command scalePID = new MoveArmPID(RobotMap.k_potScale, RobotMap.speedUpD*-1, RobotMap.speedUpD);
    	scalePID.start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	
    }
}
