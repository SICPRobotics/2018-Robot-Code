package org.usfirst.frc.team5822.robot;

public class RobotMap 
{
    //motors
    public static int k_rearLeft = 1;
    public static int k_frontLeft = 4;
    public static int k_rearRight = 2;
    public static int k_frontRight = 3;
    
    public static int k_intakeLeft = 5;
	public static int k_intakeRight = 6;
	
	public static int k_armLeft = 10;
	public static int k_armRight = 9;
	
	public static int k_climbLeft = 7;
	public static int k_climbRight = 8;
	
	public static int k_feet = 11;
	
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
	
    public static final int k_leftSide = 0;
    public static final int k_centerSide = 1;
    public static final int k_rightSide = 2;
    
	//arm heights
	public static double k_potScale = .52;
	public static double k_potSwitch = .24; //.2213
	public static double k_potFloor = .15; 
	public static double k_potExchange = .15;
	public static double aTop = .258; 
	public static double bTop = .33; 
	public static double cTop = .43; //.467
	public static double dTop = .48;
	
	//arm speeds
	public static double speedA = .8; 
	public static double speedB = .5;
	public static double speedC = .4;
	public static double speedD = .15;
}
