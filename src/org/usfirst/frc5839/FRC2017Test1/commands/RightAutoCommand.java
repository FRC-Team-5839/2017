package org.usfirst.frc5839.FRC2017Test1.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc5839.FRC2017Test1.Robot;
import org.usfirst.frc5839.FRC2017Test1.RobotMap;


public class RightAutoCommand extends Command {

	public NetworkTable myTable;
	private final double gWIDTH = 230;
	private final double CENTERX = 360;
	private int count = 0;
	private int count2 = 0;
	public RightAutoCommand() {

        requires(Robot.driveBase);
        requires(Robot.gyroPID);
        requires(Robot.gear);

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
    	
//    	if (count < 100) {
//    		Robot.gyroPID.run(35);
//			Robot.driveBase.CartesianControl(0, 0, Robot.gyroPID.getPIDController().get());
//			Robot.driveBase.CartesianControl(-0.4, 0, Robot.gyroPID.getPIDController().get());
//			
//		}else if (count<240){
//			Robot.driveBase.CartesianControl(0, -0.3, Robot.gyroPID.getPIDController().get());
//		}else if (count< 350) {
//			Robot.gyroPID.disable();
//			Robot.gyroPID.run(-38);
//			Robot.driveBase.CartesianControl(0, 0, Robot.gyroPID.getPIDController().get());
//			
//		}else{
//
//			try {
//				if ( (Math.abs(Robot.visionProcess.getcenterX1()- Robot.visionProcess.getcenterX2()) < gWIDTH)) {
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
			
			
			
		}
			
//		count++;
//		}
			
			 // stop robot
    

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

