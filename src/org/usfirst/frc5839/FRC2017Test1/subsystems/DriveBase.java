package org.usfirst.frc5839.FRC2017Test1.subsystems;

import org.usfirst.frc5839.FRC2017Test1.RobotMap;
import org.usfirst.frc5839.FRC2017Test1.commands.*;
import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveBase extends Subsystem {

//    private final CANTalon frontRight = RobotMap.driveBaseFrontRight;
//    private final CANTalon frontLeft = RobotMap.driveBaseFrontLeft;
//    private final CANTalon rearRight = RobotMap.driveBaseRearRight;
//    private final CANTalon rearLeft = RobotMap.driveBaseRearLeft;
    private final RobotDrive robotDrive41 = RobotMap.driveBaseRobotDrive41;



    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void CartesianControl(double x, double y, double z) {
    	robotDrive41.mecanumDrive_Cartesian(x, y, z, 0);
    }
    
    public void Stop() {
    	robotDrive41.stopMotor();
    }

    public void initDefaultCommand() {

        setDefaultCommand(new DriveControl());

    }
}

