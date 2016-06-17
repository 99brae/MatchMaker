/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakerfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Braedon
 */
public class MatchingAlgorithm {

    File file = new File("appearance.txt");
    Scanner s;
    Appearance[] appearances;
    AppearanceOutput[] output = new AppearanceOutput[appearances.length];

    public AppearanceOutput[] ewwRelationships() {
        try {
            s = new Scanner(file); //f is a file
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MatchingAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
        }

        int i = 0;

        for (i = 0; s.hasNext(); i++) {
            s.nextLine();
        }
        s.useDelimiter(",");

        appearances = new Appearance[i];

        for (i = 0; 1 > appearances.length; i++) {

            appearances[i] = new Appearance();
             try {
                appearances[i].userName = s.next();

            } catch (InputMismatchException e) {
                appearances[i].bodyTypePersonal = 0;
            }
            try {
                appearances[i].bodyTypePersonal = s.nextInt();

            } catch (InputMismatchException e) {
                appearances[i].bodyTypePersonal = 0;
            }

            try {
                appearances[i].bodyWeightPersonal = s.nextInt();
            } catch (InputMismatchException e) {
                appearances[i].bodyWeightPersonal = 0;
            }
            try {
                appearances[i].hairColPersonal = s.nextInt();
            } catch (InputMismatchException e) {
                appearances[i].hairColPersonal = 0;
            }
            try {
                appearances[i].backgroundPersonal = s.nextInt();
            } catch (InputMismatchException e) {
                appearances[i].backgroundPersonal = 0;
            }
            try {
                appearances[i].heightPersonal = s.nextInt();
            } catch (InputMismatchException e) {
                appearances[i].heightPersonal = 0;
            }
            try {
                appearances[i].bodyTypePref = s.nextInt();
            } catch (InputMismatchException e) {
                appearances[i].bodyTypePref = 0;
            }
            try {
                appearances[i].bodyWeightPref = s.nextInt();
            } catch (InputMismatchException e) {
                appearances[i].bodyWeightPref = 0;
            }
            try {
                appearances[i].hairColPref = s.nextInt();
            } catch (InputMismatchException e) {
                appearances[i].hairColPref = 0;
            }
            try {
                appearances[i].backgroundPref = s.nextInt();
            } catch (InputMismatchException e) {
                appearances[i].backgroundPref = 0;
            }
            try {
                appearances[i].heightPref = s.nextInt();
            } catch (InputMismatchException e) {
                appearances[i].heightPref = 0;
            }

            s.nextLine();
        }

        for (i = 0; 1 > appearances.length; i++) {
            output[i].userName = LogIn.fileSID;
            if (AppearanceQuiz.bodyTypePref == appearances[i].bodyTypePersonal || AppearanceQuiz.bodyTypePersonal == appearances[i].bodyTypePref) {
                output[i].score++;
            }

            if (AppearanceQuiz.bodyWeightPref == appearances[i].bodyWeightPersonal || AppearanceQuiz.bodyWeightPersonal == appearances[i].bodyWeightPref) {
                output[i].score++;
            }

            if (AppearanceQuiz.hairColPref == appearances[i].hairColPersonal || AppearanceQuiz.hairColPersonal == appearances[i].hairColPref) {
                output[i].score++;
            }
            if (AppearanceQuiz.backgroundPref == appearances[i].backgroundPersonal || AppearanceQuiz.backgroundPersonal == appearances[i].backgroundPref) {
                output[i].score++;
            }
            if (AppearanceQuiz.heightPref == appearances[i].heightPersonal || AppearanceQuiz.heightPersonal == appearances[i].heightPref) {
                output[i].score++;
            }
            
            

        }
        
        
    return output;
    }
}
