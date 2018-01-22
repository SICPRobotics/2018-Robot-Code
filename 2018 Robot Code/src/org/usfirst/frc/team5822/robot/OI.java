package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI 
{
	Joystick joy, xbox;
	
	public OI(Joystick j, Joystick x)
	{
		joy = j;
		xbox = x;
		
		Button j7 = new JoystickButton(j, 7);
		Button j8 = new JoystickButton(j, 8); 
		//9 and 10 don't work on our joystick 
		Button j11 = new JoystickButton(j, 11); 
		Button j12 = new JoystickButton(j, 12);

		Button buttonA = new JoystickButton(x, 1);
		Button buttonB = new JoystickButton(x, 2);
		Button buttonX = new JoystickButton(x, 3);
		Button buttonY = new JoystickButton(x, 4);
		Button buttonLB = new JoystickButton(x, 5);
		Button buttonRB = new JoystickButton(x, 6);
		Button buttonBack = new JoystickButton(x, 7);
		Button buttonStart = new JoystickButton(x, 8);
					
	}
}
