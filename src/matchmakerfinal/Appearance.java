/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchmakerfinal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Braedon
 */
public class Appearance {
PrintWriter pw;
File appearance = new File("appearance.txt");

int bodyWeightPersonal;
int bodyTypePersonal;
int hairColPersonal;
int backgroundPersonal;
int heightPersonal;
int bodyWeightPref;
int bodyTypePref;
int hairColPref;
int backgroundPref;
int heightPref;

public Appearance(int bodyWeightPersonal,int bodyTypePersonal,int hairColPersonal,int backgroundPersonal,int heightPersonal,int bodyWeightPref,int bodyTypePref,int hairColPref,int backgroundPref,int heightPref) throws IOException {
this.bodyWeightPersonal = bodyWeightPersonal;
this.bodyTypePersonal = bodyWeightPersonal;
this.hairColPersonal = hairColPersonal;
this.backgroundPersonal = backgroundPersonal;
this.heightPersonal = heightPersonal;
this.bodyWeightPref = bodyWeightPref;
this.bodyTypePref = bodyTypePref;
this.hairColPref = hairColPref;
this.backgroundPref =backgroundPref;
this.heightPref = heightPref;   

pw = new PrintWriter(new FileWriter(appearance, true));
 pw.println(bodyTypePersonal + "," + bodyWeightPersonal + "," + hairColPersonal + "," + backgroundPersonal + "," + heightPersonal + ";" + bodyTypePref + "," + bodyWeightPref + "," + hairColPref + "," + backgroundPref + "," + heightPref);
        //close printwriter
            pw.close();


}
    
}
