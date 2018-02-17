package org.usfirst.frc.team5822.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
	public static boolean isOldRobot = true;
	
	public static AutoMode autoMode;	
	Command m_autonomousCommand;
			
	public static Joystick j = new Joystick(RobotMap.k_joystick1);
	public String fieldDataIMP;

	public static Compressor c;

	UsbCamera cami = CameraServer.getInstance().startAutomaticCapture(0);
	
	SendableChooser<Integer> locationChooser = new SendableChooser<>();
	SendableChooser<Integer> goalChooser = new SendableChooser<>();
	
	int position = 1; //default center 
	int goal = 0; //default switch
	
	@Override
	public void robotInit() 
	{
		locationChooser.addDefault("Left", 0);
		locationChooser.addObject("Center", 1);
		locationChooser.addObject("Right", 2);
	
		goalChooser.addDefault("Switch", 0);
		goalChooser.addObject("Scale", 1);
		
		driveTrain = new Drivetrain();
		sensors = new Sensors();
		intakeArm = new IntakeArm();
		antiFall = new AntiFallMech();
		oi = new OI(); 
	
		c = new Compressor(0);
		c.setClosedLoopControl(true);
		
		SmartDashboard.putNumber("Gyro", sensors.getGyro()); 
		SmartDashboard.putNumber("Potentiometer", sensors.getPot());
		SmartDashboard.putData("Location Selection", locationChooser);
		SmartDashboard.putData("Goal Selection", goalChooser);
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
		position = locationChooser.getSelected();
		goal = goalChooser.getSelected();
		m_autonomousCommand = new AutoMode(fieldDataIMP, position, goal);
		m_autonomousCommand.start();
	}
 
    @Override
    public void autonomousPeriodic() 
    {
    	Scheduler.getInstance().run();
		System.out.println("Drivetrain encoders in subsystem: " + driveTrain.encDistance());
		
		SmartDashboard.putNumber("Gyro", sensors.getGyro()); 
		SmartDashboard.putData("Location Selection", locationChooser);
		SmartDashboard.putData("Goal Chooser", goalChooser);
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
		SmartDashboard.putNumber("Gyro", sensors.getGyro());
	}

	@Override
	public void testPeriodic() {}

}
