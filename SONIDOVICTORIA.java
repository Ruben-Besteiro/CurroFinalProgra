package CurroFinal;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SONIDOVICTORIA implements INTERFAZSONIDO {

	private Clip clip;
	
	 @Override
	    public void sonido() {
	        try {
	            File sonido = new File("CurroFinalProgra/win.wav"); //RUTA PARA EL AUDIO
	            AudioInputStream audio = AudioSystem.getAudioInputStream(sonido);
	            clip = AudioSystem.getClip();
	            clip.open(audio);
	            clip.start();
	        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void sonidoBucle() {
	        try {
	            File sonidoBucle = new File("CurroFinalProgra/win.wav"); //RUTA CON EL AUDIO
	            AudioInputStream audioBucle = AudioSystem.getAudioInputStream(sonidoBucle);
	            clip = AudioSystem.getClip();
	            clip.open(audioBucle);
	            clip.loop(Clip.LOOP_CONTINUOUSLY); //SONIDO EN BUCLKE
	        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	            e.printStackTrace();
	        }
	    }

	    // Método para detener el sonido
	    public void detenerSonido() {
	        if (clip != null && clip.isRunning()) {
	            clip.stop();
	        }
	    }
}
