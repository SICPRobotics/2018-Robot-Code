package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class OI 
{	
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

	Button buttonA = new JoystickButton(Robot.x, 1); //Old 2
	Button buttonB = new JoystickButton(Robot.x, 2); //Old 3
	Button buttonX = new JoystickButton(Robot.x, 3); //Old 1
	Button buttonY = new JoystickButton(Robot.x, 4); 
	Button buttonLB = new JoystickButton(Robot.x, 5);
	Button buttonRB = new JoystickButton(Robot.x, 6); 
	Button buttonBack = new JoystickButton(Robot.x, 7); //Old 9
	Button buttonStart = new JoystickButton(Robot.x, 8); //Old 10 
	Button leftThumb = new JoystickButton(Robot.x, 9);
	Button rightThumb = new JoystickButton(Robot.x, 10);
		
	XboxTrigger leftTrig = new XboxTrigger(true);
	XboxTrigger rightTrig = new XboxTrigger(false);
	
	public OI()
	{		
		buttonA.whenPressed(new LowerArm());
		buttonB.whenPressed(new MoveArmPID(RobotMap.k_potSwitch));
		buttonX.whenPressed(new OpenClose());
		buttonY.whenPressed(new MoveArmScale(RobotMap.k_potScale));
		
		buttonLB.whenPressed(new MoveIntake(.60));
		buttonLB.whenReleased(new MoveIntake(0));		
		buttonRB.whenPressed(new MoveIntake(-.750)); 
		buttonRB.whenReleased(new MoveIntake(0));
		
		buttonStart.whenPressed(new ReleaseHook());
		//buttonBack.whenPressed(???);
		
		rightThumb.whenPressed(new SolenoidForward());
		leftThumb.whenPressed(new SolenoidReverse());
			
		leftTrig.whenActive(new Climb("left"));
		leftTrig.whenInactive(new StopClimb(true));
		rightTrig.whenActive(new Climb("right"));
		rightTrig.whenInactive(new StopClimb(false));
		
		j1.whenPressed(new MoveIntake(.60));
		j1.whenReleased(new MoveIntake(0));
		j2.whenPressed(new MoveIntake(-.60));
		j2.whenReleased(new MoveIntake(0));
		
		j3.whenActive(new Climb("left"));
		j4.whenActive(new Climb("right"));
		j5.whenPressed(new SolenoidForward());
		j6.whenPressed(new SolenoidReverse());
		j7.whenActive(new ReleaseHook());
		j8.whenActive(new OpenClose());
		j10.whenPressed(new FallDown(-.6));
		j10.whenReleased(new FallDown(0));
		j12.whenPressed(new FallDown(.6));
		j12.whenReleased(new FallDown(0));
	}
}
