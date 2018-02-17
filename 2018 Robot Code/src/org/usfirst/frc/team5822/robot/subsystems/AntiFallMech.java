package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AntiFallMech extends Subsystem 
{
	// TODO: re-enable for solenoid
	//DoubleSolenoid solo;
		
	public AntiFallMech()
	{
		if (Robot.isOldRobot) return;
	//	solo = new DoubleSolenoid(RobotMap.k_antiFallSolo1, RobotMap.k_antiFallSolo2);
	//	solo.set(DoubleSolenoid.Value.kReverse);
	}

	public void forward()
	{
		System.out.println("antifallmech forward");
		if (Robot.isOldRobot) return;
	//	solo.set(DoubleSolenoid.Value.kForward);
	}
	
	public void reverse()
	{
		System.out.println("antifallmech reverse");
		if (Robot.isOldRobot) return;
	//	solo.set(DoubleSolenoid.Value.kReverse);
	}
    public void initDefaultCommand() {}
}

