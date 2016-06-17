/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakerfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 070169263
 */
public class algorithm {
     
    public person[] arraypeople() {

        // create scanner
        Scanner s = null;
        // open file of personality info
        File f = new File("person.txt");

        try {
            s = new Scanner(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(person.class.getName()).log(Level.SEVERE, null, ex);
        }

        int i;

        //go through file and count number of people
        for (i = 0; s.hasNext(); i++) {
            s.nextLine();
        }
        // create an array the number of people there are
        person[] oneperson = new person[i];

       // System.out.println(oneperson.length);

        try {
            s = new Scanner(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(person.class.getName()).log(Level.SEVERE, null, ex);
        }

        // go through each person and add there personality information
        for (int j = 0; j < oneperson.length; j++) {

            String line = s.nextLine();
            // break up string to array of strings
            String[] user = line.split(",");

            oneperson[j] = new person();

            oneperson[j].user = user[0];

            oneperson[j].besttrait = user[1];

            oneperson[j].worsttrait = user[2];

            oneperson[j].sport = user[3];

            oneperson[j].read = user[4];

            oneperson[j].vaca = user[5];

            oneperson[j].food = user[6];
            oneperson[j].night = user[7];
            oneperson[j].when = user[8];
            oneperson[j].where = user[9];

        }

        //  return person
        return oneperson;

    }

//    public void compare() {
//        int x;
//        for (x = 0; x < arraypeople().length; x++) {
//            arraypeople().
//            
//        }
//
//    }

    /**
     * Searches through personality text file
     * and finds the last user in the file
     * for comparing results
     * @return return position of last user
     */
    public int lastposition() {

        // create scanner
        Scanner s = null;
        // open file of star info
        File f = new File("person.txt");

        try {
            s = new Scanner(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(person.class.getName()).log(Level.SEVERE, null, ex);
        }

        int i;

        //go through file and count number of people
        for (i = 0; s.hasNext(); i++) {
            s.nextLine();
        }

        return i-1;
    }
}
