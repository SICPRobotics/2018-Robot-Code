package org.usfirst.frc.team5822.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team5822.robot.commands.AutoMode;

import javax.swing.JOptionPane;

import org.usfirst.frc.team5822.robot.commands.*;
import org.usfirst.frc.team5822.robot.subsystems.*;

public class Robot extends TimedRobot 
{
    public static OI oi;
	
    Command m_autonomousCommand;
    SendableChooser<Command> chooseAutonomous = new SendableChooser<>();
    
    public static Drivetrain driveTrain;
    public static Sensors sensors;
    public static IntakeArm intakeArm;
    public static AntiFallMech antiFall;
	
    public static AutoMode autoMode;

    public static Joystick j = new Joystick(RobotMap.k_joystick1);
    public String fieldDataIMP;

    int position = 1;
	
    @Override
    public void robotInit() 
    {
	driveTrain = new Drivetrain();
	sensors = new Sensors();
	intakeArm = new IntakeArm();
	antiFall = new AntiFallMech();
	
	oi = new OI();
    }
    
    @Override
    public void disabledInit() {}                                 

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
	System.out.print("Set point" + driveTrain.getSetpoint());
	Robot.sensors.getGyro();
	fieldDataIMP = DriverStation.getInstance().getGameSpecificMessage(); //GETTING THE FMS DATA
		
	position = 1;
		
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
	Robot.driveTrain.disable(); //disable any PIDs that were running
	Robot.sensors.resetEncoders();
    }

    @Override
    public void teleopPeriodic() 
    {
	Scheduler.getInstance().run();
	driveTrain.cheesyDrive(j);
	System.out.println("pot: " + Robot.sensors.getPot());
    }

    @Override
    public void testPeriodic() {}
}
