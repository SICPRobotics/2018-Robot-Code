package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class A_Center extends CommandGroup 
{
	public static int newint;
    public A_Center(String gameData, int side) 
    {
    	Robot.sensors.resetGyro();
    	if (gameData.charAt(0) == 'L')
    	{
    		//Left Side Switch
    		System.out.println("Center Position/Left Switch");
    		addSequential(new DriveForward(40.875));
    		addParallel(new MoveArm(RobotMap.k_potSwitch));
    		addSequential(new TurnGroup(-90));
    		addSequential(new DriveForward(61));
    		addSequential(new TurnGroup(90));
    		addSequential(new DriveForward(60.785));
    		addSequential(new Intake(-.7));
    	} 
    	else if (gameData.charAt(0) == 'R') 
    	{
    		// Right Side Switch
    		System.out.println("Center Position/Right Switch");
    		addSequential(new DriveForward(40.875));
    		addParallel(new MoveArm(RobotMap.k_potSwitch));
    		addSequential(new TurnGroup(90));
    		addSequential(new DriveForward(46.2));
    		addSequential(new TurnGroup(-90));
    		addSequential(new DriveForward(60.785));
    		addSequential(new Intake(-.7));
    	} else {
    		//cross baseline - this should NOT happen
    		System.out.println("Center Position/Cross Baseline");
    		addSequential(new DriveForward(40.875));
    		addSequential(new TurnGroup(90));
    		addSequential(new DriveForward(46.2));
    		addSequential(new TurnGroup(-90));
    		addSequential(new DriveForward(60.785));

    	}
    	
    }
}
