package org.usfirst.frc5839.FRC2017Test1.subsystems;

import org.usfirst.frc5839.FRC2017Test1.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Intake extends Subsystem {

    private final CANTalon intakeLeft = RobotMap.intakeIntakeLeft;
    private final CANTalon intakeRight = RobotMap.intakeIntakeRight;
    private final DoubleSolenoid intakeSolenoid = RobotMap.intakeIntakeSolenoid;




    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void ballintake() {
    	intakeSolenoid.set(DoubleSolenoid.Value.kForward);
    	intakeLeft.set(-1);
    	intakeRight.set(-1);
    }
    
    public void StopTaking() {
    	intakeLeft.set(0);
    	intakeRight.set(0);
    }

    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

