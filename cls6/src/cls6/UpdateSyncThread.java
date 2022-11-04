/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cls6;

/**
 *
 * @author ulacit
 */
public class UpdateSyncThread extends ThreadBase{

    private SharedUpdateSyncThread sync;
    public UpdateSyncThread(int id, final SharedUpdateSyncThread sync) {
        super(id);
        this.sync = sync;
    }

    @Override
    public void run() {
    while(true){
       for(var i=0;i<10001;i+=100)
       {
           sync.saveData(super.getId(), i);

           if (i == 10000) {
            System.exit(0);

           }
       }
       
       
       super.setRunning(false);
    }
    }
    
}
