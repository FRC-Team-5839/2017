package org.usfirst.frc5839.FRC2017Test1.subsystems;

import org.usfirst.frc5839.FRC2017Test1.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class VisionGyratingPID extends PIDSubsystem {

    // Initialize your subsystem here
    public VisionGyratingPID() {
    	super("VisionGyratingPID", 0.004, 0.0009, 0);
        getPIDController().setAbsoluteTolerance(20);
        getPIDController().setContinuous(true);
        getPIDController().setOutputRange(-0.3, 0.3);
        getPIDController().setInputRange(-120 , 120 );
        LiveWindow.addActuator("VisionGyratingPID", "PID4", getPIDController());
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void runVisionGyratingPID() {
    	getPIDController().setSetpoint(0);
    	getPIDController().enable();
    	
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return/*( (Robot.visionProcess.getfinalcenterx1()+Robot.visionProcess.getcenterX2())/2 - 120)*/ 0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
