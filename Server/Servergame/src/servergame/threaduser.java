/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servergame;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import chatobj.*;

/**
 *
 * @author NARK
 */
public class threaduser implements Runnable{
    int userid;
    private String username;
    ArrayList<room> room;
    room rom;
    Socket socket;
    private ObjectInputStream is;
    private ObjectOutputStream os;
    
    threaduser(Socket socket,ArrayList<room> room,int id) throws IOException{
        this.userid=id;
        this.room=room;
        this.socket=socket;
        this.is=new ObjectInputStream(socket.getInputStream());
        this.os=new ObjectOutputStream(socket.getOutputStream());
    }
    
    public void sent(Object o) throws IOException{
        os.writeObject(o);
        os.flush();
        os.reset();
    }
    
    public void addtoroom(int idroom){
        for(room ro:room){
            if(ro.getroomid()==idroom){
                ro.addplayer(this);
                rom=ro;
            }
        }
    }
    
    public void removefromroom(){
        rom.removeplayer(this);
    }
    
    public void run(){
        try {
            Object o;
            System.out.println("Client connect...");
            byte[] buf = new byte[50];
            String strbuf = new String(buf);
            while ((o = this.is.readObject())!=null) {
                if (o instanceof Chat) {
                    rom.kirim(o);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(threaduser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(threaduser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
