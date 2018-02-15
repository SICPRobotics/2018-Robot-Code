package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ArmButton extends CommandGroup {

    public ArmButton(String area, int degrees) 
    {
       if (area == "Floor")
       {
    	   addSequential(new SolenoidForward());
    	   addSequential(new MoveArm(degrees));
       }
       else
       {
    	   addSequential(new SolenoidReverse());
    	   addSequential(new MoveArm(degrees));
       }
    }
}
