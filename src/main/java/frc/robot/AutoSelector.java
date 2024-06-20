package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoSelector {
    
    private final SendableChooser<String> chooser;

    AutoSelector() {
        
        this.chooser = new SendableChooser<String>();

        chooser.setDefaultOption("Left Mobility", "Left Mobility");
        chooser.addOption("Right Mobility", "Right Mobility");
        chooser.addOption("Middle Mobility", "Middle Mobility");
        chooser.addOption("Middle Mobility w Note", "Middle Mobility w Note");
        

        SmartDashboard.putData("Auto choices", chooser);
    }


    String getSelected() {
        return this.chooser.getSelected();
    }
}
