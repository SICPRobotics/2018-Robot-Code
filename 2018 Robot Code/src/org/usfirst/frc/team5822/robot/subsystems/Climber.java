package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem 
{
	VictorSP climberL, climberR;
//	Servo servo1, servo2;
	// TODO: re-enable for solenoid
//	DoubleSolenoid release;
	public Climber()
	{
		if (Robot.isOldRobot) {
			climberL = null;
			climberR = null;
			// TODO: re-enable for solenoid
//			release = null;
		} else {
			climberL = new VictorSP(RobotMap.k_climbLeft);
			climberR = new VictorSP(RobotMap.k_climbRight);

			// servo1 = new Servo(RobotMap.k_servo1);
			// servo2 = new Servo(RobotMap.k_servo2);
			// TODO: re-enable for solenoid
//			release = new DoubleSolenoid(RobotMap.k_climberSolo1, RobotMap.k_climberSolo2);
//			release.set(DoubleSolenoid.Value.kReverse);
		}
	}
	
	public void climbLeft()
	{
		System.out.println("Climber - climbLeft");
		if (Robot.isOldRobot) {return;}
		climberL.set(.5);
	}
	public void stopClimbLeft()
	{
		System.out.println("Climber - stopClimbLeft");
		if (Robot.isOldRobot) {return;}
		climberL.set(0);
	}
	public void climbRight()
	{
		System.out.println("Climber - climbRight");
		if (Robot.isOldRobot) {return;}
		climberR.set(.5);
	}
	public void stopClimbRight()
	{
		System.out.println("Climber - stopClimbRight");
		if (Robot.isOldRobot) {return;}
		climberR.set(0);
	}
	public void release()
	{
		System.out.println("Climber - release");
		if (Robot.isOldRobot) {return;}
		// TODO: re-enable for solenoid
//		release.set(DoubleSolenoid.Value.kForward);
	}
	
    public void initDefaultCommand() {}
}

