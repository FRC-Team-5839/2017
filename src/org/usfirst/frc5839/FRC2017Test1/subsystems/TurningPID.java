package org.usfirst.frc5839.FRC2017Test1.subsystems;

import org.usfirst.frc5839.FRC2017Test1.ADIS16448_IMU;
import org.usfirst.frc5839.FRC2017Test1.RobotMap;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurningPID extends PIDSubsystem {

	private final ADIS16448_IMU imu = RobotMap.IMU;
    // Initialize your subsystem here
    public TurningPID() {
        super("GyroPID", 0.006, 0.0007, 0);
        getPIDController().setAbsoluteTolerance(2);
        getPIDController().setContinuous(true);
        getPIDController().setOutputRange(-0.9, 0.9);
        getPIDController().setInputRange(-360, 360);
        LiveWindow.addActuator("GyroPID", "PID2", getPIDController());
        SmartDashboard.putNumber("Gyro", imu.getAngleZ());
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void run (double angle) {
    	
    	getPIDController().setSetpoint(angle);
    	getPIDController().enable();
    	
    }
    
    public void stop() {
    	getPIDController().disable();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return imu.getAngleZ();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
