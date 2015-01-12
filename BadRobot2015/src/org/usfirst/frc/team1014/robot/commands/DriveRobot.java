package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.OI;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveRobot extends BadCommand {
    
	public DriveRobot()
    {
        //requires((Subsystem) driveTrain); // This line causes the error
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
