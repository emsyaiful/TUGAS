/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servergame;

import chatobj.Lobby;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author NARK
 */
public class room{
    ArrayList<threaduser> player;
    int roomid;
    
    room(threaduser tu,int id){
        player=new ArrayList<threaduser>();
        player.add(tu);
        this.roomid=id;
    }
    
    public int getroomid(){
        return roomid;
    }
    
    public void kirim(Object o) throws IOException{
        System.out.println("masuk2");
        for(threaduser t:player){
            t.sent(o);
        }
    }
    
    public void addplayer(threaduser tu){
        player.add(tu);
    }
    
    public void removeplayer(threaduser tu){
        player.remove(tu);
    }
    
    public ArrayList<String> Usernames(){
        ArrayList<String> user=new ArrayList<String>();
        for(threaduser tu:player){
            user.add(tu.getUsername());
        }
        return user;
    }
    
    public void notice() throws IOException{
        Lobby balas=new Lobby();
        balas.setCommand("INSIDEROOM");
        balas.setUsernames(this.Usernames());
        this.kirim(balas);
    }
}
