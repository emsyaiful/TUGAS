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
    String Name;
    private int position;
    private int price;
    private Player owner;
    private int sellprice;
    
    public Nation()
    {
        
    }
    
    public Nation(String Name,int position,int price, Player owner)
    {
        this.Name = Name;
        this.position=position;
        this.price=price;
        this.owner=owner;
        sellprice = price/10;
    }
    
    public void buy(Player owner)
    {
        this.owner = owner;
        this.owner.payCash(price);
    }
    public void pay(Player payer)
    {
        payer.payCash(sellprice);
        this.owner.addCash(sellprice);
    }
    
    public String getName()
    {
        return this.Name;
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
