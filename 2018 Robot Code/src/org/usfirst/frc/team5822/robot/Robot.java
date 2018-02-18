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
import org.usfirst.frc.team5822.robot.subsystems.*;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Robot extends TimedRobot 
{
	public static OI oi;

	public static Drivetrain driveTrain;
	public static Sensors sensors;
	public static Intake intake;
	public static AntiFallMech antiFall;
	public static Climber climber;
	public static ArmPID arm;
	
	public static boolean isOldRobot = false;
	
	public static AutoMode autoMode;	
	Command m_autonomousCommand;
			
	public static Joystick j = new Joystick(RobotMap.k_joystick1);
	public static XboxController x = new XboxController(RobotMap.k_xboxCntrl);
	public String fieldDataIMP;
//TODO: comment back in
//	public static Compressor c;

	//UsbCamera cami = CameraServer.getInstance().startAutomaticCapture(0);
	
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
		intake = new Intake();
		antiFall = new AntiFallMech();
		climber = new Climber();
		arm = new ArmPID();
		//TODO: disable arm pids every time we disbale bot
		oi = new OI(); 
	
		if (!isOldRobot) {
//TODO: comment back in
			//			c = new Compressor(0);
//			c.setClosedLoopControl(true);
		}
		
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
	public void disabledPeriodic() {}	
	
	@Override
	public void autonomousInit() 
	{
		Robot.sensors.resetGyro();
		Drivetrain.setPoint(0);
		
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

    int count = 0;
	@Override
	public void teleopPeriodic() 
	{
		Scheduler.getInstance().run();
		driveTrain.cheesyDrive(j);
		//System.out.println("pot: " + Robot.sensors.getPot());
		SmartDashboard.putNumber("Gyro", sensors.getGyro());
		SmartDashboard.putNumber("Potentiometer", sensors.getPot());
		if (count++ % 50 == 0) {
			System.out.println("Potentiometer: " + sensors.getPot());
		}
		
		intake.manualCntrl(x.getRawAxis(5) * -1);
	}

	@Override
	public void testPeriodic() {}

}
