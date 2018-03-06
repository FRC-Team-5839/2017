package org.usfirst.frc5839.FRC2017Test1;

import org.usfirst.frc5839.FRC2017Test1.commands.BallIntake;
import org.usfirst.frc5839.FRC2017Test1.commands.BallTakingStop;
import org.usfirst.frc5839.FRC2017Test1.commands.Climb;
import org.usfirst.frc5839.FRC2017Test1.commands.DriveControl;
import org.usfirst.frc5839.FRC2017Test1.commands.GearBoxDown;
import org.usfirst.frc5839.FRC2017Test1.commands.GearBoxUP;
import org.usfirst.frc5839.FRC2017Test1.commands.GyroPIDstart;
import org.usfirst.frc5839.FRC2017Test1.commands.GyroPIDstop;
import org.usfirst.frc5839.FRC2017Test1.commands.LoadBall;
import org.usfirst.frc5839.FRC2017Test1.commands.LowerClimber;
import org.usfirst.frc5839.FRC2017Test1.commands.LowerIntake;
import org.usfirst.frc5839.FRC2017Test1.commands.RiseIntaker;
import org.usfirst.frc5839.FRC2017Test1.commands.ShootBall;
import org.usfirst.frc5839.FRC2017Test1.commands.StopClimb;
import org.usfirst.frc5839.FRC2017Test1.commands.StopShoot;
import org.usfirst.frc5839.FRC2017Test1.commands.Stopload;
import org.usfirst.frc5839.FRC2017Test1.commands.UltrasonicPIDStop;
import org.usfirst.frc5839.FRC2017Test1.commands.UltrasonicPIDStrat;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    public Joystick joystick1;
    public JoystickButton joystickButton1;
    public JoystickButton joystickButton2;
    public JoystickButton joystickButton3;
    public JoystickButton joystickButton4;
    public JoystickButton joystickButton5;
    public JoystickButton joystickButton6;
    public JoystickButton joystickButton7;
    public JoystickButton joystickButton8;
    public JoystickButton joystickButton9;
    public JoystickButton joystickButton11;
    public JoystickButton joystickButton22;
    public Joystick joystick2;


    public OI() {


        joystick2 = new Joystick(1);
        
        joystickButton11 = new JoystickButton(joystick2, 11);
        joystickButton11.whileHeld(new LoadBall());
        joystickButton11.whenReleased(new Stopload());
        
        joystickButton9 = new JoystickButton(joystick2, 5);
        joystickButton9.whileHeld(new GearBoxDown());
        
        joystickButton8 = new JoystickButton(joystick2, 8);
        joystickButton8.whileHeld(new GearBoxUP());
        joystickButton7 = new JoystickButton(joystick2, 7);
        
        joystickButton6 = new JoystickButton(joystick2, 6);
        joystickButton6.whileHeld(new ShootBall());
        joystickButton6.whenReleased(new StopShoot());
        
//        joystickButton5 = new JoystickButton(joystick2, 5);
//        joystickButton5.whileHeld(new UltrasonicPIDStrat());
//        joystickButton5.whenReleased(new UltrasonicPIDStop());
        
        joystickButton4 = new JoystickButton(joystick2, 4);
        
        joystickButton3 = new JoystickButton(joystick2, 3);
        joystickButton3.whileHeld(new Climb());
        joystickButton3.whenReleased(new StopClimb());
        
        joystickButton2 = new JoystickButton(joystick2, 2);
        joystickButton2.whileHeld(new BallIntake());
        joystickButton2.whenReleased(new BallTakingStop());
        
        joystickButton1 = new JoystickButton(joystick2, 1);
        joystickButton1.whileHeld(new Climb());
        joystickButton1.whenReleased(new StopClimb());
        
//        joystickButton1.whenReleased(new StopClimb());
        joystick1 = new Joystick(0);
        
        joystickButton22 = new JoystickButton(joystick1, 2);
        joystickButton22.whileHeld(new GyroPIDstart());
        joystickButton22.whenReleased(new GyroPIDstop());
        


        // SmartDashboard Buttons
//        SmartDashboard.putData("DriveControl", new DriveControl());
//        SmartDashboard.putData("BallIntake", new BallIntake());
//        SmartDashboard.putData("RiseIntaker", new RiseIntaker());
//        SmartDashboard.putData("LowerIntake", new LowerIntake());
//        SmartDashboard.putData("ShootBall: First", new ShootBall());
//        SmartDashboard.putData("LowerClimber", new LowerClimber());
//        SmartDashboard.putData("GearBoxUP", new GearBoxUP());
//        SmartDashboard.putData("GearBoxDown", new GearBoxDown());

    }


    public Joystick getJoystick1() {
        return joystick1;
    }

    public Joystick getJoystick2() {
        return joystick2;
    }

}

