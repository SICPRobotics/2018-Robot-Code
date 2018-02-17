package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArm extends Command 
{
	double desiredDegrees, currentDegrees, aBot, aTop, bTop, cTop, dTop, speedUpA, speedUpB, speedUpC, speedUpD, speedDownA, speedDownB, speedDownC, speedDownD;
	boolean goingUp;
	
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
    		goingUp = true;
    	else if(Robot.sensors.getPot() > desiredDegrees)
    		goingUp = false;
    }

    protected void execute() 
    {
    	currentDegrees = Robot.sensors.getPot();
    	double speed = 0;
    	
    	if (goingUp)
    	{
    		if (currentDegrees < aTop)
    			speed = speedUpA;
    		else if (currentDegrees < bTop)
    			speed = speedUpB;
    		else if (currentDegrees < cTop)
    			speed = speedUpC;
    		else
    			speed = speedUpD;
    	}
    	else
    	{
    		if (currentDegrees > cTop)
    			speed = speedDownD;
    		else if (currentDegrees > bTop)
    			speed = speedDownC;
    		else if (currentDegrees > aTop)
    			speed = speedDownB;
    		else
    			speed = speedDownA;
    	}
    	
    	Robot.intakeArm.armMotors(speed);
    }

    protected boolean isFinished() 
    {
    	if (goingUp && Robot.sensors.getPot() > desiredDegrees)
    		return true;
    	if (!goingUp && Robot.sensors.getPot() < desiredDegrees)
    		return true;
    	return false;
    }

    protected void end() 
    {
    		Robot.intakeArm.armMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	
    }
}
