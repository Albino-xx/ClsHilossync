/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cls6;

import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author ulacit
 */
public class Monitor implements Callable<String>{

    private List<ThreadBase> threadList;
    
    public Monitor(final List<ThreadBase> threadList)
    {
        this.threadList = threadList;
    }
    
    @Override
    public String call() throws Exception {
        
        boolean run = true;
        
        while(run)
        {
            run = false;
            for(var thread : threadList)
            {
                if(thread.isRunning())
                {
                    run = true;
                  break;
                }
            }
            Thread.sleep(100);
        }
        return Utils.log;
    }
    
}
