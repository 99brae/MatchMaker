/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakerfinal;

import java.awt.Color;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author Stephanie
 */
public class General extends javax.swing.JFrame {
    // vars to store the information about the user
    public static String StudentID;
    public String gender;
    public String grade;
    public String LFGender = "";
    public String[] LFGrade = {"","","",""};
          
    /**
     * Creates new form General
     */
    public General() {
        initComponents();
       // String to store current line from the file
        String user = null;
        // The file of data about the users (this includes the SID, studentID,
        //gender, grade, the gender(s) you are looking for and the grade(s) you are looking for
          File info = new File ("GeneralInfo.txt");
          Scanner s = null;
        try {            
            s = new Scanner (info);
            // While you have not reached the end of the file
            while (s.hasNextLine()){             
            // Store the line in the user var
            user = s.nextLine();
            // Split the string into an array 
            String[] userInfo = user.split(",");   
            // if the SID matches the one previously stored
            if (LogIn.fileSID.equals(userInfo[0])){
                // set the first name field to the first name stored in the file
                firstName.setText(userInfo[1]);
                // set the last name field to the last name stored in the file
                lastName.setText(userInfo[2]);
                // if female is stored in the myGender var
                if (userInfo[3].equals("female")){
                    // auto press the myGenderFemale button (will store female in my gender and change colour accordingly)
                    myGenderFemale.doClick();
                }
                // otherwise the gender stored must be male
                else {
                    // auto click the myGenderMale button (will store male in my gender and change colour accordingly)
                    myGenderMale.doClick();
                }
                // if 9 is stored in the file
                if (userInfo[4].equals("9")){
                    // auto click the myGrade10 button
                    myGrade9.doClick();
                }
                // else if 10 is stored in the file
                else if (userInfo[4].equals("10")){
                    // auto click the myGrade10 button
                      myGrade10.doClick();
                }
                // else if 11 is stored in the file
                else if (userInfo[4].equals("11")){
                    // auto click the myGrade11 button
                      myGrade11.doClick();
                }
                // otherwise the grade stored in the file is 12
                else {
                    // auto click the myGrade12 button
                    myGrade12.doClick();
                }
                // store the int in the file in the looks text field
                looks.setText(userInfo[5]);
                // store 100 - what is stored in the file in the personality text field
                personality.setText(String.valueOf(100 - Integer.parseInt(userInfo[5])));
                // create an array of strings for the users interest in gender and split based on the delimiter ";"
                String[] interestGender = userInfo[6].split(";");               
                // using a linear search, see if female is in the array
                if (LinearStringSearcher(interestGender,"female") > 0){
                    // if it is auto click the LFFemale button
                    LFFemale.doClick();
                }
                // using a inear search, see if male is in the array
                if (LinearStringSearcher(interestGender,"male") > 0){
                    // if it is auto click the LFMale button
                    LFMale.doClick();
                }
                // create an array of string for the users interest in grade and split based on the delimiter ";"
                String[] interestGrade = userInfo[7].split(";");
                // using linear search, see if 9 is in the array
                if (LinearStringSearcher(interestGrade,"9") > 0){
                    // if it is auto click the LFGrade9 button
                    LFGrade9.doClick();
                }
                // using linear search, see if 10 is in the array
                if (LinearStringSearcher(interestGrade,"10") > 0){
                    // if it is auto click the LFGrade10 button
                    LFGrade10.doClick();
                }
                // using the linear search, see if 11 is in the array
                if (LinearStringSearcher(interestGrade,"11") > 0){
                    // if it is auto click the LFGrade11 button
                    LFGrade11.doClick();
                }
                // using the linear search, see if 12 is in the array
                if (LinearStringSearcher(interestGrade,"12") > 0){
                    // if it is auto click the LFGrade12 button
                    LFGrade12.doClick();
                } 
            }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }  
          // set the size of the screen to 1108 x 733
          setSize(1108, 733);
    }   
    
    /**
     * This method is used to search through an array of Strings using a linear
     * search method
     *
     * @ param obj - the array of Strings and the word you are looking for
     * @ return - (i) the index at which the number was found - (-1) the number
     *            was not found
     */
        public int LinearStringSearcher(String[] stringArray, String target) {
        // loop that runs through the array of strings while there are still words left
        for (int i = 0; i < stringArray.length; i++) {
            // if the word is found
            if (stringArray[i].equals(target)) {
                // return the current index
                return i + 1;
            }
        }
        // the word has not been found, return -1 to indicate such
        return -1;
    }
    
    /**
     * This method is used to determine whether or not the user has previously completed
     * this quiz. 
     *
     * @ param obj - int greater than 0 if the user has completed the quiz and where in the
     *               file this information is stored
     * @ return - (-1) if the user has not yet completed the quiz
     */
    private int completed (){
         // String to store current line in file
         String user = null;
         // where we are in the file
         int here = 0;
         // The file of data about the users (this includes the SID, studentID,
        //gender, grade, the gender(s) you are looking for and the grade(s) you are looking for
          File info = new File ("GeneralInfo.txt");
          Scanner s = null;
        try {            
            s = new Scanner (info);
            // While you have not reached the end of the file
            while (s.hasNextLine()){             
            // Store the line in the user var
            user = s.nextLine();
            // increase here by 1
            here++;
            // Split the string into an array 
            String[] userInfo = user.split(",");   
            // if the SID matches the one in the file
            if (LogIn.fileSID.equals(userInfo[0])){
                // return the line number (will be used to replace this line when the user
                // resubmits the quiz)
             return here;
            }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
    }
        // return -1 is the user has not yet completed the quiz
        return -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        personality = new javax.swing.JTextField();
        looks = new javax.swing.JTextField();
        LFGrade9 = new javax.swing.JButton();
        LFGrade10 = new javax.swing.JButton();
        LFGrade11 = new javax.swing.JButton();
        LFGrade12 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        myGrade10 = new javax.swing.JButton();
        myGrade9 = new javax.swing.JButton();
        myGrade11 = new javax.swing.JButton();
        myGrade12 = new javax.swing.JButton();
        myGenderFemale = new javax.swing.JButton();
        myGenderMale = new javax.swing.JButton();
        LFFemale = new javax.swing.JButton();
        LFMale = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        firstName.setFont(new java.awt.Font("Papyrus", 0, 18)); // NOI18N
        firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameActionPerformed(evt);
            }
        });
        getContentPane().add(firstName);
        firstName.setBounds(310, 240, 200, 40);

        lastName.setFont(new java.awt.Font("Papyrus", 0, 18)); // NOI18N
        getContentPane().add(lastName);
        lastName.setBounds(740, 240, 210, 40);

        personality.setFont(new java.awt.Font("Papyrus", 0, 18)); // NOI18N
        getContentPane().add(personality);
        personality.setBounds(700, 440, 80, 40);

        looks.setFont(new java.awt.Font("Papyrus", 0, 18)); // NOI18N
        getContentPane().add(looks);
        looks.setBounds(440, 440, 80, 40);

        LFGrade9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LFGrade9ActionPerformed(evt);
            }
        });
        getContentPane().add(LFGrade9);
        LFGrade9.setBounds(610, 610, 40, 30);

        LFGrade10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LFGrade10ActionPerformed(evt);
            }
        });
        getContentPane().add(LFGrade10);
        LFGrade10.setBounds(680, 610, 40, 30);

        LFGrade11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LFGrade11ActionPerformed(evt);
            }
        });
        getContentPane().add(LFGrade11);
        LFGrade11.setBounds(740, 610, 40, 30);

        LFGrade12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LFGrade12ActionPerformed(evt);
            }
        });
        getContentPane().add(LFGrade12);
        LFGrade12.setBounds(810, 610, 40, 30);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("~ Finished ~");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(970, 650, 120, 70);

        myGrade10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myGrade10ActionPerformed(evt);
            }
        });
        getContentPane().add(myGrade10);
        myGrade10.setBounds(790, 330, 40, 30);

        myGrade9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myGrade9ActionPerformed(evt);
            }
        });
        getContentPane().add(myGrade9);
        myGrade9.setBounds(730, 330, 40, 30);

        myGrade11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myGrade11ActionPerformed(evt);
            }
        });
        getContentPane().add(myGrade11);
        myGrade11.setBounds(860, 330, 40, 30);

        myGrade12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myGrade12ActionPerformed(evt);
            }
        });
        getContentPane().add(myGrade12);
        myGrade12.setBounds(920, 330, 40, 30);

        myGenderFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myGenderFemaleActionPerformed(evt);
            }
        });
        getContentPane().add(myGenderFemale);
        myGenderFemale.setBounds(310, 330, 40, 30);

        myGenderMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myGenderMaleActionPerformed(evt);
            }
        });
        getContentPane().add(myGenderMale);
        myGenderMale.setBounds(410, 330, 40, 30);

        LFFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LFFemaleActionPerformed(evt);
            }
        });
        getContentPane().add(LFFemale);
        LFFemale.setBounds(310, 603, 40, 30);

        LFMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LFMaleActionPerformed(evt);
            }
        });
        getContentPane().add(LFMale);
        LFMale.setBounds(400, 600, 40, 30);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/matchmakerfinal/General.jpg"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, 0, 1110, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // if the firstName or lastName field is filled out incorrectly
        if (checkNames(firstName) || checkNames(lastName)){
            // display a message to indicating such
             JOptionPane.showMessageDialog(this, "Please ensure the name fields are filled in correctly", "Names", JOptionPane.PLAIN_MESSAGE);
        }
        //check the fields to ensure both personality and looks are numbers
        else if (checkRatio(personality) || checkRatio(looks)){
            // if one is not, display a message stating such
            JOptionPane.showMessageDialog(this, "Please ensure the looks:personality field contain only numbers", "Names", JOptionPane.PLAIN_MESSAGE);
        }
        // check to make sure personality and looks add to 100
        else if (addTo()){
         // if they do not display a message stating such
         JOptionPane.showMessageDialog(this, "Please ensure the looks:personality field add to 100%", "% Looks to Personality", JOptionPane.PLAIN_MESSAGE);   
        }
        // check to make sure the user had selected at least one grade preferece
        else if (checkGrade(LFGrade[0]) && checkGrade(LFGrade[1]) && checkGrade(LFGrade[2]) && checkGrade(LFGrade[3])){
            // if they have not, display a message indicating such
         JOptionPane.showMessageDialog(this, "Please select one or more grade preferences", "Looking for Grade..", JOptionPane.PLAIN_MESSAGE);     
        }
        // check to make sure the user has selected at least one gender preference
        else if (empty(LFGender)){
            // if they have not, display a message indicating such
         JOptionPane.showMessageDialog(this, "Please select one or more gender preferences", "Looking for Gender..", JOptionPane.PLAIN_MESSAGE);         
        }
        // if the user has met all these conditions
        else{
           String gradeInterest = arrayToString();
        // store information in String
        String userInformation = (firstName.getText()+ "," + lastName.getText()+ "," + gender + "," + grade + "," + personality.getText()+ "," + LFGender + "," + gradeInterest + LogIn.fileSID);
        // if the user has not completed the quiz yet
        if (completed() == -1){
            // add the new data to the file
            addToFile(userInformation);
            }
        // the user has previously completed the quiz
        else {
            // replace the line of entered information with the new information
            replaceFile(userInformation);
        }     
        // reopen the menu screen
        setVisible(false);
        new Menu().setVisible(true);
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    
    /**
     * This method is used to replace a line in the file if the user has already completed the quiz
     *
     * @ param obj - String (the new information the user filled out in the quiz)
     * @ return - void
     */
    private void replaceFile(String userInfo){
         // String to store current line from the file
        String user = null;
        // The file of data about the users (this includes the SID, studentID,
        //gender, grade, the gender(s) you are looking for and the grade(s) you are looking for
          File info = new File ("GeneralInfo.txt");
          // create an array to store the file based on the length of the file
          String[] file = new String[findLength(info)];
          Scanner s = null;
        try {            
            s = new Scanner (info);
            // var to store where we are in the file
            int here = 0;
            // While you have not reached the end of the file
            while (s.hasNextLine()){
            // Store the line in the array
            file[here] = s.nextLine();
            // increase here by one (will move to next element in the array
            here++;
            }            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
    }
        // replace the line of data the user has already entered
        file[completed()-1] = userInfo;       
        
         PrintWriter pw = null;         
            try {
                 // The file of data about the users (this includes the SID, studentID,
                 //gender, grade, the gender(s) you are looking for and the grade(s) you are looking for
                File f = new File("GeneralInfo.txt");
                // clear the file
                pw = new PrintWriter(new FileWriter(f));
                // create a PrintWriter that will append the file (will add to it as apppose to overwrite)
                pw = new PrintWriter(new FileWriter(f, true));
                //run through the array
                for (int i = 0; i < file.length; i++)
                // store each element of the array in the file
                pw.println(file[i]);                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // close the print writer
                pw.close();  
        
        }
    }
    /**
     * This method is used to add a new line to the file because this is a new user
     *
     * @ param obj - String (the new information the user filled out in the quiz)
     * @ return - void
     */
    private void addToFile(String userInfo){
                    PrintWriter pw = null;
            try {
                // The file of data about the users (this includes the SID, studentID,
                // gender, grade, the gender(s) you are looking for and the grade(s) you are looking for
                File f = new File("GeneralInfo.txt");
                // create a PrintWriter that will append the file (will add to it as apppose to overwrite)
                pw = new PrintWriter(new FileWriter(f, true));
                // store the information about the user from the quiz
                pw.println(userInfo);                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // close the print writer
                pw.close();  
        }
    }
    /**
     * This method is used to store the array of grades the user is looking for into a string
     *
     * @ param obj - void
     * @ return - void
     */
    private String arrayToString(){
         // create a string to store the users grade interest
            String gradeInterest = "";
            // run through the array of gradeInterest (some may be empty)
            for (int i = 0; i < 3; i ++){
                // if they are empty do nothing
                if ("".equals(LFGrade[i])){
                    }
                // if they are not empty
                else {
                    // add them to the string with a ";" delimiter
                     gradeInterest = gradeInterest + LFGrade[i] +";";
                }
            }     
        // add the last element of the array to the string (it will not have a comma)  
        gradeInterest = gradeInterest + LFGrade[3];
        // find the length of this string
        int length =   gradeInterest.length();
        // if the last character in the string is a ";"
        if (gradeInterest.charAt(length-1) == ';'){
            // create a substring without the last character ";"
            gradeInterest = gradeInterest.substring(0,(length - 1));            
        }
        // return the string
        return gradeInterest;
    }
    
    /**
     * This method is used to find the length of a file
     *
     * @ param obj - File (the file you want to find the length of
     * @ return - int (the length of the file)
     */
    private int findLength(File x){
        // create an int var to store the length of the file
        int length = 0;
        Scanner s = null;
        try {            
            s = new Scanner (x);
            // While you have not reached the end of the file
            while (s.hasNextLine()){
            // move to next line
            s.nextLine();
            // increase length by 1
            length++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
    }
        // return length of the file
        return length;
    }
    
    /**
     * This method is user to check to make sure the personality and looks percent 
     * add to 100%
     *
     * @ param obj - 
     * @ return - true (if they do not add to 100)
     *            flase (if they do add to 100)
     */
    private boolean addTo(){
    // int to store the personality %
    int RP = Integer.parseInt(personality.getText());
    // int to store the looks percent
    int LP = Integer.parseInt(looks.getText());
    // if they add to 100
    if (LP + RP == 100){
        // the user passes this condition, return false
        return false;
    }
    // the user does not pass this condition, return true
    return true;
    
}
    /**
     * This method is used to check to make sure at least one of the grades has 
     * been chosen as the users grade interest
     *
     * @ param obj - 
     * @ return - true (if they have not chosen a grade)
     *            false (if one of the grades has been selected)
     */
    private boolean checkGrade (String grade){
        // if the grade is empty
        if (grade == ""){
        // return true to indicate such
        return true;
    }
        // otherwise return false
        return false;
    }
    /**
     * This method is used to check to make sure the only thing entered in the 
     * personality or looks field is numbers
     *
     * @ param obj - the text field (personality or looks)
     * @ return - true (if they contain something that is not a number)
     *            false (if they contain only numbers)
     */
    private boolean checkRatio (JTextField ratio){
        // return if the text field only numbers
        return !ratio.getText().matches("[0-9]+");        
    }
    
    /**
     * This method is used to check to make sure the name fields contain only letters
     * and are not empty
     *
     * @ param obj - the text field (personality or looks)
     * @ return - true (if they contain something that is not a number)
     *            false (if they contain only numbers)
     */
    private boolean checkNames(JTextField name){
        //This method will check each the name inputs and return true if they are not filled in properly
       // is the name filled in?
        if (empty(name.getText())){
            // return true if the name field is empty
            return true;
        }
        //is the content only letters?
        else if (letters(name.getText())){
            // return true if there are characters other than letters
            return true;
        }
        // return false if it meets both of the above two condition
        return false;
    }
    /**
     * This method is used to check to make sure the name is made up of 
     * only letters
     *
     * @ param obj - String ~ (personality or looks)
     * @ return - true (if they contain non-letter chars)
     *            false (if they do not contain non-letter chars)
     */
    public boolean letters(String name) {
    // make the string into an array of chars
    char[] chars = name.toCharArray();
    // run through the array of chars
    for (char c : chars) {
        // check to make sure it is a letter
        if(!Character.isLetter(c)) {
            // if it is not, return true
            return true;
        }
    }
    // if none of the chars are not letters return false
    return false;
}
    /**
     * This method is used to check to make sure the name is not empty
     *
     * @ param obj - String ~ (personality or looks)
     * @ return - true (if they are empty)
     *            false (if they are not empty)
     */
        private boolean empty(String text) {
        // if the field is empty
        if (text.isEmpty()) {
            // return true (yes it is empty)            
            return true;
        }
        // if the field is not empty return false
        return false;
        }
    
    private void firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameActionPerformed
    
    /**
     * This method is used to set the button colouration to that of a non pressed button
     *
     * @ param obj - JButton (the button that is not pressed)
     * @ return - void
     */
    private void notSelected(JButton button){
        // change button colours
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
    }
    
    /**
     * This method is used to set the button colouration to that of a pressed button
     *
     * @ param obj - JButton (the button that is pressed)
     * @ return - void
     */
    private void selected(JButton button){
        // change button colours
        button.setBackground(Color.BLACK);
        button.setForeground(Color.GRAY);
    }
    
    private void myGenderFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myGenderFemaleActionPerformed
       // change button colours to make female clicked and male not clicked
       notSelected(myGenderMale);
       selected(myGenderFemale);
      // store female in the gender var
        gender = "female";
       
    }//GEN-LAST:event_myGenderFemaleActionPerformed

    private void myGenderMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myGenderMaleActionPerformed
        // change button colours to make male clicked and female not clicked
       notSelected(myGenderFemale);
       selected(myGenderMale);
       // store male in the gender var
       gender = "male";
    }//GEN-LAST:event_myGenderMaleActionPerformed

    private void myGrade9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myGrade9ActionPerformed
      // set grade 9 to selected and all other grades to notSelected
       notSelected(myGrade10);
       notSelected(myGrade11);
       notSelected(myGrade12);
       selected(myGrade9);
       // store 9 in the grade var      
        grade = "9";
    }//GEN-LAST:event_myGrade9ActionPerformed

    private void myGrade10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myGrade10ActionPerformed
       // set grade 9 to selected and all other grades to notSelected
        notSelected(myGrade9);
       notSelected(myGrade11);
       notSelected(myGrade12);
       selected(myGrade10);
       // store 10 in the grade var
        grade = "10";
    }//GEN-LAST:event_myGrade10ActionPerformed

    private void myGrade11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myGrade11ActionPerformed
    // set grade 9 to selected and all other grades to notSelected
        notSelected(myGrade9);
       notSelected(myGrade10);
       notSelected(myGrade12);
       selected(myGrade11);
       // store 11 in the grade var
        grade = "11";
    }//GEN-LAST:event_myGrade11ActionPerformed

    private void myGrade12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myGrade12ActionPerformed
     // set grade 9 to selected and all other grades to notSelected
        notSelected(myGrade9);
       notSelected(myGrade11);
       notSelected(myGrade10);
       selected(myGrade12);
       // store 12 in the grade var
        grade = "12";
    }//GEN-LAST:event_myGrade12ActionPerformed

    private void LFFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LFFemaleActionPerformed
        // if male is currently stored in the LFGender var
        if ("male".equals(LFGender)){
            // select for both LFFemale and LFMale
            selected(LFFemale);
             selected(LFMale);
             // store and male in the LFGender var
            LFGender = "female;male";
        }
        // otherwise if nothing is stored in the var
        else if ("".equals(LFGender)){
            // set female to selected and male to not selected
            selected(LFFemale);
            notSelected(LFMale);
            // store just female in var
            LFGender = "female";            
        }
        // female and male are in the LFGender var
        else if ("female;male".equals(LFGender)){
            // set buttons
             notSelected(LFFemale);
            selected(LFMale);
            // remove female from LFGender var
            LFGender = "male";           
        }
        // otherwise just female is in the LFGender var
        else {
            // set buttons
            notSelected(LFFemale);
            notSelected(LFMale);
            // store nothing in the LFGender var
            LFGender = "";
        }
    }//GEN-LAST:event_LFFemaleActionPerformed

    private void LFMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LFMaleActionPerformed
        // if male is stored in the LFGender var
        if ("male".equals(LFGender)){
            // set buttons
           notSelected(LFFemale);
            notSelected(LFMale);
            // store nothing in the LFGender var
            LFGender = "";
            
        }
        // if nothing is stored in the FLGender var
        else if ("".equals(LFGender)){
            // set buttons 
            notSelected(LFFemale);
            selected(LFMale);
            // store male in the LFGender var
            LFGender = "male";
            
        }
        // otherwise if male and female are stored in the var
        else if ("female;male".equals(LFGender)){
            // set buttons
            selected(LFFemale);
            notSelected(LFMale);
            // store female in the LFGender var
            LFGender = "female";
             
        }
        // othewise female is stored in the var
        else {
            // set buttons
            selected(LFFemale);
             selected(LFMale);
             // store male and female in LFGender var
            LFGender = "female;male";
        }
    
    }//GEN-LAST:event_LFMaleActionPerformed

    private void LFGrade9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LFGrade9ActionPerformed
        // if 9 has already been stored
        if ("9".equals(LFGrade[0])){
            // unselect it 
            notSelected(LFGrade9);
            // store nothing
            LFGrade[0] = "";
            
        }
        // otherwise nothing has been stored
        else {
            // select it
            selected(LFGrade9);
            // store 9
            LFGrade[0] = "9";
        }
    }//GEN-LAST:event_LFGrade9ActionPerformed

    private void LFGrade10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LFGrade10ActionPerformed
        //if 10 has already been stored 
        if ("10".equals(LFGrade[1])){
            //unselect it
             notSelected(LFGrade10);
             //store nothing
               LFGrade[1] = "";           
        }
        //otherwise nothing has been stored
        else {
            // select it
             selected(LFGrade10);
             //store 10
               LFGrade[1] = "10";
           
        }
           
    }//GEN-LAST:event_LFGrade10ActionPerformed

    private void LFGrade11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LFGrade11ActionPerformed
        // if 11 has already been stored
        if ("11".equals(LFGrade[2])){
          //unselect it
          notSelected(LFGrade11);
          // store nothing 
            LFGrade[2] = "";           
        }
        // otherwise nothing has been stored
        else {
            // select it
          selected(LFGrade11);
          // store 11
            LFGrade[2] = "11";
            
        }
          
    }//GEN-LAST:event_LFGrade11ActionPerformed

    private void LFGrade12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LFGrade12ActionPerformed
        // if 12 has already been stored
        if ("12".equals(LFGrade[3])){
            // unselect it
            notSelected(LFGrade12);
            // store nothing
              LFGrade[3] = "";            
        }
        // otherwise nothing has been stored
        else {
            //select it
            selected(LFGrade12);
            // store 12
            LFGrade[3] = "12";       
        }         
    }//GEN-LAST:event_LFGrade12ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new General().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton LFFemale;
    private javax.swing.JButton LFGrade10;
    private javax.swing.JButton LFGrade11;
    private javax.swing.JButton LFGrade12;
    private javax.swing.JButton LFGrade9;
    private javax.swing.JButton LFMale;
    private javax.swing.JTextField firstName;
    private javax.swing.JButton jButton5;
    private javax.swing.JTextField lastName;
    private javax.swing.JTextField looks;
    private javax.swing.JButton myGenderFemale;
    private javax.swing.JButton myGenderMale;
    private javax.swing.JButton myGrade10;
    private javax.swing.JButton myGrade11;
    private javax.swing.JButton myGrade12;
    private javax.swing.JButton myGrade9;
    private javax.swing.JTextField personality;
    // End of variables declaration//GEN-END:variables
}
//take user class and write it to a file