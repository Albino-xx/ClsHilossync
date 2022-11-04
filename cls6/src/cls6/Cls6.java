/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cls6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ulacit
 */
public class Cls6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        var services = Executors.newCachedThreadPool();

        List<ThreadBase> threadList = new ArrayList<>();
        /*threadList.add(new UpdateLog(1));
        threadList.add(new UpdateLog(2));
        threadList.add(new UpdateLog(3));
        threadList.add(new UpdateLog(4));
        threadList.add(new UpdateLog(5));
        threadList.add(new UpdateLog(6));
        threadList.add(new UpdateLog(7));
        threadList.add(new UpdateLog(8));*/

        var option = 2;
        switch (option) {
            case 1:
                var sync = new SharedUpdateSyncThread();
                for (var i = 0; i < 10; i++) {
                    threadList.add(new UpdateSyncThread(i + 1, sync));
                }
                break;
            case 2:
                var sync2 = new SharedUpdateSyncThreadTwoMethod();
                for (var i = 0; i < 10; i++) {
                    threadList.add(new UpdateSyncThreadTwoMethod(i + 1, sync2));
                }
                break;
            
            default:
                throw new AssertionError();
        }
      

        for (var thread : threadList) {
            services.submit(thread);
        }

        var monitor = new Monitor(threadList);
        Future<String> result = services.submit(monitor);
        try {
            System.out.println(result.get());
        } catch (InterruptedException ex) {
            System.err.println(ex);
        } catch (ExecutionException ex) {
            System.err.println(ex);
        }

        services.shutdown();

    }

}
