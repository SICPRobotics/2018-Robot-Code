package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class ArmPID extends PIDSubsystem 
{
	AnalogPotentiometer pot = new AnalogPotentiometer(RobotMap.k_pot);
	WPI_TalonSRX talon = new WPI_TalonSRX(10);
	WPI_VictorSPX victor = new WPI_VictorSPX(9);
	
    public ArmPID() 
    {
    	super("arm", 4.0,0.0,0.0);
    	victor.follow(talon);
    }

    public void initDefaultCommand() {}
    
    public double getPot()
    {
    	return pot.get();
    }

    protected double returnPIDInput() 
    {
        return pot.get();
    }

    protected void usePIDOutput(double output) 
    {
    	talon.pidWrite(output);
    }
    
    public void armMotors(double speed)
    {
    	talon.set(speed);
    }
}
