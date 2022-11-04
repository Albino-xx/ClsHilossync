/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cls6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ulacit
 */
public class SharedUpdateSyncThread {
    
    
    public synchronized void  saveData(int id, int i)
    {
        try {
            var temp = Utils.log;
            Thread.sleep(10);
            temp += "Generador => " + id + " carga=>" + i + "\n";
            Utils.log = temp;
        } catch (InterruptedException ex) {
            Logger.getLogger(SharedUpdateSyncThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
