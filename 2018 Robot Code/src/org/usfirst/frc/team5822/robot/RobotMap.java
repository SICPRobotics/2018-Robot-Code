package org.usfirst.frc.team5822.robot;

public class RobotMap 
{
    //motors
    public static int k_rearLeft = 1;
    public static int k_frontLeft = 4;
    public static int k_rearRight = 3;
    public static int k_frontRight = 2;
    
    public static int k_intakeLeft = 5;
	public static int k_intakeRight = 6;
	
	public static int k_armLeft = 10;
	public static int k_armRight = 9;
	
	public static int k_climbLeft = 7;
	public static int k_climbRight = 8;
	
	//public static int k_servo1 = 0;
	//public static int k_servo2 = 1;
	
	//solenoids
	public static int k_intakeSolo1 = 0;
	public static int k_intakeSolo2 = 1;
	public static int k_intakeOpenSolo1 = 2; 
	public static int k_intakeOpenSolo2 = 3;
	public static int k_antiFallSolo1 = 4;
	public static int k_antiFallSolo2 = 5;
	public static int k_climberSolo1 = 6;
	public static int k_climberSolo2 = 7;
	
    //sensors
	public static int k_leftEncoder_A = 0;
	public static int k_leftEncoder_B = 1;
	public static int k_rightEncoder_A = 2;
	public static int k_rightEncoder_B = 3;
    public static int k_gyro = 2;
    public static int k_pot = 0;
	public static int k_usbCam1 = 0;

    //joysticks
    public static int k_joystick1 = 0;
    public static int k_xboxCntrl = 1;
	
//    public static double k_switch = 0;
//    public static double k_scale = 1;
	
	//Arm height
	public static double k_potClimb;
	public static double k_potScale = 1600;
	public static double k_potSwitch = 700;
	public static double k_potFloor = 200; //340
	public static double k_potExchange = 360;
	public static double  aTop = 750; 
	public static double  bTop = 1330; 
	public static double  cTop = 1550;
	public static double  dTop = 1700;
	public static double  speedUpA = 0.4; 
	public static double  speedUpB = 0.5;
	public static double  speedUpC = 0.25;
	public static double  speedUpD = 0.15;
	public static double  speedDownA = -0.1; 
	public static double  speedDownB = -0.1;
	public static double  speedDownC = -0.1;
	public static double  speedDownD = -0.1;
}
