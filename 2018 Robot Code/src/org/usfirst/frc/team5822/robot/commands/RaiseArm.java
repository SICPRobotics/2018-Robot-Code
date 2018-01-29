package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.RobotMap;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseArm extends Command 
{
	public WPI_TalonSRX armMotor;
	double armHeight;
	static Sensors sensors;

    public RaiseArm(double height) 
    {
        requires(Robot.arm);
    	armHeight = height;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    // Important: Check that the motors are moving the right way.
    protected void execute() 
    {
    		armMotor = new WPI_TalonSRX(RobotMap.k_arm);
    		if(sensors.getPotential() < armHeight)
    		{
    			while (sensors.getPotential() != armHeight)
    			{
    				armMotor.set(.7);
    			}
    		} else if (sensors.getPotential() > armHeight)
    		{
    			while (sensors.getPotential() != armHeight)
    			{
    				armMotor.set(-.7);
    			}
    		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
