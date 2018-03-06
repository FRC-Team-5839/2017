package org.usfirst.frc5839.FRC2017Test1.commands;

import org.usfirst.frc5839.FRC2017Test1.Robot;
import org.usfirst.frc5839.FRC2017Test1.RobotMap;
import org.usfirst.frc5839.FRC2017Test1.VisionProcess;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class LeftAutonomousCommand extends Command {
	
	private int count=0;
	private int count2 = 0;
	private final double gWIDTH = 190;
	private final double CENTERX = 360;
	
	public LeftAutonomousCommand() {
    	requires(Robot.driveBase);
    	requires(Robot.gyroPID);
    	requires(Robot.shiftingPID);
    	requires(Robot.visionGyratingPID);
    	requires(Robot.gear);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	count=0;
    	count2 = 0;
    	RobotMap.IMU.reset();
    	Robot.gear.UP();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (count < 100) {
			Robot.gyroPID.run(0);
			Robot.driveBase.CartesianControl(0, -0.6, Robot.gyroPID.getPIDController().get());
		}else {
			Robot.driveBase.CartesianControl(0, 0, 0);
		}
    	count++;
    }
    	
//		else{
//
//			try {
//				if ( (Math.abs(Robot.visionProcess.getcenterX1()- Robot.visionProcess.getcenterX2()) < 80)) {
//					Robot.shiftingPID.runShiftingPID();
//					Robot.visionGyratingPID.runVisionGyratingPID();
//					
//					Robot.driveBase.CartesianControl(-Robot.shiftingPID.getPIDController().get(), -0.2,0);
//
//				} else {
//					if (count2 < 100) {
//						Robot.shiftingPID.disable();
//						Robot.visionGyratingPID.disable();
//						Robot.driveBase.Stop();
//						Robot.gear.DOWN();
//					}else {
//						Robot.driveBase.CartesianControl(0, -0.2, 0);
//					}
//					count2++;
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
			
			
//			
//		}
//			
//		count++;
//    	
//    }
//    		

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
