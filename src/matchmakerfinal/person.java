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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 070169263
 */
public class person {
    
    File person = new File("person.txt");
    
    PrintWriter pw ;
    
    public String user;
    public String besttrait;
    public String worsttrait;
    public String sport;
    public String read;
    public String vaca;
    public String food;
    public String night;
    public String when;
    public String what;
    public String where;
    
    public void person() {
        
        String d = ",";
       
       try {
           //create new print writer
            pw = new PrintWriter(new FileWriter(person, true));

        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            Logger.getLogger(PersonalityQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
        //write registration info to text file
            pw.println(user + d + besttrait + d + worsttrait + d + sport + d + read + d + vaca + d + food + night + d + when + d + where + d + what);
        //close printwriter
            pw.close();
  }
    
}
