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
    		addSequential(new Turn(0, -.4, false)); //24
    		addSequential(new DriveForwardTime(3));
    		addSequential(new MoveIntakeAuto(-.7));
    		addSequential(new OpenClose());
    		addSequential(new DriveBackward(-6));
    		addSequential(new LowerArm());    		 		
    	} 
    	else if (gameData.charAt(0) == 'R') 
    	{
    		//Right Side Switch
    		System.out.println("Center Position/Right Switch");
    		addSequential(new DriveForward(5));
    		addSequential(new Turn(15, -.4, false));
    		addSequential(new MoveArmPID(RobotMap.k_potSwitch));
    		addSequential(new DriveForward(95));
    		addSequential(new Turn(5, .4, true)); //-15
    		addSequential(new DriveForward(5));
    		addSequential(new DriveForwardTime(2));
    		addSequential(new MoveIntakeAuto(-.8));
    		addSequential(new OpenClose());
    		addSequential(new DriveBackward(-10));
    		addSequential(new LowerArm());
    	}
    }
}
