/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cls6;

/**
 *
 * @author ulacit
 */
public class UpdateLog extends ThreadBase{

    
    public UpdateLog(final int id)
    {
        super(id);
    }
    
    @Override
    public void run() {
        for(var i=0; i<10;i++)
        {
            var temp = Utils.log;
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
            
            temp += "id-> " + super.getId() + " i -> " + i + "\n";
            Utils.log = temp;
        }
        super.setRunning(false);
    }
    
}
