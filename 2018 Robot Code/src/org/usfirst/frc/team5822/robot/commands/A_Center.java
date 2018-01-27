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
    			//
    			addSequential(new Forward(70.875));
    			addSequential(new Turn(-90));
    			addSequential(new Forward(5.635));
    			addParallel(new RaiseArm(RobotMap.k_switch));
    			addSequential(new Turn(90));
    			addSequential(new Forward(30.785));
    			addSequential(new Intake(-.7));
    		} 
    		else if (gameData.charAt(0) == 'R')
    		{
    			// Right Side Switch
    			//
    			addSequential(new Forward(70.875));
    			addSequential(new Turn(90));
    			addSequential(new Forward(5.635));
    			addParallel(new RaiseArm(RobotMap.k_switch));
    			addSequential(new Turn(-90));
    			addSequential(new Forward(30.785));
    			addSequential(new Intake(-.7));
    		}
    		else
    		{
    			//cross baseline
    			//
    			addSequential(new Forward(70.875));
    			addSequential(new Turn(-90));
    			addSequential(new Forward(5.635));
    			addParallel(new RaiseArm(RobotMap.k_switch));
    			addSequential(new Turn(90));
    			addSequential(new Forward(30.785));
    		}
    }
}
