/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import chatobj.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NARK
 */
public class Receiver implements Runnable{
    private ObjectInputStream ois;
    private GUI_All ga;
        
    Receiver(ObjectInputStream ois, GUI_All ga){
        this.ois = ois;
        this.ga = ga;
    }
    @Override
    public void run() {
        try {
            
            while (true) {                    
                Object o = ois.readObject();
                if(o instanceof Chat){
                    Chat ch = (Chat) o;
                    ga.append(ch.getMessages());
                    System.out.println(ch.getMessages());
                }
                else if(o instanceof Lobby){
                    Lobby lo=(Lobby) o;
                    ga.append(lo.getCommand());
                    System.out.println(lo.getCommand());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
