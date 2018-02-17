package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class A_Left extends CommandGroup
{
    public A_Left(String gameData, int side) 
    {
    	if (gameData.charAt(0) == 'L' && gameData.charAt(1) != 'L')
    	{
    		// Left Side Switch	
    		System.out.println("Left Position/ L !L /Left Switch");
    		addSequential(new DriveForward(148.875));
    		addParallel(new MoveArm(RobotMap.k_potSwitch));
    		addSequential(new TurnGroup(90));
    		addSequential(new DriveForward(19.435));
    		addSequential(new Intake(-.7));
    	} 
    	else if (gameData.charAt(0) != 'L' && gameData.charAt(1) == 'L')
    	{
    		// Left Side Scale
    		System.out.println("Left Position/ !L L /Left Scale");
			addSequential(new DriveForward(304.875));
			addParallel(new MoveArm(RobotMap.k_potScale));
			addSequential(new TurnGroup(90));
			addSequential(new DriveForward(5.755)); 
			addSequential(new Intake(-.7));
    	}
    	else if (gameData.charAt(0) == 'L' && gameData.charAt(1) == 'L')
    	{
    		System.out.println("Left Position/ L L");
    		if (side == 0)
    		{
    			//Left Side Switch
        		System.out.println("User chose switch");
        		addSequential(new DriveForward(148.875));
        		addParallel(new MoveArm(RobotMap.k_potSwitch));
        		addSequential(new TurnGroup(90));
        		addSequential(new DriveForward(19.435));
        		addSequential(new Intake(-.7));
    		}
    		else if (side == 1)
    		{
    			// Left Side Scale
        		System.out.println("User chose scale");
    			addSequential(new DriveForward(304.875));
    			addParallel(new MoveArm(RobotMap.k_potScale));
    			addSequential(new TurnGroup(90));
    			addSequential(new DriveForward(5.755)); 
    			addSequential(new Intake(-.7));
    		}
    	}
    		
    	else 
    	{
    		// Cross Baseline
    		System.out.println("Left Position/ !L !L / Cross Baseline");
    		addSequential(new DriveForward(148.875));
    	}
    }
}
