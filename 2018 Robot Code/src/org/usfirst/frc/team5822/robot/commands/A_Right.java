package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class A_Right extends CommandGroup 
{
    public A_Right(String gameData, int side) 
    {
    	if (gameData.charAt(0) == 'R' && gameData.charAt(1) != 'R')
    	{
    		// Right Side Switch
    		System.out.println("Center Position/Right Switch");
    		addSequential(new DriveForward(5));
    		addSequential(new Turn(20.3, -.4, false));
    		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
    		addSequential(new DriveForward(90));
    		addSequential(new Turn(-21.5, .4, true));
    		addSequential(new MoveIntakeAuto(-.78));
    		addSequential(new LowerArm());
    	} 
    	else if (gameData.charAt(0) != 'R' && gameData.charAt(1) == 'R')
    	{
    		// Right Side Scale
			System.out.println("Right Position/Right Scale");
			addSequential(new DriveForward(285));
			addSequential(new Turn(82, -.4, false));
			addSequential(new DriveBackward(-10));
			addParallel(new MoveArmScale(RobotMap.k_potScale));
			addSequential(new MoveIntakeAuto(0));
			addSequential(new MoveIntakeAuto(-.7));
			addSequential(new LowerArm());
			addSequential(new LowerArm());
    		addSequential(new LowerArm());    
    	}
    	else if (gameData.charAt(0) == 'R' && gameData.charAt(1) == 'R')
    	{
    		if (side == 0)
    		{
    			// Right Side Switch
        		System.out.println("Center Position/Right Switch");
        		addSequential(new DriveForward(5));
        		addSequential(new Turn(20.3, -.4, false));
        		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
        		addSequential(new DriveForward(90));
        		addSequential(new Turn(-21.5, .4, true));
        		addSequential(new MoveIntakeAuto(-.78));
        		addSequential(new LowerArm());
        	}
    		else if (side == 1)
    		{
        		// Right Side Scale
    			System.out.println("Right Position/Right Scale");
    			addSequential(new DriveForward(285));
    			addSequential(new Turn(82, -.4, false));
    			addSequential(new DriveBackward(-10));
    			addParallel(new MoveArmScale(RobotMap.k_potScale));
    			addSequential(new MoveIntakeAuto(0));
    			addSequential(new MoveIntakeAuto(-.7));
    			addSequential(new LowerArm());
    			addSequential(new LowerArm());
        		addSequential(new LowerArm());        	
        	}
    	}    		
    	else 
    	{
    		// Cross Baseline
    		System.out.println("Right Position/Cross Baseline");
    		addSequential(new DriveForward(148.875));
    	}
    }
}
