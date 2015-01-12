
package org.usfirst.frc.team1014.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1014.robot.commands.BadCommand;
import org.usfirst.frc.team1014.robot.commands.CommandBase;
import org.usfirst.frc.team1014.robot.commands.DriveRobot;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Joystick controller = new Joystick(0);

    BadCommand driveRobot;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        //driveRobot = new DriveRobot(); // This line throws an error in the DRIVER STATION
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {

        Talon frontLeft = new Talon(RobotMap.frontLeftController);
        Talon backLeft = new Talon(RobotMap.backLeftController);
        Talon frontRight = new Talon(RobotMap.frontRightController);
        Talon backRight = new Talon(RobotMap.backRightController); 
        
        //RobotDrive drive = new RobotDrive(backLeft,frontLeft,backRight,frontRight); // for mechanum drive
        //RobotDrive drive = new RobotDrive(frontLeft,backLeft,frontRight,backRight); // for tank drive
        
        while(1==1)
        {

            /*if(getLeftTrigger() > 0 || getRightTrigger() > 0)
           	{
            	frontLeft.set(deadzone(controller.getRawAxis(0))); // x left = 0
            	backRight.set(-deadzone(controller.getRawAxis(4))); // X right
            														// y right = 5
            														
            	backLeft.set(-deadzone(controller.getRawAxis(0)));
            	frontRight.set(deadzone(controller.getRawAxis(4)));
            }
            else
            {
                drive.tankDrive(deadzone(-controller.getRawAxis(1)),deadzone(controller.getRawAxis(5)));
            }
            /*
             * Left stick x raw = 0
             * and to the right full is 1 and left is -1
             * left stick y raw = 1
             * and down is 1 and up is -1	
             * 
             * shifts to side moving in
             * 
             * to go forward right, frontLeft needs forward, backLeft needs forward, backLeft needs forward, frontRight needs backwards
             */
        	 //drive.mecanumDrive_Cartesian(deadzone(controller.getRawAxis(0)), deadzone(controller.getRawAxis(0)), deadzone(controller.getRawAxis(4)), 0.0);
        	
        	if((Math.abs(controller.getRawAxis(0))+Math.abs(controller.getRawAxis(1))) > 
        		(Math.abs(controller.getRawAxis(4))+Math.abs(controller.getRawAxis(5)))) // if left stick is being used more than the right, this works 
        	{
        		if(controller.getRawAxis(1) < 0 && controller.getRawAxis(0) > 0) //top right
        		{
        			
        		}
        		if(controller.getRawAxis(1) > 0 && controller.getRawAxis(0) > 0) // Bottom Right
        		{
        			
        		}
        		if(controller.getRawAxis(1) > 0 && controller.getRawAxis(0) < 0) // Bottom left
        		{
        			
        		}
        		if(controller.getRawAxis(1) < 0 && controller.getRawAxis(0) < 0)
        		{
        			
        		}
        		/*else if(Math.abs(controller.getRawAxis(0)) < Math.abs(controller.getRawAxis(1))) // if more Y than X
        		{
        			frontLeft.set(-(deadzone(controller.getRawAxis(1))));// move forward/back
        			frontRight.set((deadzone(controller.getRawAxis(1))));
        			backLeft.set(-(deadzone(controller.getRawAxis(1))));
        			backRight.set((deadzone(controller.getRawAxis(1))));
        			so("Moving forward/back");
        		}
        		else
        		{
        			frontLeft.set(-deadzone(controller.getRawAxis(0)));  // strafe works
        			frontRight.set(-deadzone(controller.getRawAxis(0)));
        			backLeft.set(deadzone(controller.getRawAxis(0)));
        			backRight.set(deadzone(controller.getRawAxis(0)));
        			so("Strafing");
        		}*/
        	}
        	else
        	{
    			frontLeft.set(deadzone(controller.getRawAxis(4))); // rotate robot 
    			frontRight.set(deadzone(controller.getRawAxis(4)));
    			backLeft.set(deadzone(controller.getRawAxis(4)));
    			backRight.set(deadzone(controller.getRawAxis(4)));
    			so("Rotate robot clockwise");
        	}
        }

    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    public static double deadzone(double d) {
        //whenever the controller moves LESS than the magic number, the 
        //joystick is in the loose position so return zero - as if the 
        //joystick was not moved
        if (Math.abs(d) < .15) {
            return 0;
        }
        
        if (d == 0)
        {
            return 0;
        }
        //When the joystick is used for a purpose (passes the if statements, 
        //hence not just being loose), do math
        return (d / Math.abs(d)) //gets the sign of d, negative or positive
            * ((Math.abs(d) - .15) / (1 - .15)); //scales it
    }
    public static double nearOne(double d)
    {
    	if(Math.abs(d) > .9)
    		return 1;
    	else
    		return d;

    }
	public static void so(String s)
	{
		System.out.println("Robot: " + s);
	}
    
}
