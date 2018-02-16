package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI 
{	
	Joystick j = new Joystick(RobotMap.k_joystick1);
	XboxController x = new XboxController(RobotMap.k_xboxCntrl);

	Button j1 = new JoystickButton(Robot.j, 1);
	Button j2 = new JoystickButton(Robot.j, 2);
	Button j3 = new JoystickButton(Robot.j, 3);
	Button j4 = new JoystickButton(Robot.j, 4);		
	Button j5 = new JoystickButton(Robot.j, 5);
	Button j6 = new JoystickButton(Robot.j, 6);
	Button j7 = new JoystickButton(Robot.j, 7);
	Button j8 = new JoystickButton(Robot.j, 8);
	//9 and 11 don't work on our joystick 
	Button j10 = new JoystickButton(Robot.j, 10); 
	Button j12 = new JoystickButton(Robot.j, 12);

	Button buttonA = new JoystickButton(x, 1); //Old 2
	Button buttonB = new JoystickButton(x, 2); //Old 3
	Button buttonX = new JoystickButton(x, 3); //Old 1
	Button buttonY = new JoystickButton(x, 4); //Old 4
	Button buttonLB = new JoystickButton(x, 5);
	Button buttonRB = new JoystickButton(x, 6); 
	Button buttonBack = new JoystickButton(x, 7); //Old 9
	Button buttonStart = new JoystickButton(x, 8);	//Old 10 
	Button leftThumb = new JoystickButton(x, 9);
	Button rightThumb = new JoystickButton(x, 10);

	public OI()
	{
		buttonA.whenPressed(new ArmButton("Floor", RobotMap.k_potFloor));
		buttonB.whenPressed(new ArmButton("Switch", RobotMap.k_potSwitch)); 
		buttonX.whenPressed(new ArmButton("Exchange", RobotMap.k_potExchange)); 
		buttonY.whenPressed(new ArmButton("Scale", RobotMap.k_potScale)); 

		buttonLB.whenPressed(new Intake(.60, false));
		buttonLB.whenReleased(new Intake(0, false));		
		buttonRB.whenPressed(new Intake(-.10, false)); 
		buttonRB.whenReleased(new Intake(0, false));
		
		buttonStart.whenActive(new ReleaseHook("left"));
		buttonBack.whenActive(new ReleaseHook("right"));
		
		leftThumb.whenActive(new SolenoidReverse());
		rightThumb.whenActive(new OpenClose());
				
		if (x.getRawAxis(2) > 0)
			new Climb("left");
		if(x.getRawAxis(3) > 0)
			new Climb("right");
		
		j1.whenPressed(new Intake(.60, false));
		j1.whenReleased(new Intake(0, false));
		j2.whenPressed(new Intake(-.60, false));
		j2.whenReleased(new Intake(0, false));
		j3.whenActive(new Climb("left"));
		j4.whenActive(new Climb("right"));
		j5.whenPressed(new SolenoidForward());
		j6.whenPressed(new SolenoidReverse());
		j7.whenActive(new ReleaseHook("left"));
		j8.whenActive(new ReleaseHook("right"));
		j10.whenPressed(new FallDown(-1));
		j12.whenPressed(new FallDown(1));
	}
}
