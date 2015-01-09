package org.usfirst.frc.team1014.robot.subsystems;

import org.usfirst.frc.team1014.robot.RobotMap;
import org.usfirst.frc.team1014.robot.subsystems.interfaces.IDriveTrain;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


/*
 * @author Steve Popovich copying Isaac
 */
public class PrototypeDriveTrain extends BadSubsystem
{
	private static PrototypeDriveTrain instance;
	
	RobotDrive train;
	SpeedController frontLeft, backLeft, frontRight, backRight;
	
    public static PrototypeDriveTrain getInstance()
    {
        if (instance == null)
        {
            instance = new PrototypeDriveTrain();
        }
        return instance;
    }
	
    @Override
	protected void initialize()
    {
        /*frontLeft = new Talon(RobotMap.frontLeftController);
        backLeft = new Talon(RobotMap.backLeftController);
        frontRight = new Talon(RobotMap.frontRightController);
        backRight = new Talon(RobotMap.backRightController);*/ // get it right on the Roborio
    	
    	train = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		
	}

	@Override
	public String getConsoleIdentity() 
	{
		return "PrototypeDriveTrain";
	}

	@Override
	protected void initDefaultCommand() 
	{
		//this.setDefaultCommand(new DriveRobot()); //??
	}
	
    public void tankDrive(double left, double right) 
    {
        train.tankDrive(left, right);
    }

    
}

