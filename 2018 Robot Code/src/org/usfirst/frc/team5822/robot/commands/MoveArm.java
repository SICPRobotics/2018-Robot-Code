package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArm extends Command 
{
	double desiredDegrees, currentDegrees;
	boolean goingUp;
	
    public MoveArm(double degrees) 
    {
    	requires(Robot.intake);
   		requires(Robot.sensors);
        desiredDegrees = degrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
//    	System.out.println("MoveArm init "+ desiredDegrees);
//    	if(Robot.sensors.getPot() < desiredDegrees)
//    		goingUp = true;
//    	else if(Robot.sensors.getPot() > desiredDegrees)
//    		goingUp = false;
    	Robot.intake.armMotors(desiredDegrees);
    }

    protected void execute() 
    {
//    	currentDegrees = Robot.sensors.getPot();
//    	double speed = 0;
//    	
//    	if (goingUp)
//    	{
//    		if (currentDegrees < RobotMap.aTop)
//    			speed = RobotMap.speedUpA;
//    		else if (currentDegrees < RobotMap.bTop)
//    			speed = RobotMap.speedUpB;
//    		else if (currentDegrees < RobotMap.cTop)
//    			speed = RobotMap.speedUpC;
//    		else
//    			speed = RobotMap.speedUpD;
//    	}
//    	else
//    	{
//    		if (currentDegrees > RobotMap.cTop)
//    			speed = RobotMap.speedDownD;
//    		else if (currentDegrees > RobotMap.bTop)
//    			speed = RobotMap.speedDownC;
//    		else if (currentDegrees > RobotMap.aTop)
//    			speed = RobotMap.speedDownB;
//    		else
//    			speed = RobotMap.speedDownA;
//    	}
//    	
//    	Robot.intakeArm.armMotors(speed);
    }

    protected boolean isFinished() 
    {
//    	if (Robot.isOldRobot)
//    		return true;
//    	if (goingUp && Robot.sensors.getPot() > desiredDegrees)
//    		return true;
//    	if (!goingUp && Robot.sensors.getPot() < desiredDegrees)
//    		return true;
    	return false;
    }

    protected void end() 
    {
    		Robot.intake.armMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	
    }
}
