package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoMode extends CommandGroup 
{
    public AutoMode(String gameData, int fieldPosition, int side) 
    {
    	System.out.println("Auto Mode Start");
   	
    	switch (fieldPosition)
    	{
    		case RobotMap.k_leftSide:
    			System.out.println("AutoMode Left");
    			addSequential(new A_Left(gameData, side));
    			break;
    		case RobotMap.k_centerSide:
    			System.out.println("AutoMode Center");
    			addSequential(new A_Center(gameData, side));
    			break;
    		case RobotMap.k_rightSide:
    			System.out.println("AutoMode Right");
    			addSequential(new A_Right(gameData, side));
    			break;
    	}
    }
}
