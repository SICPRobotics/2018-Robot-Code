package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class A_Right extends CommandGroup {

    public A_Right(String gameData) 
    {
    	if (gameData.charAt(0) == 'R')
		{
			//Right Side Switch
    		
    		//Forward 148.875
    		addSequential(new Forward(148.875));
    		addParallel(new RaiseArm(RobotMap.k_switch));
    		//Left turn 90.000 degrees
    		addSequential(new Turn(-90));
    		//Forward 19.435
    		addSequential(new Forward(19.435));
    		addSequential(new Intake(-.7));
		} 
    	else 
		{
			if (gameData.charAt(1) == 'R')
			{
				// Right Side Scale
				
				// Forward 304.875
				addSequential(new Forward(304.875));
				addParallel(new RaiseArm(RobotMap.k_scale));
				// Left 90.000 Degrees
				addSequential(new Turn(-90));
				// forward 5.755
			//	addSequential(new Forward(5.755));
				addSequential(new Intake(-.7));
			} 
			else 
			{
				//cross baseline
				addSequential(new Forward(148.875));
			}
		}
    }
}
