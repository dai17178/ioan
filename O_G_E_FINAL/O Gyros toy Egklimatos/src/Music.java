

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

import java.io.File;
import java.util.ArrayList;

public class Music {
    
    private int currentSongIndex;
    private  String filename;
    private Clip clip;
    
   
    
    public  Music (String fileName){
        try{
            File soundFile = new File(fileName);
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-0f); 
            clip.start();
            clip.loop(clip.LOOP_CONTINUOUSLY);              
            
        }catch(Exception e){
           
        }
    }

    public void IxitikoEffe(String filename)
    {
    	 try{
             File soundFile = new File(filename);
             AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
             AudioFormat format = ais.getFormat();
             DataLine.Info info = new DataLine.Info(Clip.class, format);
             Clip clip = (Clip) AudioSystem.getLine(info);
             clip.open(ais);
             FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
             gainControl.setValue(-10f); 
             clip.start();            
             
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    public void stop(){
    	clip.stop();
    }
    

}