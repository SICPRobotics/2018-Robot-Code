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
	public static int k_feet = 8;
	
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

    //joysticks
    public static int k_joystick1 = 0;
    public static int k_joystick2 = 2;
    public static int k_xboxCntrl = 1;
	
    public static final int k_leftSide = 0;
    public static final int k_centerSide = 1;
    public static final int k_rightSide = 2;
    
	//arm heights
	public static double k_potScale = .52;
	public static double k_potSwitch = .27; //.2213
	public static double k_potFloor = .15; 
	public static double k_potTravel = .2; //TODO: tune this number 
	//public static double k_potExchange = .15;
	public static double aTop = .19714; //.258 
	public static double bTop = .24443; //.33
	public static double cTop = .29143; //.43
	public static double dTop = .33857; //.48
	public static double eTop = .38571;
	public static double fTop = .414285;
	public static double gTop = .455; //.44286
	public static double hTop = .46;
	public static double iTop = .5;
	
	//arm speeds
	public static double speedA = .8; //.8 
	public static double speedB = .7; //.5
	public static double speedC = .6; //.4
	public static double speedD = .5; //.15
	public static double speedE = .55; //.45 -> .5
	public static double speedF = .53;
	public static double speedG = .3; //.3
	public static double speedH = .23;
	public static double speedI = .15;
	
}
