
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
public class Lobby {
    private ArrayList<Integer> roomid;
    private int roomidjoin;

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
    
}
