package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Turn extends Command 
{
	boolean executedOnce, direction;
	double angle, speedTurn;
	
    public Turn(double angleTOmove, double speed, boolean turnDirection) 
    {
    	requires(Robot.driveTrain);
    	requires(Robot.sensors);
    		
    	direction = turnDirection;
        angle = angleTOmove;
        speedTurn = speed;
    }

    protected void initialize() 
    {
    	System.out.println("Starting Turn");
    	//Robot.sensors.resetGyro();
    }

    protected void execute() 
    {
    	Robot.driveTrain.autoDrive(-speedTurn, speedTurn);
    	//System.out.println("turn: " + Robot.sensors.getGyro());
    	executedOnce = true;
    }

    protected boolean isFinished() 
    {
        if (direction)
        {
       		if (angle > Robot.sensors.getGyro())
       		{
           		return true;
            }
        }
        if (!direction)
        {
       		if (angle < Robot.sensors.getGyro())
       		{
       			return true;
            }
        }
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
