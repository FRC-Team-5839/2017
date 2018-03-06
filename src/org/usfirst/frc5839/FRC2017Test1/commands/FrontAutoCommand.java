package org.usfirst.frc5839.FRC2017Test1.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5839.FRC2017Test1.Robot;
import org.usfirst.frc5839.FRC2017Test1.RobotMap;


public class FrontAutoCommand extends Command {

	public NetworkTable myTable;
	private final double gWIDTH = 230;
	private final double CENTERX = 360;
	private int count = 0;
	
	public FrontAutoCommand() {

        requires(Robot.driveBase);
        requires(Robot.gear);
        requires(Robot.shiftingPID);
        requires(Robot.gyroPID);
        requires(Robot.visionGyratingPID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	count=0;
    	RobotMap.IMU.reset();
    }

    // Called repeatedly when this Command is scheduled to run                                   
    protected void execute() {

		
		// Drive for 2 seconds
//		if ( (Math.abs(Robot.visionProcess.getcenterX1() - Robot.visionProcess.getcenterX2()) < 60 || Robot.visionProcess.getheightX1() < 60)&& count==0) {
//			Robot.shiftingPID.runShiftingPID();
//			Robot.visionGyratingPID.runVisionGyratingPID();
    	Robot.gyroPID.run(0);
    	if (count <123) {
    		Robot.gear.DOWN();
			Robot.driveBase.CartesianControl(0, -0.3, Robot.gyroPID.getPIDController().get());
		}else if (count<131) {
			Robot.driveBase.CartesianControl(0, 0.2, Robot.gyroPID.getPIDController().get());
		}else if (count<370) {
			Robot.driveBase.Stop();
		}else if(count<390) {
			Robot.driveBase.CartesianControl(0, 0.1, Robot.gyroPID.getPIDController().get());
		}else if (count<430) {
			Robot.driveBase.Stop();
//		}else if (count < 480) {
//			Robot.driveBase.CartesianControl(0, 0.4 , Robot.gyroPID.getPIDController().get());	
//		}else if (count < 580) {
//			Robot.driveBase.CartesianControl(-0.8, 0 , Robot.gyroPID.getPIDController().get());
//		}else if (count < 775) {
//			Robot.driveBase.CartesianControl(0, -0.4 , Robot.gyroPID.getPIDController().get());
//		}
		}else {
		
			Robot.driveBase.Stop();
		}
		count++;
			
			

//		} else{
//			if (count==1) {
//				Robot.driveBase.CartesianControl(0, -0.3, 0);
//			}else {
//				Robot.shiftingPID.disable();;
//				Robot.visionGyratingPID.disable();;
//				Robot.driveBase.Stop();
//				Robot.gear.DOWN();
//				Timer.delay(2);
//				count=1;
//
//			}
//		}
    }
			
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
