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
    Servergame sg;
    int userid;
    private String username;
    ArrayList<room> room;
    room rom;
    Socket socket;
    private ObjectInputStream is;
    private ObjectOutputStream os;
    
    threaduser(Socket socket,ArrayList<room> room,int id,Servergame sg) throws IOException{
        this.userid=id;
        this.room=room;
        this.sg=sg;
        this.socket=socket;
        this.is=new ObjectInputStream(socket.getInputStream());
        this.os=new ObjectOutputStream(socket.getOutputStream());
    }
    
    public void sent(Object o) throws IOException{
        os.writeObject(o);
        os.flush();
        os.reset();
    }
    
    public void addroom(room rom){
        System.out.println("getting the room");
        this.rom=rom;
        System.out.println(rom.getroomid());
    }
    
//    public void removeroom(){
  //      this.rom=null;
    //}
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
                    System.out.println("masuk");
                    Chat c=(Chat) o;
                    System.out.println(rom.getroomid());
                    rom.kirim(o);
                }
                else if(o instanceof Game){
                    rom.kirim(o);
                }
                else if(o instanceof Lobby){
                    System.out.println("masuk lobby");
                    Lobby lob=(Lobby) o;
                    System.out.println("test");
                    if(lob.getCommand().equalsIgnoreCase("JOIN")){
                        System.out.println("Room Joined");
                        this.username=lob.getUsername();
                        addtoroom(lob.getRoomidjoin());
                        rom.notice();
                    }
                    else if(lob.getCommand().equalsIgnoreCase("CREATE")){
                        System.out.println("Room Created");
                        this.username=lob.getUsername();
                        sg.makeroom(this);
                        rom.notice();     
                    }
                    else if(lob.getCommand().equalsIgnoreCase("LEAVE")){
//                        removeroom();
                        rom.notice();
                    }
                    else if(lob.getCommand().equalsIgnoreCase("GETLIST")){
                        Lobby balas=new Lobby();
                        balas.setCommand("LISTLOB");
                        balas.setRoomid(sg.getIdroom());
                        sent(balas);
                    }
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
