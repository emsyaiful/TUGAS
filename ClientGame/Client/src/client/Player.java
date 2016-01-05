/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class Player {
    private int cash;
    private int position;
    private String name;
    private ArrayList<Nation> Ownership;
    public Player()
    {
        
    }
    
    public Player(String name,int cash, int position)
    {
        this.name  = name;
        this.cash  = cash;
        this.position =position;
        Ownership = new ArrayList<>();
    }
    
    public void update(Player updatePlayer)
    {
        this.cash = updatePlayer.getCash();
        this.position = updatePlayer.getPosition();
        this.Ownership = updatePlayer.getOwnership();
    }
    
    public void addCash(int add)
    {
        this.cash = this.cash+add;
    }
    
    public void payCash(int pay)
    {   
        this.cash = this.cash-pay;
    }
    
    public void move(int move)
    {
        if(this.position + move >16)
        {
            this.addCash(200);
        }
        this.position= (position + move)%16;
    }
    
    public int getCash()
    {
        return this.cash;
    }
    public int getPosition()
    {
        return this.position;
    }
    public String getName()
    {
        return this.name;
    }
    
    public ArrayList<Nation> getOwnership()
    {
        return this.Ownership;
    }
    
    public void addOwnership(Nation ownCity)
    {
        Ownership.add(ownCity);
    } 
    public void releaseOwnership(Nation ownCity)
    {
        for(Nation owning: Ownership)
        {
            if(ownCity.getPosition()==owning.getPosition())
            {
               Ownership.remove(owning);
            }
        }
    }
}
