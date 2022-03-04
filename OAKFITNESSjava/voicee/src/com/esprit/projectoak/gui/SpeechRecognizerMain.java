package com.esprit.projectoak.gui;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SpeechRecognizerMain {

    // Necessary
    public LiveSpeechRecognizer recognizer;
    public static int a = 0;

    // Logger
    public Logger logger = Logger.getLogger(getClass().getName());

    /**
     * This String contains the Result that is coming back from SpeechRecognizer
     */
    public String speechRecognitionResult;

    //-----------------Lock Variables-----------------------------
    /**
     * This variable is used to ignore the results of speech recognition cause
     * actually it can't be stopped...
     *
     * <br>
     * Check this link for more information: <a href=
     * "https://sourceforge.net/p/cmusphinx/discussion/sphinx4/thread/3875fc39/">https://sourceforge.net/p/cmusphinx/discussion/sphinx4/thread/3875fc39/</a>
     */
    public boolean ignoreSpeechRecognitionResults = false;

    /**
     * Checks if the speech recognise is already running
     */
    public boolean speechRecognizerThreadRunning = false;

    /**
     * Checks if the resources Thread is already running
     */
    public boolean resourcesThreadRunning;

    //---
    /**
     * This executor service is used in order the playerState events to be
     * executed in an order
     */
    public ExecutorService eventsExecutorService = Executors.newFixedThreadPool(2);

    //------------------------------------------------------------------------------------
    /**
     * Constructor
     */
    public SpeechRecognizerMain() {

        // Loading Message
        logger.log(Level.INFO, "Loading Speech Recognizer...\n");

        // Configuration
        Configuration configuration = new Configuration();

        // Load model from the jar
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");

        //====================================================================================
        //=====================READ THIS!!!===============================================
        //Uncomment this line of code if you want the recognizer to recognize every word of the language 
        //you are using , here it is English for example	
        //====================================================================================
        //configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
        //====================================================================================
        //=====================READ THIS!!!===============================================
        //If you don't want to use a grammar file comment below 3 lines and uncomment the above line for language model	
        //====================================================================================
        // Grammar
        configuration.setGrammarPath("resource/grammars");
        configuration.setGrammarName("grammar");
        configuration.setUseGrammar(true);

        try {
            recognizer = new LiveSpeechRecognizer(configuration);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        // Start recognition process pruning previously cached data.
        // recognizer.startRecognition(true);
        //Check if needed resources are available
        startResourcesThread();
        //Start speech recognition thread
        startSpeechRecognition();
    }

    //-----------------------------------------------------------------------------------------------
    /**
     * Starts the Speech Recognition Thread
     */
    public int startSpeechRecognition() {
        //Check lock
        if (speechRecognizerThreadRunning) {
            logger.log(Level.INFO, "Speech Recognition Thread already running...\n");
        } else //Submit to ExecutorService
        {
            eventsExecutorService.submit(() -> {

                //locks
                speechRecognizerThreadRunning = true;
                ignoreSpeechRecognitionResults = false;

                //Start Recognition
                recognizer.startRecognition(true);

                //Information			
                logger.log(Level.INFO, "You can start to speak...\n");

                try {
                    while (speechRecognizerThreadRunning) {
                        /*
						 * This method will return when the end of speech is reached. Note that the end pointer will determine the end of speech.
                         */
                        SpeechResult speechResult = recognizer.getResult();

                        //Check if we ignore the speech recognition results
                        if (!ignoreSpeechRecognitionResults) {

                            //Check the result
                            if (speechResult == null) {
                                logger.log(Level.INFO, "I can't understand what you said.\n");
                            } else {

                                //Get the hypothesis
                                speechRecognitionResult = speechResult.getHypothesis();

                                //You said?
                                System.out.println("You said: [" + speechRecognitionResult + "]\n");
                                if ("one".equals(speechRecognitionResult)) {
                                    ForumController c = new ForumController();
                                    System.out.println("ooonnnnnnneeeee");
                                    //     ForumController.b = 1;
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            FXMLLoader loader = new FXMLLoader();
                                            loader.setLocation(getClass().getResource("Reclamation.fxml"));
                                            try {
                                                loader.load();
                                            } catch (IOException ex) {
                                                Logger.getLogger(CommentaireController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            Parent parent = loader.getRoot();
                                            Stage stage = new Stage();
                                            stage.setScene(new Scene(parent));
                                            stage.initStyle(StageStyle.UTILITY);
                                            stage.show();
                                        }
// do your GUI stuff here
                                    });
                                    a = 1;
                                    //  speechRecognizerThreadRunning = false;
                                }
                                if ("free".equals(speechRecognitionResult)) {
                                    speechRecognizerThreadRunning = false;

                                }
                                if ("close".equals(speechRecognitionResult)) {
                                    ForumController c = new ForumController();
                                    System.out.println("close");
                                    //     ForumController.b = 1;
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            Platform.exit();
                                            System.exit(0);
                                        }
// do your GUI stuff here
                                    });
                                    a = 1;
                                    //  speechRecognizerThreadRunning = false;
                                }

                                //     speechRecognizerThreadRunning = false;
                                //Call the appropriate method 
                                makeDecision(speechRecognitionResult, speechResult.getWords());

                            }
                        } else {
                            logger.log(Level.INFO, "Ingoring Speech Recognition Results...");
                        }

                    }
                } catch (Exception ex) {
                    logger.log(Level.WARNING, null, ex);
                    speechRecognizerThreadRunning = false;
                }

                logger.log(Level.INFO, "SpeechThread has exited...");

            });
        }
        return a;
    }

    /**
     * Stops ignoring the results of SpeechRecognition
     */
    public synchronized void stopIgnoreSpeechRecognitionResults() {

        //Stop ignoring speech recognition results
        ignoreSpeechRecognitionResults = false;
    }

    /**
     * Ignores the results of SpeechRecognition
     */
    public synchronized void ignoreSpeechRecognitionResults() {

        //Instead of stopping the speech recognition we are ignoring it's results
        ignoreSpeechRecognitionResults = true;

    }

    //-----------------------------------------------------------------------------------------------
    /**
     * Starting a Thread that checks if the resources needed to the
     * SpeechRecognition library are available
     */
    public void startResourcesThread() {
        //Check lock
        if (resourcesThreadRunning) {
            logger.log(Level.INFO, "Resources Thread already running...\n");
        } else //Submit to ExecutorService
        {
            eventsExecutorService.submit(() -> {
                try {

                    //Lock
                    resourcesThreadRunning = true;

                    // Detect if the microphone is available
                    while (true) {

                        //Is the Microphone Available
                        if (!AudioSystem.isLineSupported(Port.Info.MICROPHONE)) {
                            logger.log(Level.INFO, "Microphone is not available.\n");
                        }
                        // Sleep some period
                        Thread.sleep(350);
                    }

                } catch (InterruptedException ex) {
                    logger.log(Level.WARNING, null, ex);
                    resourcesThreadRunning = false;
                }
            });
        }
    }

    /**
     * Takes a decision based on the given result
     *
     * @param speechWords
     */
    public void makeDecision(String speech, List<WordResult> speechWords) {

        System.out.println(speech);

    }

    public boolean getIgnoreSpeechRecognitionResults() {
        return ignoreSpeechRecognitionResults;
    }

    public boolean getSpeechRecognizerThreadRunning() {
        return speechRecognizerThreadRunning;
    }

    /**
     * Main Method
     *
     * @param args
     */
//    public void strat() {
//        new SpeechRecognizerMain();
//    }
//        public static void test() {
//		new SpeechRecognizerMain();
//        }
}
