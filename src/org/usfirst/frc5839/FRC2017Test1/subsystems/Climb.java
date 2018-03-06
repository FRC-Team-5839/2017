package org.usfirst.frc5839.FRC2017Test1.subsystems;

import org.usfirst.frc5839.FRC2017Test1.Robot;
import org.usfirst.frc5839.FRC2017Test1.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Climb extends Subsystem {

    private final CANTalon climb = RobotMap.climbClimb;
    private final DoubleSolenoid climbSolenoid = RobotMap.climbClimbSolenoid;



    // Put methods for controlling this subsystem
    
    
    public void climb () {
    	climbSolenoid.set(DoubleSolenoid.Value.kReverse);
    	climb.set(-1);
    	
    }
    
    public void stopclimb () {
    	climb.set(0);
    }
    // here. Call these from Commands.

    public void initDefaultCommand() {

    }
}

