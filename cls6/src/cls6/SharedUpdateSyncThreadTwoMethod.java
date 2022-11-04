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
public class SharedUpdateSyncThreadTwoMethod {
    
    private boolean flag=false;
    
    public synchronized String readData()
    {
        while(flag)
        {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SharedUpdateSyncThreadTwoMethod.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        flag = true;
        return Utils.log;
    }
    
    public synchronized void writeData(String temp)
    {
        while(!flag)
        {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SharedUpdateSyncThreadTwoMethod.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Utils.log = temp;
        flag=false;
        notify();
    }
    
    
}
