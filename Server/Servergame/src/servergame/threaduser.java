/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servergame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author NARK
 */
public class threaduser implements Runnable{
    int userid;
    ArrayList<room> room;
    room rom;
    Socket socket;
    ObjectInputStream is;
    ObjectOutputStream os;
    
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
        
    }
}
