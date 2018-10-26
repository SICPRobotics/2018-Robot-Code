package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class A_Left extends CommandGroup
{
    public A_Left(String gameData, int goal) 
    {
    	if (goal == 0 && gameData.charAt(0) == 'L')
    	{
			//Left Side Switch
			System.out.println("Left Position/Left Switch");
    		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
    		addSequential(new DriveForward(147));
    		addSequential(new Turn(80, -.4, false)); //TODO: adjust these numbers
    		addSequential(new DriveForwardTime(2));
    		addSequential(new MoveIntakeAuto(-.78));
    		addSequential(new OpenClose());
    		addSequential(new LowerArm());
    	}
    	else if (goal == 1 && gameData.charAt(1) == 'L')
    	{
			// Left Side Scale
    		System.out.println("Left Position/Left Scale");
			addSequential(new DriveForward(285)); //TODO: adjust this for scale auto
			addSequential(new Turn(-95, .47, true)); //TODO: also adjust this for scale auto
			addSequential(new MoveArmScale(RobotMap.k_potScale));
			//addSequential(new MoveIntakeAuto(-.7));
			addSequential(new LowerArm());
			addSequential(new LowerArm());
    		addSequential(new LowerArm());    		
    	}
    	else
    	{
    		// Cross Baseline
    		System.out.println("Left Position/Cross Baseline");
    		addSequential(new DriveForward(145));    
    		addSequential(new DriveBackwardTime(.2));
    	}
/*    	if (gameData.charAt(0) == 'L' && gameData.charAt(1) != 'L')
    	{
    		//Left Side Switch
			System.out.println("Left Position/Left Switch");
    		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
    		addSequential(new DriveForward(140));
    		addSequential(new Turn(85, -.4, false));
    		addSequential(new DriveForwardTime(4));
    		addSequential(new MoveIntakeAuto(-.78));
    		addSequential(new OpenClose());
    		addSequential(new LowerArm());
    	} 
    	else if (gameData.charAt(0) != 'L' && gameData.charAt(1) == 'L')
    	{
    		// Left Side Scale
    		System.out.println("Left Position/Left Scale");
			addSequential(new DriveForward(285));
			addSequential(new Turn(-95, .47, true));
			addSequential(new MoveArmScale(RobotMap.k_potScale));
		//	addSequential(new MoveIntakeAuto(-.7));
			addSequential(new LowerArm());
			addSequential(new LowerArm());
    	}
    	else if (gameData.charAt(0) == 'L' && gameData.charAt(1) == 'L')
    	{
    		if (goal == 0)
    		{
    			//Left Side Switch
    			System.out.println("Left Position/Left Switch");
        		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
        		addSequential(new DriveForward(140));
        		addSequential(new Turn(85, -.4, false));
        		addSequential(new DriveForwardTime(4));
        		addSequential(new MoveIntakeAuto(-.78));
        		addSequential(new OpenClose());
        		addSequential(new LowerArm());
    		}
    		else if (goal == 1)
    		{
    			// Left Side Scale
        		System.out.println("Left Position/Left Scale");
    			addSequential(new DriveForward(285));
    			addSequential(new Turn(-95, .47, true));
    			addSequential(new MoveArmScale(RobotMap.k_potScale));
    			//addSequential(new MoveIntakeAuto(-.7));
    			addSequential(new LowerArm());
    			addSequential(new LowerArm());
        		addSequential(new LowerArm());
    		}
    		else if (goal == 2)
    		{
    			// Cross Baseline
        		System.out.println("Left Position/Cross Baseline");
        		addSequential(new DriveForward(140));
    		}
    	}
    	else 
    	{
    		// Cross Baseline
    		System.out.println("Left Position/Cross Baseline");
    		addSequential(new DriveForward(140));
    	}*/
    } 
   
}
