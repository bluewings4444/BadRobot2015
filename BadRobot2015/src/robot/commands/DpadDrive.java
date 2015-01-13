package robot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import robot.OI;

public class DpadDrive extends BadCommand {

	@Override
	protected void initialize() 
	{
		requires((Subsystem) driveTrain); // This line causes the error
		
	}

	@Override
	public String getConsoleIdentity() 
	{
		return "DpadDrive";
	}

	@Override
	protected void execute() 
	{
		driveTrain.dpadDrive(OI.xboxController.getLeftStickX(), OI.xboxController.getLeftStickY(), OI.xboxController.getRightStickX());
	}

	@Override
	protected boolean isFinished() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
