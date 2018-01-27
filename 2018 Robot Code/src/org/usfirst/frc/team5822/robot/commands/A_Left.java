package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class A_Left extends CommandGroup {

    public A_Left(String gameData) 
    {
    	if (gameData.charAt(0) == 'L')
		{
			// Left Side Switch
    			
    		//forward 148.875
    		addSequential(new Forward(148.875));
    		addParallel(new RaiseArm(RobotMap.k_switch));
    		//turn right 90 degree  
    		addSequential(new Turn(90));
    		// forward 19.435
    		addSequential(new Forward(19.435));
    		addSequential(new Intake(-.7));
 		} 
    	else 
		{
			if (gameData.charAt(1) == 'L')
			{
				// Left Side Scale
				
				//Forward 304.875
				addSequential(new Forward(304.875));
				addParallel(new RaiseArm(RobotMap.k_scale));
				// right 90 Degrees
				addSequential(new Turn(90)); //21 in from edge of scale
				// forward 5.755
				//addSequential(new Forward(5.755)); 
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
