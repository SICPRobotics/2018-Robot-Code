package org.usfirst.frc.team5822.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI 
{
	Joystick joy1, joy2; //NEW
	
	public OI(Joystick j1, Joystick j2)
	{
		joy1 = j1;
		joy2 = j2; //NEW
		
		
		Button j7 = new JoystickButton(j1, 7); //NEW
		Button j8 = new JoystickButton(j1, 8); //NEW
		//9 and 10 don't work on our joystick //NEW
		Button j11 = new JoystickButton(j1, 11); //NEW
		Button j12 = new JoystickButton(j1, 12); //NEW

		Button buttonA = new JoystickButton(j2, 1); //NEW
		Button buttonB = new JoystickButton(j2, 2); //NEW
		Button buttonX = new JoystickButton(j2, 3); //NEW
		Button buttonY = new JoystickButton(j2, 4); //NEW
		Button buttonLB = new JoystickButton(j2, 5); //NEW
		Button buttonRB = new JoystickButton(j2, 6); //NEW
		Button buttonBack = new JoystickButton(j2, 7); //NEW
		Button buttonStart = new JoystickButton(j2, 8); //NEW
		
		
		//buttonA.whenPressed(System.out.println("button A"));
		
		
		
	}

	private void Command() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
