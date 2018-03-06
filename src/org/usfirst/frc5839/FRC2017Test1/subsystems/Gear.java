// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5839.FRC2017Test1.subsystems;

import org.usfirst.frc5839.FRC2017Test1.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Gear extends Subsystem {

    private final CANTalon gear = RobotMap.gearGear;
    
    public void UP() {
    	if (gear.isRevLimitSwitchClosed()) {
    		gear.set(0);
		}else {
			gear.set(-0.8);
		}
    }
    
    public void DOWN() {
    	RobotMap.intakeIntakeSolenoid.set(DoubleSolenoid.Value.kReverse);
    	
    	if (gear.isFwdLimitSwitchClosed()) {
    		gear.set(0);
		}else {
			gear.set(0.8);
		}
    	
    }
    
    public void stop() {
    	gear.set(0);
    }

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

