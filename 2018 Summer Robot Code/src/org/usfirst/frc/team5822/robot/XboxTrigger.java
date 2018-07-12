package org.usfirst.frc.team5822.robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

public class XboxTrigger extends Trigger 
{
	boolean isLeftTrigger;
	
	public XboxTrigger(boolean leftSide)
	{
		isLeftTrigger = leftSide;
	}
    public boolean get() 
    {
    	if (isLeftTrigger && Robot.x.getRawAxis(2) > 0)
			return true;
		if(!isLeftTrigger && Robot.x.getRawAxis(3) > 0)
			return true;
		return false;
    }
}
