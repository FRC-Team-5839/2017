package org.usfirst.frc5839.FRC2017Test1.subsystems;

import org.usfirst.frc5839.FRC2017Test1.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


public class Shoot extends Subsystem {

    private final CANTalon loadRight = RobotMap.shootLoadRight;
    private final CANTalon loadLeft = RobotMap.shootLoadLeft;
    private final CANTalon shootLeft = RobotMap.shootShootLeft;
    private final CANTalon shootRight = RobotMap.shootShootRight;

    
    public void ShootBall () {
        	shootLeft.set(-1);
        	shootRight.set(-1);
    }
    
    public void stopshoot() {
    	shootLeft.set(0);
    	shootRight.set(0);
    	loadLeft.set(0);
    	loadRight.set(0);
    }
    
    public void loadball() {
    	loadLeft.set(1);
    	loadRight.set(1);
    }
    
    public void stopload() {
    	loadLeft.set(0);
    	loadRight.set(0);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

