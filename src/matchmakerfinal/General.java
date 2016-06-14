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
        //where we are in the file
        
        // The file of previously entered data (un, pw, fn, ln)
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
            // if the username and password match the one previously stored
            if (LogIn.fileSID.equals(userInfo[0])){
                firstName.setText(userInfo[1]);
                lastName.setText(userInfo[2]);
                
                if (userInfo[3].equals("female")){
                    myGenderFemale.doClick();
                   // notSelected(myGenderMale);
                    //selected(myGenderFemale);
                }
                else {
                    myGenderMale.doClick();
                }
                
                if (userInfo[4].equals("9")){
                    myGrade9.doClick();
                }
                else if (userInfo[4].equals("10")){
                      myGrade10.doClick();
                }
                else if (userInfo[4].equals("11")){
                      myGrade11.doClick();
                }
                else {
                    myGrade12.doClick();
                }
                looks.setText(userInfo[5]);
                personality.setText(String.valueOf(100 - Integer.parseInt(userInfo[5])));
                String[] interestGender = userInfo[6].split(";");
               
                
                if (LinearStringSearcher(interestGender,"female") > 0){
                    LFFemale.doClick();
                }
                if (LinearStringSearcher(interestGender,"male") > 0){
                    LFMale.doClick();
                }
                String[] interestGrade = userInfo[7].split(";");
                if (LinearStringSearcher(interestGrade,"9") > 0){
                    LFGrade9.doClick();
                }
                if (LinearStringSearcher(interestGrade,"10") > 0){
                    LFGrade10.doClick();
                }
                if (LinearStringSearcher(interestGrade,"11") > 0){
                    LFGrade11.doClick();
                }
                if (LinearStringSearcher(interestGrade,"12") > 0){
                    LFGrade12.doClick();
                } 
            }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
     //  if there is a value in SID read file and grab answer (if there )
//and add to field based on whats in the file. The file will be added to
 //      myGrade10.setSelected(true);
        
          setSize(1108, 733);
    }
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
    
    private int completed (){
         String user = null;
         int here = 0;
        //where we are in the file
        
        // The file of previously entered data (un, pw, fn, ln)
          File info = new File ("GeneralInfo.txt");
          Scanner s = null;
        try {            
            s = new Scanner (info);
            // While you have not reached the end of the file
            while (s.hasNextLine()){
             
            // Store the line in the user var
            user = s.nextLine();
            here++;
            // Split the string into an array 
            String[] userInfo = user.split(",");   
            // if the username and password match the one previously stored
            if (LogIn.fileSID.equals(userInfo[0])){
             return here;
            }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
    }
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
        if (checkNames(firstName) || checkNames(lastName)){
             JOptionPane.showMessageDialog(this, "Please ensure the name fields are filled in correctly", "Names", JOptionPane.PLAIN_MESSAGE);
        }
        //check the field for personality and looks are both numbers
        else if (checkRatio(personality) || checkRatio(looks)){
            JOptionPane.showMessageDialog(this, "Please ensure the looks:personality field contain only numbers", "Names", JOptionPane.PLAIN_MESSAGE);
        }
        else if (addTo()){
         JOptionPane.showMessageDialog(this, "Please ensure the looks:personality field add to 100%", "% Looks to Personality", JOptionPane.PLAIN_MESSAGE);   
        }
       
        else if (checkGrade(LFGrade[0]) && checkGrade(LFGrade[1]) && checkGrade(LFGrade[2]) && checkGrade(LFGrade[3])){
         JOptionPane.showMessageDialog(this, "Please select one or more grade preferences", "Looking for Grade..", JOptionPane.PLAIN_MESSAGE);      
            
        }
        else if (empty(LFGender)){
         JOptionPane.showMessageDialog(this, "Please select one or more gender preferences", "Looking for Gender..", JOptionPane.PLAIN_MESSAGE);         
        }
        else{
            String gradeInterest = "";
            for (int i = 0; i < 3; i ++){
                if ("".equals(LFGrade[i])){
                    
                }
                else {
                     gradeInterest = gradeInterest + LFGrade[i] +";";
                }
            }     
          
        gradeInterest = gradeInterest + LFGrade[3];
        int length =   gradeInterest.length();
        
        if (gradeInterest.charAt(length-1) == ';'){
           
            gradeInterest = gradeInterest.substring(0,(length - 1));
            
        }
        // store information in String
        String userInfo = (firstName.getText()+ "," + lastName.getText()+ "," + gender + "," + grade + "," + personality.getText()+ "," + LFGender + "," + gradeInterest);
     
        if (completed() == -1){
            PrintWriter pw = null;
            try {
                // create file for info to be stored
                File f = new File("GeneralInfo.txt");
                // create a PrintWriter that will append the file (will add to it as apppose to overwrite)
                pw = new PrintWriter(new FileWriter(f, true));
                // store the username, encrypted password, first name and last name
                pw.println(LogIn.fileSID + "," + userInfo);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // close the print writer, hide this screen, and set the login screen to visible
                pw.close();  
        }}
        else {
              String user = null;
        // The file of previously entered data (un, pw, fn, ln)
          File info = new File ("GeneralInfo.txt");
          String[] file = new String[findLength(info)];
          Scanner s = null;
        try {            
            s = new Scanner (info);
            int here = 0;
            // While you have not reached the end of the file
            while (s.hasNextLine()){
            // Split the string into an array 
            file[here] = s.nextLine();
            here++;
            }            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
    }
        System.out.println(completed());
        file[completed()-1] = LogIn.fileSID + "," + userInfo;
        
        
         PrintWriter pw = null;         
            try {
                // create file for info to be stored
                File f = new File("GeneralInfo.txt");
                pw = new PrintWriter(new FileWriter(f));
                // create a PrintWriter that will append the file (will add to it as apppose to overwrite)
                pw = new PrintWriter(new FileWriter(f, true));
                // store the username, encrypted password, first name and last name
                for (int i = 0; i < file.length; i++)
                pw.println(file[i]);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // close the print writer, hide this screen, and set the login screen to visible
                pw.close();  
        
        }
        }     
       
        setVisible(false);
        new Menu().setVisible(true);
        
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    
    private int findLength(File x){
        int length = 0;
        Scanner s = null;
        try {            
            s = new Scanner (x);
            // While you have not reached the end of the file
            while (s.hasNextLine()){
            s.nextLine();
            length++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
    }
        return length;
    }
    
    
    private boolean addTo(){
    int RP = Integer.parseInt(personality.getText());
    int LP = Integer.parseInt(looks.getText());
    if (LP + RP == 100){
        return false;
    }
    return true;
    
}
    private boolean checkGrade (String grade){
        if (grade == ""){
        return true;
    }
        return false;
    }
    private boolean checkRatio (JTextField ratio){
      
        return !ratio.getText().matches("[0-9]+");        
    }
    
    private boolean checkNames(JTextField name){
        //This method will check each the name inputs and return true if they are not filled in properly
       // is the name filled in?
        if (empty(name.getText())){
            return true;
        }
        //is the content only letters?
        else if (letters(name.getText())){
            return true;
        }
        return false;
    }
    public boolean letters(String name) {
    char[] chars = name.toCharArray();

    for (char c : chars) {
        if(!Character.isLetter(c)) {
            return true;
        }
    }

    return false;
}

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

    private void notSelected(JButton button){
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
    }
    
    private void selected(JButton button){
        button.setBackground(Color.BLACK);
        button.setForeground(Color.GRAY);
    }
    private void myGenderFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myGenderFemaleActionPerformed
       
       notSelected(myGenderMale);
       selected(myGenderFemale);
      
        gender = "female";
       
    }//GEN-LAST:event_myGenderFemaleActionPerformed

    private void myGenderMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myGenderMaleActionPerformed
       
       notSelected(myGenderFemale);
       selected(myGenderMale);
       gender = "male";
    }//GEN-LAST:event_myGenderMaleActionPerformed

    private void myGrade9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myGrade9ActionPerformed
       notSelected(myGrade10);
       notSelected(myGrade11);
       notSelected(myGrade12);
       selected(myGrade9);
             
        grade = "9";
    }//GEN-LAST:event_myGrade9ActionPerformed

    private void myGrade10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myGrade10ActionPerformed
       notSelected(myGrade9);
       notSelected(myGrade11);
       notSelected(myGrade12);
       selected(myGrade10);
        grade = "10";
    }//GEN-LAST:event_myGrade10ActionPerformed

    private void myGrade11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myGrade11ActionPerformed
    notSelected(myGrade9);
       notSelected(myGrade10);
       notSelected(myGrade12);
       selected(myGrade11);
        grade = "11";
    }//GEN-LAST:event_myGrade11ActionPerformed

    private void myGrade12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myGrade12ActionPerformed
     notSelected(myGrade9);
       notSelected(myGrade11);
       notSelected(myGrade10);
       selected(myGrade12);
        grade = "12";
    }//GEN-LAST:event_myGrade12ActionPerformed

    private void LFFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LFFemaleActionPerformed
        if ("male".equals(LFGender)){
            selected(LFFemale);
             selected(LFMale);
            LFGender = "female;male";
        }
        else if ("".equals(LFGender)){
            selected(LFFemale);
            notSelected(LFMale);
            LFGender = "female";
            
        }
        else if ("female;male".equals(LFGender)){
             notSelected(LFFemale);
            selected(LFMale);
            LFGender = "male";
           
        }
        else {
            notSelected(LFFemale);
            notSelected(LFMale);
            LFGender = "";
        }
    }//GEN-LAST:event_LFFemaleActionPerformed

    private void LFMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LFMaleActionPerformed
       if ("male".equals(LFGender)){
           notSelected(LFFemale);
            notSelected(LFMale);
            LFGender = "";
            
        }
        else if ("".equals(LFGender)){
            notSelected(LFFemale);
            selected(LFMale);
            LFGender = "male";
            
        }
        else if ("female;male".equals(LFGender)){
            selected(LFFemale);
            notSelected(LFMale);
            LFGender = "female";
             
        }
        else {
            selected(LFFemale);
             selected(LFMale);
            LFGender = "female;male";
        }
    
    }//GEN-LAST:event_LFMaleActionPerformed

    private void LFGrade9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LFGrade9ActionPerformed
        if ("9".equals(LFGrade[0])){
               
            notSelected(LFGrade9);
            LFGrade[0] = "";
            
        }
        else {
            selected(LFGrade9);
            LFGrade[0] = "9";
        }
    }//GEN-LAST:event_LFGrade9ActionPerformed

    private void LFGrade10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LFGrade10ActionPerformed
         if ("10".equals(LFGrade[1])){
             notSelected(LFGrade10);
               LFGrade[1] = "";
           
        }
        else {
             selected(LFGrade10);
               LFGrade[1] = "10";
           
        }
           
    }//GEN-LAST:event_LFGrade10ActionPerformed

    private void LFGrade11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LFGrade11ActionPerformed
      if ("11".equals(LFGrade[2])){
          notSelected(LFGrade11);
            LFGrade[2] = "";
           
        }
        else {
          selected(LFGrade11);
            LFGrade[2] = "11";
            
        }
          
    }//GEN-LAST:event_LFGrade11ActionPerformed

    private void LFGrade12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LFGrade12ActionPerformed
        if ("12".equals(LFGrade[3])){
            notSelected(LFGrade12);
              LFGrade[3] = "";
            
        }
        else {
            selected(LFGrade12);
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