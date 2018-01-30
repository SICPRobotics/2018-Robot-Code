package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;

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
		intakeLeft = new VictorSP(RobotMap.k_intakeLeft);
		intakeRight = new VictorSP(RobotMap.k_intakeRight);
		intakeLeft.setInverted(true);
		intake = new SpeedControllerGroup(intakeLeft, intakeRight);
	}

    public void initDefaultCommand() 
    {
    	
    }
    //oneSide true turns both opposite
    public void takeIn(double speed, boolean oneSide)
    {
    		if (oneSide && speed != 0)
    		{
    			intakeLeft.set(speed);
    			intakeRight.set(-speed - 0.8);
    		} 
    		else 
    		{
    			intake.set(speed);
    		}
    }
    
    public void pushOut(double speed)
    {
    	//if (speed < 0)
    		//intake.set(pick a negative number);
    	//intake.set(same number but positive);
    }
    
}

