package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class OI 
{	
	XboxController x = Robot.x;

	Button j1 = new JoystickButton(Robot.j, 1);
	Button j2 = new JoystickButton(Robot.j, 2);
	Button j3 = new JoystickButton(Robot.j, 3);
	Button j4 = new JoystickButton(Robot.j, 4);		
	Button j5 = new JoystickButton(Robot.j, 5);
	Button j6 = new JoystickButton(Robot.j, 6);
	Button j7 = new JoystickButton(Robot.j, 7);
	Button j8 = new JoystickButton(Robot.j, 8); //9 and 11 don't work on our joystick 
	Button j10 = new JoystickButton(Robot.j, 10); 
	Button j12 = new JoystickButton(Robot.j, 12);

	Button buttonA = new JoystickButton(x, 1); //Old 2
	Button buttonB = new JoystickButton(x, 2); //Old 3
	Button buttonX = new JoystickButton(x, 3); //Old 1
	Button buttonY = new JoystickButton(x, 4); 
	Button buttonLB = new JoystickButton(x, 5);
	Button buttonRB = new JoystickButton(x, 6); 
	Button buttonBack = new JoystickButton(x, 7); //Old 9
	Button buttonStart = new JoystickButton(x, 8); //Old 10 
	Button leftThumb = new JoystickButton(x, 9);
	Button rightThumb = new JoystickButton(x, 10);
		
	XboxTrigger leftTrig = new XboxTrigger(true);
	XboxTrigger rightTrig = new XboxTrigger(false);
	
	public OI()
	{
//		buttonA.whenPressed(new ArmButton("Floor", RobotMap.k_potFloor));
//		buttonB.whenPressed(new ArmButton("Switch", RobotMap.k_potSwitch)); 
//		buttonX.whenPressed(new ArmButton("Exchange", RobotMap.k_potExchange)); 
//		buttonY.whenPressed(new ArmButton("Scale", RobotMap.k_potScale)); 
//TODO: probably will end up deleting these
		
		buttonA.whenPressed(new LowerArm());
		buttonB.whenPressed(new MoveArmPID(RobotMap.k_potSwitch));
		buttonX.whenPressed(new MoveArmPID(RobotMap.k_potExchange));
		buttonY.whenPressed(new MoveArmScale(RobotMap.k_potScale));
		
		buttonLB.whenPressed(new Intake(.60));
		buttonLB.whenReleased(new Intake(0));		
		buttonRB.whenPressed(new Intake(-.750)); 
		buttonRB.whenReleased(new Intake(0));
		
		buttonStart.whenPressed(new SolenoidForward());
		buttonBack.whenPressed(new SolenoidReverse());
		
		rightThumb.whenPressed(new ReleaseHook());
		leftThumb.whenPressed(new OpenClose());
				
		leftTrig.whenActive(new Climb("left"));
		leftTrig.whenInactive(new StopClimb(true));
		rightTrig.whenActive(new Climb("right"));
		rightTrig.whenInactive(new StopClimb(false));
		
		new MoveArmScale(x.getRawAxis(1)); 
		
		j1.whenPressed(new Intake(.60));
		j1.whenReleased(new Intake(0));
		j2.whenPressed(new Intake(-.60));
		j2.whenReleased(new Intake(0));
		
		j3.whenActive(new Climb("left"));
		j4.whenActive(new Climb("right"));
		j5.whenPressed(new SolenoidForward());
		j6.whenPressed(new SolenoidReverse());
		j7.whenActive(new ReleaseHook());
		j8.whenActive(new OpenClose());
		j10.whenPressed(new FallDown(-1));
		j12.whenPressed(new FallDown(1));
	}
}
