package org.usfirst.frc5839.FRC2017Test1.commands;

import org.usfirst.frc5839.FRC2017Test1.Robot;
import org.usfirst.frc5839.FRC2017Test1.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroPIDstart extends Command {

    public GyroPIDstart() {
    	requires(Robot.driveBase);
    	requires(Robot.gyroPID);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.IMU.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gyroPID.run(0);
    	Robot.driveBase.CartesianControl(-Robot.oi.joystick1.getRawAxis(3), -Robot.oi.joystick1.getRawAxis(4), Robot.gyroPID.getPIDController().get());
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
    }
}
