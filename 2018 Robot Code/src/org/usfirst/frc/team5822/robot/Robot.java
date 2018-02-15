package org.usfirst.frc.team5822.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team5822.robot.commands.AutoMode;
import org.usfirst.frc.team5822.robot.subsystems.*;

public class Robot extends TimedRobot 
{
	public static OI oi;

	public static Drivetrain driveTrain;
	public static Sensors sensors;
	public static IntakeArm intakeArm;
	public static AntiFallMech antiFall;
	public static Climber climber;
	
	public static AutoMode autoMode;	
	Command m_autonomousCommand;//hi
			
	public static Joystick j = new Joystick(RobotMap.k_joystick1);
	public String fieldDataIMP;

	public static Compressor c;

	int position = 1; //change to pull this from the dashboard in autoInit()
	
	@Override
	public void robotInit() 
	{
		driveTrain = new Drivetrain();
		sensors = new Sensors();
		intakeArm = new IntakeArm();
		antiFall = new AntiFallMech();
		oi = new OI(); 
	
		c = new Compressor(0);
		c.setClosedLoopControl(true);
	}

	@Override
	public void disabledInit() 
	{
		Scheduler.getInstance().removeAll();
	}                                 
	
	@Override
	public void disabledPeriodic() 
	{
	   	//Scheduler.getInstance().removeAll();
	}	
	
	@Override
	public void autonomousInit() 
	{
		Robot.sensors.resetGyro();
		driveTrain.setPoint(0);

		fieldDataIMP = DriverStation.getInstance().getGameSpecificMessage(); 		
		position = 1; //change this to get the value from the Smart Dash
		
		m_autonomousCommand = new AutoMode(fieldDataIMP, position);
		m_autonomousCommand.start();
	}
 
    @Override
    public void autonomousPeriodic() 
    {
	Scheduler.getInstance().run();
	System.out.println("Drivetrain encoders in subsystem: " + driveTrain.encDistance());
    }
    
    @Override
	public void teleopInit() 
	{
		if (m_autonomousCommand != null) 
		{
			m_autonomousCommand.cancel();
		}
		Robot.driveTrain.disable(); 
		Robot.sensors.resetEncoders();
	}

 
	@Override
	public void teleopPeriodic() 
	{
		Scheduler.getInstance().run();
		driveTrain.cheesyDrive(j);
		//System.out.println("pot: " + Robot.sensors.getPot());
	}

	@Override
	public void testPeriodic() {}

}
