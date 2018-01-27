package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Center extends CommandGroup {

	public static int newint;
    public Center(String gameData) 
    {
    		if (gameData.charAt(0) == 'L')
    		{
    			//Left Side Switch
    			//
    			//Forward 147
    			//
    		} 
    		else 
    		{
    			// Right Side Switch
    			// Left 71.16
    			//Forward 147
    			// Right 71.16
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
