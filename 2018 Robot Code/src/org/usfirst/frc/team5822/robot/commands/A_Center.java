package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class A_Center extends CommandGroup 
{
    public A_Center(String gameData, int side) 
    {
    	if (gameData.charAt(0) == 'L')
    	{
    		//Left Side Switch
    		System.out.println("Center Position/Left Switch");
//    		addSequential(new DriveForward(40.875));
//    		addSequential(new Turn(-90, .4, true));
//    		addSequential(new DriveForward(61));
//    		addSequential(new Turn(90, -.4, false));
//    		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
//    		addSequential(new DriveForward(60.785));
//    		addSequential(new MoveIntake(-.7));
    		
    		addSequential(new DriveForward(5));
    		addSequential(new Turn(-23.96, .4, true));
    		//addSequential(new MoveArmPID(RobotMap.k_potSwitch));
    		addSequential(new DriveForward(147.73));
    		addSequential(new Turn(23.96, -.4, false));
    		addSequential(new MoveIntakeAuto(-.7));
    	} 
    	else if (gameData.charAt(0) == 'R') 
    	{
    		// Right Side Switch
    		System.out.println("Center Position/Right Switch");
//    		addSequential(new DriveForward(40.875)); 
//    		addSequential(new Turn(90, -.4, false));
//    		addSequential(new DriveForward(46.2));
//    		addSequential(new Turn(-90, .4, true));
//    		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
//    		addSequential(new DriveForward(60.785));
//    		addSequential(new MoveIntake(-.8));
    		
    		addSequential(new DriveForward(5));
    		addSequential(new Turn(20.3, -.4, false));
    		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
    		addSequential(new DriveForward(90));
    		addSequential(new Turn(-25, .4, true));
    		addSequential(new MoveIntakeAuto(-.78));
    		addSequential(new LowerArm());
    		
    	}
    }
}
