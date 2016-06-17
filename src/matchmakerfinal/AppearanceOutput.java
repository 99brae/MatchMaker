package matchmakerfinal;

import static matchmakerfinal.LogIn.fileSID;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Braedon
 */
public class AppearanceOutput {
int score;
String fileSID;


AppearanceOutput(int score) {
this.score = score;   
this.fileSID = LogIn.fileSID;
}
AppearanceOutput(){
    
}
}
