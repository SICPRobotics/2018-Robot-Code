package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AntiFallMech extends Subsystem 
{
	VictorSP feet; 
	
	public AntiFallMech()
	{
		if (Robot.isOldRobot) return;
		feet = new VictorSP(RobotMap.k_feet);
	}

	public void move(double speed)
	{
		if (Robot.isOldRobot) return;
		feet.set(speed);
	}

    public void initDefaultCommand() {}
}

