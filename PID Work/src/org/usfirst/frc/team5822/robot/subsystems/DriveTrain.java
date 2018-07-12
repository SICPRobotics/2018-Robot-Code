package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveTrain extends PIDSubsystem 
{
	TalonSRX frontL, frontR, rearL, rearR;
	ADXRS450_Gyro gyro;
	
    public DriveTrain() 
    {
    	super("driveTrain", .1, 0.01,.1); //.1, .01, .1
    	setAbsoluteTolerance(.001);    	

    	rearL = new TalonSRX(RobotMap.k_rearLeft);
    	rearL.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    	rearL.setInverted(true);
    	frontL = new TalonSRX(RobotMap.k_frontLeft);
    	frontL.follow(rearL);
    	frontL.setInverted(true);
    	
    	rearR = new TalonSRX(RobotMap.k_rearRight);
    	rearR.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    	frontR = new TalonSRX(RobotMap.k_frontRight);
    	frontR.follow(rearR);
    	
    	gyro = new ADXRS450_Gyro();
    	gyro.reset();
    	// Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {}
    
    protected double returnPIDInput() 
    {
       return gyro.getAngle();
    }

    protected void usePIDOutput(double output) 
    {
        rearL.set(ControlMode.PercentOutput, -.5 - output);
        rearR.set(ControlMode.PercentOutput, -.5 + output);
    }
    
    public String resetGyro()
    {
    	gyro.reset();
    	return "gyro reset";
    }
    
    public String gyroAngle()
    {
    	return "gyro at " + gyro.getAngle();
    }
    
    public String motorSpeeds()
    {
    	return "left: " + rearL.getMotorOutputPercent() + " right: " + rearR.getMotorOutputPercent();
    }
}
