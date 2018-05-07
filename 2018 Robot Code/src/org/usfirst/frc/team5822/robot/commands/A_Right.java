package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class A_Right extends CommandGroup 
{
    public A_Right(String gameData, int goal) 
    {
    	if (goal == 0 && gameData.charAt(0) == 'R')
    	{
    		// Right Side Switch
    		System.out.println("Right Position/Right Switch");
    		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
    		addSequential(new DriveForward(147));
    		addSequential(new Turn(-85, .4, true));
    		addSequential(new DriveForwardTime(2));
    		addSequential(new MoveIntakeAuto(-.78));
    		addSequential(new OpenClose());
    		addSequential(new LowerArm());
    	}
    	else if (goal == 1 && gameData.charAt(1) == 'R')
    	{
    		// Right Side Scale
			System.out.println("Right Position/Right Scale");
			addSequential(new DriveForward(285)); 
			addSequential(new Turn(82, -.45, false));
			addSequential(new DriveBackwardTime(2));
			addParallel(new MoveArmScale(RobotMap.k_potScale));
			//addSequential(new MoveIntakeAuto(-.7));
			addSequential(new LowerArm());
			addSequential(new LowerArm());
    		addSequential(new LowerArm());    
    	}
    	else
    	{
    		// Cross Baseline
    		System.out.println("Right Position/Cross Baseline");
    		addSequential(new DriveForward(145));
    		addSequential(new DriveBackwardTime(.2));
    	}
    	/*if (gameData.charAt(0) == 'R' && gameData.charAt(1) != 'R')
    	{
			// Right Side Switch
    		System.out.println("Right Position/Right Switch");
    		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
    		addSequential(new DriveForward(140));
    		addSequential(new Turn(-90, .4, true));
    		addSequential(new DriveForwardTime(2));
    		addSequential(new MoveIntakeAuto(-.78));
    		addSequential(new OpenClose());
    		addSequential(new LowerArm());
    	} 
    	else if (gameData.charAt(0) != 'R' && gameData.charAt(1) == 'R')
    	{
    		// Right Side Scale
			System.out.println("Right Position/Right Scale");
			addSequential(new DriveForward(285)); 
			addSequential(new Turn(82, -.45, false));
			addSequential(new DriveBackwardTime(2));
			addParallel(new MoveArmScale(RobotMap.k_potScale));
			//addSequential(new MoveIntakeAuto(-.7));
			addSequential(new LowerArm());
			addSequential(new LowerArm());
    		addSequential(new LowerArm());    
    	}
    	if (gameData.charAt(0) == 'R' )//&& gameData.charAt(1) == 'R')
    	{
    		if (goal == 0)
    		{
    			// Right Side Switch
        		System.out.println("Right Position/Right Switch");
        		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
        		addSequential(new DriveForward(120));
        		addSequential(new Turn(-90, .4, true));
        		addSequential(new DriveForwardTime(2));
        		addSequential(new MoveIntakeAuto(-.78));
        		addSequential(new OpenClose());
        		addSequential(new LowerArm());
        	}
    		else if (goal == 1)
    		{
    			// Right Side Scale
    			System.out.println("Right Position/Right Scale");
    			addSequential(new DriveForward(285));
    			addSequential(new Turn(82, -.45, false));
    			addSequential(new DriveBackwardTime(2));
    			addParallel(new MoveArmScale(RobotMap.k_potScale));
    			//addSequential(new MoveIntakeAuto(-.7));
    			addSequential(new LowerArm());
    			addSequential(new LowerArm());
        		addSequential(new LowerArm());
        	}
    		else if (goal == 2)
    		{
    			// Cross Baseline
        		System.out.println("Right Position/Cross Baseline");
        		//addSequential(new DriveForwardTime(2.25));
        		addSequential(new DriveForward(140));
    		}
    	}    		
    	else 
    	{
    		// Cross Baseline
    		System.out.println("Right Position/Cross Baseline");
    		addSequential(new DriveForward(140));
    	}*/
    }
}
