package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AntiFallMech extends Subsystem 
{
	Solenoid solo;
		
	public AntiFallMech()
	{
		solo = new Solenoid(2);
		solo.set(true);
	}

	public void forward()
	{
		solo.set(true);
	}
	
	public void reverse()
	{
		solo.set(false);
	}
    public void initDefaultCommand() {}
}

