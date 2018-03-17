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
    		addSequential(new DriveForward(5));
    		addSequential(new Turn(-30, .4, true)); //-28
    		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
    		addSequential(new DriveForward(103)); //92
    		addSequential(new Turn(15, -.4, false)); //24
    		//addSequential(new DriveForward(2));
    		addSequential(new DriveForwardTime(3));
    		addSequential(new MoveIntakeAuto(-.7));
    		addSequential(new DriveBackward(-10));
    		addSequential(new LowerArm());
    		
    		
//    		addSequential(new Turn(-41.4096, .5, true));
//    		addSequential(new DriveForward(90.33));
//    		addSequential(new Turn(41.4096, -.5, false));
//    		addSequential(new DriveForward(60));
//    		addSequential(new Turn90(false));
//    		addSequential(new DriveForward(37));
//    		addSequential(new Turn90(false));
    		 		
    	} 
    	else if (gameData.charAt(0) == 'R') 
    	{
    		// Right Side Switch
    		System.out.println("Center Position/Right Switch");
    		addSequential(new DriveForward(5));
    		addSequential(new Turn(15, -.4, false));
    		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
    		addSequential(new DriveForward(95));
    		addSequential(new Turn(-20, .4, true));
    		addSequential(new DriveForward(5));
    		addSequential(new DriveForwardTime(2));
    		addSequential(new MoveIntakeAuto(-.8));
    		addSequential(new DriveBackward(-10));
    		addSequential(new LowerArm());
    		/*
    		addSequential(new Turn(theta, -.5, false));
    		addSequential(new DriveForward(z));
    		addSequential(new Turn(-theta, .5, true));
    		addSequential(new DriveForward(40 + y/2));
    		addSequential(new Turn(-90, .4, true));
    		addSequential(new DriveForward(37));
    		addSequential(new Turn(-90, .4, true));
    		*/
    	}
    }
}
