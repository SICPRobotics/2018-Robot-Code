package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Right extends CommandGroup {

    public Right(String gameData) 
    {
    		if (gameData.charAt(0) == 'R')
		{
			//Right Side Switch
    			//Forward 135.7
    			//Left turn 90 degrees
    			//Forward 7.525
		} else 
		{
			if (gameData.charAt(1) == 'R')
			{
				// Right Side Scale
				// Forward 376.1
				// Left 90 Degrees
				// Back 48.3
			} else 
			{
				// Left Side Switch
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
