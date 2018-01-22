package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI 
{
	//Joystick j = new Joystick(RobotMap.k_joystick1);
	Joystick x = new Joystick(RobotMap.k_xboxCntrl);
	
	Button j7 = new JoystickButton(Robot.j, 7);
	Button j8 = new JoystickButton(Robot.j, 8); 
	//9 and 10 don't work on our joystick 
	Button j11 = new JoystickButton(Robot.j, 11); 
	Button j12 = new JoystickButton(Robot.j, 12);

	Button buttonA = new JoystickButton(x, 1);
	Button buttonB = new JoystickButton(x, 2);
	Button buttonX = new JoystickButton(x, 3);
	Button buttonY = new JoystickButton(x, 4);
	Button buttonLB = new JoystickButton(x, 5);
	Button buttonRB = new JoystickButton(x, 6);
	Button buttonBack = new JoystickButton(x, 7);
	Button buttonStart = new JoystickButton(x, 8);	
	
	public OI()
	{
		buttonA.whileHeld(new Intake(.7));
		buttonB.whileHeld(new Intake(-.7));
		
		buttonY.whileHeld(new ClimbUp());
	}
	
	
}
