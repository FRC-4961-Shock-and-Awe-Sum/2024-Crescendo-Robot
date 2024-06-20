package frc.robot.commands.swervedrive.drivebase;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;

public class AbsoluteDriveSlow extends Command {

    private final SwerveSubsystem swerve;

    private final DoubleSupplier translationX, translationY, headingX, headingY;


    public AbsoluteDriveSlow(SwerveSubsystem swerve, DoubleSupplier translationX, DoubleSupplier translationY, DoubleSupplier headingX, DoubleSupplier headingY) {
        this.swerve = swerve;
        this.translationX = translationX;
        this.translationY = translationY;
        this.headingX = headingX;
        this.headingY = headingY;

        addRequirements(swerve);
    }

  @Override
  public void initialize()
  {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()
  {

    double xInput = Math.pow(translationX.getAsDouble(), 3); // Smooth controll out
    double yInput = Math.pow(translationY.getAsDouble(), 3); // Smooth controll out
    // Make the robot move
      swerve.driveFieldOriented(swerve.getTargetSpeeds(xInput, yInput,
                                                headingX.getAsDouble(),
                                                headingY.getAsDouble(), true));

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return false;
  }

}
