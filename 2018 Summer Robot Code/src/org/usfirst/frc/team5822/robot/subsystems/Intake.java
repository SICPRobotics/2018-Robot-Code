package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;
import org.usfirst.frc.team5822.robot.commands.OpenClose;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem 
{
	VictorSP intakeRight, intakeLeft;
	DoubleSolenoid hanSolo, openShut;

	public Intake()
	{
		intakeRight = new VictorSP(RobotMap.k_intakeRight);
		intakeLeft = new VictorSP(RobotMap.k_intakeLeft);
		intakeLeft.setInverted(true);	
		
		hanSolo = new DoubleSolenoid(RobotMap.k_intakeSolo1,RobotMap.k_intakeSolo2);
		hanSolo.set(DoubleSolenoid.Value.kReverse);
		
		openShut = new DoubleSolenoid(RobotMap.k_intakeOpenSolo1,RobotMap.k_intakeOpenSolo2);
		openShut.set(DoubleSolenoid.Value.kReverse);
	}
	
    public void initDefaultCommand() {}
    
    public void intakeMotors(double speed)
    {	
    	//System.out.println("IntakeArm intakeMotors: " + speed);
    	intakeRight.set(speed);
    	intakeLeft.set(speed);
    }
    
    public void forward()
    {
    	System.out.println("IntakeArm forward");
    	hanSolo.set(DoubleSolenoid.Value.kForward);
    }
    
    public void reverse()
    {
    	System.out.println("IntakeArm reverse");
    	hanSolo.set(DoubleSolenoid.Value.kReverse);
    }
    public static boolean position()
    {
    	return OpenClose.direction;
    }
    public void open()
    {
    	System.out.println("IntakeArm open");
    	openShut.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shut()
    {
    	System.out.println("IntakeArm shut");
    	openShut.set(DoubleSolenoid.Value.kReverse);
    }
}

