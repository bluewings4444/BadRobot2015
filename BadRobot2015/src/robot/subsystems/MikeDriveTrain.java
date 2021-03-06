package robot.subsystems;

import robot.RobotMap;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


/*
 * @author Steve Popovich copying Isaac
 */
public class MikeDriveTrain extends BadSubsystem
{
	private static MikeDriveTrain instance;
	
	RobotDrive train;
	Talon frontLeft, backLeft, frontRight, backRight;
	Gyro gyro;
	
    public static MikeDriveTrain getInstance()
    {
        if (instance == null)
        {
            instance = new MikeDriveTrain();
        }
        return instance;
    }
	
    @Override
	protected void initialize()
    {
        frontLeft = new Talon(RobotMap.frontLeftController);
        backLeft = new Talon(RobotMap.backLeftController);
        frontRight = new Talon(RobotMap.frontRightController);
        backRight = new Talon(RobotMap.backRightController); 
    	
        gyro = new Gyro(RobotMap.gyro);
        gyro.reset();
        
    	train = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		
	}

	@Override
	public String getConsoleIdentity() 
	{
		return "MikeDriveTrain";
	}

	@Override
	protected void initDefaultCommand() 
	{
		//this.setDefaultCommand(new DriveRobot()); //??
	}
	
    public void tankDrive(double leftY, double rightY) //analogs
    {
        train.tankDrive(leftY, rightY);
    }
    public void dpadDrive(double leftX, double leftY, double rightX)
    {
    	if((Math.abs(leftX)+Math.abs(leftY)) > 
		(Math.abs(rightX)*2))// if left stick is being used more than the right, this works 
	{
		
		if(Math.abs(leftX) < Math.abs(leftY)) // if more Y than X
		{
			frontLeft.set(-(leftY));// move forward/back
			frontRight.set((leftY));
			backLeft.set(-(leftY));
			backRight.set((leftY));
		}
		else
		{
			frontLeft.set(-(leftX));  // strafe works
			frontRight.set(-(leftX));
			backLeft.set(leftX);
			backRight.set(leftX);
		}
	}
	else
	{
		frontLeft.set(rightX); // rotate robot 
		frontRight.set(rightX);
		backLeft.set(rightX);
		backRight.set(rightX);
	}
    }
    public Gyro getGyro()
    {
    	return gyro;
    }
    
}

