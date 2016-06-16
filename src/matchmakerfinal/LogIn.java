package matchmakerfinal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static matchmakerfinal.Registration.byteArrayToHexString;
import static matchmakerfinal.Registration.computeHash;
//import static matchmakerfinal.LogIn.byteArrayToHexString;
//import static matchmakerfinal.LogIn.computeHash;

/**
 *
 * @author Stephanie
 */
public class LogIn extends javax.swing.JFrame {
    static public String fileSID;
    /**
     * Creates new form LogIn
     */
    person log = new person();
    
    public LogIn() {
        initComponents();
         // Set the screen size to 580 x 500
        setSize(1016, 699);
        admin.setOpaque(false);
        admin.setContentAreaFilled(false);
        admin.setBorderPainted(false);
   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JButton();
        openRegScreen = new javax.swing.JButton();
        userName = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        admin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(820, 530, 110, 56);

        openRegScreen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        openRegScreen.setText("Register");
        openRegScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openRegScreenActionPerformed(evt);
            }
        });
        getContentPane().add(openRegScreen);
        openRegScreen.setBounds(280, 530, 110, 60);

        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });
        getContentPane().add(userName);
        userName.setBounds(470, 290, 280, 40);

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password);
        password.setBounds(470, 390, 280, 40);

        admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminActionPerformed(evt);
            }
        });
        getContentPane().add(admin);
        admin.setBounds(60, 80, 130, 130);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/matchmakerfinal/Login.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 1020, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * This method is used to allow the user to register
     *
     * @ param obj - none
     * @ return - none
     */
    private void openRegScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openRegScreenActionPerformed
        // hide the log in screen
        log.user = userName.getText();
        setVisible(false);
        // open the resitration screen
        new Registration().setVisible(true);
    }//GEN-LAST:event_openRegScreenActionPerformed

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

       
    /**
     * This method is used to compare the users username and password to the file of 
     * usernames and passwords created in the registration screen
     *
     * @ param obj - none
     * @ return - none
     */
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // String to store current line from the file
        String user = null;
        // The file containing the users and their passwords
          File f = new File ("user.txt");
          Scanner s = null;
        try {            
            s = new Scanner (f);
            // While you have not reached the end of the file
            while (s.hasNextLine()){             
            // Store the line in the user var
            user = s.nextLine();
            // Split the string into an array 
            String[] sa = user.split(",");   
            // if the username and password match the one previously stored
            if (userName.getText().equals(sa[0]) && encrypt().equals(sa[1])){
             // store the user name in a globel var to be accessed from quizes
             fileSID = sa[0];
                // The user has logged in, set the menu screen to visable
                 setVisible(false);
                 new Menu().setVisible(true);
                break;
            }
            // if you reach the end of the file
            else if (!s.hasNextLine()){
                // The information entered is not correct, do not log in and display message.
                JOptionPane.showMessageDialog(this, "The information you entered was not correct", "Login", JOptionPane.PLAIN_MESSAGE);
            }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_loginActionPerformed

    
    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed

    
    }//GEN-LAST:event_passwordActionPerformed

    private void adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActionPerformed
              System.out.println("IT WORKS");
        try {
            if (userName.getText().equals("ADMIN") && encrypt().equals("7719653DDE352CA76EE01E8898B68C2343DF60FAEACC8EC0F1BE132AD03B56A8")){
                
            }   } catch (Exception ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_adminActionPerformed

        
    /**
     * This method is used to encrypt the entered password
     * @ param obj - none
     * @ return - the string of the encypted password
     */
    private String encrypt() throws Exception{
        // var to store the password as a string
        String passwordAsString = "";
        // run through array of chars (from password field)
        for (int i = 0; i < password.getPassword().length; i++){
             // store in string
             passwordAsString = passwordAsString + password.getPassword()[i];
        }
    // encrypt using methods previously
    String hash = byteArrayToHexString(computeHash(passwordAsString));
    // return the encrypted password
    return hash;
}
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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton login;
    private javax.swing.JButton openRegScreen;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
