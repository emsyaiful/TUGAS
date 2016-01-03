/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author asus
 */
public class Nation {
    private int position;
    private int price;
    private Player owner;
    
    public Nation()
    {
        
    }
    
    public Nation(int position,int price, Player owner)
    {
        this.position=position;
        this.price=price;
        this.owner=owner;
    }
    
    public void buy(Player owner)
    {
        this.owner = owner;
        this.owner.payCash(price);
    }
    public void pay(Player payer)
    {
        payer.payCash(price);
        this.owner.addCash(price);
    }
    
    public Player getOwner()
    {
        return this.owner;
    }
    public int getPosition()
    {
        return this.position;
    }
    public int getPrice()
    {
        return this.price;
    }
}
