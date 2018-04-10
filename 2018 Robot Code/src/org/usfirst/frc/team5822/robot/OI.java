package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI 
{	
	Button j1 = new JoystickButton(Robot.j1, 1);
	Button j2 = new JoystickButton(Robot.j1, 2);
	Button j3 = new JoystickButton(Robot.j1, 3);
	Button j4 = new JoystickButton(Robot.j1, 4);		
	Button j5 = new JoystickButton(Robot.j1, 5);
	Button j6 = new JoystickButton(Robot.j1, 6);
	//Button j7 = new JoystickButton(Robot.j, 7); BEING USED IN MAIN ROBOT
	Button j8 = new JoystickButton(Robot.j1, 8); //9 and 11 don't work on our joystick 
	Button j10 = new JoystickButton(Robot.j1, 10); 
	Button j12 = new JoystickButton(Robot.j1, 12);

	Button buttonA = new JoystickButton(Robot.x, 1); 
	Button buttonB = new JoystickButton(Robot.x, 2); 
	Button buttonX = new JoystickButton(Robot.x, 3); 
	Button buttonY = new JoystickButton(Robot.x, 4); 
	Button buttonLB = new JoystickButton(Robot.x, 5);
	Button buttonRB = new JoystickButton(Robot.x, 6); 
	Button buttonBack = new JoystickButton(Robot.x, 7); 
	Button buttonStart = new JoystickButton(Robot.x, 8);  
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
		buttonRB.whenPressed(new MoveIntake(-.8)); 
		buttonRB.whenReleased(new MoveIntake(0));
		//buttonBack.whenPressed(new MoveIntake(-1));
		//buttonBack.whenReleased(new MoveIntake(0));
		
		buttonStart.whenPressed(new MoveArmClimb());
		//buttonBack open
		
		rightThumb.whenPressed(new SolenoidForward());
		leftThumb.whenPressed(new SolenoidReverse());
			
		leftTrig.whenActive(new Climb("left"));
		leftTrig.whenInactive(new StopClimb());
		rightTrig.whenActive(new MoveArmPID(RobotMap.k_potTravel)); //TODO: test this and ask Charles if he wants to switch buttons with OpenClose
		
		j1.whenPressed(new MoveIntake(.85));
		j1.whenReleased(new MoveIntake(0));
		j2.whenPressed(new MoveIntake(-.85));
		j2.whenReleased(new MoveIntake(0));
		
		j3.whenActive(new Climb("left"));
		//j4 open
		j5.whenPressed(new SolenoidForward());
		j6.whenPressed(new SolenoidReverse());
		//j7 open
		j8.whenActive(new OpenClose());
		j10.whenPressed(new FallDown(-.6));
		j10.whenReleased(new FallDown(0));
		j12.whenPressed(new FallDown(.6));
		j12.whenReleased(new FallDown(0));
	}
}
