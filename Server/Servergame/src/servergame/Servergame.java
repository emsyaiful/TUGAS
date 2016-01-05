/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servergame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author NARK
 */
public class Servergame {
    
    /**
     * @param args the command line arguments
     */

    ArrayList<threaduser> threuser=new ArrayList<threaduser>();
    ArrayList<room> roomava=new ArrayList<room>();
    private ArrayList<Integer> idroom=new ArrayList<Integer>();
    int roomid=0;
    int userid=0;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
       Servergame sg=new Servergame();
       sg.server();
    }
    
    public void server(){
       try {
            ServerSocket servsock = new ServerSocket(9988);
           //System.out.println("Server mau berjalan ....");
            while(true) {
                Socket socket;
                socket = servsock.accept();
                threaduser tc = new threaduser(socket,roomava,userid,this);
                threuser.add(tc);
                userid+=1;
                Thread t = new Thread(tc);
                t.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servergame.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void makeroom(threaduser tu){
        room newroom=new room(tu,roomid);
        roomava.add(newroom);
        idroom.add(roomid);
        tu.addroom(newroom);
        roomid+=1;
        
    }
    
    public void deleteroom(int id){
        for(room ro:roomava){
            if(ro.getroomid()==id){
             roomava.remove(ro);
                getIdroom().remove(ro.getroomid());
             break;
            }
        }
    }
    
    public void globalchat(Object o) throws IOException{
        for(threaduser tu:threuser){
            tu.sent(o);
        }
    }

    /**
     * @return the idroom
     */
    public ArrayList<Integer> getIdroom() {
        return idroom;
    }
}