package chatobj;


import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NARK
 */
public class Lobby implements Serializable{
    private String Command;
    private String Argument;
    private ArrayList<Integer> roomid;
    private int roomidjoin;
    private ArrayList<String> username; 
    private String user;
    /**
     * @return the roomid
     */
    public ArrayList<Integer> getRoomid() {
        return roomid;
    }

    /**
     * @param roomid the roomid to set
     */
    public void setRoomid(ArrayList<Integer> roomid) {
        this.roomid = roomid;
    }

    /**
     * @return the roomidjoin
     */
    public int getRoomidjoin() {
        return roomidjoin;
    }

    /**
     * @param roomidjoin the roomidjoin to set
     */
    public void setRoomidjoin(int roomidjoin) {
        this.roomidjoin = roomidjoin;
    }

    /**
     * @return the username
     */
    public ArrayList<String> getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(ArrayList<String> username) {
        this.username = username;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }
    
}
