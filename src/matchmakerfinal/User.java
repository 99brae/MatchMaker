/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakerfinal;

/**
 *
 * @author Stephanie
 */
public class User {
    // General information about the user
    public String FN;
    public String LN;
    public String gender;
    public String grade;
    public int weightFactor;
    public String[] LFGender;
    public String[] LFGrade;
    
    public User(String info) {
        String[] user = info.split(",");
        FN = user[0];
        LN = user[1];
        gender = user[2];
        grade = user[3];
        weightFactor = Integer.parseInt(user[4]);
        LFGender = user[4].split(";");
        LFGrade = user[5].split(";");            
    }
    
}
