package robot.commands;

import robot.OI;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TankDrive extends BadCommand {
    
	public TankDrive()
    {
<<<<<<< HEAD:BadRobot2015/src/org/usfirst/frc/team1014/robot/commands/DriveRobot.java
        //requires((Subsystem) driveTrain); // This line causes the error
=======
        requires((Subsystem) driveTrain); // This line causes the error
>>>>>>> d6efd342df2ae6bca10e71e8a4cfd8c022d1ff84:BadRobot2015/src/robot/commands/TankDrive.java
    }

	@Override
	protected void initialize() 
	{
		driveTrain.tankDrive(0, 0);
	}

	@Override
	public String getConsoleIdentity() 
	{
		return "DriveRobot";
	}

	@Override
	protected void execute() 
	{
		driveTrain.tankDrive(OI.xboxController.getLeftStickY(), OI.xboxController.getRightStickY());
	}

	@Override
	protected boolean isFinished() 
	{
		return false;
	}

	@Override
	protected void end() 
	{
		driveTrain.tankDrive(0, 0);
	}

	@Override
	protected void interrupted() 
	{

	}
}
