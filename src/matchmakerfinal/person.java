/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakerfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nijat
 */
public class person {
    
    // create text file to store personality info
    File person = new File("person.txt");
    
    // create printwriter
    PrintWriter pw ;
    
    // declare global variables
    public String user;
    public String besttrait;
    public String worsttrait;
    public String sport;
    public String read;
    public String vaca;
    public String food;
    public String night;
    public String when;
    public String where;
        
    
    /**
     * Adds a new person to the text file 
     * with personality info
     * Nijat
     */
    public void person() {
        
        // create delimiter
        String d = ",";
       
       try {
           //create new print writer
            pw = new PrintWriter(new FileWriter(person, true));

        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            Logger.getLogger(PersonalityQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
        //write personnality info to text file
            pw.println(LogIn.fileSID  + d + besttrait + d + worsttrait + d + sport + d + read + d + vaca + d + food + d +  night + d + when + d + where);
        //close printwriter
           
             pw.close();
          
  }
    
    
    

}
