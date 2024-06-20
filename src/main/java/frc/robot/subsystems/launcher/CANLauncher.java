package frc.robot.subsystems.launcher;

import static frc.robot.Constants.CANLauncher.*;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.StrictFollower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class CANLauncher extends SubsystemBase {
    CANSparkMax m_launchWheel;
    CANSparkMax m_launchWheelFollower;
    TalonFX m_feedWheel;
    TalonFX m_feedWheelFollower;
  
    /** Creates a new Launcher. */
    public CANLauncher() {
      m_launchWheel = new CANSparkMax(kLauncherID, MotorType.kBrushless);
      m_launchWheelFollower = new CANSparkMax(kLauncherFollowerID, MotorType.kBrushless);
      
      m_launchWheel.setSmartCurrentLimit(kLauncherCurrentLimit);
      m_launchWheelFollower.setSmartCurrentLimit(kLauncherCurrentLimit);

      m_launchWheel.setInverted(Constants.CANLauncher.launchInvert);
      m_launchWheelFollower.setInverted(Constants.CANLauncher.launchFollowerInvert);


      
      m_feedWheel = new TalonFX(kFeederID);
      m_feedWheelFollower = new TalonFX(kFeederFollowerID);
      m_feedWheelFollower.setControl(new StrictFollower(kFeederID));

            

      TalonFXConfiguration feedMotorConfig = new TalonFXConfiguration();

      feedMotorConfig.CurrentLimits.SupplyCurrentLimitEnable = Constants.CANLauncher.EnableCurrentLimit;
      feedMotorConfig.CurrentLimits.SupplyCurrentLimit = Constants.CANLauncher.CurrentLimit;
      feedMotorConfig.CurrentLimits.SupplyCurrentThreshold = Constants.CANLauncher.CurrentThreshold;
      feedMotorConfig.CurrentLimits.SupplyTimeThreshold = Constants.CANLauncher.TimeThreshold;
      
      feedMotorConfig.MotorOutput.Inverted = Constants.CANLauncher.feedMotorInvert;        
      feedMotorConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;

      m_feedWheel.getConfigurator().apply(new TalonFXConfiguration());
      m_feedWheel.getConfigurator().apply(feedMotorConfig);

      feedMotorConfig.MotorOutput.Inverted = Constants.CANLauncher.feedFollowerMotorInvert;

      m_feedWheelFollower.getConfigurator().apply(new TalonFXConfiguration());
      m_feedWheel.getConfigurator().apply(feedMotorConfig);
      
    }

    @Override
    public void periodic() {
      
    }
  
    /**
     * This method is an example of the 'subsystem factory' style of command creation. A method inside
     * the subsytem is created to return an instance of a command. This works for commands that
     * operate on only that subsystem, a similar approach can be done in RobotContainer for commands
     * that need to span subsystems. The Subsystem class has helper methods, such as the startEnd
     * method used here, to create these commands.
     */
    public Command getIntakeCommand() {
      // The startEnd helper method takes a method to call when the command is initialized and one to
      // call when it ends
      return this.startEnd(
          // When the command is initialized, set the wheels to the intake speed values
          () -> {
            setFeedWheel(kIntakeFeederSpeed);
            setLaunchWheel(kIntakeLauncherSpeed);
          },
          // When the command stops, stop the wheels
          () -> {
            stop();
          });
    }
  
    // An accessor method to set the speed (technically the output percentage) of the launch wheel
    public void setLaunchWheel(double speed) {
      m_launchWheel.set(speed);
      m_launchWheelFollower.set(-speed);
    }
  
    // An accessor method to set the speed (technically the output percentage) of the feed wheel
    public void setFeedWheel(double speed) {
      m_feedWheel.set(speed);
    }
  
    // A helper method to stop both wheels. You could skip having a method like this and call the
    // individual accessors with speed = 0 instead
    public void stop() {
      m_launchWheel.set(0);
      m_feedWheel.set(0);
      m_launchWheelFollower.set(0);
    }




    public TalonFX getFeedMotor() {

      return this.m_feedWheel;
    }


    
    public TalonFX getFeedFollowerMotor() {

      return this.m_feedWheelFollower;
    }

  }
