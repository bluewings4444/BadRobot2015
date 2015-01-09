package org.usfirst.frc.team1014.robot.commands;

import org.usfirst.frc.team1014.robot.OI;
import org.usfirst.frc.team1014.robot.commands.CommandBase;
import org.usfirst.frc.team1014.robot.subsystems.interfaces.Logger;

/**
 *
 * @author Isaac
 * */
public abstract class BadCommand extends CommandBase implements Logger 
{
    protected static final boolean CONSOLE_OUTPUT_ENABLED = true;
    
    protected BadCommand()
    {
	        
    }
	    
    /**
     * Subclasses should implement their own implementations on initialize. This
     * method is meant to instantiate any hardware or variables that will be 
     * needed. This is specific to each class and can be left blank.
     */
    protected abstract void initialize();
        
    public void log(String str) 
    {
        if (CONSOLE_OUTPUT_ENABLED) 
        {
            System.out.println(getConsoleIdentity()+": "+str);
        }
    }
    
    public abstract String getConsoleIdentity();
    
}

