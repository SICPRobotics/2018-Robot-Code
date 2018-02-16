package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem 
{
	VictorSP climberL, climberR;
//	Servo servo1, servo2;
	DoubleSolenoid release;
	public Climber()
	{
		climberL = new VictorSP(RobotMap.k_climbLeft);
		climberR = new VictorSP(RobotMap.k_climbRight);
		//servo1 = new Servo(RobotMap.k_servo1);
		//servo2 = new Servo(RobotMap.k_servo2);
		release = new DoubleSolenoid(RobotMap.k_climberSolo1, RobotMap.k_climberSolo2);
		release.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void climbLeft()
	{
		climberL.set(.5);
	}
	public void climbRight()
	{
		climberR.set(.5);
	}
	public void release()
	{
		release.set(DoubleSolenoid.Value.kForward);
	}
	
    public void initDefaultCommand() {}
}

