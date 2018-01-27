package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Left extends CommandGroup {

    public Left(String gameData) 
    {
    		if (gameData.charAt(0) == 'L')
		{
			// Left Side Switch
    			
    		//forward 148.875
    		addSequential(new Forward(148.875));
    		//turn right 90 degree  
    		addSequential(new Turn(90));
    		// forward 19.435
    		addSequential(new Forward(19.435));
 		} else 
		{
			if (gameData.charAt(1) == 'L')
			{
				// Left Side Scale
				
				//Forward 304.875
				addSequential(new Forward(304.875));
				// right 90 Degrees
				addSequential(new Turn(90));
				// forward 5.755
				addSequential(new Forward(5.755));

			} else 
			{
				//cross baseline
				addSequential(new Forward(148.875));
			}
			
		}
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
