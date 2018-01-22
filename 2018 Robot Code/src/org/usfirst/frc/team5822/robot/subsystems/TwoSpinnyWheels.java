package org.usfirst.frc.team5822.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TwoSpinnyWheels extends Subsystem 
{
	//VictorSP intakeLeft, intakeRight;
	//SpeedControllerGroup intake;
	public TwoSpinnyWheels()
	{
		//intakeLeft = new VictorSP(k_intakeLeft);
		//intakeRight = new VictorSP(k_intakeRight);
		//intake = new SpeedControllerGroup(intakeLeft, intakeRight);
	}

    public void initDefaultCommand() 
    {
    	
    }
    
    public void takeIn(double speed)
    {
    	//if (speed < 0)
    		//intake.set(pick a negative number);
    	//intake.set(same number but positive);
    }
    
    public void pushOut(double speed)
    {
    	//if (speed < 0)
    		//intake.set(pick a negative number);
    	//intake.set(same number but positive);
    }
    
}

