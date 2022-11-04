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
public class UpdateSyncThreadTwoMethod extends ThreadBase {

    private SharedUpdateSyncThreadTwoMethod sync;
    public UpdateSyncThreadTwoMethod(int id, final SharedUpdateSyncThreadTwoMethod sync) {
        super(id);
        this.sync=sync;
    }

    @Override
    public void run() {
        for(var i=0;i<10;i++)
        {
            try {
                var temp = sync.readData();
                Thread.sleep(6000);
                temp += "id => " + super.getId() + " i=> " + i + "\n";
                sync.writeData(temp);
            } catch (InterruptedException ex) {
                Logger.getLogger(UpdateSyncThreadTwoMethod.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        super.setRunning(false);
    }
    
}
