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
 * @author 070169263
 */
public class person {
    
    File person = new File("person.txt");
    
    PrintWriter pw ;
    
    private String user;
    private String besttrait;
    private String worsttrait;
    private String sport;
    private String read;
    private String vaca;
    private String food;
    private String night;
    private String when;
    private String where;
    
    int toCompare;
    
    public void person(String line){
        try {
            Scanner s = new Scanner(person);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(person.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        String[] stuff = line.split(",");
        user = stuff[0];
        besttrait = stuff[1];
        worsttrait = stuff[2];
        sport = stuff[3];
        read = stuff[4];
        vaca = stuff[5];
        food = stuff[6];
        night = stuff[7];
       
        
    }
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
            pw.println(LogIn.fileSID  + d + getBesttrait() + d + getWorsttrait() + d + getSport() + d + getRead() + d + getVaca() + d + getFood() + d +  getNight() + d + getWhen() + d + getWhere());
        //close printwriter
            pw.close();
            
            System.out.println(getUser());
  }
    
    public void compare(){
        
        
            
        
    }
   
    
    

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the besttrait
     */
    public String getBesttrait() {
        return besttrait;
    }

    /**
     * @param besttrait the besttrait to set
     */
    public void setBesttrait(String besttrait) {
        this.besttrait = besttrait;
    }

    /**
     * @return the worsttrait
     */
    public String getWorsttrait() {
        return worsttrait;
    }

    /**
     * @param worsttrait the worsttrait to set
     */
    public void setWorsttrait(String worsttrait) {
        this.worsttrait = worsttrait;
    }

    /**
     * @return the sport
     */
    public String getSport() {
        return sport;
    }

    /**
     * @param sport the sport to set
     */
    public void setSport(String sport) {
        this.sport = sport;
    }

    /**
     * @return the read
     */
    public String getRead() {
        return read;
    }

    /**
     * @param read the read to set
     */
    public void setRead(String read) {
        this.read = read;
    }

    /**
     * @return the vaca
     */
    public String getVaca() {
        return vaca;
    }

    /**
     * @param vaca the vaca to set
     */
    public void setVaca(String vaca) {
        this.vaca = vaca;
    }

    /**
     * @return the food
     */
    public String getFood() {
        return food;
    }

    /**
     * @param food the food to set
     */
    public void setFood(String food) {
        this.food = food;
    }

    /**
     * @return the night
     */
    public String getNight() {
        return night;
    }

    /**
     * @param night the night to set
     */
    public void setNight(String night) {
        this.night = night;
    }

    /**
     * @return the when
     */
    public String getWhen() {
        return when;
    }

    /**
     * @param when the when to set
     */
    public void setWhen(String when) {
        this.when = when;
    }

    /**
     * @return the where
     */
    public String getWhere() {
        return where;
    }

    /**
     * @param where the where to set
     */
    public void setWhere(String where) {
        this.where = where;
    }

    
}
