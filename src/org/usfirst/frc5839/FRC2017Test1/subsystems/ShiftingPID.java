package org.usfirst.frc5839.FRC2017Test1.subsystems;

import org.usfirst.frc5839.FRC2017Test1.Robot;
import org.usfirst.frc5839.FRC2017Test1.RobotMap;
import org.usfirst.frc5839.FRC2017Test1.VisionProcess;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class ShiftingPID extends PIDSubsystem {

	VisionProcess visionProcess;
    // Initialize your subsystem here
    public ShiftingPID() {
    	super("ShiftingPID", 0.006, 0.008, 0.00001);
        getPIDController().setAbsoluteTolerance(10);
        getPIDController().setContinuous(true);
        getPIDController().setOutputRange(-0.5, 0.5);
        getPIDController().setInputRange(-320, 320);
        LiveWindow.addActuator("ShiftingPID", "PID3", getPIDController());
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void runShiftingPID() {
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
        return /*Robot.visionProcess.getfinalheightx1()-Robot.visionProcess.getfinalheightx2()*/ 0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
