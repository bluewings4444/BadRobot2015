package org.usfirst.frc.team1014.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * 
 * @author Steve Popovich
 */
public class OI {

	public static DriverStation driverStation;
	public static XboxController xboxController;
	
	public static void init()
	{
		try
		{
			driverStation = DriverStation.getInstance();
			xboxController = new XboxController(1);//needs a proper port
		} catch (Exception e)
		{
			so(e);
		}
	}
    /**
     * Used with the primary xbox controller
     * @return The deadzone corrected left stick x value
     */
    public static double getLeftX()
    {
        return deadzone(-xboxController.getRawAxis(1));
    }

    /**
     * Used with the primary xbox controller
     * @return The deadzone corrected left stick y value
     */
    public static double getLeftY()
    {        
        return deadzone(xboxController.getRawAxis(2));
    }

    /**
     * Used with the primary xbox controller
     * @return The deadzone corrected right stick x value
     */
    public static double getRightX()
    {
        return deadzone(-xboxController.getRawAxis(4));
    }

    /**
     * Used with the primary xbox controller
     * @return The deadzone corrected right stick y value
     */
    public static double getRightY()
    {
        return deadzone(xboxController.getRawAxis(5));
    }

    /**
     * @return The primary xbox X button value
     */
    public static boolean getXButton()
    {
        return xboxController.getRawButton(3);
    }

    /**
     * @return The primary xbox Y button value
     */
    public static boolean getYButton()
    {
        return xboxController.getRawButton(4);
    }

    /**
     * @return The primary xbox A button value
     */
    public static boolean getAButton()
    {
        return xboxController.getRawButton(1);
    }

    /**
     * @return The primary xbox B button value
     */
    public static boolean getBButton()
    {
        return xboxController.getRawButton(2);
    }

    /**
     * @return The primary xbox right bumper button value
     */
    public static boolean getRBButton()
    {
        return xboxController.getRawButton(6);
    }

    /**
     * @return The primary xbox left bumper button value
     */
    public static boolean getLBButton()
    {
        return xboxController.getRawButton(5);
    }

    /**
     * @return The primary xbox left joystick clicked in value
     */
    public static boolean getLeftJoyClick()
    {
        return xboxController.getRawButton(9);
    }

    /**
     * @return The primary xbox right joystick clicked in value
     */
    public static boolean getRightJoyClick()
    {
        return xboxController.getRawButton(10);
    }
	public static void so(Object s)
	{
		System.out.println("OI: " + s);
	}
    private static double deadzone(double d)
    {
        if (Math.abs(d) < .2)
        {
            return 0;
        } else
        {
            if (Math.abs(d) < .2)
            {
                return 0;
            }
        }

        return d / Math.abs(d) * ((Math.abs(d) - .10) / .90);
    }
}

