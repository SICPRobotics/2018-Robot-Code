package org.usfirst.frc.team5822.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TwoSpinnyWheels extends Subsystem 
{
	VictorSP intakeLeft, intakeRight;
	SpeedControllerGroup intake;
	public TwoSpinnyWheels()
	{
		intakeLeft = new VictorSP(5); //k_intakeLeft
		intakeRight = new VictorSP(6); //k_intakeRight
		intakeLeft.setInverted(true);
		intake = new SpeedControllerGroup(intakeLeft, intakeRight);
	}

    public void initDefaultCommand() 
    {
    	
    }
    
    public void takeIn(double speed)
    {
    	if (speed < 0)
    		intake.set(speed);
    	intake.set(speed);
    }
    
    public void pushOut(double speed)
    {
    	//if (speed < 0)
    		//intake.set(pick a negative number);
    	//intake.set(same number but positive);
    }
    
}

