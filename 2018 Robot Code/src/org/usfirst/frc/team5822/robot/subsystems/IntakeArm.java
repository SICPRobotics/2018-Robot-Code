package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeArm extends Subsystem 
{
	VictorSP intakeRight, intakeLeft, armRight, armLeft;
	
	DoubleSolenoid hanSolo;

	public IntakeArm()
	{
		//intakeRight = new VictorSP(RobotMap.k_intakeRight);
		intakeLeft = new VictorSP(RobotMap.k_intakeLeft);
		intakeLeft.setInverted(true);
		armRight.setInverted(true);
		/*hanSolo = new DoubleSolenoid(0,1);
		hanSolo.set(DoubleSolenoid.Value.kReverse);*/
		
		armLeft = new VictorSP(RobotMap.k_armLeft);
		//armRight = new VictorSP(RobotMap.k_armRight);
	}

    public void initDefaultCommand() 
    {
    }
    public void armMotors(boolean reverse, double speed)
    {
    	if (!reverse)
    	{
    		armLeft.set(speed);
    		//armRight.set(speed);
    	}
    	else
    	{
    		armLeft.set(-speed);
       		//armRight.set(-speed);
    	}
    }
    public void intakeMotors(double speed, boolean oneSide)
    {
    	if (!oneSide)
    	{
    		intakeRight.set(speed);
    		intakeLeft.set(speed);
    	} 
    	else if (oneSide)
    	{
    		intakeLeft.set(speed);
    		intakeRight.set(-speed - 0.8);
    	}
    }
    
    public void forward()
    {
    	hanSolo.set(DoubleSolenoid.Value.kForward);
    }
    
    public void reverse()
    {
    	hanSolo.set(DoubleSolenoid.Value.kReverse);
    }

    public void off()
    {
		hanSolo.set(DoubleSolenoid.Value.kOff);
    }
}

