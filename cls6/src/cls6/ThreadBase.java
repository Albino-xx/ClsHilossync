/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cls6;

/**
 *
 * @author ulacit
 */
public abstract class ThreadBase implements Runnable{
    
    private int id;
    private boolean running=true;
    
    public ThreadBase(final int id)
    {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    
    
    
}
