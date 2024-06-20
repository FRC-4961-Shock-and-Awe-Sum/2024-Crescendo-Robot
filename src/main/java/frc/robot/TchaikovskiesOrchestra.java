/*package frc.robot;

import com.ctre.phoenix6.Orchestra;

import frc.robot.subsystems.climber.Climber;
import frc.robot.subsystems.launcher.CANLauncher;

public class TchaikovskiesOrchestra {

    private int songIndex;
    private String[] songs;
    
    TchaikovskiesOrchestra(CANLauncher launcher, Climber climber) {

        Orchestra tchaisOrchestra = new Orchestra();

        this.songIndex = 0;

        songs = new String[] {
            "NutcrackerMarch.chrp",
            "Nut"
        }

        tchaisOrchestra.addInstrument(launcher.getFeedMotor());
        tchaisOrchestra.addInstrument(launcher.getFeedFollowerMotor());
        tchaisOrchestra.addInstrument(climber.getMotor());

        


    }
    

    void LoadMusicSelection()
    {
         increment song selection 
        this.songIndex++;
        /* wrap song index in case it exceeds boundary 
        if (_songSelection >= _songs.length) {
            _songSelection = 0;
        }
        if (_songSelection < 0) {
            _songSelection = _songs.length - 1;
        }
        /* load the chirp file 
        _orchestra.loadMusic(_songs[_songSelection]); 

        /* print to console 
        System.out.println("Song selected is: " + _songs[_songSelection] + ".  Press left/right on d-pad to change.");
        
        /* schedule a play request, after a delay.  
            This gives the Orchestra service time to parse chirp file.
            If play() is called immedietely after, you may get an invalid action error code. 
        _timeToPlayLoops = 10;
    }
}*/