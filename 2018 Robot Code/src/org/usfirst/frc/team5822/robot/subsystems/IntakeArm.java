package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeArm extends Subsystem 
{
	VictorSP intakeRight, intakeLeft;
	VictorSPX armRight;
	TalonSRX armLeft;
	DoubleSolenoid hanSolo, openShut;
	SpeedControllerGroup arm;
	
	public IntakeArm()
	{
		if (Robot.isOldRobot) return;
		intakeRight = new VictorSP(RobotMap.k_intakeRight);
		intakeLeft = new VictorSP(RobotMap.k_intakeLeft);
		intakeLeft.setInverted(true);	
		
		armLeft = new TalonSRX(RobotMap.k_armLeft);
		armRight = new VictorSPX(RobotMap.k_armRight);
		armRight.follow(armLeft);
		
		armLeft.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0);
		armLeft.config_kP(0,2,0);
		armLeft.config_kI(0, 0, 0);
		armLeft.config_kD(0, 0, 0);
		armLeft.config_kF(0,0,0);

		//arm = new SpeedControllerGroup(armLeft, armRight);
		
//		hanSolo = new DoubleSolenoid(RobotMap.k_intakeSolo1,RobotMap.k_intakeSolo2);
//		hanSolo.set(DoubleSolenoid.Value.kReverse);
//		
//		openShut = new DoubleSolenoid(RobotMap.k_intakeOpenSolo1,RobotMap.k_intakeOpenSolo2);
//
//		openShut.set(DoubleSolenoid.Value.kReverse);
	}
	
    public void initDefaultCommand() {}
    
    public void armMotors(double pos)
    {
    	double position = (pos + 180.0) / 3600.0;
    	
    	System.out.println("IntakeArm armMotors: position " + position + " pos " + pos);
    	if (Robot.isOldRobot) return;
    		//armLeft.set(ControlMode.PercentOutput, speed);
    	armLeft.set(ControlMode.Position, position);
    }
    
    public void intakeMotors(double speed)
    {	
    	System.out.println("IntakeArm intakeMotors: " + speed);
    	if (Robot.isOldRobot) return;
    	intakeRight.set(speed);
    	intakeLeft.set(speed);
    }
    
    public void forward()
    {
    	System.out.println("IntakeArm forward");
    	if (Robot.isOldRobot) return;
//    	hanSolo.set(DoubleSolenoid.Value.kForward);
    }
    
    public void reverse()
    {
    	System.out.println("IntakeArm reverse");
    	if (Robot.isOldRobot) return;
//    	hanSolo.set(DoubleSolenoid.Value.kReverse);
    }

    public void open()
    {
    	System.out.println("IntakeArm open");
    	if (Robot.isOldRobot) return;
//    	openShut.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shut()
    {
    	System.out.println("IntakeArm shut");
    	if (Robot.isOldRobot) return;
//    	openShut.set(DoubleSolenoid.Value.kReverse);
    }
}

