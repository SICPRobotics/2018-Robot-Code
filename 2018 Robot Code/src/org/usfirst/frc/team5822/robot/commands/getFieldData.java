package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class getFieldData extends Command {

	String fieldDataIMP;
	int count = 0;
	
    public getFieldData() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	fieldDataIMP = DriverStation.getInstance().getGameSpecificMessage(); 		
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	int fieldDataLength = fieldDataIMP.length();
    	double matchTime = DriverStation.getInstance().getMatchTime();
    	
    	if (count++%50 == 0)
    		System.out.println("Field Data: " + fieldDataLength + "Match Time: " + matchTime);
    	
    	if (fieldDataLength < 2 || matchTime > 10)
    	{
    		return false;
    	}
    	else return true;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	System.out.println("ending getFieldData");
    	Command auto = new AutoMode(fieldDataIMP, Robot.position, Robot.goal);
    	auto.start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
}
