package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class getFieldData extends Command 
{
	String fieldDataIMP;
	int count = 0;
	
    public getFieldData() {}

    protected void initialize() {}

    protected void execute() 
    {
    	fieldDataIMP = DriverStation.getInstance().getGameSpecificMessage(); 			
    }

    protected boolean isFinished() 
    {
    	int fieldDataLength = fieldDataIMP.length();
    	double matchTime = DriverStation.getInstance().getMatchTime();
    	
//    	if (count++%50 == 0)
//    		System.out.println("Field Data: " + fieldDataIMP + " Length: " + fieldDataLength + " Match Time: " + matchTime);
    	
    	if (fieldDataLength < 2 && matchTime > 10)
    	{
    		return false;
    	}
    	else 
    	{		
    		System.out.println("Field Data - Success: " + fieldDataIMP);
    		return true;
    	}
    }

    protected void end() 
    {
    	System.out.println("ending getFieldData");
    	Command auto = null;
 //   	Command auto = new AutoMode(fieldDataIMP, Robot.position, Robot.goal);
    	
    	switch (Robot.position)
    	{
    		case RobotMap.k_leftSide:
    			System.out.println("AutoMode Left");
    			auto = new A_Left(fieldDataIMP, Robot.goal);
    			break;
    		case RobotMap.k_centerSide:
    			System.out.println("AutoMode Center");
    			auto = new A_Center(fieldDataIMP, Robot.goal);
    			break;
    		case RobotMap.k_rightSide:
    			System.out.println("AutoMode Right");
    			auto = new A_Right(fieldDataIMP, Robot.goal);
    			break;
    	}
    	
    	auto.start();
    }
    
    protected void interrupted() {}
}
