/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.projectoak.gui;

import com.gtranslate.Audio;
import com.gtranslate.Language;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javazoom.jl.decoder.JavaLayerException;

/**
 * FXML Controller class
 *
 * @author user
 */
public class TextController implements Initializable {

    @FXML
    private Button hello;
    @FXML
    private Button hello2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void hello(ActionEvent event) {
//            InputStream sound = null;
//                try {
//                    System.out.println("Hello World!");
//                    Audio audio = Audio.getInstance();
//                    sound = audio.getAudio("Hello World", Language.ENGLISH);
//                    audio.play(sound);
//                } catch (IOException | JavaLayerException ex) {
//                    Logger.getLogger(TextController.class.getName()).log(Level.SEVERE, null, ex);
//                } finally {
//                    try {
//                        sound.close();
//                    } catch (IOException ex) {
//                        Logger.getLogger(TextController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//    }
}

    @FXML
    private void hello2(ActionEvent event) {
         try {
            // Set property as Kevin Dictionary
            System.setProperty(
                "freetts.voices",
                "com.sun.speech.freetts.en.us"
                    + ".cmu_us_kal.KevinVoiceDirectory");
  
            // Register Engine
            Central.registerEngineCentral(
                "com.sun.speech.freetts"
                + ".jsapi.FreeTTSEngineCentral");
  
            // Create a Synthesizer
            Synthesizer synthesizer
                = Central.createSynthesizer(
                    new SynthesizerModeDesc(Locale.US));
  
            // Allocate synthesizer
            synthesizer.allocate();
  
            // Resume Synthesizer
            synthesizer.resume();
  
            // Speaks the given text
            // until the queue is empty.
            synthesizer.speakPlainText(
                "hellow world", null);
            synthesizer.waitEngineState(
                Synthesizer.QUEUE_EMPTY);
  
            // Deallocate the Synthesizer.
           // synthesizer.deallocate();
        }
  
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

    

