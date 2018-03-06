

package org.usfirst.frc5839.FRC2017Test1;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import com.ctre.CANTalon;

import edu.wpi.cscore.AxisCamera;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
//import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    public static CANTalon driveBaseFrontRight;
    public static CANTalon driveBaseFrontLeft;
    public static CANTalon driveBaseRearRight;
    public static CANTalon driveBaseRearLeft;
    public static RobotDrive driveBaseRobotDrive41;
    public static CANTalon intakeIntakeLeft;
    public static CANTalon intakeIntakeRight;
    public static DoubleSolenoid intakeIntakeSolenoid;
    public static CANTalon shootLoadRight;
    public static CANTalon shootLoadLeft;
    public static CANTalon shootShootLeft;
    public static CANTalon shootShootRight;
    public static CANTalon climbClimb;
    public static DoubleSolenoid climbClimbSolenoid;
    public static CANTalon gearGear;
    public static AnalogInput LeftUltrasonic;
    public static AnalogInput RightUltrasonic;
    public static PIDController ultrasonicpidController;
    public static ADIS16448_IMU IMU;
    public static AxisCamera axisCamera;
//    public static USBCamera usbCamera;


    public static void init() {

        driveBaseFrontRight = new CANTalon(3);
        LiveWindow.addActuator("DriveBase", "FrontRight", driveBaseFrontRight);
        
        driveBaseFrontLeft = new CANTalon(9);
        LiveWindow.addActuator("DriveBase", "FrontLeft", driveBaseFrontLeft);
        
        driveBaseRearRight = new CANTalon(7);
        LiveWindow.addActuator("DriveBase", "RearRight", driveBaseRearRight);
        
        driveBaseRearLeft = new CANTalon(10);
        LiveWindow.addActuator("DriveBase", "RearLeft", driveBaseRearLeft);
        
        driveBaseRobotDrive41 = new RobotDrive(driveBaseFrontLeft, driveBaseRearLeft,
              driveBaseFrontRight, driveBaseRearRight);
        
        driveBaseRobotDrive41.setSafetyEnabled(true);
        driveBaseRobotDrive41.setExpiration(0.1);
        driveBaseRobotDrive41.setSensitivity(0.5);
        driveBaseRobotDrive41.setMaxOutput(1.0);
        driveBaseRobotDrive41.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        driveBaseRobotDrive41.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        intakeIntakeLeft = new CANTalon(6);
        LiveWindow.addActuator("Intake", "IntakeLeft", intakeIntakeLeft);
        
        intakeIntakeRight = new CANTalon(11);
        LiveWindow.addActuator("Intake", "IntakeRight", intakeIntakeRight);
        
        intakeIntakeSolenoid = new DoubleSolenoid(20, 7, 5);
        LiveWindow.addActuator("Intake", "IntakeSolenoid", intakeIntakeSolenoid);
        
        shootLoadRight = new CANTalon(4);
        LiveWindow.addActuator("Shoot", "LoadRight", shootLoadRight);
        
        shootLoadLeft = new CANTalon(1);
        LiveWindow.addActuator("Shoot", "LoadLeft", shootLoadLeft);
        
        shootShootLeft = new CANTalon(8);
        LiveWindow.addActuator("Shoot", "ShootLeft", shootShootLeft);
        
        shootShootRight = new CANTalon(5);
        LiveWindow.addActuator("Shoot", "ShootRight", shootShootRight);
        
        climbClimb = new CANTalon(2);
        LiveWindow.addActuator("Climb", "Climb", climbClimb);
        
        climbClimbSolenoid = new DoubleSolenoid(20, 6, 4);
        LiveWindow.addActuator("Climb", "ClimbSolenoid", climbClimbSolenoid);
        
        gearGear = new CANTalon(12);
        LiveWindow.addActuator("Gear", "Gear", gearGear);
        
        LeftUltrasonic = new AnalogInput(0);
        LiveWindow.addSensor("UltrasonicPID", "LeftUltrasonic", LeftUltrasonic);
       
        
        RightUltrasonic = new AnalogInput(1);
        LiveWindow.addSensor("UltrasonicPID", "RightUltrasonic", RightUltrasonic);
        SmartDashboard.putNumber("rightUltra", RightUltrasonic.getValue());
        
        try {
        	IMU = new ADIS16448_IMU();
		} catch (Exception e) {
			DriverStation.reportError(e.toString(), true);
		}
        LiveWindow.addSensor("IMU", "IMU", IMU);
        
//        try {
//        	axisCamera = new AxisCamera("camaxi", "10.58.39.20");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
        
//        try {
//			CameraServer.getInstance().startAutomaticCapture().setResolution(640, 480);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//      
		new Thread(() -> {
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setResolution(640, 480);
			camera.setFPS(30);

			CvSink cvSink = CameraServer.getInstance().getVideo();
			CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640,
			480);
			Mat source = new Mat();
			Mat output = new Mat();
			while(true) {
			cvSink.grabFrame(source);
			Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
			outputStream.putFrame(output);
			}
			}).start();
//        
       
    }
}
