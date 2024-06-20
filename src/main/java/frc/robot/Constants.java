// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;
import com.pathplanner.lib.util.PIDConstants;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean constants. This
 * class should not be used for any other purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{

public static final class Climber {

  public static final int MotorID = 1;
  public static final boolean EnableCurrentLimit = true;
  public static final double CurrentLimit = 35.0;
  public static final double CurrentThreshold = 60.0;
  public static final double TimeThreshold = 0.1;
  public static final InvertedValue MotorInvert = InvertedValue.CounterClockwise_Positive;


  public static final double ExtendSpeed = 1;
  public static final double RetractSpeed = 1;
}

  public static final class CANLauncher {

    //Shooter motor IDs
    public static final int kLauncherID = 10;
    public static final int kFeederID = 0;
    public static final int kFeederFollowerID = 2; //TBD
    public static final int kLauncherFollowerID = 40; //TBD

    public static final boolean launchInvert = false;
    public static final boolean launchFollowerInvert = false;


    //Shooter motor current limits
    public static final int kLauncherCurrentLimit = 40;
    public static final int kFeedCurrentLimit = 40;


    public static final int MotorID = 1;
    public static final boolean EnableCurrentLimit = true;
    public static final double CurrentLimit = 35.0;
    public static final double CurrentThreshold = 60.0;
    public static final double TimeThreshold = 0.1;
    public static final InvertedValue feedMotorInvert = InvertedValue.CounterClockwise_Positive;
    public static final InvertedValue feedFollowerMotorInvert = InvertedValue.Clockwise_Positive;
  
    // Speeds for wheels when intaking and launching. Intake speeds are negative to run the wheels
    // in reverse
    public static final double kLauncherSpeed = 1;
    public static final double kLaunchFeederSpeed = 0.2;
    public static final double kIntakeLauncherSpeed = -1;
    public static final double kIntakeFeederSpeed = -0.4;
    public static double kLauncherDelay = 1.0;

  }

  public static final double ROBOT_MASS = (95) * 0.453592; // 95lbs * kg per pound
  public static final Matter CHASSIS    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), ROBOT_MASS);
  public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag

  public static final class AutonConstants
  {
    public static final PIDConstants TRANSLATION_PID = new PIDConstants(0.63, 0, 0);
    public static final PIDConstants ANGLE_PID   = new PIDConstants(0.4, 0, 0.01);
  }

  public static final class DrivebaseConstants
  {
    public static final double slowModePercent = 0.25;
    // Hold time on motor brakes when disabled
    public static final double WHEEL_LOCK_TIME = 10; // seconds
  }

  public static class OperatorConstants
  {

    // Joystick Deadband
    public static final double LEFT_X_DEADBAND  = 0.1;
    public static final double LEFT_Y_DEADBAND  = 0.1;
    public static final double RIGHT_X_DEADBAND = 0.1;
    public static final double TURN_CONSTANT    = 6;
  }
}
