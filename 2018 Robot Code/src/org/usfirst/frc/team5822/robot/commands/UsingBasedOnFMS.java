package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class UsingBasedOnFMS extends CommandGroup 
{
    public UsingBasedOnFMS(String gameData, int fieldPosition) 
    {
    	System.out.println("Used base");
    	final int leftSide = 0;
    	final int centerSide = 1;
    	final int rightSide = 2;
    	
    	switch (fieldPosition)
    	{
    		case leftSide:
    			System.out.println("Left");
    			addSequential(new A_Left(gameData));
    		case centerSide:
    			System.out.println("Center");
    			addSequential(new A_Center(gameData));
    		case rightSide:
    			System.out.println("Right");
    			addSequential(new A_Right(gameData));
    	}
    }
}
