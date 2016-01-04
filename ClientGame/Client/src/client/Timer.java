/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class Timer implements Runnable{
    int time;
    GameControl gc;
    
    Timer(GameControl gc){
        this.gc=gc;
    }
    public void resettimer(){
        time=60;
    }
    
    public void run(){
       time=60;
       while(time>0){
           System.out.println(time+"...");
           time-=1;
           try {
               Thread.sleep(1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       gc.setflag();
   }
}
