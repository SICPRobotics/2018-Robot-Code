package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class A_Right extends CommandGroup 
{
    public A_Right(String gameData, int side) 
    {
    	if (gameData.charAt(0) == 'R' && gameData.charAt(1) != 'R')
    	{
    		//Right Side Switch
    		System.out.println("Right Position/Right Switch");
    		addSequential(new DriveForward(140)); //148.875
    		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
    		addSequential(new Turn(-90, .4, true));
    		addSequential(new DriveForward(19.435));
    		addSequential(new MoveIntakeAuto(-.7));
    		addSequential(new LowerArm());
    	} 
    	else if (gameData.charAt(0) != 'R' && gameData.charAt(1) == 'R')
    	{
    		// Right Side Scale
			System.out.println("Right Position/Right Scale");
			addSequential(new DriveForward(304.875));
			addSequential(new MoveArmScale(RobotMap.k_potScale));
			addSequential(new Turn(-90, .4, true));
			addSequential(new DriveForward(5.755));
			addSequential(new MoveIntakeAuto(-.7));
			addSequential(new LowerArm());
    		addSequential(new LowerArm());
    		addSequential(new LowerArm());
    	}
    	else if (gameData.charAt(0) == 'R' && gameData.charAt(1) == 'R')
    	{
    		if (side == 0)
    		{
    			//Right Side Switch
        		System.out.println("Right Position/Right Switch");
        		addSequential(new DriveForward(140)); //148.875
        		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
        		addSequential(new Turn(-90, .6, true));
        		addSequential(new DriveForward(19.435));
        		addSequential(new MoveIntakeAuto(-.7));
        		addSequential(new LowerArm());
        	}
    		else if (side == 1)
    		{
        		// Right Side Scale
    			System.out.println("Right Position/Right Scale");
    			addSequential(new DriveForward(304.875));
    			addSequential(new MoveArmScale(RobotMap.k_potScale));
    			addSequential(new Turn(-90, .5, true));
    			addSequential(new DriveForward(5.755));
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
