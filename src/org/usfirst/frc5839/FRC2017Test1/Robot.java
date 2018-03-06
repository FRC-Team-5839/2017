package org.usfirst.frc5839.FRC2017Test1;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc5839.FRC2017Test1.commands.FrontAutoCommand;
import org.usfirst.frc5839.FRC2017Test1.commands.LeftAutonomousCommand;
import org.usfirst.frc5839.FRC2017Test1.commands.RightAutoCommand;
import org.usfirst.frc5839.FRC2017Test1.subsystems.Climb;
import org.usfirst.frc5839.FRC2017Test1.subsystems.DriveBase;
import org.usfirst.frc5839.FRC2017Test1.subsystems.Gear;
import org.usfirst.frc5839.FRC2017Test1.subsystems.Intake;
import org.usfirst.frc5839.FRC2017Test1.subsystems.ShiftingPID;
import org.usfirst.frc5839.FRC2017Test1.subsystems.Shoot;
import org.usfirst.frc5839.FRC2017Test1.subsystems.TurningPID;
import org.usfirst.frc5839.FRC2017Test1.subsystems.UltrasonicPIDsubsystem;
import org.usfirst.frc5839.FRC2017Test1.subsystems.VisionGyratingPID;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command frontauto;
    Command leftauto;
    Command rightauto;

    public static OI oi;
    public static DriveBase driveBase;
    public static Intake intake;
    public static Shoot shoot;
    public static Climb climb;
    public static Gear gear;
    public static UltrasonicPIDsubsystem ultrasonicPIDsubsystem;
    public static TurningPID gyroPID;
//    public static VisionProcess visionProcess;
    public static ShiftingPID shiftingPID;
    public static VisionGyratingPID visionGyratingPID;
	final String Front = "Front";
	final String Left = "Left";
	final String Right = "Right";
	final String None = "None";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();

        driveBase = new DriveBase();
        intake = new Intake();
        shoot = new Shoot();
        climb = new Climb();
        gear = new Gear();
        ultrasonicPIDsubsystem = new UltrasonicPIDsubsystem();
        gyroPID = new TurningPID();
//        visionProcess = new VisionProcess();
        shiftingPID = new ShiftingPID();
        visionGyratingPID = new VisionGyratingPID();
        chooser.addDefault("Front", Front);
        chooser.addObject("Left", Left);
        chooser.addObject("Right", Right);
        chooser.addObject("None", None);
        

        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period

        frontauto = new FrontAutoCommand();
        leftauto = new LeftAutonomousCommand();
        rightauto = new RightAutoCommand();
        SmartDashboard.putData("自动程序", chooser);
//        visionProcess.runVisionThread();
//        

        

    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	autoSelected = chooser.getSelected();
        // schedule the autonomous command (example)
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
		switch (autoSelected) {
		case Front:
			frontauto.start();
			break;
		case Left:
			leftauto.start();
			break;
		case Right:
			rightauto.start();
			break;
		case None:
			break;
		}

    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (frontauto != null) {
        	frontauto.cancel();
        }else if (leftauto != null) {
			leftauto.cancel();
		}else if (rightauto != null) {
			rightauto.cancel();
		}
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Gyro", RobotMap.IMU.getAngleZ());


    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
