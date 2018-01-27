package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class UsingBasedOnFMS extends CommandGroup 
{
    public UsingBasedOnFMS(String gameData, int fieldPosition) 
    {
    	final int leftSide = 0;
    	final int centerSide = 1;
    	final int rightSide = 2;
    	
    	switch (fieldPosition)
    	{
    		case leftSide:
    			addSequential(new A_Left(gameData));
    		case centerSide:
    			addSequential(new A_Center(gameData));
    		case rightSide:
    			addSequential(new A_Right(gameData));
    	}
    }
}
