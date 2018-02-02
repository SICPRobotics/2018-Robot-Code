package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class A_Left extends CommandGroup
{
    public A_Left(String gameData) 
    {
    		if (gameData.charAt(0) == 'L')
    		{
    			// Left Side Switch	
    			System.out.println("Left Position/Left Switch");
    		
    			// Forward 148.875
    			addSequential(new DriveForward(148.875));
    			addParallel(new MoveArm(RobotMap.k_switch));
    		
    			// Turn right 90 degree  
    			addSequential(new TurnGroup(90));
    		
    			// Forward 19.435
    			addSequential(new DriveForward(19.435));
    			addSequential(new Intake(-.7, false));
    		} 
    		else 
    		{
    			if (gameData.charAt(1) == 'L')
    			{
    				// Left Side Scale
    				System.out.println("Left Position/Left Scale");
    			
    				// Forward 304.875
    				addSequential(new DriveForward(304.875));
    				addParallel(new MoveArm(RobotMap.k_scale));
    			
    				// Right 90 Degrees
    				addSequential(new TurnGroup(90)); //21 in from edge of scale
    			
    				// Forward 5.755
    				addSequential(new DriveForward(5.755)); 
    				addSequential(new Intake(-.7, false));
    			} 
    			else 
    			{
    				// Cross Baseline
    				System.out.println("Left Position/ Cross Baseline");
    				addSequential(new DriveForward(148.875));
    			}
    		}
    }
}
