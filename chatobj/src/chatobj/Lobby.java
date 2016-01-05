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
    private int roomidjoin=0;
    private ArrayList<String> usernames; 
    private String username;
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
    public ArrayList<String> getUsernames() {
        return usernames;
    }

    /**
     * @param username the username to set
     */
    public void setUsernames(ArrayList<String> usernames) {
        this.usernames = usernames;
    }

    /**
     * @return the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param user the user to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the Command
     */
    public String getCommand() {
        return Command;
    }

    /**
     * @param Command the Command to set
     */
    public void setCommand(String Command) {
        this.Command = Command;
    }

    /**
     * @return the Argument
     */
    public String getArgument() {
        return Argument;
    }

    /**
     * @param Argument the Argument to set
     */
    public void setArgument(String Argument) {
        this.Argument = Argument;
    }
    
}
