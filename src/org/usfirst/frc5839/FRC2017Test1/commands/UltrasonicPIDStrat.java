package org.usfirst.frc5839.FRC2017Test1.commands;

import org.usfirst.frc5839.FRC2017Test1.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UltrasonicPIDStrat extends Command {

    public UltrasonicPIDStrat() {
    	requires(Robot.ultrasonicPIDsubsystem);
    	requires(Robot.driveBase);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ultrasonicPIDsubsystem.RunUltrasonicpid();
    	Robot.driveBase.CartesianControl(Robot.oi.joystick1.getRawAxis(3), Robot.oi.joystick1.getRawAxis(4), -Robot.ultrasonicPIDsubsystem.getPIDController().get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.ultrasonicPIDsubsystem.getPIDController().disable();
    }
}
