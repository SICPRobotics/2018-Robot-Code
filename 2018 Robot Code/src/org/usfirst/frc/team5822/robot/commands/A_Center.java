package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class A_Center extends CommandGroup {

	public static int newint;
    public A_Center(String gameData) 
    {
    		if (gameData.charAt(0) == 'L')
    		{
    			//Left Side Switch
    			System.out.println("In command");
    			addSequential(new Forward(40.875)); //70.875
    			addSequential(new Turn(-90));
    			addSequential(new Forward(61)); //5.635
    			addParallel(new RaiseArm(RobotMap.k_switch));
    			addSequential(new Turn(90));
    			addSequential(new Forward(60.785)); //30.785
    			addSequential(new Intake(-.7, false));
    		} 
    		else if (gameData.charAt(0) == 'R')
    		{
    			// Right Side Switch
    			//
    			addSequential(new Forward(70.875));
    			addSequential(new Turn(90));
    			addSequential(new Forward(46.2));
    			addParallel(new RaiseArm(RobotMap.k_switch));
    			addSequential(new Turn(-90));
    			addSequential(new Forward(60.785));
    			addSequential(new Intake(-.7, false));
    		}
    		else
    		{
    			addSequential(new Forward(70.875));
    			addSequential(new Turn(90));
    			addSequential(new Forward(5.635));
    			addSequential(new Turn(-90));
    			addSequential(new Forward(30.785));
  
    		}
    }
}
