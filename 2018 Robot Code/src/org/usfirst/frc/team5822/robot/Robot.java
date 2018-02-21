package org.usfirst.frc.team5822.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5822.robot.commands.AutoMode;
import org.usfirst.frc.team5822.robot.commands.DisableArmPID;
import org.usfirst.frc.team5822.robot.commands.MoveIntake;
import org.usfirst.frc.team5822.robot.commands.getFieldData;
import org.usfirst.frc.team5822.robot.subsystems.*;

public class Robot extends TimedRobot 
{
	public static OI oi;

	public static Drivetrain driveTrain;
	public static Sensors sensors;
	public static Intake intake;
	public static AntiFallMech antiFall;
	public static Climber climber;
	public static ArmPID arm;
	
	public static Compressor c;
	//UsbCamera cami = CameraServer.getInstance().startAutomaticCapture(0);
	
	public static Joystick j = new Joystick(RobotMap.k_joystick1);
	public static XboxController x = new XboxController(RobotMap.k_xboxCntrl);
	
	public String fieldDataIMP;
	public static boolean isOldRobot = false;
	Command m_autonomousCommand;
	
	SendableChooser<Integer> locationChooser = new SendableChooser<>();
	SendableChooser<Integer> goalChooser = new SendableChooser<>();
	
	public static int position = 1; //default center 
	public static int goal = 0; //default switch
	
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
		intake = new Intake();
		antiFall = new AntiFallMech();
		climber = new Climber();
		arm = new ArmPID();
		
		
		oi = new OI(); 
	
		if (!isOldRobot) 
		{
			c = new Compressor(0);
			c.setClosedLoopControl(true);
		}
		
		SmartDashboard.putString("Intake Position:", intake.position());
		SmartDashboard.putNumber("Gyro", sensors.getGyro()); 
		SmartDashboard.putNumber("Potentiometer", arm.getPot());
		SmartDashboard.putData("Location Selection", locationChooser);
		SmartDashboard.putData("Goal Selection", goalChooser);
	}

	@Override
	public void disabledInit() 
	{
		Command disable = new DisableArmPID();
		disable.start();
		Command stopIntake = new MoveIntake(0);
		stopIntake.start();
	}                                 
	
	@Override
	public void disabledPeriodic() 
	{
		Scheduler.getInstance().removeAll();
	}	
	
	@Override
	public void autonomousInit() 
	{
		Robot.sensors.resetGyro();
	
		//TODO: figure out how to get these values from the SD
		position = locationChooser.getSelected();
		goal = goalChooser.getSelected();
		
		m_autonomousCommand = new getFieldData();
		m_autonomousCommand.start();
	}
 
    @Override
    public void autonomousPeriodic() 
    {
    	Scheduler.getInstance().run();
		System.out.print("Position: " + position);
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
		Scheduler.getInstance().removeAll();
		Robot.driveTrain.resetEncoders();
	}

   // int count = 0;
	@Override
	public void teleopPeriodic() 
	{
		Scheduler.getInstance().run();
		driveTrain.cheesyDrive(j);
		SmartDashboard.putNumber("Gyro", sensors.getGyro());
		SmartDashboard.putNumber("Potentiometer", arm.getPot());
//		if (count++ % 50 == 0) 
//		{
//			System.out.println("Potentiometer: " + arm.getPot());
//		}
	}

	@Override
	public void testPeriodic() {}

}
