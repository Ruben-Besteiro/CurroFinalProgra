package CurroFinal;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SONIDOMENU implements INTERFAZSONIDO {
    private Clip clip; //CLIP COMPARTIDO PARA EL AUDIO

    @Override
    public void sonido() {
        try {
            File sonido = new File("ruta/al/audio.wav"); //RUTA PARA EL AUDIO
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
            File sonidoBucle = new File("ruta/al/audio.wav"); //RUTA CON EL AUDIO
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

