package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AntiFallMech extends Subsystem 
{
	DoubleSolenoid solo;
		
	public AntiFallMech()
	{
		solo = new DoubleSolenoid(RobotMap.k_antiFallSolo1, RobotMap.k_antiFallSolo2);
		solo.set(DoubleSolenoid.Value.kReverse);
	}

	public void forward()
	{
		solo.set(DoubleSolenoid.Value.kForward);
	}
	
	public void reverse()
	{
		solo.set(DoubleSolenoid.Value.kReverse);
	}
    public void initDefaultCommand() {}
}

